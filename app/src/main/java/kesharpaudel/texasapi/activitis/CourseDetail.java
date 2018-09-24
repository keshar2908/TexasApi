package kesharpaudel.texasapi.activitis;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import kesharpaudel.texasapi.R;

public class CourseDetail extends AppCompatActivity {


    TextView name, description, affiliation, duration, createdBy, createdDate;
    String cName;
    String cDescription;
    String cAffiliation;
    int cDuration;
    String cCreatedBy;
    String cCreatedDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_detail);
        name = findViewById(R.id.nameID);
        description = findViewById(R.id.descriptionID);
        affiliation = findViewById(R.id.affiliationID);
        duration = findViewById(R.id.durationID);
        createdBy = findViewById(R.id.createdByID);
        createdDate = findViewById(R.id.createdDateID);


        Intent intent = getIntent();
        cName = intent.getExtras().getString("Name");
        cDescription = intent.getExtras().getString("Description");
        cAffiliation = intent.getExtras().getString("Affiliation");
        cDuration = intent.getExtras().getInt("Duration");
        cCreatedBy = intent.getExtras().getString("CreatedBy");
        cCreatedDate = intent.getExtras().getString("CreatedDate");

        name.setText("Name: "+cName);
        description.setText("Description: "+cDescription);
        affiliation.setText("Affiliation: "+cAffiliation);
        duration.setText("Duration: "+Integer.toString(cDuration));
        createdBy.setText("Created By: "+cCreatedBy);
        createdDate.setText("Created Date: "+cCreatedDate);


    }

}
