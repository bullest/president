package com.bullest.president.news;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

/**
 * Created by yunfezhang on 4/1/18.
 */

public class NewsViewModel extends ViewModel {
    private NewsRepository mNewsRepository;

    public NewsViewModel() {
        mNewsRepository = NewsRepository.getInstance();
    }

    public LiveData<List<NewsData>> getNewsList(int offset, int size) {
        return mNewsRepository.getNewsList();
    }

    public LiveData<NewsData> getFullNews(String title) {
        return mNewsRepository.getFullNews(title);
    }
}
