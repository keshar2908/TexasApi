package kesharpaudel.texasapi.api;


import java.util.List;

import kesharpaudel.texasapi.models.Course;

import kesharpaudel.texasapi.models.ListStudent;

import kesharpaudel.texasapi.models.ListDto;
import kesharpaudel.texasapi.models.Login;
import kesharpaudel.texasapi.models.Notification;
import kesharpaudel.texasapi.models.Teacher;
import kesharpaudel.texasapi.models.User;
import kesharpaudel.texasapi.models.UserDto;
import kesharpaudel.texasapi.models.teamDto;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Api {


    @POST("login")
    Call<UserDto> login(@Body Login login);

    @GET("users?page=0&size=41&sort=firstName%2Cdesc")
    Call<ListDto> userlist(@Header("loginId") long loginId, @Header("customerId") long customerId, @Header("token") String token);

    @GET("notifications?page=0&size=20&sort=id%2Casc")
    Call<Notification> notificationList(@Header("loginId") long loginId, @Header("customerId") long customerId, @Header("token") String token);

    @GET("students?page=0&size=23&sort=firstName%2Cdesc")
    Call<ListStudent> studentList(@Header("customerId") long customerId, @Header("token") String token, @Header("loginId") String loginId);

    @GET("courses")
    Call<List<Course>> courseList(@Header("customerId") long customerId, @Header("token") String token,@Header("userId") long loginId);

    @GET("teachers?page=0&size=20&sort=firstName%2Cdesc")
    Call<Teacher> teacherList(@Header("loginId") long loginId, @Header("customerId") long customerId,
                              @Header("token") String token);

    @GET("teams?page=0&size=20&sort=id%2Casc&search=Accounting")
    Call<teamDto> teamList0(@Header("customerId") long customerId,@Header("token") String token,@Header("loginId") String loginId);

    @GET("teams?page=0&size=20&sort=id%2Casc&search=Programmer")
    Call<teamDto> teamList1(@Header("customerId") long customerId,@Header("token") String token,@Header("loginId") String loginId);

    @GET("teams?page=0&size=20&sort=id%2Casc&search=Student")
    Call<teamDto> teamList2(@Header("customerId") long customerId,@Header("token") String token,@Header("loginId") String loginId);

    @GET("teams?page=0&size=20&sort=id%2Casc&search=Counseling")
    Call<teamDto> teamList3(@Header("customerId") long customerId,@Header("token") String token,@Header("loginId") String loginId);

    @GET("teams?page=0&size=20&sort=id%2Casc&search=Front%20Desk%20Team")
    Call<teamDto> teamList4(@Header("customerId") long customerId,@Header("token") String token,@Header("loginId") String loginId);

    @GET("teams?page=0&size=20&sort=id%2Casc&search=User%20Team")
    Call<teamDto> teamList5(@Header("customerId") long customerId,@Header("token") String token,@Header("loginId") String loginId);

    @GET("teams?page=0&size=20&sort=id%2Casc&search=Teacher%20Team")
    Call<teamDto> teamList6(@Header("customerId") long customerId,@Header("token") String token,@Header("loginId") String loginId);



}
