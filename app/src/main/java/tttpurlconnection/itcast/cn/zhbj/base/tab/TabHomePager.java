package tttpurlconnection.itcast.cn.zhbj.base.tab;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

//主页tab对应的页面
import tttpurlconnection.itcast.cn.zhbj.TabBasePager;

public class TabHomePager extends TabBasePager{
    public TabHomePager(Context context) {
        super(context);
    }

    @Override
    public void initData() {
        //1.title部分数据的设置
        mTvTitle.setText("智慧北京");
        mIvMenu.setVisibility(View.GONE);
        //2.内容区域数据的设置
        TextView tv=new TextView(mcontext);
        tv.setText("首页内容区域");
        tv.setTextColor(Color.RED);
        tv.setTextSize(24);
        tv.setGravity(Gravity.CENTER);
        FrameLayout.LayoutParams params=new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,FrameLayout.LayoutParams.MATCH_PARENT);

        mContentContainer.addView(tv,params);

    }
}
