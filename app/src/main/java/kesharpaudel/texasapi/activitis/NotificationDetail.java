package kesharpaudel.texasapi.activitis;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;


import kesharpaudel.texasapi.R;
import kesharpaudel.texasapi.adapter.NotificationAdapter;
import kesharpaudel.texasapi.api.RetrofitClient;
import kesharpaudel.texasapi.models.ListDto;
import kesharpaudel.texasapi.models.Notification;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NotificationDetail extends AppCompatActivity {

    RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    String token;
    long loginId,customerId;
    DrawerLayout mDrawerLayout;
    ActionBarDrawerToggle mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);
        recyclerView = findViewById(R.id.recyclerview);








        token=getIntent().getExtras().getString("token");
        loginId=getIntent().getExtras().getLong("loginid");
        customerId=getIntent().getExtras().getLong("customerid");

        layoutManager=new LinearLayoutManager(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        showNotification();



    }

    private void showNotification() {

        Call<Notification> call= RetrofitClient.getInstance()
                .getApi().notificationList(loginId,customerId,token);

        call.enqueue(new Callback<Notification>() {
            @Override
            public void onResponse(Call<Notification> call, Response<Notification> response) {
                Toast.makeText(NotificationDetail.this, token, Toast.LENGTH_SHORT).show();
                Toast.makeText(NotificationDetail.this, String.valueOf(loginId), Toast.LENGTH_SHORT).show();
                Toast.makeText(NotificationDetail.this, String.valueOf(customerId), Toast.LENGTH_SHORT).show();
                if (response.isSuccessful()) {
                    NotificationAdapter adapter = new NotificationAdapter(response.body().getData(),NotificationDetail.this);
                    recyclerView.setAdapter(adapter);
                }
                else {
                    Toast.makeText(NotificationDetail.this, "No response", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Notification> call, Throwable t) {

                Toast.makeText(NotificationDetail.this, "Error occured.", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
