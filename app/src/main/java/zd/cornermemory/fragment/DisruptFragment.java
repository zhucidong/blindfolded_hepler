package zd.cornermemory.fragment;

import android.content.BroadcastReceiver;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import zd.cornermemory.R;
import zd.cornermemory.bean.CoordinateKeyValue;
import zd.cornermemory.bean.CornerOrEdge;
import zd.cornermemory.bean.Cube;
import zd.cornermemory.bean.Probability;
import zd.cornermemory.min2phase.Search;
import zd.cornermemory.utils.CoordinateUtil;
import zd.cornermemory.utils.ProbabilityUtil;
import zd.cornermemory.utils.SPUtils;
import zd.cornermemory.utils.SpKey;

import static android.content.Context.INPUT_METHOD_SERVICE;

/**
 * Created by zhud on 2019/4/29.
 * 生成打乱公式
 */

public class DisruptFragment extends Fragment implements View.OnClickListener{

    private Button   clear_button;
    private Button   disrupt_button;
    private TextView result_text;

    private EditText edge_code_length;
    private EditText edge_fanse_count;
    private EditText edge_xunhuan_count;
    private Spinner  edge_is_homing;

    private EditText corner_code_length;
    private EditText corner_fanse_count;
    private EditText corner_xunhuan_count;
    private Spinner  corner_is_homing;

    private Spinner  is_parity;
    private Spinner  is_dl_zb;
    private Spinner  dl_ms;
    private int cornerIshoming = 0;
    private int edgeIshoming = 0;
    private int is_parity_all = 0;
    private int is_dl_zb_all = 0;
    private int dlms_type = 0;

    private LinearLayout code_layout;
    private Button copy_button;

    private TextView corner_buffer;
    private TextView edge_buffer;

    private Toast toast;
    private Toast copyToast;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab3, container, false);
        toast = Toast.makeText(getActivity(),"打乱类型不存在", Toast.LENGTH_SHORT);
        copyToast = Toast.makeText(getActivity(),"已复制", Toast.LENGTH_SHORT);
        initViews(view);
        setEvent();
        setBuffer();
        getActivity().registerReceiver(broadcastReceiver,new IntentFilter(SpKey.MODIFY_BUFFER_SUCCESS));
        return view;
    }

    private void setEvent() {
        disrupt_button.setOnClickListener(this);
        clear_button.setOnClickListener(this);
        copy_button.setOnClickListener(this);

        String[] isHome = getActivity().getResources().getStringArray(R.array.is_homing);
        List<String> list = new ArrayList<>();
        for(int i=0;i<isHome.length;i++) {
            list.add(isHome[i]);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),

                R.layout.spinner_checked_text, list);

        corner_is_homing.setAdapter(adapter);

        corner_is_homing.setSelection(0);
        corner_is_homing.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                hideSoftInput();
                cornerIshoming = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                hideSoftInput();
            }
        });
        edge_is_homing.setAdapter(adapter);
        edge_is_homing.setSelection(0);
        edge_is_homing.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                hideSoftInput();
                edgeIshoming = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                hideSoftInput();
            }
        });

        String[] isParity = getActivity().getResources().getStringArray(R.array.is_parity);
        List<String> listParity = new ArrayList<>();
        for(int i=0;i<isParity.length;i++) {
            listParity.add(isParity[i]);
        }
        ArrayAdapter<String> adapterParity = new ArrayAdapter<String>(getContext(),

                R.layout.spinner_checked_text, listParity);
        is_parity.setAdapter(adapterParity);
        is_parity.setSelection(0);
        is_parity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                hideSoftInput();
                is_parity_all = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                hideSoftInput();
            }
        });

        String[] isDlzb = getActivity().getResources().getStringArray(R.array.is_zuobiao);
        List<String> listDlzb = new ArrayList<>();
        for(int i=0;i<isDlzb.length;i++) {
            listDlzb.add(isDlzb[i]);
        }
        ArrayAdapter<String> adapterDlzb = new ArrayAdapter<String>(getContext(),

                R.layout.spinner_checked_text, listDlzb);
        is_dl_zb.setAdapter(adapterDlzb);

        int position = 0;
        String isDlzbStr = SPUtils.getInstance().getString(SpKey.IS_DL_ZB);
        if(TextUtils.isEmpty(isDlzbStr)){
            //没有设置过，用默认
            SPUtils.getInstance().put(SpKey.IS_DL_ZB,"0");
        }else {
            position = Integer.parseInt(isDlzbStr);
        }
        is_dl_zb.setSelection(position);
        is_dl_zb.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                hideSoftInput();
                is_dl_zb_all = i;
                SPUtils.getInstance().put(SpKey.IS_DL_ZB,is_dl_zb_all+"");
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                hideSoftInput();
            }
        });

        corner_code_length.addTextChangedListener(tw);
        edge_code_length.addTextChangedListener(tw);




        String[] dsms = getActivity().getResources().getStringArray(R.array.dlms);
        List<String> listDlms = new ArrayList<>();
        for(int i=0;i<dsms.length;i++) {
            listDlms.add(dsms[i]);
        }
        ArrayAdapter<String> adapterDlms = new ArrayAdapter<String>(getContext(),

                R.layout.spinner_checked_text, listDlms);
        dl_ms.setAdapter(adapterDlms);
        dl_ms.setSelection(0);
        dl_ms.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                hideSoftInput();
                dlms_type = i;
                clearTj();
                switch (dlms_type) {
                    case 0:
                        corner_code_length.setEnabled(true);
                        corner_fanse_count.setEnabled(true);
                        corner_xunhuan_count.setEnabled(true);
                        corner_is_homing.setEnabled(true);

                        edge_code_length.setEnabled(true);
                        edge_fanse_count.setEnabled(true);
                        edge_xunhuan_count.setEnabled(true);
                        edge_is_homing.setEnabled(true);

                        is_parity.setEnabled(true);
                        break;
                    case 1:
                        is_parity.setSelection(2);
                        corner_code_length.setEnabled(true);
                        corner_fanse_count.setEnabled(true);
                        corner_xunhuan_count.setEnabled(true);
                        corner_is_homing.setEnabled(true);

                        edge_code_length.setEnabled(false);
                        edge_fanse_count.setEnabled(false);
                        edge_xunhuan_count.setEnabled(false);
                        edge_is_homing.setEnabled(false);
                        is_parity.setEnabled(false);
                        break;
                    case 2:
                        is_parity.setSelection(2);
                        corner_code_length.setEnabled(false);
                        corner_fanse_count.setEnabled(false);
                        corner_xunhuan_count.setEnabled(false);
                        corner_is_homing.setEnabled(false);

                        edge_code_length.setEnabled(true);
                        edge_fanse_count.setEnabled(true);
                        edge_xunhuan_count.setEnabled(true);
                        edge_is_homing.setEnabled(true);
                        is_parity.setEnabled(false);
                        break;
                    case 3:
                        corner_code_length.setEnabled(false);
                        corner_fanse_count.setEnabled(false);
                        corner_xunhuan_count.setEnabled(false);
                        corner_is_homing.setEnabled(false);

                        edge_code_length.setEnabled(false);
                        edge_fanse_count.setEnabled(false);
                        edge_xunhuan_count.setEnabled(false);
                        edge_is_homing.setEnabled(false);

                        is_parity.setEnabled(false);

                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                hideSoftInput();
            }
        });

    }

    private void clearTj() {
        hideSoftInput();
        code_layout.setVisibility(View.GONE);
        result_text.setText("");
        edge_code_length.setText("");
        edge_fanse_count.setText("");
        edge_xunhuan_count.setText("");
        corner_code_length.setText("");
        corner_fanse_count.setText("");
        corner_xunhuan_count.setText("");
        edge_is_homing.setSelection(0);
        corner_is_homing.setSelection(0);
        is_parity.setSelection(0);
//        is_dl_zb.setSelection(0);
    }

    private void initViews(View view) {
        clear_button = view.findViewById(R.id.clear_button);
        disrupt_button = view.findViewById(R.id.disrupt_button);
        result_text = view.findViewById(R.id.result_text);
        edge_code_length = view.findViewById(R.id.edge_code_length);
        edge_fanse_count = view.findViewById(R.id.edge_fanse_count);
        edge_xunhuan_count = view.findViewById(R.id.edge_xunhuan_count);
        edge_is_homing = view.findViewById(R.id.edge_is_homing);
        corner_code_length = view.findViewById(R.id.corner_code_length);
        corner_fanse_count = view.findViewById(R.id.corner_fanse_count);
        corner_xunhuan_count = view.findViewById(R.id.corner_xunhuan_count);
        corner_is_homing = view.findViewById(R.id.corner_is_homing);
        is_parity = view.findViewById(R.id.is_parity);
        is_dl_zb = view.findViewById(R.id.is_dl_zb);
        code_layout = view.findViewById(R.id.code_layout);
        copy_button = view.findViewById(R.id.copy_button);
        corner_buffer = view.findViewById(R.id.corner_buffer);
        edge_buffer = view.findViewById(R.id.edge_buffer);
        dl_ms = view.findViewById(R.id.dl_ms);
    }

    private TextWatcher tw = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {

            if (dlms_type == 0) {
                String cornerCode = corner_code_length.getText().toString().trim();
                String edgeCode =  edge_code_length.getText().toString().trim();
                if (!TextUtils.isEmpty(cornerCode) && !TextUtils.isEmpty(edgeCode)) {
                    int corner = Integer.parseInt(cornerCode);
                    int edge = Integer.parseInt(edgeCode);
                    if(corner%2!=0&&edge%2!=0){
                        //jiou
                        is_parity.setSelection(1);
                    } else if (corner % 2 == 0 && edge % 2 == 0) {
                        is_parity.setSelection(2);
                    }else{
                        is_parity.setSelection(0);
                    }

                }else if(!TextUtils.isEmpty(cornerCode)){
                    int corner = Integer.parseInt(cornerCode);
                    if (corner % 2 != 0) {
                        //jiou
                        is_parity.setSelection(1);
                    }else{
                        is_parity.setSelection(2);
                    }
                } else if (!TextUtils.isEmpty(edgeCode)) {
                    int edge = Integer.parseInt(edgeCode);
                    if (edge % 2 != 0) {
                        //jiou
                        is_parity.setSelection(1);
                    }else {
                        is_parity.setSelection(2);
                    }
                }else{
                    is_parity.setSelection(0);
                }

            }


        }
    };

    private List<Probability> getCornerProbability(){
        List<Probability> all = ProbabilityUtil.getCornerProbabilities();

        String cornerLength = corner_code_length.getText().toString().trim();
        if (!TextUtils.isEmpty(cornerLength)) {
            int length = Integer.parseInt(cornerLength);
            List<Probability> tempList = ProbabilityUtil.getKindByCodeCount(CornerOrEdge.CORNER,length);
            all = ProbabilityUtil.getRepeatList(all, tempList);
        }

        String cornerFsCount = corner_fanse_count.getText().toString().trim();
        if (!TextUtils.isEmpty(cornerFsCount)) {
            int count = Integer.parseInt(cornerFsCount);
            List<Probability> tempList = ProbabilityUtil.getKindByTurnOverColorCount(CornerOrEdge.CORNER,count);
            all = ProbabilityUtil.getRepeatList(all, tempList);
        }

        String cornerMinCount = corner_xunhuan_count.getText().toString().trim();
        if (!TextUtils.isEmpty(cornerMinCount)) {
            int count = Integer.parseInt(cornerMinCount);
            List<Probability> tempList = ProbabilityUtil.getKindByMinorCycleCount(CornerOrEdge.CORNER,count);
            all = ProbabilityUtil.getRepeatList(all, tempList);
        }

        if (cornerIshoming > 0) {
            List<Probability> tempList = new ArrayList<>();
            if(cornerIshoming==1){//归位
                tempList = ProbabilityUtil.getKindByIsHoming(CornerOrEdge.CORNER,true);
            }else {//不归位
                tempList = ProbabilityUtil.getKindByIsHoming(CornerOrEdge.CORNER,false);
            }
            all = ProbabilityUtil.getRepeatList(all, tempList);
        }

        if(is_parity_all>0){
            List<Probability> tempList = new ArrayList<>();
            if(is_parity_all==1){//有奇偶
                tempList = ProbabilityUtil.getKindByIsParity(CornerOrEdge.CORNER,true);
            }else {//无奇偶
                tempList = ProbabilityUtil.getKindByIsParity(CornerOrEdge.CORNER,false);
            }
            all = ProbabilityUtil.getRepeatList(all, tempList);
        }
        return all;
    }


    private List<Probability> getEdgeProbability(){
        List<Probability> all = ProbabilityUtil.getEdgeProbabilities();

        String cornerLength = edge_code_length.getText().toString().trim();
        if (!TextUtils.isEmpty(cornerLength)) {
            int length = Integer.parseInt(cornerLength);
            List<Probability> tempList = ProbabilityUtil.getKindByCodeCount(CornerOrEdge.EDGE,length);
            all = ProbabilityUtil.getRepeatList(all, tempList);
        }

        String cornerFsCount = edge_fanse_count.getText().toString().trim();
        if (!TextUtils.isEmpty(cornerFsCount)) {
            int count = Integer.parseInt(cornerFsCount);
            List<Probability> tempList = ProbabilityUtil.getKindByTurnOverColorCount(CornerOrEdge.EDGE,count);
            all = ProbabilityUtil.getRepeatList(all, tempList);
        }

        String cornerMinCount = edge_xunhuan_count.getText().toString().trim();
        if (!TextUtils.isEmpty(cornerMinCount)) {
            int count = Integer.parseInt(cornerMinCount);
            List<Probability> tempList = ProbabilityUtil.getKindByMinorCycleCount(CornerOrEdge.EDGE,count);
            all = ProbabilityUtil.getRepeatList(all, tempList);
        }

        if (edgeIshoming > 0) {
            List<Probability> tempList = new ArrayList<>();
            if(edgeIshoming==1){//归位
                tempList = ProbabilityUtil.getKindByIsHoming(CornerOrEdge.EDGE,true);
            }else {//不归位
                tempList = ProbabilityUtil.getKindByIsHoming(CornerOrEdge.EDGE,false);
            }
            all = ProbabilityUtil.getRepeatList(all, tempList);
        }

        if(is_parity_all>0){
            List<Probability> tempList = new ArrayList<>();
            if(is_parity_all==1){//有奇偶
                tempList = ProbabilityUtil.getKindByIsParity(CornerOrEdge.EDGE,true);
            }else {//无奇偶
                tempList = ProbabilityUtil.getKindByIsParity(CornerOrEdge.EDGE,false);
            }
            all = ProbabilityUtil.getRepeatList(all, tempList);
        }

        return all;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.disrupt_button:
                hideSoftInput();
                Cube cube = new Cube();
                cube.init();
                List<Probability> corners = getCornerProbability();
                List<Probability> edges = getEdgeProbability();
                Probability corner;
                Probability edge;
                switch (dlms_type) {
                    case 0:
                        if (corners.size() == 0) {
                            result_text.setText("");
                            code_layout.setVisibility(View.GONE);
                            toast.show();
                            return;
                        }

                        if (edges.size() == 0) {
                            result_text.setText("");
                            code_layout.setVisibility(View.GONE);
                            toast.show();
                            return;
                        }

                        corner = corners.get(new Random().nextInt(corners.size()));
                        List<Probability> edgeTemp = new ArrayList<>();
                        for (Probability p : edges) {
                            if (p.isParity() == corner.isParity()) {
                                edgeTemp.add(p);
                            }
                        }

                        if (edgeTemp.size() == 0) {
                            result_text.setText("");
                            code_layout.setVisibility(View.GONE);
                            toast.show();
                            return;
                        }
                        edge = edgeTemp.get(new Random().nextInt(edgeTemp.size()));
                        cube.cornerRandomStatus(corner);
                        cube.edgeRandomStatus(edge);
                        break;
                    case 1:
                        if (corners.size() == 0) {
                            result_text.setText("");
                            code_layout.setVisibility(View.GONE);
                            toast.show();
                            return;
                        }
                        corner = corners.get(new Random().nextInt(corners.size()));
                        cube.cornerRandomStatus(corner);
                        break;
                    case 2:
                        if (edges.size() == 0) {
                            result_text.setText("");
                            code_layout.setVisibility(View.GONE);
                            toast.show();
                            return;
                        }
                        edge = edges.get(new Random().nextInt(edges.size()));
                        cube.edgeRandomStatus(edge);
                        break;
                    case 3:
                        //神打
                        List<Probability> probabilities = ProbabilityUtil.getShenType();
                        corner = probabilities.get(0);
                        edge = probabilities.get(1);
                        cube.cornerRandomStatus(corner);
                        cube.edgeRandomStatus(edge);
                        break;

                }
                scremble(cube);
                code_layout.setVisibility(View.VISIBLE);
                break;
            case R.id.clear_button:
                clearTj();
                break;
            case R.id.copy_button:
                //获取剪贴板管理器：
                ClipboardManager cm = (ClipboardManager) getActivity().getSystemService(Context.CLIPBOARD_SERVICE);
                // 创建普通字符型ClipData
                ClipData mClipData = ClipData.newPlainText("Label", result_text.getText().toString());
                // 将ClipData内容放到系统剪贴板里。
                cm.setPrimaryClip(mClipData);
                copyToast.show();
                break;

        }
    }

    private void scremble(Cube cube) {
        String phaseStr = cube.get2phaseStr();
        String result = new Search().solution(phaseStr, 21, 100000000, 0, Search.INVERSE_SOLUTION);

        if (is_dl_zb_all == 0) {//打乱坐标
            CoordinateKeyValue keyValue = CoordinateUtil.coordinateKeyValues.get(new Random().nextInt(CoordinateUtil.coordinateKeyValues.size()));
            cube.disrupt(keyValue.getDisrupt());
            String phaseStr2 = cube.get2phaseStr();
            String result2 = new Search().solution(phaseStr2, 21, 100000000, 0, Search.INVERSE_SOLUTION);
            String disrupt = result2+keyValue.getDisplay();
            result_text.setText(disrupt);
        }else {
            result_text.setText(result);
        }
    }

    private void setBuffer() {
        String cornerBufferStr = SPUtils.getInstance().getString(SpKey.CORNER_BUFFER);
        String[] corner = getResources().getStringArray(R.array.corner_buffer);
        if(TextUtils.isEmpty(cornerBufferStr)){
            corner_buffer.setText("角缓冲："+corner[1]);
        }else{
            corner_buffer.setText("角缓冲："+corner[Integer.parseInt(cornerBufferStr)]);
        }

        String edgeBufferStr = SPUtils.getInstance().getString(SpKey.EDGE_BUFFER);
        String[] edge = getResources().getStringArray(R.array.edge_buffer);

        if (TextUtils.isEmpty(edgeBufferStr)) {
            edge_buffer.setText("棱缓冲："+edge[2]);
        }else {
            edge_buffer.setText("棱缓冲："+edge[Integer.parseInt(edgeBufferStr)]);
        }
    }

    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            switch (intent.getAction()){
                case SpKey.MODIFY_BUFFER_SUCCESS:
                    setBuffer();
                    break;
            }
        }
    };
    private void hideSoftInput() {
        try{
            InputMethodManager mInputMethodManager = (InputMethodManager) getActivity().getSystemService(INPUT_METHOD_SERVICE);
            assert mInputMethodManager != null;
            mInputMethodManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 0);

        }catch (Exception e){

        }
    }








}
