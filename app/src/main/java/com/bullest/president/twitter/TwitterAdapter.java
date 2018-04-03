package com.bullest.president.twitter;

import android.support.annotation.Nullable;

import com.bullest.president.R;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by yunfezhang on 3/29/18.
 */

public class TwitterAdapter extends BaseQuickAdapter<TwitterData, BaseViewHolder> {

    public TwitterAdapter(int layoutResId, @Nullable List<TwitterData> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, TwitterData item) {
        ((TwitterItemView) helper.getView(R.id.twitter_item)).setData(item);
    }
}
