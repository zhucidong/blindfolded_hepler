package zd.cornermemory.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import zd.cornermemory.utils.Dictionary;
import zd.cornermemory.R;

/**
 * Created by zhud on 2019/4/30.
 */

public class NormalAdapter extends RecyclerView.Adapter<NormalAdapter.VH>{
    public static class VH extends RecyclerView.ViewHolder{
        public final ImageView img;
        public final TextView remark;
        public VH(View v) {
            super(v);
            img = (ImageView) v.findViewById(R.id.img);
            remark = (TextView) v.findViewById(R.id.remark);
        }
    }

    private List<String> mDatas;
    public NormalAdapter(List<String> data) {
        this.mDatas = data;
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {

        holder.img.setImageResource(Dictionary.pic.get(mDatas.get(position)));
        holder.remark.setText(Dictionary.dic.get(mDatas.get(position)));
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new VH(v);
    }
}

