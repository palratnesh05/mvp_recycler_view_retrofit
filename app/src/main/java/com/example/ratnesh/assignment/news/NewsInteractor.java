package com.example.ratnesh.assignment.news;

import android.content.Context;
import android.util.Log;

import com.example.ratnesh.assignment.api.ApiInterface;
import com.example.ratnesh.assignment.news.model.NewsResponse;
import com.example.ratnesh.assignment.news.model.Result;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

;

public class NewsInteractor implements NewsDataContract.Interactor {
    List<Result> resultsList = new ArrayList<>();
    private NewsDataContract.onGetDataListener mOnGetDataListener;

    public NewsInteractor(NewsDataContract.onGetDataListener mOnGetDataListener) {
        this.mOnGetDataListener = mOnGetDataListener;
    }

    @Override
    public void initRetrofitCall(Context context, String url) {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();

        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        httpClient.addInterceptor(logging);
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.nytimes.com/svc/mostpopular/v2/mostviewed/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(httpClient.build())
                .build();
        final ApiInterface request = retrofit.create(ApiInterface.class);
        retrofit2.Call<NewsResponse> call = request.getNewsData();
        call.enqueue(new retrofit2.Callback<NewsResponse>() {
            @Override
            public void onResponse(retrofit2.Call<NewsResponse> call, retrofit2.Response<NewsResponse> response) {
                NewsResponse jsonResponse = response.body();
                resultsList = jsonResponse.getResults();

                mOnGetDataListener.onSuccess("List Size: " + resultsList.size(), resultsList);


            }

            @Override
            public void onFailure(retrofit2.Call<NewsResponse> call, Throwable t) {
                Log.v("Error", t.getMessage());
                mOnGetDataListener.onFailure(t.getMessage());
            }
        });
    }
}
