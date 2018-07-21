package tttpurlconnection.itcast.cn.zhbj.base.newscentermenu;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
//新闻页面
import tttpurlconnection.itcast.cn.zhbj.base.NewsConterBaseMenu;

public class NewsConterNewsMenu extends NewsConterBaseMenu {

    public NewsConterNewsMenu(Context context) {
        super(context);
    }

    @Override
    protected View initView() {
        TextView tv=new TextView(mContext);
        tv.setText("新闻页面的内容区域");
        tv.setTextColor(24);
        tv.setGravity(Color.RED);
        tv.setGravity(Gravity.CENTER);
        return tv;
    }
}
