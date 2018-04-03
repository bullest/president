package com.bullest.president.twitter;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

/**
 * Created by yunfezhang on 3/27/18.
 */

public class TwitterRepository {
    private static final Object syncLock = new Object();
    private static TwitterRepository instance;
    private MutableLiveData<List<TwitterData>> twitterList = new MutableLiveData<>();

    public TwitterRepository() {
        updateTwitterList();
    }

    public static TwitterRepository getInstance() {
        synchronized (syncLock) {
            if (instance == null) {
                instance = new TwitterRepository();
            }
            return instance;
        }
    }

    public void updateTwitterList() {
        BmobQuery<TwitterData> query = new BmobQuery<TwitterData>();
        query.setLimit(10);
        query.order("-createdAt").findObjects(new FindListener<TwitterData>() {
            @Override
            public void done(List<TwitterData> list, BmobException e) {
                twitterList.setValue(list);
            }
        });
    }

    public LiveData<List<TwitterData>> getTwitterList() {
        return twitterList;
    }
}
