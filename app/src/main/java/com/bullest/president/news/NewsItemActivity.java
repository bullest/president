package com.bullest.president.news;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bullest.president.R;

public class NewsItemActivity extends AppCompatActivity {
    private NewsViewModel mNewsViewModel;
    private LiveData<NewsData> news;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_item);
        Intent intent = getIntent();
        mNewsViewModel = new NewsViewModel();
        news = mNewsViewModel.getFullNews(intent.getStringExtra("title"));
        news.observe(this, new Observer<NewsData>() {
            @Override
            public void onChanged(@Nullable NewsData newsData) {

            }
        });


    }
}
