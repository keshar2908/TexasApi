package kesharpaudel.texasapi.activitis;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import kesharpaudel.texasapi.R;

public class SingleUserDetail extends AppCompatActivity {

    private ImageView ProfilePicture;
    private TextView Username,Firstname,Lastname,Email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_user_detail);

        ProfilePicture=findViewById(R.id.profilepicture);
        Username=findViewById(R.id.username);
        Firstname=findViewById(R.id.fn);
        Lastname=findViewById(R.id.ln);
        Email=findViewById(R.id.email);

        Glide.with(this).load(getIntent()
                .getStringExtra("profilepicture"))
                .into(ProfilePicture);
        Username.setText(getIntent().getStringExtra("username"));
        Firstname.setText(getIntent().getStringExtra("firstname"));
        Lastname.setText(getIntent().getStringExtra("lastname"));
        Email.setText(getIntent().getStringExtra("email"));

    }
}
