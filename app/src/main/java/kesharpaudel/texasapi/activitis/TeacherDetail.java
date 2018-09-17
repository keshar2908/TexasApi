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

import kesharpaudel.texasapi.R;
import kesharpaudel.texasapi.adapter.TeacherAdapter;
import kesharpaudel.texasapi.api.RetrofitClient;
import kesharpaudel.texasapi.models.Teacher;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TeacherDetail extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    // private RecyclerView.Adapter adapter;

    long loginId, customerId;
    String token;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);
        getSupportActionBar().setTitle("Teachers");

        recyclerView = findViewById(R.id.recyclerview);


        token = getIntent().getExtras().getString("token");
        customerId = getIntent().getExtras().getLong("customerId");
        loginId = getIntent().getExtras().getLong("loginId");

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

        showTeacherDetail();

    }

    private void showTeacherDetail() {
        Call<Teacher> call = RetrofitClient.getInstance()
                .getApi().teacherList(loginId, customerId, token);

        call.enqueue(new Callback<Teacher>() {
            @Override
            public void onResponse(Call<Teacher> call, Response<Teacher> response) {
                if (response.isSuccessful()) {
                    // Toast.makeText(TeacherDetail.this, "Successful", Toast.LENGTH_SHORT).show();

                    TeacherAdapter adapter = new TeacherAdapter(response.body().getData(), TeacherDetail.this);
                    recyclerView.setAdapter(adapter);
                } else {
                    Toast.makeText(TeacherDetail.this, "Failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Teacher> call, Throwable t) {

                Toast.makeText(TeacherDetail.this, "No response", Toast.LENGTH_SHORT).show();
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
            Intent intent = new Intent(this, NotificationDetail.class);
            intent.putExtra("loginid", loginId);
            intent.putExtra("token", token);
            intent.putExtra("customerid", customerId);
            startActivity(intent);
            item.setChecked(true);
            mDrawerLayout.closeDrawers();
        }
        if (id == R.id.team) {
            Toast.makeText(this, "Team", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, teamActivity.class);
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
            Intent intent = new Intent(TeacherDetail.this, studentDetails.class);
            intent.putExtra("loginid", loginId);
            intent.putExtra("token", token);
            intent.putExtra("customerid", customerId);
            startActivity(intent);
            item.setChecked(true);
            mDrawerLayout.closeDrawers();
        }
        if (id == R.id.teacher) {
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
            Intent intent = new Intent(TeacherDetail.this, UserDetail.class);
            intent.putExtra("loginid", loginId);
            intent.putExtra("token", token);
            intent.putExtra("customerid", customerId);
            startActivity(intent);
            item.setChecked(true);
            mDrawerLayout.closeDrawers();
        }
        return false;
    }
}

