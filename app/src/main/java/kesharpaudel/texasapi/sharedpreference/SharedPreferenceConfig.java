package kesharpaudel.texasapi.sharedpreference;

import android.content.Context;
import android.content.SharedPreferences;

import kesharpaudel.texasapi.R;
import kesharpaudel.texasapi.models.Login;
import kesharpaudel.texasapi.models.User;

public class SharedPreferenceConfig {

    public static SharedPreferenceConfig mInstance;
    private static final String SHARED_PREF_NAME="my_shared_preff";


    private Context context;

    private SharedPreferenceConfig(Context context) {
        this.context = context;

    }

    public static synchronized SharedPreferenceConfig getInstance(Context context){

        if(mInstance==null){

            mInstance=new SharedPreferenceConfig(context);
        }
        return mInstance;

    }

    public void saveUser(User user){

        SharedPreferences sharedPreferences=context
                .getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putLong("loginid",user.getLoginId());
        editor.putLong("customerid",user.getCustomerId());
        editor.putString("token",user.getToken());

        editor.apply();


    }

    public boolean isLogedIn(){
        SharedPreferences sharedPreferences=context
                .getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);

        if(sharedPreferences.getLong("loginid",-1)!=-1 &&
                sharedPreferences.getString("token",null)!=null&&
                sharedPreferences.getLong("customerid",-1)!=-1){
            return true;

        }

        return false;


    }

    public User getUser(){

        SharedPreferences sharedPreferences=context.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);

        return new User(
                sharedPreferences.getLong("loginid",-1),
                sharedPreferences.getLong("customerid",-1),
                sharedPreferences.getString("token",null)

        );




    }
    public void clear(){

        SharedPreferences sharedPreferences=context.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.clear();
        editor.apply();

    }

}
