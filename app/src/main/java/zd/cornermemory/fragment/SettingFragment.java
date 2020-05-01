package zd.cornermemory.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import zd.cornermemory.R;
import zd.cornermemory.ui.AboutActivity;
import zd.cornermemory.ui.MotifyHelpActivity;
import zd.cornermemory.ui.QueryActivity;
import zd.cornermemory.ui.SettingActivity;

/**
 * Created by zhud on 2019/4/29.
 */

public class SettingFragment extends Fragment implements View.OnClickListener{
    private TextView corner_tt;
    private TextView l_tt;
    private TextView lx_tt;
    private TextView zl_tt;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab4, container, false);
        corner_tt = view.findViewById(R.id.corner_tt);
        l_tt = view.findViewById(R.id.l_tt);
        lx_tt = view.findViewById(R.id.lx_tt);
        zl_tt = view.findViewById(R.id.zl_tt);
        corner_tt.setOnClickListener(this);
        l_tt.setOnClickListener(this);
        lx_tt.setOnClickListener(this);
        zl_tt.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.corner_tt:
                intent = new Intent(getActivity(), SettingActivity.class);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
                break;
            case R.id.lx_tt:
                intent = new Intent(getActivity(), MotifyHelpActivity.class);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
                break;
            case R.id.l_tt:
                intent = new Intent(getActivity(), QueryActivity.class);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
                break;
            case R.id.zl_tt:
                intent = new Intent(getActivity(), AboutActivity.class);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
                break;
        }
    }
}
