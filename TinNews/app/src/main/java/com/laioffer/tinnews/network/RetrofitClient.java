package com.laioffer.tinnews.network;

import com.laioffer.tinnews.MainActivity;
import com.laioffer.tinnews.repository.NewsRepository;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {  //相当于配置文件，定义base url 和 api key等

    // TODO: Assign your API_KEY here
    private static final String API_KEY = "e350cd95850740f68d4d412d3a4ca9d3";
    private static final String BASE_URL = "https://newsapi.org/v2/";

    public static Retrofit newInstance(NewsRepository mainActivity) {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new HeaderInterceptor())
                .build();
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
    }

    private static class HeaderInterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request original = chain.request();
            Request request = original
                    .newBuilder()
                    .header("X-Api-Key", API_KEY)
                    .build();
            return chain.proceed(request);
        }
    }
}