package booken.yrrah.alarmbos;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void notifyMeButton(View view){

         // A small notification. Nothing much
        Intent resultIntent = new Intent(this, ResultActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,resultIntent,PendingIntent.FLAG_UPDATE_CURRENT);

        int notificationID = 1;
        NotificationCompat.Builder mBuilder =
                (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.firstnotificationimage) // Appears that this must exist.
                        .setContentTitle("My notification")
                        .setContentText("Hello World!")
                        .setContentIntent(pendingIntent);

        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        manager.notify(notificationID, mBuilder.build());


        /* // This is the Service!
        Toast.makeText(getApplicationContext(),"NotifyMe is clicked.", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, AlarmBosService.class);
        //intent.setAction("booken.yrrah.alarmbos.action.FOO");
        startService(intent);*/
    }
}
