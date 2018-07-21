package tttpurlconnection.itcast.cn.zhbj.bean;

import java.util.List;

public class NewsCenterBean {
    public List<NewCenterMenuListBean> data;
    public List extend;
    public int retcode;

    public class NewCenterMenuListBean{
        public List<NewsCenterNewsItemBean> children;
        public long id;
        public String title;
        public int type;

        public String url;
        public String url1;

        public String dayurl;
        public String excurl;
        public String weekurl;

    }
    public class NewsCenterNewsItemBean{
        public long id;
        public String title;
        public int type;
        public String url;
    }
}
