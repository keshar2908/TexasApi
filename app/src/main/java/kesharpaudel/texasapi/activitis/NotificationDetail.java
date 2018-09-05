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



        mDrawerLayout=findViewById(R.id.drawerlayout);
        mToggle=new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navigationView=findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener((NavigationView.OnNavigationItemSelectedListener) NotificationDetail.this);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        Intent intent =getIntent();
        token = intent.getExtras().getString("token");
        loginId = intent.getExtras().getLong("loginId");
        customerId = intent.getExtras().getLong("customerId");

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
                if (response.isSuccessful()) {
                    NotificationAdapter adapter = new NotificationAdapter(response.body().getData(),NotificationDetail.this);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<Notification> call, Throwable t) {

                Toast.makeText(NotificationDetail.this, "Error occured.", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
