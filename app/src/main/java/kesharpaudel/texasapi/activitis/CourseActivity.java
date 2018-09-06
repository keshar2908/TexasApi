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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import kesharpaudel.texasapi.R;
import kesharpaudel.texasapi.adapter.CourseAdapter;
import kesharpaudel.texasapi.api.RetrofitClient;
import kesharpaudel.texasapi.models.Course;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CourseActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    String token;
    long loginId,customerId;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);

        recyclerView = findViewById(R.id.recyclerview);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        token=getIntent().getExtras().getString("token");
        loginId=getIntent().getExtras().getLong("loginid");
        customerId=getIntent().getExtras().getLong("customerid");

        mDrawerLayout = findViewById(R.id.drawerlayout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        showCourses();

    }

    private void showCourses() {
        Call<List<Course>> call= RetrofitClient.getInstance()
                .getApi().courseList(customerId,token,loginId);
        call.enqueue(new Callback<List<Course>>() {
            @Override
            public void onResponse(Call<List<Course>> call, Response<List<Course>> response) {
                CourseAdapter adapter = new CourseAdapter((ArrayList<Course>) response.body(),CourseActivity.this);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Course>> call, Throwable t) {

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
            Toast.makeText(this, "Notification", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(CourseActivity.this, NotificationDetail.class);
            intent.putExtra("loginid", loginId);
            intent.putExtra("token", token);
            intent.putExtra("customerid", customerId);
            startActivity(intent);
            item.setChecked(true);
            mDrawerLayout.closeDrawers();
        }
        if (id == R.id.team) {
            Toast.makeText(this, "Team", Toast.LENGTH_SHORT).show();
            item.setChecked(true);
            mDrawerLayout.closeDrawers();
        }

        if(id==R.id.course) {

            Toast.makeText(this, "Course", Toast.LENGTH_SHORT).show();
            item.setChecked(true);
            mDrawerLayout.closeDrawers();
        }


        if (id == R.id.student) {
            Toast.makeText(this, "For Student", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(CourseActivity.this, studentDetails.class);
            intent.putExtra("loginid", loginId);
            intent.putExtra("token", token);
            intent.putExtra("customerid", customerId);
            startActivity(intent);
            item.setChecked(true);
            mDrawerLayout.closeDrawers();
        }
        if (id == R.id.teacher) {
            Intent intent = new Intent(this,TeacherDetail.class);
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
            Intent intent = new Intent(CourseActivity.this, UserDetail.class);
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
