package in.jsb.jsb.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import in.jsb.jsb.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

       final Thread splasThread = new Thread(new Runnable() {
            @Override
            public void run() {

               /* try {

                    //Thread.sleep(10000);

                } catch (InterruptedException e) {

                    e.printStackTrace();

                }*/


            }
        });

        splasThread.start();
        try {
            splasThread.join();
            startActivity(new Intent(SplashActivity.this,LoginActivity.class));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }







}
