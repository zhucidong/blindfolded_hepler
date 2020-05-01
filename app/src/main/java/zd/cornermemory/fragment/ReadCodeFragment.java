package zd.cornermemory.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Random;

import zd.cornermemory.R;
import zd.cornermemory.bean.CoordinateKeyValue;
import zd.cornermemory.bean.Cube;
import zd.cornermemory.bean.CubeColor;
import zd.cornermemory.bean.DisplayBean;
import zd.cornermemory.bean.Probability;
import zd.cornermemory.bean.SortCode;
import zd.cornermemory.min2phase.Search;
import zd.cornermemory.utils.CoordinateUtil;
import zd.cornermemory.utils.ProbabilityUtil;
import zd.cornermemory.utils.SPUtils;
import zd.cornermemory.utils.SpKey;

import static android.content.Context.INPUT_METHOD_SERVICE;

/**
 * Created by zhud on 2019/4/29.
 * 读码
 */

public class ReadCodeFragment extends Fragment{
    private LinearLayout up_corner_0;
    private LinearLayout up_corner_1;
    private LinearLayout up_corner_2;
    private LinearLayout up_corner_3;
    private LinearLayout up_edge_0;
    private LinearLayout up_edge_1;
    private LinearLayout up_edge_2;
    private LinearLayout up_edge_3;
    private LinearLayout up_edge_4;

    private LinearLayout down_corner_0;
    private LinearLayout down_corner_1;
    private LinearLayout down_corner_2;
    private LinearLayout down_corner_3;
    private LinearLayout down_edge_0;
    private LinearLayout down_edge_1;
    private LinearLayout down_edge_2;
    private LinearLayout down_edge_3;
    private LinearLayout down_edge_4;

    private LinearLayout left_corner_0;
    private LinearLayout left_corner_1;
    private LinearLayout left_corner_2;
    private LinearLayout left_corner_3;
    private LinearLayout left_edge_0;
    private LinearLayout left_edge_1;
    private LinearLayout left_edge_2;
    private LinearLayout left_edge_3;
    private LinearLayout left_edge_4;

    private LinearLayout right_corner_0;
    private LinearLayout right_corner_1;
    private LinearLayout right_corner_2;
    private LinearLayout right_corner_3;
    private LinearLayout right_edge_0;
    private LinearLayout right_edge_1;
    private LinearLayout right_edge_2;
    private LinearLayout right_edge_3;
    private LinearLayout right_edge_4;

    private LinearLayout front_corner_0;
    private LinearLayout front_corner_1;
    private LinearLayout front_corner_2;
    private LinearLayout front_corner_3;
    private LinearLayout front_edge_0;
    private LinearLayout front_edge_1;
    private LinearLayout front_edge_2;
    private LinearLayout front_edge_3;
    private LinearLayout front_edge_4;


    private LinearLayout back_corner_0;
    private LinearLayout back_corner_1;
    private LinearLayout back_corner_2;
    private LinearLayout back_corner_3;
    private LinearLayout back_edge_0;
    private LinearLayout back_edge_1;
    private LinearLayout back_edge_2;
    private LinearLayout back_edge_3;
    private LinearLayout back_edge_4;

    private EditText code_edit;
    private Button disrupt_button;
    private Button clear_button;
    private Button random_button;

    private TextView current_coorniate;
    private TextView corner_buffer;
    private TextView edge_buffer;
    private TextView corner_code;
    private TextView corner_code_fanse;
    private TextView edge_code;
    private TextView edge_code_fanse;
    private TextView coordinate_code;
    private TextView remark;
    private TextView current_corder_sort;
    private TextView current_edge_sort;
    private Toast toast;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab2, container, false);
        toast = Toast.makeText(getActivity(),"打乱公式有误",Toast.LENGTH_SHORT);
        initViews(view);
        initEvent();
        initCube();
        setCoordinate();
        setBuffer();
        setSort();
        registerBroadcast();

        return view;
    }

    private void registerBroadcast() {
        getActivity().registerReceiver(broadcastReceiver,new IntentFilter(SpKey.MODIFY_BUFFER_SUCCESS));
        getActivity().registerReceiver(broadcastReceiver,new IntentFilter(SpKey.MODIFY_COORNIATE_SUCCESS));
        getActivity().registerReceiver(broadcastReceiver,new IntentFilter(SpKey.MODIFY_CODE_SUCCESS));
        getActivity().registerReceiver(broadcastReceiver,new IntentFilter(SpKey.MODIFY_SORT_SUCCESS));
    }

    private void initCube() {
        Cube cube = new Cube();
        cube.init();
        List<DisplayBean> displayBeanList =  cube.getCubeColorStatusData();
        show(displayBeanList);
    }

    private void show(List<DisplayBean> displayBeanList){
        for (DisplayBean displayBean:displayBeanList) {
            switch (displayBean.getCubeDirection()){
                case UP:
                    up_corner_0.setBackground(getDisplayColor(displayBean.getCornerColors().get(0)));
                    up_corner_1.setBackground(getDisplayColor(displayBean.getCornerColors().get(1)));
                    up_corner_2.setBackground(getDisplayColor(displayBean.getCornerColors().get(2)));
                    up_corner_3.setBackground(getDisplayColor(displayBean.getCornerColors().get(3)));

                    up_edge_0.setBackground(getDisplayColor(displayBean.getEdgeColors().get(0)));
                    up_edge_1.setBackground(getDisplayColor(displayBean.getEdgeColors().get(1)));
                    up_edge_2.setBackground(getDisplayColor(displayBean.getEdgeColors().get(2)));
                    up_edge_3.setBackground(getDisplayColor(displayBean.getEdgeColors().get(3)));
                    up_edge_4.setBackground(getDisplayColor(displayBean.getEdgeColors().get(4)));

                    break;
                case DOWN:
                    down_corner_0.setBackground(getDisplayColor(displayBean.getCornerColors().get(0)));
                    down_corner_1.setBackground(getDisplayColor(displayBean.getCornerColors().get(1)));
                    down_corner_2.setBackground(getDisplayColor(displayBean.getCornerColors().get(2)));
                    down_corner_3.setBackground(getDisplayColor(displayBean.getCornerColors().get(3)));

                    down_edge_0.setBackground(getDisplayColor(displayBean.getEdgeColors().get(0)));
                    down_edge_1.setBackground(getDisplayColor(displayBean.getEdgeColors().get(1)));
                    down_edge_2.setBackground(getDisplayColor(displayBean.getEdgeColors().get(2)));
                    down_edge_3.setBackground(getDisplayColor(displayBean.getEdgeColors().get(3)));
                    down_edge_4.setBackground(getDisplayColor(displayBean.getEdgeColors().get(4)));

                    break;
                case LEFT:
                    left_corner_0.setBackground(getDisplayColor(displayBean.getCornerColors().get(0)));
                    left_corner_1.setBackground(getDisplayColor(displayBean.getCornerColors().get(1)));
                    left_corner_2.setBackground(getDisplayColor(displayBean.getCornerColors().get(2)));
                    left_corner_3.setBackground(getDisplayColor(displayBean.getCornerColors().get(3)));

                    left_edge_0.setBackground(getDisplayColor(displayBean.getEdgeColors().get(0)));
                    left_edge_1.setBackground(getDisplayColor(displayBean.getEdgeColors().get(1)));
                    left_edge_2.setBackground(getDisplayColor(displayBean.getEdgeColors().get(2)));
                    left_edge_3.setBackground(getDisplayColor(displayBean.getEdgeColors().get(3)));
                    left_edge_4.setBackground(getDisplayColor(displayBean.getEdgeColors().get(4)));

                    break;
                case RIGHT:
                    right_corner_0.setBackground(getDisplayColor(displayBean.getCornerColors().get(0)));
                    right_corner_1.setBackground(getDisplayColor(displayBean.getCornerColors().get(1)));
                    right_corner_2.setBackground(getDisplayColor(displayBean.getCornerColors().get(2)));
                    right_corner_3.setBackground(getDisplayColor(displayBean.getCornerColors().get(3)));

                    right_edge_0.setBackground(getDisplayColor(displayBean.getEdgeColors().get(0)));
                    right_edge_1.setBackground(getDisplayColor(displayBean.getEdgeColors().get(1)));
                    right_edge_2.setBackground(getDisplayColor(displayBean.getEdgeColors().get(2)));
                    right_edge_3.setBackground(getDisplayColor(displayBean.getEdgeColors().get(3)));
                    right_edge_4.setBackground(getDisplayColor(displayBean.getEdgeColors().get(4)));

                    break;
                case FRONT:
                    front_corner_0.setBackground(getDisplayColor(displayBean.getCornerColors().get(0)));
                    front_corner_1.setBackground(getDisplayColor(displayBean.getCornerColors().get(1)));
                    front_corner_2.setBackground(getDisplayColor(displayBean.getCornerColors().get(2)));
                    front_corner_3.setBackground(getDisplayColor(displayBean.getCornerColors().get(3)));

                    front_edge_0.setBackground(getDisplayColor(displayBean.getEdgeColors().get(0)));
                    front_edge_1.setBackground(getDisplayColor(displayBean.getEdgeColors().get(1)));
                    front_edge_2.setBackground(getDisplayColor(displayBean.getEdgeColors().get(2)));
                    front_edge_3.setBackground(getDisplayColor(displayBean.getEdgeColors().get(3)));
                    front_edge_4.setBackground(getDisplayColor(displayBean.getEdgeColors().get(4)));

                    break;
                case BACK:
                    back_corner_0.setBackground(getDisplayColor(displayBean.getCornerColors().get(0)));
                    back_corner_1.setBackground(getDisplayColor(displayBean.getCornerColors().get(1)));
                    back_corner_2.setBackground(getDisplayColor(displayBean.getCornerColors().get(2)));
                    back_corner_3.setBackground(getDisplayColor(displayBean.getCornerColors().get(3)));

                    back_edge_0.setBackground(getDisplayColor(displayBean.getEdgeColors().get(0)));
                    back_edge_1.setBackground(getDisplayColor(displayBean.getEdgeColors().get(1)));
                    back_edge_2.setBackground(getDisplayColor(displayBean.getEdgeColors().get(2)));
                    back_edge_3.setBackground(getDisplayColor(displayBean.getEdgeColors().get(3)));
                    back_edge_4.setBackground(getDisplayColor(displayBean.getEdgeColors().get(4)));
                    break;
            }
        }
    }

    private Drawable getDisplayColor(CubeColor colorEnum){
        Drawable color = null;
        switch (colorEnum) {
            case YELLOW:
                color = getResources().getDrawable(R.drawable.color_yellow_bg);
                break;
            case WIHTE:
                color = getResources().getDrawable(R.drawable.color_white_bg);
                break;
            case BLUE:
                color = getResources().getDrawable(R.drawable.color_blue_bg);
                break;
            case GREEN:
                color = getResources().getDrawable(R.drawable.color_green_bg);
                break;
            case RED:
                color = getResources().getDrawable(R.drawable.color_red_bg);
                break;
            case ORANGE:
                color = getResources().getDrawable(R.drawable.color_orange_bg);
                break;
        }

        return color;
    }

    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            switch (intent.getAction()){
                case SpKey.MODIFY_BUFFER_SUCCESS:
                    setBuffer();
                    break;
                case SpKey.MODIFY_COORNIATE_SUCCESS:
                    setCoordinate();
                    initCube();
                    break;
                case SpKey.MODIFY_CODE_SUCCESS:
                    setSort();
                    break;
                case SpKey.MODIFY_SORT_SUCCESS:
                    setSort();
                    break;
            }
        }
    };


    private void initViews(View view) {
        up_corner_0 = view.findViewById(R.id.up_corner_0);
        up_corner_1 = view.findViewById(R.id.up_corner_1);
        up_corner_2 = view.findViewById(R.id.up_corner_2);
        up_corner_3 = view.findViewById(R.id.up_corner_3);
        up_edge_0 = view.findViewById(R.id.up_edge_0);
        up_edge_1 = view.findViewById(R.id.up_edge_1);
        up_edge_2 = view.findViewById(R.id.up_edge_2);
        up_edge_3 = view.findViewById(R.id.up_edge_3);
        up_edge_4 = view.findViewById(R.id.up_edge_4);

        down_corner_0 = view.findViewById(R.id.down_corner_0);
        down_corner_1 = view.findViewById(R.id.down_corner_1);
        down_corner_2 = view.findViewById(R.id.down_corner_2);
        down_corner_3 = view.findViewById(R.id.down_corner_3);
        down_edge_0 = view.findViewById(R.id.down_edge_0);
        down_edge_1 = view.findViewById(R.id.down_edge_1);
        down_edge_2 = view.findViewById(R.id.down_edge_2);
        down_edge_3 = view.findViewById(R.id.down_edge_3);
        down_edge_4 = view.findViewById(R.id.down_edge_4);


        left_corner_0 = view.findViewById(R.id.left_corner_0);
        left_corner_1 = view.findViewById(R.id.left_corner_1);
        left_corner_2 = view.findViewById(R.id.left_corner_2);
        left_corner_3 = view.findViewById(R.id.left_corner_3);
        left_edge_0 = view.findViewById(R.id.left_edge_0);
        left_edge_1 = view.findViewById(R.id.left_edge_1);
        left_edge_2 = view.findViewById(R.id.left_edge_2);
        left_edge_3 = view.findViewById(R.id.left_edge_3);
        left_edge_4 = view.findViewById(R.id.left_edge_4);


        right_corner_0 = view.findViewById(R.id.right_corner_0);
        right_corner_1 = view.findViewById(R.id.right_corner_1);
        right_corner_2 = view.findViewById(R.id.right_corner_2);
        right_corner_3 = view.findViewById(R.id.right_corner_3);
        right_edge_0 = view.findViewById(R.id.right_edge_0);
        right_edge_1 = view.findViewById(R.id.right_edge_1);
        right_edge_2 = view.findViewById(R.id.right_edge_2);
        right_edge_3 = view.findViewById(R.id.right_edge_3);
        right_edge_4 = view.findViewById(R.id.right_edge_4);

        front_corner_0 = view.findViewById(R.id.front_corner_0);
        front_corner_1 = view.findViewById(R.id.front_corner_1);
        front_corner_2 = view.findViewById(R.id.front_corner_2);
        front_corner_3 = view.findViewById(R.id.front_corner_3);
        front_edge_0 = view.findViewById(R.id.front_edge_0);
        front_edge_1 = view.findViewById(R.id.front_edge_1);
        front_edge_2 = view.findViewById(R.id.front_edge_2);
        front_edge_3 = view.findViewById(R.id.front_edge_3);
        front_edge_4 = view.findViewById(R.id.front_edge_4);

        back_corner_0 = view.findViewById(R.id.back_corner_0);
        back_corner_1 = view.findViewById(R.id.back_corner_1);
        back_corner_2 = view.findViewById(R.id.back_corner_2);
        back_corner_3 = view.findViewById(R.id.back_corner_3);
        back_edge_0 = view.findViewById(R.id.back_edge_0);
        back_edge_1 = view.findViewById(R.id.back_edge_1);
        back_edge_2 = view.findViewById(R.id.back_edge_2);
        back_edge_3 = view.findViewById(R.id.back_edge_3);
        back_edge_4 = view.findViewById(R.id.back_edge_4);

        code_edit = view.findViewById(R.id.code_edit);
        disrupt_button = view.findViewById(R.id.disrupt_button);
        clear_button = view.findViewById(R.id.clear_button);
        random_button = view.findViewById(R.id.random_button);

        current_coorniate = view.findViewById(R.id.current_coorniate);
        corner_buffer = view.findViewById(R.id.corner_buffer);
        edge_buffer = view.findViewById(R.id.edge_buffer);
        corner_code = view.findViewById(R.id.corner_code);
        corner_code_fanse = view.findViewById(R.id.corner_code_fanse);
        edge_code = view.findViewById(R.id.edge_code);
        edge_code_fanse = view.findViewById(R.id.edge_code_fanse);
        coordinate_code = view.findViewById(R.id.coordinate_code);
        remark = view.findViewById(R.id.remark);
        current_corder_sort = view.findViewById(R.id.current_corder_sort);
        current_edge_sort = view.findViewById(R.id.current_edge_sort);

    }

    private void setSort(){
        boolean iskeepHue = SPUtils.getInstance().getBoolean(SpKey.KEEP_HUE);
        boolean iskeepHueEdge = SPUtils.getInstance().getBoolean(SpKey.KEEP_HUE_EDGE);
        String isKeepStr = "蓝色借位，绿色还位";

        SpannableStringBuilder ssb = new SpannableStringBuilder();


        SpannableString ss = new SpannableString("蓝色借位,");
        ForegroundColorSpan span = new ForegroundColorSpan(Color.parseColor("#0099EE"));
        ss.setSpan(span,0,4, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        ssb.append(ss);

        SpannableString ss2 = new SpannableString("绿色还位");
        ForegroundColorSpan span2 = new ForegroundColorSpan(Color.parseColor("#00FF33"));
        ss2.setSpan(span2,0,4, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        ssb.append(ss2);

        if(iskeepHue&&iskeepHueEdge){
            ssb.append(" (保持色相借位)");
        }else if(!iskeepHue&&!iskeepHueEdge){
            ssb.append(" （未保持色相借位）");
        }else{
            if (iskeepHue) {
                ssb.append(" 角保持色相");
            }else {
                ssb.append(" 角未保持色相");
            }

            if (iskeepHueEdge) {
                ssb.append(" 棱保持色相");
            }else {
                ssb.append(" 棱未保持色相");
            }

        }
        remark.setText(ssb);
        String cornerSortStr = "角块：";
        String edgeSortStr = "棱块：";
        List<SortCode>[] sorts = CoordinateUtil.getSortCode();
        for(SortCode sc:sorts[0]){
            cornerSortStr+=sc.getDisplay()+" ";
        }
        for(SortCode sc:sorts[1]){
            edgeSortStr+=sc.getDisplay()+" ";
        }
        current_corder_sort.setText(cornerSortStr);
        current_edge_sort.setText(edgeSortStr);
    }

    private void setBuffer() {
        String cornerBufferStr = SPUtils.getInstance().getString(SpKey.CORNER_BUFFER);
        String[] corner = getResources().getStringArray(R.array.corner_buffer);
        if(TextUtils.isEmpty(cornerBufferStr)){
            corner_buffer.setText("角块缓冲："+corner[1]);
        }else{
            corner_buffer.setText("角块缓冲："+corner[Integer.parseInt(cornerBufferStr)]);
        }

        String edgeBufferStr = SPUtils.getInstance().getString(SpKey.EDGE_BUFFER);
        String[] edge = getResources().getStringArray(R.array.edge_buffer);

        if (TextUtils.isEmpty(edgeBufferStr)) {
            edge_buffer.setText("棱块缓冲："+edge[2]);
        }else {
            edge_buffer.setText("棱块缓冲："+edge[Integer.parseInt(edgeBufferStr)]);
        }
    }

    private void setCoordinate() {
        String coordinateStr = SPUtils.getInstance().getString(SpKey.COORDINATE);
        String[] s = getResources().getStringArray(R.array.coordinate);
        if(TextUtils.isEmpty(coordinateStr)){
            current_coorniate.setText("当前坐标："+s[2]);
        }else{
           List<String> flags =  CoordinateUtil.getcoordinateFlag();
            for(int i = 0;i<flags.size();i++) {
                if (TextUtils.equals(coordinateStr, flags.get(i))) {
                    current_coorniate.setText("当前坐标："+s[i]);
                    break;
                }
            }
        }
    }

    private void initEvent() {

        disrupt_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                disrupt();
            }
        });

        random_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                code_edit.setText("");
                Cube cube = new Cube();
                cube.init();
                List<Probability> probabilities = ProbabilityUtil.getRandomType();


                Probability corner = probabilities.get(0);
                Probability edge = probabilities.get(1);
                cube.cornerRandomStatus(corner);
                cube.edgeRandomStatus(edge);
//                System.out.println("当前类型c："+corner);
//                System.out.println("当前类型e："+edge);
                String phaseStr = cube.get2phaseStr();
                String result = new Search().solution(phaseStr, 21, 100000000, 0, Search.INVERSE_SOLUTION);


                CoordinateKeyValue keyValue = CoordinateUtil.coordinateKeyValues.get(new Random().nextInt(CoordinateUtil.coordinateKeyValues.size()));
                cube.disrupt(keyValue.getDisrupt());
                String phaseStr2 = cube.get2phaseStr();
                String result2 = new Search().solution(phaseStr2, 21, 100000000, 0, Search.INVERSE_SOLUTION);
                String disrupt = result2+keyValue.getDisplay();
                code_edit.setText(disrupt);

//                //随机打乱
//                code_edit.setText(result);
                disrupt();
            }
        });
        clear_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                hideSoftInput();
                code_edit.setText("");
                Cube cube = new Cube();
                cube.init();
                List<DisplayBean> displayBeanList =  cube.getCubeColorStatusData();
                show(displayBeanList);
                coordinate_code.setText("坐标调整： ");
                corner_code.setText("角块编码： ");
                corner_code_fanse.setText("角块翻色： ");
                edge_code.setText("棱块编码： ");
                edge_code_fanse.setText("棱块翻色： ");
            }
        });
    }

    private void hideSoftInput() {
        try{
            InputMethodManager mInputMethodManager = (InputMethodManager) getActivity().getSystemService(INPUT_METHOD_SERVICE);
            assert mInputMethodManager != null;
            mInputMethodManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 0);

        }catch (Exception e){

        }
    }

    private void disrupt() {
        hideSoftInput();

        String code = code_edit.getText().toString();
        if(isCorrect(code)){
            Cube cube = new Cube();
            cube.init();
            cube.disrupt(code);
            List<DisplayBean> displayBeanList =  cube.getCubeColorStatusData();
            show(displayBeanList);

            //最少步求解
            // String result = new Search().solution(cube.get2phaseStr(), 21, 100000000, 0, 0);
            // System.out.println(result);

            String coordinateStr = cube.handlCoordinate();
            coordinate_code.setText("坐标调整： "+coordinateStr);
            SpannableStringBuilder[] cornerSsb = cube.readCorner();
            SpannableStringBuilder codeStr = cornerSsb[0];
            SpannableStringBuilder codeFStr = cornerSsb[1];
            corner_code.setText(codeStr);
            corner_code_fanse.setText(codeFStr);


            SpannableStringBuilder[] edgeSsb = cube.readEdge();
            SpannableStringBuilder codeEdgeStr = edgeSsb[0];
            SpannableStringBuilder codeFEdgeStr = edgeSsb[1];

            edge_code.setText(codeEdgeStr);
            edge_code_fanse.setText(codeFEdgeStr);

            return;
        }

        toast.show();
    }

    private boolean isCorrect(String code) {
        String regex = "[RUDLFBEMSxyz'w2\\s]+";
        return code.matches(regex);
    }


}
