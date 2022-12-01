package com.example.hw09_s1080418;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.JsonReader;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {
    Handler mHnd = new Handler(new HDCbfun());
    //用第一個
    String urlstr = "https://api.kcg.gov.tw/api/service/Get/84b6150e-f6dd-42da-b509-04ffc1bd8d3f";
    // Swagger
    //https://api.kcg.gov.tw/Service/Doc#/
    TextView tv;
    HttpsURLConnection con;

    RecyclerView recyclerView;
    private List<Preschool> lstData = new ArrayList<>();
    myAdapter adp;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rv);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adp = new myAdapter(lstData);
        recyclerView.setAdapter(adp);


        Thread t1 = new Thread(new TRClass(urlstr));
        t1.start();


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
        @SuppressLint("SetTextI18n")
        @Override
        public boolean handleMessage(@NonNull Message message) {
            String sJ = message.obj.toString();
            //tv.setText(sJ);
           // InputStreamReader is = new InputStreamReader(sJ);
            try {
                JSONObject jo = new JSONObject(sJ);
                JSONArray jr =  jo.getJSONArray("data");
                for (int i = 0; i < 25; i++) {
                    jo = jr.getJSONObject(i);
                    Preschool temp = new Preschool(
                            jo.getInt("seq"),
                            jo.getString("類別"),
                            jo.getString("幼兒園名稱(改)"),
                            jo.getString("幼兒園住址完整"),
                            jo.getString("核定總招收人數"));
                    lstData.add(temp);
                }



                adp.notifyDataSetChanged();
                //}
                    // jo.getString("行政區") + "\n" +
                    // jo.getString("幼兒園名稱") + "\n" +
                    // jo.getString("幼兒園") + "\n" +
                    // jo.getString("幼兒園住址") + "\n" +
                    // jo.getString("地址-縣市") + "\n" +
                    // jo.getString("地址-行政區") + "\n" +
                    // jo.getString("數量")

                //Toast.makeText(MainActivity.this, String.valueOf(jr.length()), Toast.LENGTH_LONG).show();
            } catch (JSONException e) {
                Log.w("Chiu123", e.getMessage());
            }
            return true;
        }
    }
//https://openapi.twse.com.tw/#/%E5%85%AC%E5%8F%B8%E6%B2%BB%E7%90%86/get_company_newlisting
    private String sendPostDataToInternet(String strTxt){
        StringBuffer response;
        try{
            // open url post connection and send data
            URL obj = new URL(strTxt);
            con = (HttpsURLConnection) obj.openConnection();
            con.setDoInput(true);
            con.setRequestMethod("GET");

            // client 接收到 response
            int responseCode = con.getResponseCode();
            Log.w("Chiu1", String.valueOf(responseCode));;
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            response = new StringBuffer();
            String inputLine;
            while((inputLine=in.readLine())!=null){
                response.append(inputLine);
            }

            in.close();
            Log.w("Chiu2", response.toString());

            return response.toString();
        } catch (IOException e) {
            Log.w("Chiu3",e.getMessage().toString());
            return null;
        }


    }

}
