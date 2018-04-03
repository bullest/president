package com.bullest.president.news;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.bullest.president.R;

import java.util.List;

/**
 * Created by yunfezhang on 4/2/18.
 */

public class NewsAdapter extends BaseQuickAdapter<NewsData, BaseViewHolder> {
    public NewsAdapter(int layoutResId, @Nullable List<NewsData> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, NewsData item) {
        helper.setText(R.id.news_title, item.getTitle());
        helper.setText(R.id.news_short_content, item.getShort_content());
        helper.setText(R.id.news_time, item.getTime());

    }
}
