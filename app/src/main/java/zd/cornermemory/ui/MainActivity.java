package zd.cornermemory.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import zd.cornermemory.utils.Dictionary;
import zd.cornermemory.R;
import zd.cornermemory.fragment.DisruptFragment;
import zd.cornermemory.fragment.ReadCodeFragment;
import zd.cornermemory.fragment.SettingFragment;
import zd.cornermemory.fragment.RememberFragment;

/**
 * Created by zhud on 2019/4/29.
 */

public class MainActivity extends FragmentActivity implements OnClickListener {
    //四个Tab的布局文件
    private LinearLayout mTabRemember;
    private LinearLayout mTabDisrupt;
    private LinearLayout mTabQuery;
    private LinearLayout mTabSetting;

    //四个Tab的ImageButton
    private ImageButton mRememberImg;
    private ImageButton mDisruptImg;
    private ImageButton mQueryImg;
    private ImageButton mSettingImg;

    //四个Tab分别对应的Fragment
    private Fragment mFragRemember;
    private Fragment mFragDisrupt;
    private Fragment mFragQuery;
    private Fragment mFragSetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

        Dictionary.initDic();
        Dictionary.initPic();
        Dictionary.initFormulaCorner();
        Dictionary.initFormulaEdge();
        initViews();//初始化控件
        initEvents();//初始化事件
        selectTab(0);//默认选中第一个Tab
    }

    private void initEvents() {
        //初始化四个Tab的点击事件
        mTabRemember.setOnClickListener(this);
        mTabDisrupt.setOnClickListener(this);
        mTabQuery.setOnClickListener(this);
        mTabSetting.setOnClickListener(this);
    }

    private void initViews() {
        //初始化四个Tab的布局文件
        mTabRemember = (LinearLayout) findViewById(R.id.id_tab_weixin);
        mTabDisrupt = (LinearLayout) findViewById(R.id.id_tab_frd);
        mTabQuery = (LinearLayout) findViewById(R.id.id_tab_address);
        mTabSetting = (LinearLayout) findViewById(R.id.id_tab_setting);

        //初始化四个ImageButton
        mRememberImg = (ImageButton) findViewById(R.id.id_tab_weixin_img);
        mDisruptImg = (ImageButton) findViewById(R.id.id_tab_frd_img);
        mQueryImg = (ImageButton) findViewById(R.id.id_tab_address_img);
        mSettingImg = (ImageButton) findViewById(R.id.id_tab_setting_img);
    }

    //处理Tab的点击事件
    @Override
    public void onClick(View v) {
        //先将四个ImageButton置为灰色
        resetImgs();
        try{
            InputMethodManager mInputMethodManager = (InputMethodManager)this.getSystemService(INPUT_METHOD_SERVICE);
            assert mInputMethodManager != null;
            mInputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);

        }catch (Exception e){

        }
        switch (v.getId()) {
            case R.id.id_tab_weixin:
                selectTab(0);
                break;
            case R.id.id_tab_frd:
                selectTab(1);
                break;
            case R.id.id_tab_address:
                selectTab(2);
                break;
            case R.id.id_tab_setting:
                selectTab(3);
                break;
        }

    }

    //进行选中Tab的处理
    private void selectTab(int i) {
        //获取FragmentManager对象
        FragmentManager manager = getSupportFragmentManager();
        //获取FragmentTransaction对象
        FragmentTransaction transaction = manager.beginTransaction();
        //先隐藏所有的Fragment
        hideFragments(transaction);
        switch (i) {
            //当选中点击Tab时
            case 0:
                //设置ImageButton为绿色
                mRememberImg.setImageResource(R.mipmap.tab_weixin_pressed);
                //如果对应的Fragment没有实例化，则进行实例化，并显示出来
                if (mFragRemember == null) {
                    mFragRemember = new RememberFragment();
                    transaction.add(R.id.id_content, mFragRemember);
                } else {
                    //如果对应的Fragment已经实例化，则直接显示出来
                    transaction.show(mFragRemember);
                }
                break;
            case 1:
                mDisruptImg.setImageResource(R.mipmap.tab_find_frd_pressed);
                if (mFragDisrupt == null) {
                    mFragDisrupt = new ReadCodeFragment();
                    transaction.add(R.id.id_content, mFragDisrupt);
                } else {
                    transaction.show(mFragDisrupt);
                }
                break;
            case 2:
                mQueryImg.setImageResource(R.mipmap.tab_address_pressed);
                if (mFragQuery == null) {
                    mFragQuery = new DisruptFragment();
                    transaction.add(R.id.id_content, mFragQuery);
                } else {
                    transaction.show(mFragQuery);
                }
                break;
            case 3:
                mSettingImg.setImageResource(R.mipmap.tab_settings_pressed);
                if (mFragSetting == null) {
                    mFragSetting = new SettingFragment();
                    transaction.add(R.id.id_content, mFragSetting);
                } else {
                    transaction.show(mFragSetting);
                }
                break;
        }
        //提交事务
        transaction.commit();
    }

    //将四个的Fragment隐藏
    private void hideFragments(FragmentTransaction transaction) {
        if (mFragRemember != null) {
            transaction.hide(mFragRemember);
        }
        if (mFragDisrupt != null) {
            transaction.hide(mFragDisrupt);
        }
        if (mFragQuery != null) {
            transaction.hide(mFragQuery);
        }
        if (mFragSetting != null) {
            transaction.hide(mFragSetting);
        }
    }

    //将四个ImageButton置为灰色
    private void resetImgs() {
        mRememberImg.setImageResource(R.mipmap.tab_weixin_normal);
        mDisruptImg.setImageResource(R.mipmap.tab_find_frd_normal);
        mQueryImg.setImageResource(R.mipmap.tab_address_normal);
        mSettingImg.setImageResource(R.mipmap.tab_settings_normal);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (null != this.getCurrentFocus()) {
            /**
             * 点击空白位置 隐藏软键盘
             */
            InputMethodManager mInputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            assert mInputMethodManager != null;
            return mInputMethodManager.hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(), 0);
        }
        return super.onTouchEvent(event);

    }

}
