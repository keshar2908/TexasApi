package kesharpaudel.texasapi.activitis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import kesharpaudel.texasapi.R;
import kesharpaudel.texasapi.adapter.RoutineAdapter;
import kesharpaudel.texasapi.api.RetrofitClient;
import kesharpaudel.texasapi.models.Routine;
import kesharpaudel.texasapi.models.RoutineResponseDto;
import kesharpaudel.texasapi.models.SemesterRoutineResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RoutineActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    String token;
    long loginId,customerId, courseId;
    RecyclerView.Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routine);

        recyclerView = findViewById(R.id.recyclerview);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        token = "bUZW7EshOxs17pgjnJi9CkvJPkJCvwshDpoqqBhqDVfJyI9M20" ;
        loginId = 921;
        customerId = 1;
        courseId = 40;


        showCourses();



    }

    private void showCourses() {
        Call<RoutineResponseDto> call = RetrofitClient.getInstance()
                .getApi().routineList(loginId,customerId,courseId,token);
        call.enqueue(new Callback<RoutineResponseDto>() {
            @Override
            public void onResponse(Call<RoutineResponseDto> call, Response<RoutineResponseDto> response) {
                if (response.isSuccessful()) {

                    RoutineResponseDto res = response.body();
                    List<SemesterRoutineResponse> semesterRoutineResponseList = res.getSemesterRoutineResponse();
                    if(semesterRoutineResponseList != null){

                        for(SemesterRoutineResponse semesterRoutineResponse : semesterRoutineResponseList){
                            String semester = semesterRoutineResponse.getSemester();
                            List<Routine> routineList = semesterRoutineResponse.getRoutines();
                            adapter = new RoutineAdapter(routineList, RoutineActivity.this);
                            recyclerView.setAdapter(adapter);
                            if(routineList != null){
                                for(Routine routine: routineList){

                                }
                            }
                        }
                    }



                }else{
                    Toast.makeText(RoutineActivity.this, "Response failure.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<RoutineResponseDto> call, Throwable t) {

                Toast.makeText(RoutineActivity.this, "Error occured.", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
