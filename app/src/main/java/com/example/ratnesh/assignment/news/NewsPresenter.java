package com.example.ratnesh.assignment.news;

import android.content.Context;

import com.example.ratnesh.assignment.news.model.Result;

import java.util.List;

public class NewsPresenter implements NewsDataContract.Presenter, NewsDataContract.onGetDataListener {
    private NewsDataContract.View mGetDataView;
    private NewsInteractor mNewsInteractor;

    public NewsPresenter(NewsDataContract.View mGetDataView) {
        this.mGetDataView = mGetDataView;
        mNewsInteractor = new NewsInteractor(this);
    }

    @Override
    public void getDataFromURL(Context context, String url) {
        mNewsInteractor.initRetrofitCall(context, url);
    }

    @Override
    public void onSuccess(String message, List<Result> allResults) {
        mGetDataView.onGetDataSuccess(message, allResults);
    }

    @Override
    public void onFailure(String message) {
        mGetDataView.onGetDataFailure(message);
    }
}
