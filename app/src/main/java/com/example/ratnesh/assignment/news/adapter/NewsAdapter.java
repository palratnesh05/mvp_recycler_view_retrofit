package com.example.ratnesh.assignment.news.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ratnesh.assignment.R;
import com.example.ratnesh.assignment.news.model.Result;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyViewHolder> {
    private Context context;
    private List<Result> resultList = new ArrayList<>();
    public NewsAdapter(Context context, List<Result> resultList){
        this.context = context;
        this.resultList = resultList;
    }
    @Override
    public NewsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(NewsAdapter.MyViewHolder holder, int position) {
        holder.tvTitle.setText(resultList.get(position).getTitle());
        holder.tvByLine.setText(resultList.get(position).getByline());
        holder.tvPublishedDate.setText(resultList.get(position).getPublishedDate());
        if (position == resultList.size() / 2 /* calculate middle element position */) {
            holder.setIsInTheMiddle(true);

        } else {
            holder.setIsInTheMiddle(false);
        }

    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private boolean mIsInTheMiddle = false;
        TextView tvTitle;
        TextView tvByLine;
        TextView tvPublishedDate;
        CircleImageView imgProfile;
        public MyViewHolder(View itemView) {
            super(itemView);
            tvTitle = (TextView)itemView.findViewById(R.id.title);
            tvByLine = (TextView)itemView.findViewById(R.id.byLine);
            tvPublishedDate = (TextView)itemView.findViewById(R.id.publishedDate);
            imgProfile = (CircleImageView)itemView.findViewById(R.id.profileImage);

        }
       public boolean getIsInTheMiddle() {
            return mIsInTheMiddle;
        }

        void setIsInTheMiddle(boolean isInTheMiddle) {
            mIsInTheMiddle = isInTheMiddle;
        }
    }
}
