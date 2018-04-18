package com.example.fpp_109.revisicounter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;



public class PopActivity extends Activity {

    public TextView tex2;
    Button tutup, tutup2;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop);
        tutup2 = findViewById(R.id.share);
        tutup = findViewById(R.id.tutup);
        final TextView edit,edit1,edit2,edit3,edit4,edit5,edit6;

        kill();

        final Intent intent = getIntent();
        final String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        final String message1 = intent.getStringExtra(MainActivity.EXTRA_MESSAGE1);
        final String message2 = intent.getStringExtra(MainActivity.EXTRA_MESSAGE2);
        final String message3 = intent.getStringExtra(MainActivity.EXTRA_MESSAGE3);
        final String message4 = intent.getStringExtra(MainActivity.EXTRA_MESSAGE4);
        final String message5 = intent.getStringExtra(MainActivity.EXTRA_MESSAGE5);
        final String message6 = intent.getStringExtra(MainActivity.EXTRA_MESSAGE6);
        final String message7 = intent.getStringExtra(MainActivity.EXTRA_MESSAGE7);




        edit = findViewById(R.id.tv);
        edit.setText("Tanpa Helm : "+message);
        edit1 = findViewById(R.id.tv2);
        edit1.setText("Roda 4 Di RHK : "+message1);
        edit2 = findViewById(R.id.tv3);
        edit2.setText("Melanggar Stop Line : "+message2);
        edit3 = findViewById(R.id.tv4);
        edit3.setText("Berhenti Di ZebraCross : "+message3);
        edit4 = findViewById(R.id.tv5);
        edit4.setText("Roda 2 Kelebihan Penumpang : "+message4);
        edit5 = findViewById(R.id.tv6);
        edit5.setText("Berkendara Sambil Merokok : "+message5);
        edit6 = findViewById(R.id.tv7);
        edit6.setText("Pelanggaran Lainnya : "+message6);
        Chronometer edit7 = findViewById(R.id.tv8);
        edit7.setText(message7);


        tutup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int) (width * .9), (int) (height * .8));
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.CENTER;
        params.x = 0;
        params.y = -20;
        getWindow().setAttributes(params);

        tutup2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendIntent = new Intent(Intent.ACTION_SEND);
                sendIntent.setType("text/plain");
                sendIntent.putExtra(Intent.EXTRA_TEXT,"Total Pelanggaran Pengguna Jalan : "+"\n"+"\n"+
                        "Tidak Mengenakan Helm  =  "+(message)+"\n"+
                        "Roda 4 Di RHK  =  "+(message1)+"\n"+
                        "Melanggar Stop Line  =  "+(message2)+"\n"+
                        "Berhenti Di ZebraCross  =  "+(message3)+"\n"+
                        "Roda 2 Kelebihan Penumpang  =  "+(message4)+"\n"+
                        "Merokok Sambil Berkendara  =  "+(message5)+"\n"+
                        "Pelanggaran Lainnya  =  "+(message6)+"\n"+"\n"+

                        "Total Pelanggaran = "+(getIntent().getExtras().getInt("key"))+" Pelanggar"  +"\n"+
                        "Total Waktu  =  "+(message7)+ " Menit.");
                    startActivity(sendIntent);


            }

        });


    }

    @SuppressLint("SetTextI18n")
    public void kill(){
        tex2=findViewById(R.id.tex2);
        int sum=getIntent().getExtras().getInt("key");
        tex2.setText(Integer.toString(sum));
    }



}

