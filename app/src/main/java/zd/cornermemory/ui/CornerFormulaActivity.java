package zd.cornermemory.ui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import zd.cornermemory.R;
import zd.cornermemory.utils.Dictionary;
import zd.cornermemory.utils.SPUtils;
import zd.cornermemory.utils.SpKey;

/**
 * 角块公式查询
 */
public class CornerFormulaActivity extends BaseActivity implements View.OnClickListener{
    private TextView formula_tt;
    private TextView gif_tt;
    private EditText ans;


    private TextView        add_formula_tt;
    private LinearLayout    by_layout;
    private TextView        by_formula_code_tt;
    private TextView        eidt_tt;
    private TextView        delete_tt;
    private View            dialogView;
    private AlertDialog.Builder builder;//增加
    private AlertDialog.Builder builder_update;//修改
    private String currentBM;
    private String currentByGs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corner_formula);
        add_formula_tt = findViewById(R.id.add_formula_tt);
        by_layout = findViewById(R.id.by_layout);
        by_formula_code_tt = findViewById(R.id.by_formula_code_tt);
        eidt_tt = findViewById(R.id.eidt_tt);
        delete_tt = findViewById(R.id.delete_tt);
        add_formula_tt.setOnClickListener(this);
        eidt_tt.setOnClickListener(this);
        delete_tt.setOnClickListener(this);
        dialogView = LayoutInflater.from(mContext).inflate(R.layout.dialogview,null);
        initDialogViews(dialogView);

        formula_tt = findViewById(R.id.formula_tt);
        gif_tt = findViewById(R.id.gif_tt);
        ans = findViewById(R.id.ans);

        gif_tt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CornerFormulaActivity.this, RoatePicActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            }
        });

        ans.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                formula_tt.setText("");
                String ansStr = ans.getText().toString().trim().toUpperCase();
                formula_tt.setText(Dictionary.formula_corner.get(ansStr));
                if(!TextUtils.isEmpty(Dictionary.formula_corner.get(ansStr))){
                    currentBM = ansStr;
                    String byStr = SPUtils.getInstance().getString(currentBM+ SpKey.CORNER);
                    if(TextUtils.isEmpty(byStr)){
                        add_formula_tt.setVisibility(View.VISIBLE);
                        by_layout.setVisibility(View.GONE);
                        currentByGs = null;
                    }else{
                        add_formula_tt.setVisibility(View.GONE);
                        by_layout.setVisibility(View.VISIBLE);
                        by_formula_code_tt.setText(byStr);
                        currentByGs = byStr;
                    }

                }
                return false;
            }
        });
        ans.setTransformationMethod(new UpperCaseTransform());

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add_formula_tt:
                dialogView = LayoutInflater.from(mContext).inflate(R.layout.dialogview,null);
                initDialogViews(dialogView);
                builder = new AlertDialog.Builder(mContext)
                        .setTitle("增加备用公式")
                        .setView(dialogView)
                        .setMessage("角块编码： "+currentBM)
                        .setCancelable(false)
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {
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
                    String codeStr = code_edit.getText().toString().trim();
                        if(TextUtils.isEmpty(codeStr)){
                            return;
                        }

                        currentByGs = codeStr;
                        by_formula_code_tt.setText(currentByGs);
                        SPUtils.getInstance().put(currentBM + SpKey.CORNER,currentByGs);
                        dialog.dismiss();
                        add_formula_tt.setVisibility(View.GONE);
                        by_layout.setVisibility(View.VISIBLE);


                    }
                });



                break;
            case R.id.eidt_tt:
                dialogView = LayoutInflater.from(mContext).inflate(R.layout.dialogview,null);
                initDialogViews(dialogView);
                code_edit.setText(currentByGs);
                code_edit.setSelection(code_edit.getText().length());
                builder_update = new AlertDialog.Builder(mContext)
                        .setTitle("修改备用公式")
                        .setView(dialogView)
                        .setMessage("角块编码： "+currentBM)
                        .setCancelable(false)
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {

                                dialog.dismiss();
                            }
                        })
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });


                final AlertDialog dialog2 = builder_update.create();
                dialog2.show();
                //重写“确定”，截取监听
                dialog2.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String codeStr = code_edit.getText().toString().trim();
                        if(TextUtils.isEmpty(codeStr)){
                            return;
                        }
                        currentByGs = codeStr;
                        by_formula_code_tt.setText(currentByGs);
                        SPUtils.getInstance().put(currentBM + SpKey.CORNER,currentByGs);
                        add_formula_tt.setVisibility(View.GONE);
                        by_layout.setVisibility(View.VISIBLE);

                        dialog2.dismiss();




                    }
                });
                break;
            case R.id.delete_tt:
                new AlertDialog.Builder(mContext)
                        .setTitle("删除备用公式")
                        .setMessage("确定删除？")
                        .setCancelable(false)
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {

                                dialog.dismiss();
                            }
                        })
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                currentByGs = null;
                                SPUtils.getInstance().remove(currentBM + SpKey.CORNER);
                                by_layout.setVisibility(View.GONE);
                            }
                        }).show();




                break;
        }
    }


    private EditText code_edit;
    private void initDialogViews(View view) {
        code_edit = view.findViewById(R.id.code_edit);
        code_edit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int lines = code_edit.getLineCount();
                // 限制最大输入行数
                if (lines > 3) {
                    String str = s.toString();
                    int cursorStart = code_edit.getSelectionStart();
                    int cursorEnd = code_edit.getSelectionEnd();
                    if (cursorStart == cursorEnd && cursorStart < str.length() && cursorStart >= 1) {
                        str = str.substring(0, cursorStart-1) + str.substring(cursorStart);
                    } else {
                        str = str.substring(0, s.length()-1);
                    }
                    // setText会触发afterTextChanged的递归
                    code_edit.setText(str);
                    // setSelection用的索引不能使用str.length()否则会越界
                    code_edit.setSelection(code_edit.getText().length());
                }
            }
        });
    }
}
