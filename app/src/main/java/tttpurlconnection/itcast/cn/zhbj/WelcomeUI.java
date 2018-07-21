package tttpurlconnection.itcast.cn.zhbj;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;

import tttpurlconnection.itcast.cn.zhbj.utils.CacheUtils;

public class WelcomeUI extends AppCompatActivity {
    private View mContainer;//外侧容器
    private static final int Duration=1000;
    public final static String KEY_IS_FIRST="if_first";//第一次登陆的标记

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);


        mContainer=findViewById(R.id.welcome_container);
        //实现动画
        AnimationSet set=new AnimationSet(false);//创建一个动画集合
        //旋转
        RotateAnimation rotateAnimation=new RotateAnimation(
                0,//开始角度
                360,//结束角度
                Animation.RELATIVE_TO_SELF,//在y轴相对于自身
                0.5f,
                Animation.RELATIVE_TO_SELF,//在x轴相对于自身
                0.5f
        );
        rotateAnimation.setFillEnabled(true);//是否保持状态
        rotateAnimation.setFillAfter(true);//保持为之后状态
        rotateAnimation.setDuration(Duration);
        //缩放
        ScaleAnimation scaleAnimation=new ScaleAnimation(
                0f,//x缩放的比例
                1f,
                0f,//y缩放的比例从0f缩放到1f
                1f,
                Animation.RELATIVE_TO_SELF,//在y轴相对于自身
                0.5f,
                Animation.RELATIVE_TO_SELF,//在x轴相对于自身
                0.5f
        );
        scaleAnimation.setFillEnabled(true);//是否保持状态
        scaleAnimation.setFillAfter(true);//保持为之后状态
        scaleAnimation.setDuration(Duration);
        //透明渐变
        AlphaAnimation alphaAnimation=new AlphaAnimation( 0f,1f);//从0-1透明到不透明
        alphaAnimation.setFillEnabled(true);//是否保持状态
        alphaAnimation.setFillAfter(true);//保持为之后状态
        alphaAnimation.setDuration(Duration);
        //添加动画
        set.addAnimation(rotateAnimation);
        set.addAnimation(scaleAnimation);
        set.addAnimation(alphaAnimation);
        //开始动画
        mContainer.startAnimation(set);
        set.setAnimationListener(new WelcomeAnimationListener());
    }
    class WelcomeAnimationListener implements Animation.AnimationListener {

        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {
            //当动画结束之后运行什么

            boolean isFirst= CacheUtils.getBoolean(WelcomeUI.this,KEY_IS_FIRST,true);//第一次进入默认值为true

            if(isFirst){
                //第一次结束，进入到引导页面
                Intent intent=new Intent(WelcomeUI.this,GuideUI.class);
                startActivity(intent);
            }
            else{
                //否则跳进主页面
                Intent intent=new Intent(WelcomeUI.this,MainUI.class);
                startActivity(intent);
            }
            finish();
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    }
}
