package com.pnlinh.tikihometest.data;

import com.pnlinh.tikihometest.Def;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {
    private static OkHttpClient httpClient = new OkHttpClient.Builder()
            .build();

    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(Def.BASE_URL)
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static <S> S createService(Class<S> serviceClass) {
        return retrofit.create(serviceClass);
    }
}
