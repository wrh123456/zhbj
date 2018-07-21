package tttpurlconnection.itcast.cn.zhbj.base.newscentermenu;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import tttpurlconnection.itcast.cn.zhbj.base.NewsConterBaseMenu;

//组图对应的内容页面
public class NewsConterPicMenu extends NewsConterBaseMenu {

    public NewsConterPicMenu(Context context) {
        super(context);
    }

    @Override
    protected View initView() {
        TextView tv=new TextView(mContext);
        tv.setText("组图页面的内容区域");
        tv.setTextColor(24);
        tv.setGravity(Color.RED);
        tv.setGravity(Gravity.CENTER);
        return tv;
    }
}
