package kesharpaudel.texasapi.activitis;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import kesharpaudel.texasapi.R;
import kesharpaudel.texasapi.adapter.listAdapter;
import kesharpaudel.texasapi.api.RetrofitClient;
import kesharpaudel.texasapi.models.ListStudent;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class studentDetails extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    String token;
    long loginId,customerId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);
        recyclerView=findViewById(R.id.recyclerview);
        token=getIntent().getExtras().getString("token");
        loginId=getIntent().getExtras().getLong("loginid");
        customerId=getIntent().getExtras().getLong("customerid");




        layoutManager=new LinearLayoutManager(this );
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);





        showUserDetail();



    }

    private void showUserDetail() {


        Call<ListStudent> call = RetrofitClient.getInstance().getApi().studentList(customerId,token,String.valueOf(loginId));
        call.enqueue(new Callback<ListStudent>() {
            @Override
            public void onResponse(Call<ListStudent> call, Response<ListStudent> response) {
                Toast.makeText(studentDetails.this, "success", Toast.LENGTH_SHORT).show();
                adapter=new listAdapter(response.body().getData(),studentDetails.this);

                if(response.isSuccessful()){
                    recyclerView.setAdapter(adapter);

                }
            }

            @Override
            public void onFailure(Call<ListStudent> call, Throwable t) {
                Toast.makeText(studentDetails.this, "not successful", Toast.LENGTH_SHORT).show();
            }
        });
        /* Call<ListDto> call= RetrofitClient.getInstance()
                .getApi().userlist(loginId,customerId,token);

        call.enqueue(new Callback<ListDto>() {
            @Override
            public void onResponse(Call<ListDto> call, Response<ListDto> response) {

                adapter=new RecyclerAdapter(response.body().getData(),UserDetail.this);

                if(response.isSuccessful()){
                    recyclerView.setAdapter(adapter);

                }

            }

            @Override
            public void onFailure(Call<ListDto> call, Throwable t) {
                Toast.makeText(UserDetail.this, "Something went wrong.", Toast.LENGTH_SHORT).show();

            }
        });

*/


    }


}
