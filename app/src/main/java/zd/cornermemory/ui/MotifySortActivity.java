package zd.cornermemory.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import java.util.List;

import zd.cornermemory.R;
import zd.cornermemory.adapter.CodeSortAdapter;
import zd.cornermemory.bean.SortCode;
import zd.cornermemory.utils.CoordinateUtil;
import zd.cornermemory.utils.SPUtils;
import zd.cornermemory.utils.SpKey;

/**
 * 借位顺序
 */
public class MotifySortActivity extends BaseActivity {
    private Button          save_button;
    private CheckBox        is_check;
    private CheckBox        is_check_edge;
    private boolean         isCheck;
    private boolean         isCheckEdge;
    private RecyclerView    listView;
    private RecyclerView    edge_code;
    private CodeSortAdapter mAdapter;
    private CodeSortAdapter mAdapterEdge;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motify_sort);
        initView();
        initEvent();
        is_check.setChecked(SPUtils.getInstance().getBoolean(SpKey.KEEP_HUE));
        is_check_edge.setChecked(SPUtils.getInstance().getBoolean(SpKey.KEEP_HUE_EDGE));
        List<SortCode>[] sorts = CoordinateUtil.getSortCode();
        mAdapter = new CodeSortAdapter(sorts[0]);
        listView.setLayoutManager(new LinearLayoutManager(this));
        listView.setAdapter(mAdapter);

        mAdapterEdge = new CodeSortAdapter(sorts[1]);
        edge_code.setLayoutManager(new LinearLayoutManager(this));
        edge_code.setAdapter(mAdapterEdge);

    }





    private void initEvent() {

        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SPUtils.getInstance().put(SpKey.KEEP_HUE,isCheck);
                SPUtils.getInstance().put(SpKey.KEEP_HUE_EDGE,isCheckEdge);
                Toast.makeText(mContext,"修改成功",Toast.LENGTH_SHORT).show();
               List<SortCode> cornerSorts =  mAdapter.getList();
                String saveCornerStr = "";
                for(SortCode sc : cornerSorts){
                    saveCornerStr+=sc.getKey();
                }
                SPUtils.getInstance().put(SpKey.SORT_CORNER_JIE,saveCornerStr);

                List<SortCode> edgeSorts =  mAdapterEdge.getList();
                String saveEdgeStr = "";
                for(SortCode sc : edgeSorts){
                    saveEdgeStr+=sc.getKey();
                }
                SPUtils.getInstance().put(SpKey.SORT_EDGE_JIE,saveEdgeStr);
                Intent broadcast = new Intent(SpKey.MODIFY_SORT_SUCCESS);
                sendBroadcast(broadcast);
                finish();
            }
        });

        is_check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                isCheck = b;
            }
        });
        is_check_edge.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                isCheckEdge = b;
            }
        });


    }

    private void initView() {

        save_button = findViewById(R.id.save_button);
        is_check = findViewById(R.id.is_check);
        is_check_edge = findViewById(R.id.is_check_edge);
        listView = findViewById(R.id.corner_code);
        edge_code = findViewById(R.id.edge_code);
    }


}
