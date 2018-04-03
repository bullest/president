package com.bullest.president.twitter;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bullest.president.R;

/**
 * Created by yunfezhang on 3/27/18.
 */

public class TwitterItemView extends LinearLayout {
    TextView twitter_cn, twitter_en, twitter_time;
    ImageView twitterImage;

    public TwitterItemView(Context context) {
        super(context);
        init(context);
    }

    public TwitterItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    private void init(Context context) {
        View view = inflate(context, R.layout.twitter_item, this);
        twitter_cn = view.findViewById(R.id.twitter_cn);
        twitter_en = view.findViewById(R.id.twitter_en);
        twitter_time = view.findViewById(R.id.twitter_time);
        twitterImage = view.findViewById(R.id.twitter_image);
    }

    public void setData(TwitterData twitterData) {
        twitter_en.setText(twitterData.getTwitter_en());
        twitter_cn.setText(twitterData.getTwitter_cn());
        twitter_time.setText(twitterData.getTime());
    }

}