package kesharpaudel.texasapi.activitis;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import kesharpaudel.texasapi.R;
import kesharpaudel.texasapi.adapter.RecyclerAdapter;
import kesharpaudel.texasapi.api.RetrofitClient;
import kesharpaudel.texasapi.models.Data;
import kesharpaudel.texasapi.models.ListDto;
import kesharpaudel.texasapi.models.User;
import kesharpaudel.texasapi.sharedpreference.SharedPreferenceConfig;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.view.View.VISIBLE;

public class UserDetail extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private ProgressBar progressBar;
    private RecyclerView.Adapter adapter;

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    String token;
    long loginId, customerId;

    private int item_count = 20;
    private int page_number = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);
        getSupportActionBar().setTitle("User");

        recyclerView = findViewById(R.id.recyclerview);
        progressBar = findViewById(R.id.progressbar);
        token=SharedPreferenceConfig.getInstance(this).getUser().getToken();
        loginId=SharedPreferenceConfig.getInstance(this).getUser().getLoginId();
        customerId=SharedPreferenceConfig.getInstance(this).getUser().getCustomerId();


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

    @Override
    protected void onStart() {
        super.onStart();

        if(!SharedPreferenceConfig.getInstance(this).isLogedIn()){

            Intent intent=new Intent(UserDetail.this,MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);

        }
    }



    private void showUserDetail() {

        progressBar.setVisibility(View.VISIBLE);


        Call<ListDto> call = RetrofitClient.getInstance()
                .getApi().userlist(loginId, customerId, token);

        call.enqueue(new Callback<ListDto>() {
            @Override
            public void onResponse(Call<ListDto> call, Response<ListDto> response) {

                List<Data> data = response.body().getData();

                adapter = new RecyclerAdapter(data, UserDetail.this);

                if (response.isSuccessful()) {
                    recyclerView.setAdapter(adapter);

                    progressBar.setVisibility(View.GONE);

                }

            }

            @Override
            public void onFailure(Call<ListDto> call, Throwable t) {
                Toast.makeText(UserDetail.this, "Response Failed.", Toast.LENGTH_SHORT).show();

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
            Intent intent = new Intent(UserDetail.this, TeacherDetail.class);
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

    private void performPagination() {

        Call<ListDto> call = RetrofitClient.getInstance()
                .getApi().userlist(loginId, customerId, token);

        call.enqueue(new Callback<ListDto>() {
            @Override
            public void onResponse(Call<ListDto> call, Response<ListDto> response) {


            }

            @Override
            public void onFailure(Call<ListDto> call, Throwable t) {

            }
        });

    }
}
