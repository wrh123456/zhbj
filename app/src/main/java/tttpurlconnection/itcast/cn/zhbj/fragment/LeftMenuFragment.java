package tttpurlconnection.itcast.cn.zhbj.fragment;

import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.TextView;

import tttpurlconnection.itcast.cn.zhbj.base.BaseFragment;

public class LeftMenuFragment extends BaseFragment{

    @Override
    protected View initView() {
        TextView tv=new TextView(mActivity);
        tv.setText("菜单内容");
        return tv;
    }
}
