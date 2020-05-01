package zd.cornermemory.ui;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import zd.cornermemory.R;
import zd.cornermemory.utils.Dictionary;

public class LxPicActivity extends BaseActivity {
    private EditText  ans;
    private TextView  remark;
    private ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lx_pic);
        ans = findViewById(R.id.ans);
        remark = findViewById(R.id.remark);
        img = findViewById(R.id.img);
        ans.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                remark.setText("");
                String ansStr = ans.getText().toString().trim().toUpperCase();
                remark.setText(Dictionary.dic.get(ansStr));
                img.setVisibility(View.VISIBLE);
                try {
                    img.setImageResource(Dictionary.pic.get(ansStr));
                } catch (Exception e) {
                    e.printStackTrace();
                    img.setVisibility(View.INVISIBLE);
                }
                return false;
            }
        });
        ans.setTransformationMethod(new UpperCaseTransform());
    }

}
