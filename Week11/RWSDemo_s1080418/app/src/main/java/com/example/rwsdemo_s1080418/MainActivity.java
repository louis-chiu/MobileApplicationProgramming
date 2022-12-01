package com.example.rwsdemo_s1080418;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {
    Handler mHnd = new Handler(new HDCbfun());
    String urlstr = "https://httpbin.org/post";
    TextView tv;
    HttpsURLConnection con;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.tv);
        //tv.setText("First!!!");

        Thread t1 = new Thread(new TRClass(urlstr));
        t1.start();

        Toast.makeText(this, "After t1 in program!!", Toast.LENGTH_LONG).show();

    }

    //Thread Runnable Class
    class TRClass implements Runnable {
        private String url;

        public TRClass(String url) {
            this.url = url;
        }

        @Override
        public void run() {
            //HTTP
            String res = sendPostDataToInternet(url);
            //
            mHnd.obtainMessage(1, res)
                    .sendToTarget();
        }
    }

    class  HDCbfun implements Handler.Callback{
        @Override
        public boolean handleMessage(@NonNull Message message) {
            tv.setText(message.obj.toString());
            return true;
        }
    }

    private String sendPostDataToInternet(String strTxt){
        final String USER_AGENT = "Mozilla/5.0";
        StringBuffer response;
        try{
            // open url post connection and send data
            URL obj = new URL(strTxt);
            con = (HttpsURLConnection) obj.openConnection();
            con.setRequestProperty("User-Agent", USER_AGENT);
            con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestMethod("POST");
            //
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            //
            String urlParameters = "Phone_ID=123456&Time=1234&wifi_db=12" +
                        "&becon1_db=-10&becon2_db=-12&becon3_db=-9";

            wr.writeBytes(urlParameters);
            wr.flush();
            wr.close();

            // client 接收到 response
            int responseCode = con.getResponseCode();
            Log.w("Chiu", String.valueOf(responseCode));;
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            response = new StringBuffer();
            String inputLine;
            while((inputLine=in.readLine())!=null){
                response.append(inputLine);
            }

            in.close();
            Log.w("Chiu", response.toString());
            return response.toString();
        } catch (IOException e) {
            Log.w("Chiu",e.getMessage().toString());
            return null;
        }

    }
}