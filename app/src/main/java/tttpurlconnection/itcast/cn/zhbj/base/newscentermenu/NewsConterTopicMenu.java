package tttpurlconnection.itcast.cn.zhbj.base.newscentermenu;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import tttpurlconnection.itcast.cn.zhbj.base.NewsConterBaseMenu;

//专题菜单对应的页面内容
public class NewsConterTopicMenu extends NewsConterBaseMenu {

    public NewsConterTopicMenu(Context context) {
        super(context);
    }

    @Override
    protected View initView() {
        TextView tv=new TextView(mContext);
        tv.setText("专题页面的内容区域");
        tv.setTextColor(24);
        tv.setGravity(Color.RED);
        tv.setGravity(Gravity.CENTER);
        return tv;
    }
}
