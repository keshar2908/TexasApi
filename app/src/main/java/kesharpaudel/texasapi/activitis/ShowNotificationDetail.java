package kesharpaudel.texasapi.activitis;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

import kesharpaudel.texasapi.R;

public class ShowNotificationDetail extends AppCompatActivity {

    TextView teamName, messages, sendByName, sendDates;
    String team, message, sendBy, sendDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_notification_detail);
        teamName = findViewById(R.id.teamID);
        messages = findViewById(R.id.messageID);
        sendByName = findViewById(R.id.sendById);
        sendDates = findViewById(R.id.sendDateId);

        Intent intent = getIntent();
        team = intent.getExtras().getString("Team");
        message = intent.getExtras().getString("Message");
        sendBy = intent.getExtras().getString("SendBy");
        sendDate = intent.getExtras().getString("SendDate");

        teamName.setText("Team: "+team);
        messages.setText("Message: "+message);
        sendByName.setText("Send by: " +sendBy);

        Date date = new Date(new Long(sendDate));
        String newstring = new SimpleDateFormat("MMM-dd, yyyy hh:mm:ss").format(date);
        sendDates.setText("Send date: " +newstring);

    }
}