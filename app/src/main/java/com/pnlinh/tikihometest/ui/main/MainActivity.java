package com.pnlinh.tikihometest.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.pnlinh.tikihometest.R;
import com.pnlinh.tikihometest.data.AppClient;
import com.pnlinh.tikihometest.data.ServiceGenerator;
import com.pnlinh.tikihometest.ui.main.adapter.KeywordItemDecorator;
import com.pnlinh.tikihometest.ui.main.adapter.KeywordRecyclerAdapter;

import java.lang.ref.WeakReference;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private KeywordRecyclerAdapter mAdapter;

    private AppClient mAppClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        mAppClient = ServiceGenerator.createService(AppClient.class);
        mAppClient.getKeywords().enqueue(new KeywordCallback(this));
    }

    private void showData(List<String> data) {
        if (data == null)
            return;
        mAdapter.setKeywords(data);
    }

    private void showError(String error) {
        if (error == null)
            return;
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }


    private void initView() {
        mRecyclerView = findViewById(R.id.rcl_test);
        mAdapter = new KeywordRecyclerAdapter();
        mRecyclerView.setAdapter(mAdapter);
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.addItemDecoration(new KeywordItemDecorator());
    }

    static class KeywordCallback implements Callback<List<String>> {
        private WeakReference<MainActivity> mReference;

        private KeywordCallback(MainActivity mainActivity) {
            mReference = new WeakReference<>(mainActivity);
        }

        @Override
        public void onResponse(Call<List<String>> call, Response<List<String>> response) {
            MainActivity mainActivity = mReference.get();
            if (mainActivity == null)
                return;
            if (response.isSuccessful()) {
                mainActivity.showData(response.body());
            }
        }

        @Override
        public void onFailure(Call<List<String>> call, Throwable t) {
            MainActivity mainActivity = mReference.get();
            if (mainActivity == null)
                return;
            mainActivity.showError(t.getMessage());
        }
    }
}
