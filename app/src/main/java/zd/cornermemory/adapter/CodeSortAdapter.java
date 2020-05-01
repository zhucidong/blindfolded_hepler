package zd.cornermemory.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import zd.cornermemory.R;
import zd.cornermemory.bean.SortCode;

/**
 * Created by zhud on 2019/4/30.
 */

public class CodeSortAdapter extends RecyclerView.Adapter<CodeSortAdapter.VH>{
    public static class VH extends RecyclerView.ViewHolder{
        public final TextView code;
        public final TextView op_xia;
        public final TextView op_shang;
        public VH(View v) {
            super(v);
            code = (TextView) v.findViewById(R.id.code);
            op_xia = (TextView) v.findViewById(R.id.op_xia);
            op_shang = (TextView) v.findViewById(R.id.op_shang);
        }
    }

    private List<SortCode> mDatas;
    public CodeSortAdapter(List<SortCode> data) {
        this.mDatas = data;
    }

    @Override
    public void onBindViewHolder(VH holder, final int position) {

        holder.code.setText(mDatas.get(position).getDisplay());
        if(position==0){
            holder.op_shang.setVisibility(View.INVISIBLE);
        }else{
            holder.op_shang.setVisibility(View.VISIBLE);
        }

        if(position==mDatas.size()-1){
            holder.op_xia.setVisibility(View.INVISIBLE);
        }else {
            holder.op_xia.setVisibility(View.VISIBLE);
        }

        holder.op_shang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SortCode cc = mDatas.get(position);
                mDatas.remove(position);
                mDatas.add(position-1,cc);
                notifyDataSetChanged();
            }
        });

        holder.op_xia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SortCode cc = mDatas.get(position);
                mDatas.remove(position);
                mDatas.add(position+1,cc);
                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public List<SortCode> getList(){
        return mDatas;
    }


    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sort, parent, false);
        return new VH(v);
    }
}

