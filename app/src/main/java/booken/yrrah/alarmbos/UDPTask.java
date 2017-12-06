package booken.yrrah.alarmbos;

/**
 * Created by Yrrah on 2017-12-06.
 */

import android.os.AsyncTask;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPTask extends AsyncTask<String,String,String> {

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        //color = (new Random().nextInt() < 0 ) ? "BLUE" : "RAINBOW";

        /*
        if(color == null) {
            color = "RED";
        }else if(color.equals("RAINBOW")){
            color = "BLUE";
        }else{
            color = "RAINBOW";
        }
        */
    }

    @Override
    protected String doInBackground(String... params) {

        DatagramSocket s = null;
        String udpMessage = "1";
        int port = 5831; // This was the RaspberryPi port we used at Sigma. (5831)

        try {
            s = new DatagramSocket();
            InetAddress inetAddress = InetAddress.getByName("192.168.43.102"); //ip of destination
            int msg_length=udpMessage.length();
            byte[] byteUDPMessage = udpMessage.getBytes();
            DatagramPacket p = new DatagramPacket(byteUDPMessage, msg_length,inetAddress,port);

            s.send(p);

        } catch (Exception e) { // Catch all exceptions. Cant bother reading them anyway
            e.printStackTrace();
        }finally {
            if (s != null) {
                s.close();
            }
        }
        return null;
    }
}
