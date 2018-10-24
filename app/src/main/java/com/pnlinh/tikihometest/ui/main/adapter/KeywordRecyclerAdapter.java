package com.pnlinh.tikihometest.ui.main.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pnlinh.tikihometest.R;

import java.util.ArrayList;
import java.util.List;

public class KeywordRecyclerAdapter extends RecyclerView.Adapter<KeywordRecyclerAdapter.MyViewHolder> {

    List<String> keywords = new ArrayList<>();

    public void setKeywords(List<String> keywords) {
        this.keywords.clear();
        this.keywords.addAll(keywords);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(
                LayoutInflater.from(viewGroup.getContext()).inflate(
                        R.layout.item_recycler_keyword, viewGroup, false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.mTextView.setText(keywords.get(i));
    }

    @Override
    public int getItemCount() {
        return keywords.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView mTextView;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextView = (TextView) itemView;
        }
    }
}
