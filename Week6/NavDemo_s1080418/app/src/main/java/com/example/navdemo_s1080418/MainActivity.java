package com.example.navdemo_s1080418;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavHost;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn01 = findViewById(R.id.button1);
        Button btn02 = findViewById(R.id.button2);

        btn01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment cf =(NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView);
                String cname = cf.getChildFragmentManager().getFragments().get(0).getClass().getName();
                if( cname.contains("firstFragment") ){
                    Navigation.findNavController(MainActivity.this, R.id.fragmentContainerView)
                            .navigate(R.id.action_firstFragment_self);
                }else if ( cname.contains("navHFragment")){
                    Navigation.findNavController(MainActivity.this, R.id.fragmentContainerView)
                            .navigate(R.id.action_navHFragment_to_firstFragment);
                }else if ( cname.contains("secFragment")) {
                    Navigation.findNavController(MainActivity.this, R.id.fragmentContainerView)
                            .navigate(R.id.action_navHFragment_to_secFragment);
                }
            }
        });

        btn02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(MainActivity.this, R.id.fragmentContainerView)
                        .navigate(R.id.action_navHFragment_to_secFragment);
            }
        });
    }
}