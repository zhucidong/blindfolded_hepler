package zd.cornermemory.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.ReplacementTransformationMethod;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import zd.cornermemory.R;
import zd.cornermemory.adapter.NormalAdapter;
import zd.cornermemory.utils.CodeUtil;
import zd.cornermemory.utils.SPUtils;

import static android.content.Context.INPUT_METHOD_SERVICE;
import static zd.cornermemory.R.id.open_radio;

/**
 * Created by zhud on 2019/4/29.
 */

public class RememberFragment extends Fragment implements View.OnClickListener{

    private Button startButton;
    private Button input;
    private Button check;
    private TextView code_text;
    private RadioGroup radio_group;
    private RadioGroup lx_radio_group;
    private int team = -1;//默认组数3-5
    private boolean isOpenLx = true;//是否开启联想词,默认开启
    private EditText ans;
    private String currentAns = "";
    private NormalAdapter adapter;
    private List<String> codeList = new ArrayList<>();
    private RecyclerView recycleView;
    private View dialogView;
    private AlertDialog.Builder builder;//数字题dialog
    private TextView tip;
    private TextView number1;
    private TextView number2;
    private TextView number3;
    private EditText answer1;
    private EditText answer2;
    private EditText answer3;
    private LinearLayout ans_layout;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab1, container, false);
        dialogView = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_number,null);

        initDialogViews(dialogView);

        startButton = view.findViewById(R.id.start_button);


        ans_layout = view.findViewById(R.id.ans_layout);
        recycleView = view.findViewById(R.id.recycleView);
        input = view.findViewById(R.id.input);
        check = view.findViewById(R.id.check);
        code_text = view.findViewById(R.id.code_text);
        radio_group = view.findViewById(R.id.radio_group);
        lx_radio_group = view.findViewById(R.id.lx_radio_group);
        ans = view.findViewById(R.id.ans);
        startButton.setOnClickListener(this);
        input.setOnClickListener(this);
        check.setOnClickListener(this);
        ans.setTransformationMethod(new UpperCaseTransform());
        radio_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                switch (checkedId) {
                    case R.id.three_five_radio:
                        team = -1;
                        break;
                    case R.id.three_radio:
                        team = 3;
                        break;
                    case R.id.four_radio:
                        team = 4;
                        break;
                    case R.id.five_radio:
                        team = 5;
                        break;
                }
            }
        });

        lx_radio_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                switch (checkedId) {
                    case open_radio:
                        isOpenLx = true;
                        recycleView.setVisibility(View.VISIBLE);
                        SPUtils.getInstance().put("is_open",true);
                        break;
                    case R.id.close_radio:
                        isOpenLx = false;
                        SPUtils.getInstance().put("is_open",false);
                        recycleView.setVisibility(View.INVISIBLE);
                        break;
                }
            }
        });
        ans.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(!TextUtils.isEmpty(ans.getText().toString().trim()))
                    code_text.setVisibility(View.INVISIBLE);
                    recycleView.setVisibility(View.INVISIBLE);
            }
        });

        ans.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                checkAnswer();
                return false;
            }
        });

        adapter = new NormalAdapter(codeList);
        recycleView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        recycleView.setAdapter(adapter);
        //第一次进入先自动生成编码
        createCode();
        isOpenLx = SPUtils.getInstance().getBoolean("is_open");
        if(!SPUtils.getInstance().getBoolean("is_frist")){//如果是第一次打开 默认开启联想
            isOpenLx = true;
            SPUtils.getInstance().put("is_open",true);
            lx_radio_group.check(R.id.open_radio);
        }
        if(isOpenLx){
            SPUtils.getInstance().put("is_open",true);
            lx_radio_group.check(R.id.open_radio);
            recycleView.setVisibility(View.VISIBLE);
        }else {
            SPUtils.getInstance().put("is_open",false);
            lx_radio_group.check(R.id.close_radio);
            recycleView.setVisibility(View.INVISIBLE);
        }
        SPUtils.getInstance().put("is_frist",true);
        return view;
    }

    private void initDialogViews(View view) {
        tip = view.findViewById(R.id.tip);
        number1 = view.findViewById(R.id.number1);
        number2 = view.findViewById(R.id.number2);
        number3 = view.findViewById(R.id.number3);
        answer1 = view.findViewById(R.id.answer1);
        answer2 = view.findViewById(R.id.answer2);
        answer3 = view.findViewById(R.id.answer3);
        tip.setVisibility(View.GONE);
    }

    //三题答案
    private String ansStr1;
    private String ansStr2;
    private String ansStr3;

    //设置题目及答案
    private void setSubject(){
        List<Integer> number1List = new ArrayList<>();
        number1List.add(getRandomNumber());
        number1List.add(getRandomNumber());
        number1List.add(getRandomNumber());
        String subject1Str = number1List.get(0)+" * "+number1List.get(1)+" + "+number1List.get(2)+" = ?";
        number1.setText(subject1Str);
        //xx * xx + xx = ?
        ansStr1 = number1List.get(0)*number1List.get(1)+number1List.get(2)+"";


        List<Integer> number2List = new ArrayList<>();
        number2List.add(getRandomNumber());
        number2List.add(getRandomNumber());
        number2List.add(getRandomNumber());
        String subject2Str = number2List.get(0)+" + "+number2List.get(1)+" * "+number2List.get(2)+" = ?";
        number2.setText(subject2Str);
        //xx + xx * xx = ?
        ansStr2 = number2List.get(0)+number2List.get(1)*number2List.get(2)+"";


        List<Integer> number3List = new ArrayList<>();
        number3List.add(getRandomNumber());
        number3List.add(getRandomNumber());
        number3List.add(getRandomNumber());
        String subject3Str = number3List.get(0)+" + "+number3List.get(1)+" + "+number3List.get(2)+" = ?";
        number3.setText(subject3Str);
        //xx + xx + xx = ?
        ansStr3 = number3List.get(0)+number3List.get(1)+number3List.get(2)+"";
    }

    //随机生成题目中的数字
    private int getRandomNumber(){
        int number=0;
        Random random = new Random();
        number = random.nextInt(10);
        if (number == 0) {
            return getRandom();
        }
        return number;
    }



    @Override
    public void onClick(View view) {
        hideSoftInput();
        switch (view.getId()) {
            case R.id.start_button:
                createCode();
                if(isOpenLx){
                    recycleView.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.input:
                inputAnswer();


                break;

            case R.id.check:
                checkAnswer();
                break;
        }
    }

    private void hideSoftInput() {
        try{
            InputMethodManager mInputMethodManager = (InputMethodManager) getActivity().getSystemService(INPUT_METHOD_SERVICE);
            assert mInputMethodManager != null;
            mInputMethodManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 0);

        }catch (Exception e){

        }
    }

    private void inputAnswer() {
        code_text.setVisibility(View.INVISIBLE);
        recycleView.setVisibility(View.INVISIBLE);
        ans.setText("");
        ans_layout.setVisibility(View.VISIBLE);
        dialogView = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_number,null);
        initDialogViews(dialogView);
        setSubject();
        builder = new AlertDialog.Builder(getActivity())
                .setTitle("提示")
                .setView(dialogView)
                .setMessage("先做完数学题再填写之前记忆的编码")
                .setCancelable(false)
                .setNegativeButton("放弃(重新记忆下一组编码)", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        createCode();
                        if(isOpenLx){
                            recycleView.setVisibility(View.VISIBLE);
                        }
                        dialog.dismiss();
                    }
                })
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });


        final AlertDialog dialog = builder.create();
        dialog.show();
        //重写“确定”，截取监听
        dialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String noFinishTip = "请做完数学题再说！";
                String noCorrect = "数学题不完全正确,请检查！！！";

                //检验题目是否做完
                String answer1Str = answer1.getText().toString().trim();
                String answer2Str = answer2.getText().toString().trim();
                String answer3Str = answer3.getText().toString().trim();
                if (TextUtils.isEmpty(answer1Str)) {
                    tip.setVisibility(View.VISIBLE);
                    tip.setText(noFinishTip);
                    return;
                }else if(TextUtils.isEmpty(answer2Str)){
                    tip.setVisibility(View.VISIBLE);
                    tip.setText(noFinishTip);
                    return;
                }else if(TextUtils.isEmpty(answer3Str)){
                    tip.setVisibility(View.VISIBLE);
                    tip.setText(noFinishTip);
                    return;
                }
                if(!(ansStr1.equals(answer1Str)&&ansStr2.equals(answer2Str)&&ansStr3.equals(answer3Str))){
                    tip.setVisibility(View.VISIBLE);
                    tip.setText(noCorrect);
                    return;
                }


                dialog.dismiss();




            }
        });
    }

    private void checkAnswer() {
        code_text.setVisibility(View.VISIBLE);
        if(isOpenLx){
            recycleView.setVisibility(View.VISIBLE);
        }
        ans_layout.setVisibility(View.VISIBLE);
        String ansStr = ans.getText().toString().trim();
        if (TextUtils.isEmpty(ansStr)) {
            return;
        }
        if(!ansStr.toUpperCase().equals(currentAns)){

            new AlertDialog.Builder(getActivity())
                    .setTitle("提示")
                    .setMessage("回答错误")
                    .setCancelable(false)
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ans.requestFocus();
                            dialog.dismiss();
                        }
                    }).show();


        }else{
            new AlertDialog.Builder(getActivity())
                    .setTitle("提示")
                    .setMessage("回答正确")
                    .setCancelable(false)
                    .setPositiveButton("下一组", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ans.setText("");
                            ans_layout.setVisibility(View.INVISIBLE);
                            createCode();
                            dialog.dismiss();
                        }
                    }).show();

        }
    }

    //生成编码
    private void createCode() {
        codeList.clear();
        code_text.setVisibility(View.VISIBLE);
        if(isOpenLx){
            recycleView.setVisibility(View.VISIBLE);
        }
        ans.setText("");
        ans_layout.setVisibility(View.INVISIBLE);
        String codes = CodeUtil.getCode(team);
        if(team==-1){
            codes = CodeUtil.getCode(getRandom());
        }
        codes = codes.substring(0,codes.length()-1);
        code_text.setText(codes);

        String[] c = codes.split("  ");
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < c.length; i++) {
            sb.append(c[i].trim());
        }
        currentAns = sb.toString();

        for (int i = 0; i <c.length; i++) {
            codeList.add(c[i].trim());
        }
       adapter.notifyDataSetChanged();
        if(isOpenLx){
            recycleView.setVisibility(View.VISIBLE);
        }
    }

    private int getRandom(){
        int t ;
        Random random = new Random();
        t = random.nextInt(5);
        if(t<2){
            return getRandom();
        }
        return t;
    }

    //首先是小写转大写的方法
    public class UpperCaseTransform extends ReplacementTransformationMethod {
        @Override
        protected char[] getOriginal() {
            char[] aa = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
            return aa;
        }

        @Override
        protected char[] getReplacement() {
            char[] cc = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
            return cc;
        }
    }




}
