package kesharpaudel.texasapi.activitis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import kesharpaudel.texasapi.R;
import kesharpaudel.texasapi.adapter.TeacherAdapter;
import kesharpaudel.texasapi.api.RetrofitClient;
import kesharpaudel.texasapi.models.Teacher;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TeacherDetail extends AppCompatActivity {

     RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
   // private RecyclerView.Adapter adapter;

    long loginId,customerId;
    String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);

        recyclerView = findViewById(R.id.recyclerview);

        //token = "s1OFZhi5pu6qDSsMKN0odUq5p0bhW7Vdjvx79i7LXNEW2BHVMH";
        //loginId = 869;
        //customerId = 1;

        token = getIntent().getExtras().getString("token");
        customerId = getIntent().getExtras().getLong("customerId");
        loginId =  getIntent().getExtras().getLong("loginId");

        layoutManager=new LinearLayoutManager(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        showTeacherDetail();

    }

    private void showTeacherDetail() {
        Call<Teacher> call = RetrofitClient.getInstance()
                .getApi().teacherList(loginId,customerId,token);

        call.enqueue(new Callback<Teacher>() {
            @Override
            public void onResponse(Call<Teacher> call, Response<Teacher> response) {
                if (response.isSuccessful()){
                   // Toast.makeText(TeacherDetail.this, "Successful", Toast.LENGTH_SHORT).show();

                    TeacherAdapter adapter = new TeacherAdapter(response.body().getData(),TeacherDetail.this);
                    recyclerView.setAdapter(adapter);
                }else{
                    Toast.makeText(TeacherDetail.this, "Failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Teacher> call, Throwable t) {

                Toast.makeText(TeacherDetail.this, "No response", Toast.LENGTH_SHORT).show();
            }
        });
    }

}

