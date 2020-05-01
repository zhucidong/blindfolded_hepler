package zd.cornermemory.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import zd.cornermemory.R;
import zd.cornermemory.utils.SPUtils;
import zd.cornermemory.utils.SpKey;

/**
 * 修改缓冲
 */
public class MotifyBufferActivity extends BaseActivity {
    private Spinner corner_buffer;
    private Spinner edge_buffer;
    private Button save_button;
    private String cornerBufferStr;
    private String edgeBufferStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motify_buffer);
        initView();
        initEvent();

        String cornerSp = SPUtils.getInstance().getString(SpKey.CORNER_BUFFER);
        String edgeSp = SPUtils.getInstance().getString(SpKey.EDGE_BUFFER);

        if (TextUtils.isEmpty(cornerSp)) {
            corner_buffer.setSelection(1);
        }else {
            corner_buffer.setSelection(Integer.parseInt(cornerSp));
        }

        if (TextUtils.isEmpty(edgeSp)) {
            edge_buffer.setSelection(2);
        }else {
            edge_buffer.setSelection(Integer.parseInt(edgeSp));
        }
    }

    private void initEvent() {

        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SPUtils.getInstance().put(SpKey.CORNER_BUFFER,cornerBufferStr);
                SPUtils.getInstance().put(SpKey.EDGE_BUFFER,edgeBufferStr);
                Toast.makeText(mContext,"修改成功",Toast.LENGTH_SHORT).show();
                Intent broadcast = new Intent(SpKey.MODIFY_BUFFER_SUCCESS);
                sendBroadcast(broadcast);
                finish();
            }
        });


        corner_buffer.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                cornerBufferStr = i + "";
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        edge_buffer.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                edgeBufferStr = i + "";
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void initView() {
        corner_buffer = findViewById(R.id.corner_buffer);
        edge_buffer = findViewById(R.id.edge_buffer);
        save_button = findViewById(R.id.save_button);
        String[] cornerBuffer = getResources().getStringArray(R.array.corner_buffer);
        List<String> cornerList = new ArrayList<>();
        for(int i=0;i<cornerBuffer.length;i++) {
            cornerList.add(cornerBuffer[i]);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(mContext,

                R.layout.spinner_checked_text, cornerList);
        corner_buffer.setAdapter(adapter);


        String[] edgeBuffer = getResources().getStringArray(R.array.edge_buffer);
        List<String> edgeList = new ArrayList<>();
        for(int i=0;i<edgeBuffer.length;i++) {
            edgeList.add(edgeBuffer[i]);
        }
        ArrayAdapter<String> edgeAdapter = new ArrayAdapter<String>(mContext,
                R.layout.spinner_checked_text, edgeList);
        edge_buffer.setAdapter(edgeAdapter);
    }


}
