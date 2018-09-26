package kesharpaudel.texasapi.activitis;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;
import kesharpaudel.texasapi.R;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private ViewFlipper mSlider;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        int images[] = {R.drawable.img0, R.drawable.img1, R.drawable.img2, R.drawable.img3};
        mSlider = findViewById(R.id.mSlider);

        for (int image: images){

            flipperImage(image);

        }

        mDrawerLayout = findViewById(R.id.drawerlayout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);




    }
    public void flipperImage(int image){

        ImageView imageView=new ImageView(this);
        imageView.setBackgroundResource(image);
        mSlider.addView(imageView);
        mSlider.setFlipInterval(3000);
        mSlider.setAutoStart(true);


        mSlider.setInAnimation(this,android.R.anim.slide_in_left);
        mSlider.setOutAnimation(this,android.R.anim.slide_out_right);



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

        if (id == R.id.dashboard) {
            Toast.makeText(this, "Dashboard", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this,DashboardActivity.class));
            item.setChecked(true);
            mDrawerLayout.closeDrawers();
        }
        if (id == R.id.news) {
            Toast.makeText(this, " News and Notification", Toast.LENGTH_SHORT).show();
            item.setChecked(true);
            mDrawerLayout.closeDrawers();
        }
        if (id == R.id.routine) {

            Toast.makeText(this, "Routine", Toast.LENGTH_SHORT).show();
            item.setChecked(true);
            mDrawerLayout.closeDrawers();
        }



        if (id == R.id.contact) {

            Toast.makeText(this, "Contact", Toast.LENGTH_SHORT).show();
            item.setChecked(true);
            mDrawerLayout.closeDrawers();
        }


        if (id == R.id.about) {
            Toast.makeText(this, " About", Toast.LENGTH_SHORT).show();
            item.setChecked(true);
            mDrawerLayout.closeDrawers();
        }
        if (id == R.id.logout) {
            item.setChecked(true);
            mDrawerLayout.closeDrawers();

        }
        return false;
    }
}
