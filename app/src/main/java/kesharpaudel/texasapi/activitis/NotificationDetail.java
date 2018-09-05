package kesharpaudel.texasapi.activitis;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notify_recycle);
        recyclerView = findViewById(R.id.nRViewID);


        token = "86D1gNbiYvwGatQe6KuvY3mLpfl1BNQPcQSck7BKA16bKwFQEm";
        loginId = 921;
        customerId = 1;

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
