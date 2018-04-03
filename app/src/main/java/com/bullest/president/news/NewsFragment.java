package com.bullest.president.news;


import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bullest.president.R;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment {
    RecyclerView mRecyclerView;
    NewsViewModel mNewsViewModel;

    public NewsFragment() {
        // Required empty public constructor
        mNewsViewModel = new NewsViewModel();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        mRecyclerView = view.findViewById(R.id.news_recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mNewsViewModel.getNewsList(0,0).observe(getActivity(), new Observer<List<NewsData>>() {
            @Override
            public void onChanged(@Nullable final List<NewsData> newsData) {
                NewsAdapter newsAdapter = new NewsAdapter(R.layout.news_list_item, newsData);
                mRecyclerView.setAdapter(newsAdapter);
                newsAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                        Intent intent = new Intent(getActivity(), NewsItemActivity.class);
                        intent.putExtra("NewsTitle", newsData.get(position).getTitle());
                    }
                });

            }
        });
        return view;
    }

}
