package kesharpaudel.texasapi.activitis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import kesharpaudel.texasapi.R;
import kesharpaudel.texasapi.adapter.teamAdapter;
import kesharpaudel.texasapi.api.RetrofitClient;
import kesharpaudel.texasapi.models.teamDto;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class teamActivity extends AppCompatActivity{
    RecyclerView recyclerView;
    String token;
    long loginId, customerId;
    String type;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    Button b1,b2,b3,b4,b5,b6,b7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);
        getSupportActionBar().setTitle("Team");
        recyclerView = findViewById(R.id.recyclerview);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        token = getIntent().getExtras().getString("token");
        loginId = getIntent().getExtras().getLong("loginid");
        customerId = getIntent().getExtras().getLong("customerid");
        b1 = findViewById(R.id.account);
        b2 = findViewById(R.id.programmer);
        b3 = findViewById(R.id.Student);
        b4 = findViewById(R.id.Counseling);
        b5 = findViewById(R.id.FDTeam);
        b6 = findViewById(R.id.USERTEAM);
        b7 = findViewById(R.id.Teacherteam);

b1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        showteamList0();
    }
});
b2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        showteamList1();
    }
});

b3.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        showteamList2();
    }
});

b4.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        showteamList3();
    }
});
b5.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        showteamList4();
    }
});
b6.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        showteamList5();
    }
});

 b7.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View v) {
         showteamList6();
     }
 });






    }


    public void showteamList0() {


        Call<teamDto> call = RetrofitClient.getInstance().getApi().teamList0(customerId, token, String.valueOf(loginId));

        call.enqueue(new Callback<teamDto>() {
            @Override
            public void onResponse(Call<teamDto> call, Response<teamDto> response) {
                if(response.isSuccessful()){
                    Toast.makeText(teamActivity.this, response.body().getSize().toString(), Toast.LENGTH_SHORT).show();
                    adapter = new teamAdapter(response.body().getContents(), teamActivity.this);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<teamDto> call, Throwable t) {

            }
        });
    }
    public void showteamList1() {


        Call<teamDto> call = RetrofitClient.getInstance().getApi().teamList1(customerId, token, String.valueOf(loginId));

        call.enqueue(new Callback<teamDto>() {
            @Override
            public void onResponse(Call<teamDto> call, Response<teamDto> response) {
                if(response.isSuccessful()){
                    Toast.makeText(teamActivity.this, response.body().getSize().toString(), Toast.LENGTH_SHORT).show();
                    adapter = new teamAdapter(response.body().getContents(), teamActivity.this);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<teamDto> call, Throwable t) {

            }
        });
    }public void showteamList2() {


        Call<teamDto> call = RetrofitClient.getInstance().getApi().teamList2(customerId, token, String.valueOf(loginId));

        call.enqueue(new Callback<teamDto>() {
            @Override
            public void onResponse(Call<teamDto> call, Response<teamDto> response) {
                if(response.isSuccessful()){
                    Toast.makeText(teamActivity.this, response.body().getSize().toString(), Toast.LENGTH_SHORT).show();
                    adapter = new teamAdapter(response.body().getContents(), teamActivity.this);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<teamDto> call, Throwable t) {

            }
        });
    }public void showteamList3() {


        Call<teamDto> call = RetrofitClient.getInstance().getApi().teamList3(customerId, token, String.valueOf(loginId));

        call.enqueue(new Callback<teamDto>() {
            @Override
            public void onResponse(Call<teamDto> call, Response<teamDto> response) {
                if(response.isSuccessful()){
                    Toast.makeText(teamActivity.this, response.body().getSize().toString(), Toast.LENGTH_SHORT).show();
                    adapter = new teamAdapter(response.body().getContents(), teamActivity.this);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<teamDto> call, Throwable t) {

            }
        });
    }public void showteamList4() {


        Call<teamDto> call = RetrofitClient.getInstance().getApi().teamList4(customerId, token, String.valueOf(loginId));

        call.enqueue(new Callback<teamDto>() {
            @Override
            public void onResponse(Call<teamDto> call, Response<teamDto> response) {
                if(response.isSuccessful()){
                    Toast.makeText(teamActivity.this, response.body().getSize().toString(), Toast.LENGTH_SHORT).show();
                    adapter = new teamAdapter(response.body().getContents(), teamActivity.this);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<teamDto> call, Throwable t) {

            }
        });
    }public void showteamList5() {


        Call<teamDto> call = RetrofitClient.getInstance().getApi().teamList5(customerId, token, String.valueOf(loginId));

        call.enqueue(new Callback<teamDto>() {
            @Override
            public void onResponse(Call<teamDto> call, Response<teamDto> response) {
                if(response.isSuccessful()){
                    Toast.makeText(teamActivity.this, response.body().getSize().toString(), Toast.LENGTH_SHORT).show();
                    adapter = new teamAdapter(response.body().getContents(), teamActivity.this);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<teamDto> call, Throwable t) {

            }
        });
    }public void showteamList6() {


        Call<teamDto> call = RetrofitClient.getInstance().getApi().teamList6(customerId, token, String.valueOf(loginId));

        call.enqueue(new Callback<teamDto>() {
            @Override
            public void onResponse(Call<teamDto> call, Response<teamDto> response) {
                if(response.isSuccessful()){
                    Toast.makeText(teamActivity.this, response.body().getSize().toString(), Toast.LENGTH_SHORT).show();
                    adapter = new teamAdapter(response.body().getContents(), teamActivity.this);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<teamDto> call, Throwable t) {

            }
        });
    }

}

