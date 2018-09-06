package kesharpaudel.texasapi.activitis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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

public class CourseActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    String token;
    long loginId,customerId;

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
}
