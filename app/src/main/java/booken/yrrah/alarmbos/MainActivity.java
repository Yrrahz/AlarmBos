package booken.yrrah.alarmbos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void notifyMeButton(View view){
        Toast.makeText(getApplicationContext(),"NotifyMe is clicked.", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, AlarmBosService.class);
        //intent.setAction("booken.yrrah.alarmbos.action.FOO");
        startService(intent);
    }
}
