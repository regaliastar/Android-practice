package com.example.secondmodule;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 艾德米 on 2018/3/8.
 */

public class InfosBean implements Serializable{

    public List<NewsBean> news;

    public static class NewsBean {
        /**
         * title : 白血病患儿国产廉价救命药出现“断货”，李克强批示：特事特办！
         * img : http://p3.pstatp.com/list/190x124/46f2000235ff5c583596
         * from : 中国政府网
         * comment : 14
         * time : 22分钟前
         * href : https://www.toutiao.com/a6490467169803960846/
         */

        public String title;
        public String img;
        public String from;
        public String comment;
        public String time;
        public String href;
    }
}
