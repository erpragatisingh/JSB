package in.jsb.jsb.net;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;


import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.schedulers.Schedulers;


public class ApiClient {
    private static final int   CONNECT_TIMEOUT = 60 * 1000;
    private static final int  READ_TIMEOUT = 60 * 1000;

    public static Retrofit getClient(String requestURL) {
        RxJavaCallAdapterFactory rxAdapter = RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io());
        Retrofit retrofit = null;
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        OkHttpClient okHttpClient = new OkHttpClient.Builder().writeTimeout( READ_TIMEOUT, TimeUnit.MILLISECONDS)
                .readTimeout( READ_TIMEOUT, TimeUnit.MILLISECONDS)
                .retryOnConnectionFailure(true)
                .connectTimeout( CONNECT_TIMEOUT, TimeUnit.MILLISECONDS)
                .addInterceptor(interceptor)
                /*.addNetworkInterceptor(new StethoInterceptor())*/.retryOnConnectionFailure(true)
                .build();

            retrofit = new Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl(requestURL)
                    .addConverterFactory(GsonConverterFactory.create(gson)).addCallAdapterFactory(rxAdapter)
                    .build();

        return retrofit;

    }
}
