package zd.cornermemory.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import zd.cornermemory.R;
import zd.cornermemory.bean.CubeCode;
import zd.cornermemory.utils.CoordinateUtil;
import zd.cornermemory.utils.SPUtils;
import zd.cornermemory.utils.SpKey;

/**
 * 修改编码
 */
public class MotifyCodeActivity extends BaseActivity {
    private EditText c_a;
    private EditText c_b;
    private EditText c_c;
    private EditText c_d;
    private EditText c_e;
    private EditText c_f;
    private EditText c_g;
    private EditText c_h;
    private EditText c_i;
    private EditText c_j;
    private EditText c_k;
    private EditText c_l;
    private EditText c_w;
    private EditText c_m;
    private EditText c_n;
    private EditText c_o;
    private EditText c_p;
    private EditText c_q;
    private EditText c_r;
    private EditText c_s;
    private EditText c_t;
    private EditText c_x;
    private EditText c_y;
    private EditText c_z;

    private EditText e_a;
    private EditText e_b;
    private EditText e_c;
    private EditText e_d;
    private EditText e_e;
    private EditText e_f;
    private EditText e_g;
    private EditText e_h;
    private EditText e_i;
    private EditText e_j;
    private EditText e_k;
    private EditText e_l;
    private EditText e_m;
    private EditText e_n;
    private EditText e_o;
    private EditText e_p;
    private EditText e_q;
    private EditText e_r;
    private EditText e_s;
    private EditText e_t;
    private EditText e_w;
    private EditText e_x;
    private EditText e_y;
    private EditText e_z;

    private Button save_button;

    private String str_c_a;
    private String str_c_b;
    private String str_c_c;
    private String str_c_d;
    private String str_c_e;
    private String str_c_f;
    private String str_c_g;
    private String str_c_h;
    private String str_c_i;
    private String str_c_j;
    private String str_c_k;
    private String str_c_l;
    private String str_c_w;
    private String str_c_m;
    private String str_c_n;
    private String str_c_o;
    private String str_c_p;
    private String str_c_q;
    private String str_c_r;
    private String str_c_s;
    private String str_c_t;
    private String str_c_x;
    private String str_c_y;
    private String str_c_z;

    private String str_e_a;
    private String str_e_b;
    private String str_e_c;
    private String str_e_d;
    private String str_e_e;
    private String str_e_f;
    private String str_e_g;
    private String str_e_h;
    private String str_e_i;
    private String str_e_j;
    private String str_e_k;
    private String str_e_l;
    private String str_e_m;
    private String str_e_n;
    private String str_e_o;
    private String str_e_p;
    private String str_e_q;
    private String str_e_r;
    private String str_e_s;
    private String str_e_t;
    private String str_e_w;
    private String str_e_x;
    private String str_e_y;
    private String str_e_z;
    private Toast empty ;
    private Toast repC ;
    private Toast repE ;
    private Toast succes ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motify_code);
        initViews();
        initEditEvent();
        initOnclick();
        initData();
        empty =Toast.makeText(mContext,"角或棱编码不完整",Toast.LENGTH_SHORT);
        repC =Toast.makeText(mContext,"角块编码有重复元素",Toast.LENGTH_SHORT);
        repE =Toast.makeText(mContext,"棱块编码有重复元素",Toast.LENGTH_SHORT);
        succes =Toast.makeText(mContext,"修改成功",Toast.LENGTH_SHORT);
    }

    private void initData() {
        List<CubeCode> cubeCodes = CoordinateUtil.getCustomCode();
        initCubeCode(cubeCodes);
    }

    /**
     * 初始化编码
     * @param codes
     */
    private void initCubeCode(List<CubeCode> codes) {
        for (CubeCode code : codes) {
            switch (code.getDirection()) {
                case UP:
                    c_g.setText(code.getCorners().get(0));
                    c_j.setText(code.getCorners().get(1));
                    c_a.setText(code.getCorners().get(2));
                    c_d.setText(code.getCorners().get(3));

                    e_e.setText(code.getEdges().get(0));
                    e_g.setText(code.getEdges().get(1));
                    e_a.setText(code.getEdges().get(2));
                    e_c.setText(code.getEdges().get(3));

                    break;
                case DOWN:
                    c_x.setText(code.getCorners().get(0));
                    c_r.setText(code.getCorners().get(1));
                    c_o.setText(code.getCorners().get(2));
                    c_w.setText(code.getCorners().get(3));

                    e_i.setText(code.getEdges().get(0));
                    e_o.setText(code.getEdges().get(1));
                    e_m.setText(code.getEdges().get(2));
                    e_k.setText(code.getEdges().get(3));
                    break;
                case LEFT:
                    c_c.setText(code.getCorners().get(0));
                    c_m.setText(code.getCorners().get(1));
                    c_q.setText(code.getCorners().get(2));
                    c_e.setText(code.getCorners().get(3));

                    e_d.setText(code.getEdges().get(0));
                    e_t.setText(code.getEdges().get(1));
                    e_l.setText(code.getEdges().get(2));
                    e_x.setText(code.getEdges().get(3));
                    break;
                case RIGHT:
                    c_i.setText(code.getCorners().get(0));
                    c_s.setText(code.getCorners().get(1));
                    c_z.setText(code.getCorners().get(2));
                    c_k.setText(code.getCorners().get(3));

                    e_h.setText(code.getEdges().get(0));
                    e_z.setText(code.getEdges().get(1));
                    e_p.setText(code.getEdges().get(2));
                    e_r.setText(code.getEdges().get(3));
                    break;
                case FRONT:
                    c_l.setText(code.getCorners().get(0));
                    c_y.setText(code.getCorners().get(1));
                    c_n.setText(code.getCorners().get(2));
                    c_b.setText(code.getCorners().get(3));

                    e_b.setText(code.getEdges().get(0));
                    e_q.setText(code.getEdges().get(1));
                    e_j.setText(code.getEdges().get(2));
                    e_s.setText(code.getEdges().get(3));
                    break;
                case BACK:
                    c_f.setText(code.getCorners().get(0));
                    c_p.setText(code.getCorners().get(1));
                    c_t.setText(code.getCorners().get(2));
                    c_h.setText(code.getCorners().get(3));

                    e_f.setText(code.getEdges().get(0));
                    e_w.setText(code.getEdges().get(1));
                    e_n.setText(code.getEdges().get(2));
                    e_y.setText(code.getEdges().get(3));
                    break;
            }

        }
    }

    private boolean isCorrect(){
        str_c_a = c_a.getText().toString().trim().toUpperCase();
        str_c_b = c_b.getText().toString().trim().toUpperCase();
        str_c_c = c_c.getText().toString().trim().toUpperCase();

        str_c_d = c_d.getText().toString().trim().toUpperCase();
        str_c_e = c_e.getText().toString().trim().toUpperCase();
        str_c_f = c_f.getText().toString().trim().toUpperCase();

        str_c_g = c_g.getText().toString().trim().toUpperCase();
        str_c_h = c_h.getText().toString().trim().toUpperCase();
        str_c_i = c_i.getText().toString().trim().toUpperCase();

        str_c_j = c_j.getText().toString().trim().toUpperCase();
        str_c_k = c_k.getText().toString().trim().toUpperCase();
        str_c_l = c_l.getText().toString().trim().toUpperCase();

        str_c_w = c_w.getText().toString().trim().toUpperCase();
        str_c_m = c_m.getText().toString().trim().toUpperCase();
        str_c_n = c_n.getText().toString().trim().toUpperCase();

        str_c_o = c_o.getText().toString().trim().toUpperCase();
        str_c_p = c_p.getText().toString().trim().toUpperCase();
        str_c_q = c_q.getText().toString().trim().toUpperCase();

        str_c_r = c_r.getText().toString().trim().toUpperCase();
        str_c_s = c_s.getText().toString().trim().toUpperCase();
        str_c_t = c_t.getText().toString().trim().toUpperCase();

        str_c_x = c_x.getText().toString().trim().toUpperCase();
        str_c_y = c_y.getText().toString().trim().toUpperCase();
        str_c_z = c_z.getText().toString().trim().toUpperCase();

        str_e_a = e_a.getText().toString().trim().toUpperCase();
        str_e_b = e_b.getText().toString().trim().toUpperCase();
        str_e_c = e_c.getText().toString().trim().toUpperCase();
        str_e_d = e_d.getText().toString().trim().toUpperCase();

        str_e_e = e_e.getText().toString().trim().toUpperCase();
        str_e_f = e_f.getText().toString().trim().toUpperCase();
        str_e_g = e_g.getText().toString().trim().toUpperCase();
        str_e_h = e_h.getText().toString().trim().toUpperCase();

        str_e_i = e_i.getText().toString().trim().toUpperCase();
        str_e_j = e_j.getText().toString().trim().toUpperCase();
        str_e_k = e_k.getText().toString().trim().toUpperCase();
        str_e_l = e_l.getText().toString().trim().toUpperCase();

        str_e_m = e_m.getText().toString().trim().toUpperCase();
        str_e_n = e_n.getText().toString().trim().toUpperCase();
        str_e_o = e_o.getText().toString().trim().toUpperCase();
        str_e_p = e_p.getText().toString().trim().toUpperCase();

        str_e_q = e_q.getText().toString().trim().toUpperCase();
        str_e_r = e_r.getText().toString().trim().toUpperCase();
        str_e_s = e_s.getText().toString().trim().toUpperCase();
        str_e_t = e_t.getText().toString().trim().toUpperCase();

        str_e_w = e_w.getText().toString().trim().toUpperCase();
        str_e_x = e_x.getText().toString().trim().toUpperCase();
        str_e_y = e_y.getText().toString().trim().toUpperCase();
        str_e_z = e_z.getText().toString().trim().toUpperCase();

        return isEmpty(str_c_a,str_c_b,str_c_c,
                str_c_d,str_c_e,str_c_f,
                str_c_g,str_c_h,str_c_i,
                str_c_j,str_c_k,str_c_l,
                str_c_w,str_c_m,str_c_n
                ,str_c_o,str_c_p,str_c_q,
                str_c_r,str_c_s,str_c_t,
                str_c_x,str_c_y,str_c_z,

                str_e_a,str_e_b,str_e_c,str_e_d,
                str_e_e,str_e_f,str_e_g,str_e_h,
                str_e_i,str_e_j,str_e_k,str_e_l,
                str_e_m,str_e_n,str_e_o,str_e_p,
                str_e_q,str_e_r,str_e_s,str_e_t,
                str_e_w,str_e_x,str_e_y,str_e_z
        );
    }


    private boolean isEmpty(String... str){
        boolean isEmp = false;
        for(String s:str){
            if(TextUtils.isEmpty(s)){
                isEmp = true;
                break;
            }
        }
        return isEmp;
    }




    private boolean isRepeatC(){
        return isRepeat(str_c_a,str_c_b,str_c_c,
                str_c_d,str_c_e,str_c_f,
                str_c_g,str_c_h,str_c_i,
                str_c_j,str_c_k,str_c_l,
                str_c_w,str_c_m,str_c_n
                ,str_c_o,str_c_p,str_c_q,
                str_c_r,str_c_s,str_c_t,
                str_c_x,str_c_y,str_c_z);
    }

    private boolean isRepeatE(){
        return isRepeat(
                str_e_a,str_e_b,str_e_c,str_e_d,
                str_e_e,str_e_f,str_e_g,str_e_h,
                str_e_i,str_e_j,str_e_k,str_e_l,
                str_e_m,str_e_n,str_e_o,str_e_p,
                str_e_q,str_e_r,str_e_s,str_e_t,
                str_e_w,str_e_x,str_e_y,str_e_z);
    }


    private boolean isRepeat(String... str){
        List<String> list = new ArrayList<>();
        for (String s:str) {
            list.add(s);
        }
        String temp = "";
        for (int i = 0; i < list.size() - 1; i++)
        {
            temp = list.get(i);
            for (int j = i + 1; j < list.size(); j++)
            {
                if (temp.equals(list.get(j)))
                {
                    return true;
                }
            }
        }
        return false;
    }

    
    private void initViews() {

        e_a = findViewById(R.id.e_a);
        e_b = findViewById(R.id.e_b);
        e_c = findViewById(R.id.e_c);
        e_d = findViewById(R.id.e_d);
        e_e = findViewById(R.id.e_e);
        e_f = findViewById(R.id.e_f);
        e_g = findViewById(R.id.e_g);
        e_h = findViewById(R.id.e_h);
        e_i = findViewById(R.id.e_i);
        e_j = findViewById(R.id.e_j);
        e_k = findViewById(R.id.e_k);
        e_l = findViewById(R.id.e_l);
        e_m = findViewById(R.id.e_m);
        e_n = findViewById(R.id.e_n);
        e_o = findViewById(R.id.e_o);
        e_p = findViewById(R.id.e_p);
        e_q = findViewById(R.id.e_q);
        e_r = findViewById(R.id.e_r);
        e_s = findViewById(R.id.e_s);
        e_t = findViewById(R.id.e_t);
        e_w = findViewById(R.id.e_w);
        e_x = findViewById(R.id.e_x);
        e_y = findViewById(R.id.e_y);
        e_z = findViewById(R.id.e_z);

        c_a = findViewById(R.id.c_a);
        c_b = findViewById(R.id.c_b);
        c_c = findViewById(R.id.c_c);
        c_d = findViewById(R.id.c_d);
        c_e = findViewById(R.id.c_e);
        c_f = findViewById(R.id.c_f);
        c_g = findViewById(R.id.c_g);
        c_h = findViewById(R.id.c_h);
        c_i = findViewById(R.id.c_i);
        c_j = findViewById(R.id.c_j);
        c_k = findViewById(R.id.c_k);
        c_l = findViewById(R.id.c_l);
        c_w = findViewById(R.id.c_w);
        c_m = findViewById(R.id.c_m);
        c_n = findViewById(R.id.c_n);
        c_o = findViewById(R.id.c_o);
        c_p = findViewById(R.id.c_p);
        c_q = findViewById(R.id.c_q);
        c_r = findViewById(R.id.c_r);
        c_s = findViewById(R.id.c_s);
        c_t = findViewById(R.id.c_t);
        c_x = findViewById(R.id.c_x);
        c_y = findViewById(R.id.c_y);
        c_z = findViewById(R.id.c_z);

        save_button = findViewById(R.id.save_button);

    }

    private void initEditEvent() {
        
        c_a.setTransformationMethod(new UpperCaseTransform());
        c_b.setTransformationMethod(new UpperCaseTransform());
        c_c.setTransformationMethod(new UpperCaseTransform());
        c_d.setTransformationMethod(new UpperCaseTransform());
        c_e.setTransformationMethod(new UpperCaseTransform());
        c_f.setTransformationMethod(new UpperCaseTransform());
        c_g.setTransformationMethod(new UpperCaseTransform());
        c_h.setTransformationMethod(new UpperCaseTransform());
        c_i.setTransformationMethod(new UpperCaseTransform());
        c_j.setTransformationMethod(new UpperCaseTransform());
        c_k.setTransformationMethod(new UpperCaseTransform());
        c_l.setTransformationMethod(new UpperCaseTransform());
        c_w.setTransformationMethod(new UpperCaseTransform());
        c_m.setTransformationMethod(new UpperCaseTransform());
        c_n.setTransformationMethod(new UpperCaseTransform());
        c_o.setTransformationMethod(new UpperCaseTransform());
        c_p.setTransformationMethod(new UpperCaseTransform());
        c_q.setTransformationMethod(new UpperCaseTransform());
        c_r.setTransformationMethod(new UpperCaseTransform());
        c_s.setTransformationMethod(new UpperCaseTransform());
        c_t.setTransformationMethod(new UpperCaseTransform());
        c_x.setTransformationMethod(new UpperCaseTransform());
        c_y.setTransformationMethod(new UpperCaseTransform());
        c_z.setTransformationMethod(new UpperCaseTransform());

        e_a.setTransformationMethod(new UpperCaseTransform());
        e_b.setTransformationMethod(new UpperCaseTransform());
        e_c.setTransformationMethod(new UpperCaseTransform());
        e_d.setTransformationMethod(new UpperCaseTransform());
        e_e.setTransformationMethod(new UpperCaseTransform());
        e_f.setTransformationMethod(new UpperCaseTransform());
        e_g.setTransformationMethod(new UpperCaseTransform());
        e_h.setTransformationMethod(new UpperCaseTransform());
        e_i.setTransformationMethod(new UpperCaseTransform());
        e_j.setTransformationMethod(new UpperCaseTransform());
        e_k.setTransformationMethod(new UpperCaseTransform());
        e_l.setTransformationMethod(new UpperCaseTransform());
        e_m.setTransformationMethod(new UpperCaseTransform());
        e_n.setTransformationMethod(new UpperCaseTransform());
        e_o.setTransformationMethod(new UpperCaseTransform());
        e_p.setTransformationMethod(new UpperCaseTransform());
        e_q.setTransformationMethod(new UpperCaseTransform());
        e_r.setTransformationMethod(new UpperCaseTransform());
        e_s.setTransformationMethod(new UpperCaseTransform());
        e_t.setTransformationMethod(new UpperCaseTransform());
        e_w.setTransformationMethod(new UpperCaseTransform());
        e_x.setTransformationMethod(new UpperCaseTransform());
        e_y.setTransformationMethod(new UpperCaseTransform());
        e_z.setTransformationMethod(new UpperCaseTransform());

    }



    private void initOnclick() {
        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isCorrect()){
                    empty.show();
                    return;
                }
                if(isRepeatC()){
                    repC.show();
                    return;
                }

                if(isRepeatE()){
                    repE.show();
                    return;
                }

                saveCoordinate();
                succes.show();
                Intent broadcast = new Intent(SpKey.MODIFY_CODE_SUCCESS);
                sendBroadcast(broadcast);
                finish();
           }
        });
    }


    private void saveCoordinate() {
        String UP_CORNER = str_c_g + str_c_j + str_c_a + str_c_d;
        String UP_EDGE = str_e_e + str_e_g + str_e_a + str_e_c;
        String DOWN_CORNER = str_c_x + str_c_r + str_c_o + str_c_w;
        String DOWN_EDGE = str_e_i + str_e_o + str_e_m + str_e_k;

        String LEFT_CORNER = str_c_c + str_c_m + str_c_q + str_c_e;
        String LEFT_EDGE = str_e_d + str_e_t + str_e_l + str_e_x;
        String RIGHT_CORNER = str_c_i + str_c_s + str_c_z + str_c_k;
        String RIGHT_EDGE = str_e_h + str_e_z + str_e_p + str_e_r;

        String FRONT_CORNER = str_c_l + str_c_y + str_c_n + str_c_b;
        String FRONT_EDGE = str_e_b + str_e_q + str_e_j + str_e_s;
        String BACK_CORNER = str_c_f + str_c_p + str_c_t + str_c_h;
        String BACK_EDGE = str_e_f + str_e_w + str_e_n + str_e_y;


        SPUtils.getInstance().put(SpKey.UP_CORNER,UP_CORNER);
        SPUtils.getInstance().put(SpKey.UP_EDGE,UP_EDGE);
        SPUtils.getInstance().put(SpKey.DOWN_CORNER,DOWN_CORNER);
        SPUtils.getInstance().put(SpKey.DOWN_EDGE,DOWN_EDGE);

        SPUtils.getInstance().put(SpKey.LEFT_CORNER,LEFT_CORNER);
        SPUtils.getInstance().put(SpKey.LEFT_EDGE,LEFT_EDGE);
        SPUtils.getInstance().put(SpKey.RIGHT_CORNER,RIGHT_CORNER);
        SPUtils.getInstance().put(SpKey.RIGHT_EDGE,RIGHT_EDGE);

        SPUtils.getInstance().put(SpKey.FRONT_CORNER,FRONT_CORNER);
        SPUtils.getInstance().put(SpKey.FRONT_EDGE,FRONT_EDGE);
        SPUtils.getInstance().put(SpKey.BACK_CORNER,BACK_CORNER);
        SPUtils.getInstance().put(SpKey.BACK_EDGE,BACK_EDGE);

    }

}
