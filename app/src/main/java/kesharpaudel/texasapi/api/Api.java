package kesharpaudel.texasapi.api;

import kesharpaudel.texasapi.activitis.ListStudent;
import kesharpaudel.texasapi.models.ListDto;
import kesharpaudel.texasapi.models.Login;
import kesharpaudel.texasapi.models.Notification;
import kesharpaudel.texasapi.models.User;
import kesharpaudel.texasapi.models.UserDto;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface Api {


    @POST("login")
    Call<UserDto> login(@Body Login login);

    @GET("users?page=0&size=41&sort=firstName%2Cdesc")
    Call<ListDto> userlist(@Header("loginId") long loginId, @Header("customerId") long customerId, @Header("token") String token);

    @GET("notifications?page=0&size=20&sort=id%2Casc")
    Call<Notification> notificationList(@Header("loginId") long loginId, @Header("customerId") long customerId, @Header("token") String token);

    @GET("students?page=0&size=23&sort=firstName%2Cdesc")
    Call<ListStudent> studentList(@Header("customerId") long customerId, @Header("token") String token, @Header("loginId") String loginId);

}
