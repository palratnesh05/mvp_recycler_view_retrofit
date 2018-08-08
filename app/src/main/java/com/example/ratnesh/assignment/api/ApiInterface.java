package com.example.ratnesh.assignment.api;

import com.example.ratnesh.assignment.news.model.NewsResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("all-sections/7.json?api-key=5cb782ef8b55474caeb03acdf25bafb0")
    Call<NewsResponse> getNewsData();
}
