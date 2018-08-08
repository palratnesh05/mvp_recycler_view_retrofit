package com.example.ratnesh.assignment.news;

import android.content.Context;

import com.example.ratnesh.assignment.Base.BasePresenter;
import com.example.ratnesh.assignment.Base.BaseView;
import com.example.ratnesh.assignment.news.model.Result;

import java.util.List;


public interface NewsDataContract {
    interface View extends BaseView {
        void onGetDataSuccess(String message, List<Result> list);

        void onGetDataFailure(String message);
    }

    interface Presenter extends BasePresenter {
        void getDataFromURL(Context context, String url);
    }

    interface Interactor {
        void initRetrofitCall(Context context, String url);

    }

    interface onGetDataListener {
        void onSuccess(String message, List<Result> list);

        void onFailure(String message);
    }
}
