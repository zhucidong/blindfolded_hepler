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
import zd.cornermemory.utils.CoordinateUtil;
import zd.cornermemory.utils.SPUtils;
import zd.cornermemory.utils.SpKey;

/**
 * 修改坐标
 */
public class MotifyCoornateActivity extends BaseActivity {

    private Spinner coordinate;
    private String coordinatestr;
    private Button save_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motify_coornate);
        coordinate = findViewById(R.id.coordinate);

        String[] coordianteArray = getResources().getStringArray(R.array.coordinate);
        List<String> list = new ArrayList<>();
        for(int i=0;i<coordianteArray.length;i++) {
            list.add(coordianteArray[i]);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(mContext,
                R.layout.spinner_checked_text, list);

        coordinate.setAdapter(adapter);

        save_button = findViewById(R.id.save_button);
        initData();
    }

    private void initData(){

        String coordinateStr = SPUtils.getInstance().getString(SpKey.COORDINATE);
        if(TextUtils.isEmpty(coordinateStr)){
            coordinate.setSelection(2);
        }else{
            List<String> flags =  CoordinateUtil.getcoordinateFlag();
            for(int i = 0;i<flags.size();i++) {
                if (TextUtils.equals(coordinateStr, flags.get(i))) {
                    coordinate.setSelection(i);
                    break;
                }
            }
        }

        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SPUtils.getInstance().put(SpKey.COORDINATE,coordinatestr);
                Toast.makeText(mContext,"修改成功",Toast.LENGTH_SHORT).show();
                Intent broadcast = new Intent(SpKey.MODIFY_COORNIATE_SUCCESS);
                sendBroadcast(broadcast);
                finish();
            }
        });

        coordinate.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                List<String> flags = CoordinateUtil.getcoordinateFlag();
                coordinatestr = flags.get(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }


   

}
