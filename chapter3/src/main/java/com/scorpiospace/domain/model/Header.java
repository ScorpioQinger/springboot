package com.scorpiospace.domain.model;

/**
 * @ClassName Header
 * @Description TODO
 * @Author zq
 * @Date 2019/7/23 11:04
 * @Version 1.0
 **/
public class Header {
    private String title;
    private String desc;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Header(String title, String desc) {
        this.title = title;
        this.desc = desc;
    }
}
