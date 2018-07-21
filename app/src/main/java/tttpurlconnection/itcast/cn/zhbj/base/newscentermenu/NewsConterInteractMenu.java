package tttpurlconnection.itcast.cn.zhbj.base.newscentermenu;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import tttpurlconnection.itcast.cn.zhbj.base.NewsConterBaseMenu;

//互动页面
public class NewsConterInteractMenu extends NewsConterBaseMenu {

    public NewsConterInteractMenu(Context context) {
        super(context);
    }

    @Override
    protected View initView() {
        TextView tv=new TextView(mContext);
        tv.setText("互动页面的内容区域");
        tv.setTextColor(24);
        tv.setGravity(Color.RED);
        tv.setGravity(Gravity.CENTER);
        return tv;
    }
}
