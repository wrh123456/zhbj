package tttpurlconnection.itcast.cn.zhbj;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

import tttpurlconnection.itcast.cn.zhbj.utils.CacheUtils;

//用户引导页面
public class GuideUI extends Activity implements ViewPager.OnPageChangeListener,View.OnClickListener{
    private ViewPager mPager;
    private Button mBtnStart;                //开始按钮
    private LinearLayout mPointContainer;   //装点的容器
    private View mSelectedPoint;            //选中的点
    private int mspace;                       //点与点间的距离

    private List<ImageView> mImagList;//存储viewPager中的imageView

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        //去除title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guide);
        mPager=(ViewPager)findViewById(R.id.guide_pager);
        mBtnStart=(Button)findViewById(R.id.guide_btn_start);
        mPointContainer=(LinearLayout)findViewById(R.id.guide_point_container);
        mSelectedPoint=(View)findViewById(R.id.guide_point_selected);

        mBtnStart.setOnClickListener(this);

        initDate();

        //计算点与点之间的距离
        mSelectedPoint.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {

                //当UI的书布局改变时调用
                if(mImagList==null){
                    return;
                }
                mSelectedPoint.getViewTreeObserver().removeGlobalOnLayoutListener(this);//移除监听，只进行一次;
                mspace=mPointContainer.getChildAt(1).getLeft()-mPointContainer.getChildAt(0).getLeft();

            }
        });
    }
    private void initDate(){//初始化数据
        int[] imgRes=new int[]{
                R.drawable.guide_1,
                R.drawable.guide_2,
                R.drawable.guide_3
        };
        //完善lsit
        mImagList=new ArrayList<ImageView>();
        for(int i=0;i<imgRes.length;i++){
            //新建ImgView
            ImageView iv=new ImageView(this);
            iv.setImageResource(imgRes[i]);
            //使iv图片填充
            iv.setScaleType(ImageView.ScaleType.FIT_XY);
            //给list添加img
            mImagList.add(iv);
            //动态添加点
            View point=new View(this);
            point.setBackgroundResource(R.drawable.guide_point_normal);

            //设置点的大小
            LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(30,30);
           if(i!=0) {//如果不是第一个点给加间距
               params.leftMargin = 10;//设置间距
           }
            mPointContainer.addView(point,params);
        }
        //给viewPager数据-->adapter-->list
        mPager.setAdapter(new GuidePagerAdapter());
        mPager.setOnPageChangeListener(this);
    }

    //当viewpager正在滑动时的回调
    //1:position:当前所处的页面；
    // 2:positionOffset:值得是百分比；
    // 3：positionOffsetPixels:实际滑动的距离
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        //1.去对滑动的点做操作
        //2.设置marginLeft
        RelativeLayout.LayoutParams params= (RelativeLayout.LayoutParams) mSelectedPoint.getLayoutParams();//此处用的是他的父类
        params.leftMargin=(int)(mspace*position+mspace*positionOffset+0.5f);//四舍五入,前面点的距离+后面两个点之间距离的百分比
        mSelectedPoint.setLayoutParams(params);

    }

    //当viewPager某个页面选中时的回调
    //1:position:当前选中的位置
    @Override
    public void onPageSelected(int position) {
        //在最后一个页面时
//        if(position==mImagList.size()-1){
//            //显示button
//            mBtnStart.setVisibility(View.VISIBLE);
//        }
//        else{
//            //隐藏button,完全隐藏
//            mBtnStart.setVisibility(View.GONE);
//        }
        //优化后
        mBtnStart.setVisibility(position==mImagList.size()-1?View.VISIBLE:View.GONE);
    }

    //当viewPager的滑动状态改变时的回调
    //state：状态值
    @Override
    public void onPageScrollStateChanged(int state) {

    }

    //点击监听
    @Override
    public void onClick(View v) {
        if(v==mBtnStart){
            go2Main();//到主页
        }

    }
    private void go2Main(){
        //保存已经不是第一次登陆了

        CacheUtils.setBoolean(this,WelcomeUI.KEY_IS_FIRST,false);

        Intent intent=new Intent(GuideUI.this,MainUI.class);
        startActivity(intent);

        finish();
    }

    class GuidePagerAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            if(mImagList!=null){
                return mImagList.size();
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
           ImageView iv=mImagList.get(position);
           //添加到viewpager中
            //ViewGroup是ViewPager的父类，container在这里与mpager相同作用
            container.addView(iv);
            //需要返回的是显示的imageview
            return iv;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            //从viewpager中移除imageview
            //此处的object就是从instantiateItem传出来的
            //这里是与instantiateItem对应，从instantiateItem传出来什么才能移除什么
            container.removeView((View)object);
        }
    }
}
