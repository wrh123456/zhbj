package tttpurlconnection.itcast.cn.zhbj.utils;

import android.content.Context;
import android.content.SharedPreferences;

//通过sharePreference存储数据
public class CacheUtils {
    private static final String SP_NAME="zhbj";
    private static SharedPreferences sp;
    private static  SharedPreferences getPreferences(Context context){
        if(sp==null){
            sp=context.getSharedPreferences(SP_NAME,Context.MODE_PRIVATE);
        }
        return sp;
    }
    //获取Boolean的缓存数据，没有的话默认值为false;
    public static boolean getBoolean(Context context,String key){
        SharedPreferences sp=getPreferences(context);
        return sp.getBoolean(key,false);
    }

    public static boolean getBoolean(Context context,String key,boolean defValue){
        SharedPreferences sp=getPreferences(context);
        return sp.getBoolean(key,defValue);
    }
    //设置Boolean类型的缓存
    public static void setBoolean(Context context,String key,boolean value){
        SharedPreferences sp=getPreferences(context);
        SharedPreferences.Editor editor=sp.edit();
        editor.putBoolean(key,value);
        editor.commit();
    }

}
