package com.example.cusservicedemo_s1080418;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.Random;

public class MyService extends Service {
    public MyService() {
    }

    public class MyBinder extends Binder{
        MyService getService(){
            return MyService.this;
        }
    }

    private  final IBinder sBinder = new MyBinder();


    // onStartCommand 為創造一個新的
    // onBind 則是將已存在的 Service 連接
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        // throw new UnsupportedOperationException("Not yet implemented");
        return sBinder;
    }
    // 若 service 沒有 binding 成功，則系統會自動清除
    /// 除非使用 onStart() 喚醒的就必須要自行處理

    private final Random mGenerator = new Random();

    public int getRandomNumber(){

        return mGenerator.nextInt(100);

    }
}