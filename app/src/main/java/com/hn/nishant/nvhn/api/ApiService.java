package com.hn.nishant.nvhn.api;

import com.hn.nishant.nvhn.model.Story;
import com.hn.nishant.nvhn.model.User;
import com.hn.nishant.nvhn.network.ResponseListener;

import java.util.List;

import rx.Observable;
import rx.Observer;

/**
 * Created by nishant on 16.03.17.
 */

public interface ApiService {

    void getStoryIds(ResponseListener<List<Long>> responseListener, String type);

    void getStory(long id, ResponseListener<Story> responseListener);

    void listenForUpdates();

    void stopListeningForUpdate();

    Observable<User> getUserDetail(String userId);

}
