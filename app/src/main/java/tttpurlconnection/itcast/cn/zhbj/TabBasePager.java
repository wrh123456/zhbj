package tttpurlconnection.itcast.cn.zhbj;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

//viewpager的每一个子页的controller的基类
public abstract class TabBasePager implements View.OnClickListener {
    protected View mRootView;//根视图
    protected Context mcontext;//上下文
    protected TextView mTvTitle;//title
    protected ImageButton mIvMenu;//menu
    protected FrameLayout mContentContainer;//内容容器

    public TabBasePager(Context context){
        this.mcontext=context;
        mRootView=initView();

    }

    protected View initView(){
        View view=View.inflate(mcontext,R.layout.tab_base_pager,null);

        //实现查找view
        mTvTitle=(TextView)view.findViewById(R.id.title_bar_tv_title);
        mIvMenu=(ImageButton)view.findViewById(R.id.title_bar_tv_menu);
        mContentContainer=view.findViewById(R.id.tab_base_content_container);
        mIvMenu.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        if(v==mIvMenu){
            toggleSlidingMenu();
        }

    }
    private void toggleSlidingMenu(){
        //打开slidingMenu
        MainUI ui=(MainUI)mcontext;
        SlidingMenu menu=ui.getSlidingMenu();
        //如果slidingmenus是打开的，那么就关闭，否则相反
        menu.toggle();
    }

    //数据加载的方法，子类如果要实现数据加载，就需要复写这个方法
    public void initData(){
    }

    public View getmRootView(){
        return mRootView;
    }

}
