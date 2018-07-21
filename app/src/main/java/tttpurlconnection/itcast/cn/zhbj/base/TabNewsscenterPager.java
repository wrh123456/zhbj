package tttpurlconnection.itcast.cn.zhbj.base;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import tttpurlconnection.itcast.cn.zhbj.MainUI;
import tttpurlconnection.itcast.cn.zhbj.TabBasePager;
import tttpurlconnection.itcast.cn.zhbj.bean.NewsCenterBean;
import tttpurlconnection.itcast.cn.zhbj.fragment.LeftMenuFragment;
import tttpurlconnection.itcast.cn.zhbj.utils.Constans;

//新闻页面
public class TabNewsscenterPager extends TabBasePager{
    private static final String TAG = "TabNewsscenterPager";
    private List<TextView> mPagerList;
    private String s=null;
    private NewsCenterBean mData;//页面对应的数据
    private List<NewsCenterMenuListBean> mMenuDates;
    public TabNewsscenterPager(Context context) {
        super(context);
    }

    @Override
    public void initData() {
        //1.title部分数据的设置
        mTvTitle.setText("新闻");
        mIvMenu.setVisibility(View.VISIBLE);
        //2.内容区域数据的设置
        //通过网络获取数据，并把数据加载到页面上来
        HttpUtils utils=new HttpUtils();
        utils.send(HttpRequest.HttpMethod.GET, Constans.news_center_url, new RequestCallBack<String>() {
           //访问网络成功后的回调
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                //取出结果值
                String result=responseInfo.result;
                Log.d(TAG,"访问网络成功："+result);
            }
            //访问网络失败后的回调
            @Override
            public void onFailure(HttpException e, String s) {
                Log.d(TAG,"访问网络成功："+s);
            }
        });

        //内容区域视图的展示默认值
//        switchPager(0);

    }
    private  void processData(String json){
        //1.json串的解析
        Gson gson=new Gson();
        mData=gson.fromJson(json,NewsCenterBean.class);
        mMenuDates=mData.data;
        //2.将数据展示到界面上
        //2-1.展示到左侧菜单
        //获取左侧菜单的fragment
        MainUI ui=(MainUI)mcontext;
        LeftMenuFragment leftfra=ui.getLeftFragment();
        //设置数据
        mData.data

        //2-2展示到内容区域 TODO:

    }
    private  void switchPager(int i){
        //清空数据的内容
        mContentContainer.removeAllViews();
        //TODO:
        TextView tv=mPagerList.get(i);
        tv.setTextColor(Color.RED);
        tv.setTextSize(24);
        tv.setGravity(Gravity.CENTER);
        FrameLayout.LayoutParams params=new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,FrameLayout.LayoutParams.MATCH_PARENT);
        mContentContainer.addView(tv,params);
    }
}
