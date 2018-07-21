package tttpurlconnection.itcast.cn.zhbj.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

//不可以触摸滑动的viewPager
public class NoScrollViewPager extends LazyViewPager{
    public NoScrollViewPager(@NonNull Context context) {
        super(context);
    }
    public NoScrollViewPager(Context context, AttributeSet attrs){
        super(context,attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return false;
    }
}
