package kesharpaudel.texasapi.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static final String BASE_URL="http://devapp.texasintl.edu.np/auth/api/v1/";
    //10.10.30.111
    private static RetrofitClient mInstance;

    private Retrofit retrofit;


    private RetrofitClient(){

        retrofit=new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized RetrofitClient getInstance(){
        if(mInstance==null){
            mInstance = new RetrofitClient();


        }
        return mInstance;
    }

    public Api getApi(){
        return retrofit.create(Api.class);
    }
}
