package booken.yrrah.alarmbos;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class MyReceiver extends BroadcastReceiver implements Runnable{

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        //Bundle extras = intent.getExtras();
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


        }
    }

    @Override
    public void run() {
        try{
            String messageStr = "feed";
            int server_port = 8888;
            InetAddress local = InetAddress.getByName("10.0.2.2");
            int msg_length = messageStr.length();
            byte[] message = messageStr.getBytes();

            DatagramSocket s = new DatagramSocket();

            DatagramPacket p = new DatagramPacket(message, msg_length, local, server_port);
            s.send(p);
        }catch (Exception e){
            Log.d("testReceiver", "Exception was caught in run() in MyReceiver.java");
        }
    }
}
