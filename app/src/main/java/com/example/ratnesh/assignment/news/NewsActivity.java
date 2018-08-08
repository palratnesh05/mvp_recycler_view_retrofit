package com.example.ratnesh.assignment.news;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.ratnesh.assignment.R;
import com.example.ratnesh.assignment.news.adapter.NewsAdapter;
import com.example.ratnesh.assignment.news.model.Result;

import java.util.List;


public class NewsActivity extends AppCompatActivity implements NewsDataContract.View {

    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    NewsAdapter newsAdapter;
    private NewsPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPresenter = new NewsPresenter(this);
        mPresenter.getDataFromURL(getApplicationContext(), "");
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void onGetDataSuccess(String message, List<Result> list) {
        newsAdapter = new NewsAdapter(getApplicationContext(), list);
        recyclerView.setAdapter(newsAdapter);
    }

    @Override
    public void onGetDataFailure(String message) {
        Log.d("Status", message);
    }
}
