package com.bullest.president.news;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

/**
 * Created by yunfezhang on 4/1/18.
 */

public class NewsRepository {

    private static final Object syncLock = new Object();
    private static NewsRepository instance;
    private MutableLiveData<List<NewsData>> newsList = new MutableLiveData<>();
    private MutableLiveData<NewsData> newsItem = new MutableLiveData<>();

    public NewsRepository() {
        updateNewsList();
    }

    public static NewsRepository getInstance() {
        synchronized (syncLock) {
            if (instance == null) {
                instance = new NewsRepository();
            }
            return instance;
        }
    }

    public void updateNewsList() {
        BmobQuery<NewsData> query = new BmobQuery<>();
        query.setLimit(10);
        query.addQueryKeys("title, short_content, time, source");
        query.order("-createdAt").findObjects(new FindListener<NewsData>() {
            @Override
            public void done(List<NewsData> list, BmobException e) {
                newsList.postValue(list);
                if (e != null) {
                    Log.d("News", e.toString());
                }
            }
        });
    }

    public LiveData<NewsData> getFullNews(String title) {
        BmobQuery<NewsData> query = new BmobQuery<>();
        query.addWhereEqualTo("title", title).findObjects(new FindListener<NewsData>() {
            @Override
            public void done(List<NewsData> list, BmobException e) {
                if (list != null && !list.isEmpty()) {
                    newsItem.setValue(list.get(0));
                }
            }
        });
        return newsItem;
    }

    public LiveData<List<NewsData>> getNewsList() {
        return newsList;
    }
}
