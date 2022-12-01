package com.example.jsondemo_s1080418;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.JsonReader;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv = findViewById(R.id.tv);

        String sJ = "{" +"\"query\":\"Pizza\"," + "\"locations\": [94043, 90210]" + "}";
        try {
            JSONObject jo = new JSONObject(sJ);

            JSONArray jr =  jo.getJSONArray("locations");
            tv.setText(jo.getString("query")+"\n"+String.valueOf(jr.get(0))+"\n"+String.valueOf(jr.get(1)));
        } catch (JSONException e) {
            Log.w("Chiu", e.getMessage());
        }


        // read file
        // Json Reader
        JsonReader jr = new JsonReader(new InputStreamReader(getResources().openRawResource(R.raw.sss)));
        String temp = "";
        try {
            jr.beginObject();
            while (jr.hasNext()){
                if(jr.nextName().equals("query")){
                    temp = temp + jr.nextString();
                }
                if(jr.nextName().equals("locations")){
                    jr.beginArray();
                    while (jr.hasNext()){
                        temp=temp+"\n"+jr.nextLong();
                    }
                    jr.endArray();
                }
            }
            jr.endObject();
        } catch (IOException e) {
            Log.w("Chiu",e.getMessage());
        }
        tv.setText(temp);

    }
}