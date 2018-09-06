package kesharpaudel.texasapi.activitis;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.Toast;


import de.codecrafters.tableview.TableView;
import kesharpaudel.texasapi.R;
import kesharpaudel.texasapi.adapter.NotificationAdapter;
import kesharpaudel.texasapi.api.RetrofitClient;
import kesharpaudel.texasapi.models.ListDto;
import kesharpaudel.texasapi.models.Notification;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NotificationDetail extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    String token;
    long loginId,customerId;
    DrawerLayout mDrawerLayout;
    ActionBarDrawerToggle mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);
        getSupportActionBar().setTitle("Notification");
        recyclerView = findViewById(R.id.recyclerview);

        mDrawerLayout=findViewById(R.id.drawerlayout);
        mToggle=new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close);


        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navigationView=findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);








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
                /*Toast.makeText(NotificationDetail.this, token, Toast.LENGTH_SHORT).show();
                Toast.makeText(NotificationDetail.this, String.valueOf(loginId), Toast.LENGTH_SHORT).show();
                Toast.makeText(NotificationDetail.this, String.valueOf(customerId), Toast.LENGTH_SHORT).show();
                */
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
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(mToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id=item.getItemId();

        if(id==R.id.counselling){
            Toast.makeText(this, "counselling", Toast.LENGTH_SHORT).show();
            item.setChecked(true);
            mDrawerLayout.closeDrawers();
        }
        if(id==R.id.notification){
            Toast.makeText(this, "Notification", Toast.LENGTH_SHORT).show();
            item.setChecked(true);
            mDrawerLayout.closeDrawers();
        }
        if(id==R.id.team){
            Toast.makeText(this, "Team", Toast.LENGTH_SHORT).show();
            item.setChecked(true);
            mDrawerLayout.closeDrawers();
        }
        if(id==R.id.course){
            Intent intent = new Intent(this,CourseActivity.class);
            intent.putExtra("loginId", loginId);
            intent.putExtra("token", token);
            intent.putExtra("customerId", customerId);
            startActivity(intent);

            Toast.makeText(this, "Teacher", Toast.LENGTH_SHORT).show();
            item.setChecked(true);
            mDrawerLayout.closeDrawers();
        }
        if(id==R.id.student){
            Toast.makeText(this, "Student", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(NotificationDetail.this, studentDetails.class);
            intent.putExtra("loginid",loginId);
            intent.putExtra("token",token);
            intent.putExtra("customerid",customerId);
            startActivity(intent);
            item.setChecked(true);
            mDrawerLayout.closeDrawers();
        }
        if(id==R.id.teacher){
            Intent intent = new Intent(this,TeacherDetail.class);
            intent.putExtra("loginId", loginId);
            intent.putExtra("token", token);
            intent.putExtra("customerId", customerId);
            startActivity(intent);

            Toast.makeText(this, "Teacher", Toast.LENGTH_SHORT).show();
            item.setChecked(true);
            mDrawerLayout.closeDrawers();
        }
        if(id==R.id.routine){
            Toast.makeText(this, "Routine", Toast.LENGTH_SHORT).show();
            item.setChecked(true);
            mDrawerLayout.closeDrawers();
        }
        if(id==R.id.user){
            Toast.makeText(this, "User", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(NotificationDetail.this, UserDetail.class);
            intent.putExtra("loginid",loginId);
            intent.putExtra("token",token);
            intent.putExtra("customerid",customerId);
            startActivity(intent);
            item.setChecked(true);
            mDrawerLayout.closeDrawers();

        }
        return false;
    }
}
