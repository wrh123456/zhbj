package tttpurlconnection.itcast.cn.zhbj.fragment;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import java.util.ArrayList;
import java.util.List;

import tttpurlconnection.itcast.cn.zhbj.MainUI;
import tttpurlconnection.itcast.cn.zhbj.R;
import tttpurlconnection.itcast.cn.zhbj.TabBasePager;
import tttpurlconnection.itcast.cn.zhbj.base.BaseFragment;
import tttpurlconnection.itcast.cn.zhbj.base.tab.TabGovPager;
import tttpurlconnection.itcast.cn.zhbj.base.tab.TabHomePager;
import tttpurlconnection.itcast.cn.zhbj.base.TabNewsscenterPager;
import tttpurlconnection.itcast.cn.zhbj.base.tab.TabSettingPager;
import tttpurlconnection.itcast.cn.zhbj.base.tab.TabSmarstservicePager;
import tttpurlconnection.itcast.cn.zhbj.widget.NoScrollViewPager;

public class ContentFragment extends BaseFragment implements RadioGroup.OnCheckedChangeListener{
    private NoScrollViewPager mPager;//viewpager
    private RadioGroup mRadioGroup;//底部容器
    private List<TabBasePager> mPagerList;


    @Override
    protected View initView() {
        View view=View.inflate(mActivity, R.layout.content,null);
        mPager=view.findViewById(R.id.content_pager);
        mRadioGroup=view.findViewById(R.id.content_rg);
        return view;
    }

    @Override
    protected void initData() {
        mPagerList=new ArrayList<TabBasePager>();

        //添加实际的页面
        mPagerList.add(new TabHomePager(mActivity));
        mPagerList.add(new TabNewsscenterPager(mActivity));
        mPagerList.add(new TabSmarstservicePager(mActivity));
        mPagerList.add(new TabGovPager(mActivity));
        mPagerList.add(new TabSettingPager(mActivity));


        //给viewpager加载数据--》adapter-->list
        mPager.setAdapter(new ContentPagerAdapter());

        //给RadioGroup设置监听
        mRadioGroup.setOnCheckedChangeListener(this);
        //设置初始化选中的界面
        mRadioGroup.check(R.id.tab_home);


    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        //1.RadioGroup
        //2.选中的RadioButton的id
        int currentIndex=-1;
        switch (checkedId){
            case R.id.tab_home:
                currentIndex=0;
                setSlidingMenuTouchEnable(false);
                break;
            case R.id.tab_newscenter:
                currentIndex=1;
                setSlidingMenuTouchEnable(true);
                break;
            case R.id.tab_smartservice:
                currentIndex=2;
                setSlidingMenuTouchEnable(true);
                break;
            case R.id.tab_gov:
                currentIndex=3;
                setSlidingMenuTouchEnable(true);
                break;
            case R.id.tab_setting:
                currentIndex=4;
                setSlidingMenuTouchEnable(false);
                break;
             default:
                 break;
        }
        //给ViewPager设置选中的页面
        mPager.setCurrentItem(currentIndex);
    }
    private void setSlidingMenuTouchEnable(boolean enable){
        MainUI ui=(MainUI)mActivity;
        SlidingMenu menu=ui.getSlidingMenu();
        menu.setTouchModeAbove(enable?SlidingMenu.TOUCHMODE_FULLSCREEN:SlidingMenu.TOUCHMODE_NONE);
    }

    class ContentPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            if(mPagerList!=null){
                return mPagerList.size();
            }
            return 0;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view==object;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            TabBasePager pager=mPagerList.get(position);
            View view=pager.getmRootView();
            //viewpager需放视图
            container.addView(view);

            //给页面控制器加载数据
            pager.initData();

            return view;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((View)object);
        }
    }
}
