package com.propertyguru.nishant.nvpropertyguru.network;

import com.propertyguru.nishant.nvpropertyguru.App;
import com.propertyguru.nishant.nvpropertyguru.api.ApiService;
import com.propertyguru.nishant.nvpropertyguru.api.RetorfitApiService;
import com.propertyguru.nishant.nvpropertyguru.model.Story;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by nishant on 17.03.17.
 */

public class RetrofitImpl implements ApiService {

    private RetorfitApiService retorfitApiService;

    private RetrofitImpl retrofitImpl = new RetrofitImpl();

    private RetrofitImpl(){
        retorfitApiService = App.getRetrofit().create(RetorfitApiService.class);
    }

    @Override
    public void getStory(long id, final ResponseListener<Story> responseListener) {
        Call<Story> storyCall = retorfitApiService.getStory(id);
        storyCall.enqueue(new Callback<Story>() {
            @Override
            public void onResponse(Call<Story> call, Response<Story> response) {
                responseListener.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<Story> call, Throwable t) {
                 responseListener.onError(new Exception(t.getMessage()));
            }
        });
    }

    @Override
    public void getStoryIds(final ResponseListener<List<Long>> responseListener) {
        Call<List<Long>> call =  retorfitApiService.getStoryIds();
        call.enqueue(new Callback<List<Long>>() {
            @Override
            public void onResponse(Call<List<Long>> call, Response<List<Long>> response) {
                responseListener.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<Long>> call, Throwable t) {
                responseListener.onError(new Exception(t.getMessage()));
            }
        });
    }

    public RetrofitImpl getRetrofitImpl() {
        return retrofitImpl;
    }

}
