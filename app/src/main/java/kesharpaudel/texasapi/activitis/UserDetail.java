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

import kesharpaudel.texasapi.R;
import kesharpaudel.texasapi.adapter.RecyclerAdapter;
import kesharpaudel.texasapi.api.RetrofitClient;
import kesharpaudel.texasapi.models.ListDto;
import kesharpaudel.texasapi.models.Notification;
import kesharpaudel.texasapi.models.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserDetail extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    String token;
    long loginId, customerId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);
        getSupportActionBar().setTitle("User");

        recyclerView = findViewById(R.id.recyclerview);
        token = getIntent().getExtras().getString("token");
        loginId = getIntent().getExtras().getLong("loginid");
        customerId = getIntent().getExtras().getLong("customerid");


        layoutManager = new LinearLayoutManager(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        mDrawerLayout = findViewById(R.id.drawerlayout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);
        showUserDetail();

    }

    private void showUserDetail() {


        Call<ListDto> call = RetrofitClient.getInstance()
                .getApi().userlist(loginId, customerId, token);

        call.enqueue(new Callback<ListDto>() {
            @Override
            public void onResponse(Call<ListDto> call, Response<ListDto> response) {

                adapter = new RecyclerAdapter(response.body().getData(), UserDetail.this);

                if (response.isSuccessful()) {
                    recyclerView.setAdapter(adapter);

                }

            }

            @Override
            public void onFailure(Call<ListDto> call, Throwable t) {
                Toast.makeText(UserDetail.this, "Something went wrong.", Toast.LENGTH_SHORT).show();

            }
        });




    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (mToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.counselling) {
            Toast.makeText(this, "counselling", Toast.LENGTH_SHORT).show();
            item.setChecked(true);
            mDrawerLayout.closeDrawers();
        }
        if (id == R.id.notification) {
            Toast.makeText(this, " Notification", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(UserDetail.this, NotificationDetail.class);
            intent.putExtra("loginid", loginId);
            intent.putExtra("token", token);
            intent.putExtra("customerid", customerId);
            startActivity(intent);
            item.setChecked(true);
            mDrawerLayout.closeDrawers();
        }
        if (id == R.id.team) {
            Toast.makeText(this, "Team", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(UserDetail.this, teamActivity.class);
            intent.putExtra("loginid", loginId);
            intent.putExtra("token", token);
            intent.putExtra("customerid", customerId);
            startActivity(intent);
            item.setChecked(true);
            mDrawerLayout.closeDrawers();
        }




            if (id == R.id.course) {
                Intent intent = new Intent(this, CourseActivity.class);
                intent.putExtra("loginid", loginId);
                intent.putExtra("token", token);
                intent.putExtra("customerid", customerId);
                startActivity(intent);
                //Toast.makeText(this, "For Course", Toast.LENGTH_SHORT).show();


            }

        if(id==R.id.course) {
            Intent intent = new Intent(this, CourseActivity.class);
            intent.putExtra("loginid", loginId);
            intent.putExtra("token", token);
            intent.putExtra("customerid", customerId);
            startActivity(intent);
            Toast.makeText(this, "Course", Toast.LENGTH_SHORT).show();
            item.setChecked(true);
            mDrawerLayout.closeDrawers();
        }


            if (id == R.id.student) {
                Toast.makeText(this, " Student", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(UserDetail.this, studentDetails.class);
                intent.putExtra("loginid", loginId);
                intent.putExtra("token", token);
                intent.putExtra("customerid", customerId);
                startActivity(intent);
                item.setChecked(true);
                mDrawerLayout.closeDrawers();
            }
            if (id == R.id.teacher) {

                //Toast.makeText(this, "For Teacher", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(UserDetail.this,TeacherDetail.class);
                intent.putExtra("loginId", loginId);
                intent.putExtra("token", token);
                intent.putExtra("customerId", customerId);
                startActivity(intent);

                Toast.makeText(this, "Teacher", Toast.LENGTH_SHORT).show();
                item.setChecked(true);
                mDrawerLayout.closeDrawers();

            }
            if (id == R.id.routine) {
                Toast.makeText(this, "Routine", Toast.LENGTH_SHORT).show();
                item.setChecked(true);
                mDrawerLayout.closeDrawers();
            }
            if (id == R.id.user) {
                Toast.makeText(this, "User", Toast.LENGTH_SHORT).show();
                item.setChecked(true);
                mDrawerLayout.closeDrawers();
            }
            return false;
        }

}
