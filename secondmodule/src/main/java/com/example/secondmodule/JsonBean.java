package com.example.secondmodule;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 艾德米 on 2018/3/7.
 */

public class JsonBean implements Serializable{

    public List<SitesBean> sites;

    public List<SitesBean> getSites() {
        return sites;
    }

    public void setSites(List<SitesBean> sites) {
        this.sites = sites;
    }

    public static class SitesBean {

        public String name;
        private String url;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
