package com.hn.nishant.nvhn.api;

import com.hn.nishant.nvhn.model.Story;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by nishant on 15.03.17.
 */

public interface RetorfitApiService {

    @GET("v0/topstories.json")
    Call<List<Long>> getStoryIds();

    @GET("v0/item/{id}.json")
    Call<Story> getStory(@Path("id") long id);

}
