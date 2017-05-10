package com.example.za407.handlermessageprogess;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    ProgressBar bar = null;
    Button startButton =null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bar = (ProgressBar)findViewById(R.id.bar);
        startButton =(Button)findViewById(R.id.startButton);
        startButton.setOnClickListener(new ButtonListener());
    }

    //当点击startButton按钮时，就会执行ButtonListener的onClick方法
    class ButtonListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            bar.setVisibility(View.VISIBLE);
            updateBarHandler.post(updateThread);
        }
    }
    //使用匿名内部类来复写Hanler当中的handleMessage方法
    Handler updateBarHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            bar.setProgress(msg.arg1);
            updateBarHandler.post(updateThread);
        }
    };
    //线程类，该类使用匿名内部类的方式进行声明
    Runnable updateThread = new Runnable() {
        int i =0;
        @Override
        public void run() {
            System.out.println("Begin Thread");
            i = i+10;
            Message msg = updateBarHandler.obtainMessage();
            //将msg对象的arg1参数的值设置为i,用arg1和arg2这两个成员变量传递消息，优点是系统性能消耗较少
            msg.arg1 =i;
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    };
}
