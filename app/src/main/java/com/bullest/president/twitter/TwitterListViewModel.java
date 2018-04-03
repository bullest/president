package com.bullest.president.twitter;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

/**
 * Created by yunfezhang on 3/29/18.
 */

public class TwitterListViewModel extends ViewModel {
    private TwitterRepository mTwitterRepository;

    public TwitterListViewModel() {
        mTwitterRepository = TwitterRepository.getInstance();
    }

    public LiveData<List<TwitterData>> getTwitterList(int offset, int size) {
        return mTwitterRepository.getTwitterList();
    }
}
