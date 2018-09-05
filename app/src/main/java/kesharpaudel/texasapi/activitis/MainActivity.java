package kesharpaudel.texasapi.activitis;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


import kesharpaudel.texasapi.R;
import kesharpaudel.texasapi.api.RetrofitClient;
import kesharpaudel.texasapi.models.Login;
import kesharpaudel.texasapi.models.User;
import kesharpaudel.texasapi.models.UserDto;
import kesharpaudel.texasapi.sharedpreference.SharedPreferenceConfig;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Call;

public class MainActivity extends AppCompatActivity {

    private ImageView mImage;
    private EditText mUsername;
    private EditText mPassword;
    private Button mLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        mImage = findViewById(R.id.image);
        mUsername = findViewById(R.id.username);
        mPassword = findViewById(R.id.password);
        mLogin = findViewById(R.id.login);


        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                userLogin();
                //Toast.makeText(MainActivity.this, "I don't know Api. please tech us.", Toast.LENGTH_SHORT).show();

            }
        });


    }

    public void userLogin() {


        String username = mUsername.getText().toString().trim();
        String password = mPassword.getText().toString().trim();

        if (username.isEmpty()) {
            mUsername.setError("Username is required.");
            mUsername.requestFocus();
            return;
        }

        //-----------for email validation------------//

        /*if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){

            mUsername.setError("Enter a valid email.");
            mUsername.requestFocus();
            return;

        }*/

        if (password.isEmpty()) {
            mPassword.setError("Password is Required.");
            mPassword.requestFocus();
            return;
        }
        if (password.length() < 2) {
            mPassword.setError("Password should be at least 6 character long.");
            mPassword.requestFocus();
            return;
        }


        Login login = new Login(password, username);

        Call<UserDto> call = RetrofitClient.getInstance()
                .getApi().login(login);


        call.enqueue(new Callback<UserDto>() {
            @Override
            public void onResponse(Call<UserDto> call, Response<UserDto> response) {


                if (response.isSuccessful()) {


                    UserDto user = response.body();


                    String token = user.getUser().getToken();
                    long loginid = user.getUser().getLoginId();
                    long customerid = user.getUser().getCustomerId();

                    Intent intent = new Intent(MainActivity.this, UserDetail.class);


                    intent.putExtra("loginid", loginid);
                    intent.putExtra("token", token);
                    intent.putExtra("customerid", customerid);
                    startActivity(intent);


                    //Toast.makeText(MainActivity.this, user.getUser().getFirstName(), Toast.LENGTH_SHORT).show();
                    //Toast.makeText(MainActivity.this, user.getUser().getToken(), Toast.LENGTH_SHORT).show();


                } else {
                    Toast.makeText(MainActivity.this, "Username and Password is mismatch.", Toast.LENGTH_SHORT).show();
                    mPassword.setText("");
                }


            }

            @Override


            public void onFailure(Call<UserDto> call, Throwable t) {

                Toast.makeText(MainActivity.this, "Username and Password is mismatch.", Toast.LENGTH_SHORT).show();


            }
        });


    }


}
