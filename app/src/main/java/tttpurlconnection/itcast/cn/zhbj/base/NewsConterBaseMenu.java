package tttpurlconnection.itcast.cn.zhbj.base;

import android.content.Context;
import android.view.View;

//新闻中心内容区域的基类
public abstract class NewsConterBaseMenu {
    protected Context mContext;//上下文
    protected View mRootView;//根视图
    public NewsConterBaseMenu(Context context){
        this.mContext=context;
        mRootView=initView();
    }

    //让子类去实现自己长什么样子
    protected abstract View initView();
    public void initData(){}

    public View getRootView() {
        return mRootView;
    }
}
