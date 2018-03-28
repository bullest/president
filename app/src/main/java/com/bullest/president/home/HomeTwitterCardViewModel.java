package com.bullest.president.home;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.bullest.president.twitter.TwitterData;
import com.bullest.president.twitter.TwitterRepository;

import java.util.List;

/**
 * Created by yunfezhang on 3/27/18.
 */

public class HomeTwitterCardViewModel extends ViewModel {

    private TwitterRepository mTwitterRepository;

    public HomeTwitterCardViewModel() {
        mTwitterRepository = TwitterRepository.getInstance();
    }

    public LiveData<List<TwitterData>> getTwitterList() {
        return mTwitterRepository.getTwitterList();
    }

}
