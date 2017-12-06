package booken.yrrah.alarmbos;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {

        // TODO : Maybe should use a switch/Case statement here... We might get a lot of intent actions.
        int duration = Toast.LENGTH_LONG;
        Log.d("testReceiver", "Test begins...");
        if(intent.getAction().equals("android.intent.action.AIRPLANE_MODE")){
            //String state = extras.getString(TelephonyManager.EXTRA_STATE);
            //Log.w("MY_DEBUG_TAG", state);

            Toast toast = Toast.makeText(context,
                    "Airplane mode is on or off.", duration);
            toast.show();
            Log.d("testReceiver", "Airplane mode is on or off");
        }else if(intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED")){
            Toast toast = Toast.makeText(context,
                    "SMS received", duration);
            toast.show();
            Log.d("testReceiver", "SMS was received");

            UDPTask udpTask = new UDPTask();
            udpTask.execute();
        }
    }
}
