package zd.cornermemory.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import zd.cornermemory.R;

/**
 * 查询
 */
public class QueryActivity extends BaseActivity implements View.OnClickListener{
    private     TextView corner_tt;
    private TextView l_tt;
    private TextView lx_tt;
    private TextView zl_tt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_query);
        corner_tt = findViewById(R.id.corner_tt);
        l_tt = findViewById(R.id.l_tt);
        lx_tt = findViewById(R.id.lx_tt);
        zl_tt = findViewById(R.id.zl_tt);
        corner_tt.setOnClickListener(this);
        l_tt.setOnClickListener(this);
        lx_tt.setOnClickListener(this);
        zl_tt.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.corner_tt:
                intent = new Intent(mContext, CornerFormulaActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
                break;
            case R.id.lx_tt:
                intent = new Intent(mContext, LxPicActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
                break;
            case R.id.l_tt:
                intent = new Intent(mContext, EdgeFormulaActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
                break;
            case R.id.zl_tt:
                intent = new Intent(mContext, DuLActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
                break;
        }
    }

}
