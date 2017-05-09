package com.example.za407.logactivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.app.Activity;

public class MainActivity extends AppCompatActivity {
    private Button myButton;
    static final String LIFT_TAG="LogActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(MainActivity.LIFT_TAG,"FirstActivity --->onCreate");
        Button myButton = (Button)findViewById(R.id.button);
        myButton.setText("启动第二个Activity");
        myButton.setOnClickListener(new ButtonOnClickListener());
    }


    @Override
    protected void onDestroy() {
        Log.v(MainActivity.LIFT_TAG,"FirstActivity --->onDestroy");
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        Log.v(MainActivity.LIFT_TAG,"FirstActivity --->onPause");
        super.onPause();
    }

    @Override
    protected void onRestart() {
        Log.v(MainActivity.LIFT_TAG,"FirstActivity --->onRestart");
        super.onRestart();
    }

    @Override
    protected void onResume() {
        Log.v(MainActivity.LIFT_TAG,"FirstActivity --->onResume");
        super.onResume();
    }

    @Override
    protected void onStart() {
        Log.v(MainActivity.LIFT_TAG,"FirstActivity --->onStart");
        super.onStart();
    }

    @Override
    protected void onStop() {
        Log.v(MainActivity.LIFT_TAG,"FirstActivity --->onStop");
        super.onStop();
    }

    class ButtonOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this,LogActivity2.class);
            MainActivity.this.startActivity(intent);
        }


    }
}
