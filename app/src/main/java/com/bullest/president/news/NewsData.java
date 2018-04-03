package com.bullest.president.news;

/**
 * Created by yunfezhang on 4/1/18.
 */

public class NewsData {
    String time;
    String title;
    String short_content;
    String full_content;
    String source;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShort_content() {
        return short_content;
    }

    public void setShort_content(String short_content) {
        this.short_content = short_content;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getFull_content() {
        return full_content;
    }

    public void setFull_content(String full_content) {
        this.full_content = full_content;
    }
}
