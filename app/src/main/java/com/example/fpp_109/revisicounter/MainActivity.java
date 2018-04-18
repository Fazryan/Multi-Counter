package com.example.fpp_109.revisicounter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.SystemClock;
import android.os.Vibrator;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "Counter";
    public static final String EXTRA_MESSAGE1 = "Counter1";
    public static final String EXTRA_MESSAGE2 = "Counter2";
    public static final String EXTRA_MESSAGE3 = "Counter3";
    public static final String EXTRA_MESSAGE4 = "Counter4";
    public static final String EXTRA_MESSAGE5 = "Counter5";
    public static final String EXTRA_MESSAGE6 = "Counter6";
    public static final String EXTRA_MESSAGE7 = "Jam Kerja";
    public static final String EXTRA_MESSAGE8 = "Total";
    public TextView tex1;


    int mCounter = 0;
    int Mcc = 0;
    int Mcc2 = 0;
    int Mcc3 = 0;
    int Mcc4 = 0;
    int Mcc5 = 0;
    int Mcc6 = 0;
    int focuss = 0;




    Vibrator vibe;
    long timeElapsed = 0;
    Chronometer focus;

    Button start, reset;

    public TextView tx, tx1, tx2, tx3, tx4, tx5, tx6, tv;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reset = findViewById(R.id.reset);

        vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        start = findViewById(R.id.start);
        focus = findViewById(R.id.mfocus);


        tv = findViewById(R.id.tv);
        tx = findViewById(R.id.tx);
        tx1 = findViewById(R.id.tx1);
        tx2 = findViewById(R.id.tx2);
        tx3 = findViewById(R.id.tx3);
        tx4 = findViewById(R.id.tx4);
        tx5 = findViewById(R.id.tx5);
        tx6 = findViewById(R.id.tx6);
        tex1 = findViewById(R.id.tex1);

        DrawerLayout mDrawerlayout = findViewById(R.id.drawer);
        ActionBarDrawerToggle mToggle = new ActionBarDrawerToggle(this, mDrawerlayout, R.string.open, R.string.close);
        mDrawerlayout.addDrawerListener(mToggle);

        focus.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                timeElapsed = SystemClock.elapsedRealtime() - focus.getBase();

            }
        });


        start.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                // WAKTU JAM MULAI
                if (timeElapsed == 0) {
                    focus.start();
                    focus.setBase(SystemClock.elapsedRealtime());
                    start.setText("STOP SESION");
                }
                {
                    focus.start();
                }
                if (timeElapsed != 0) {
                    timeElapsed = 0;
                    focus.stop();
                    start.setText(" - ");
                    start.setEnabled(false);


                }
            }
        });

    }


    @SuppressLint("SetTextI18n")
    public void mc(View view) {

        mCounter = mCounter + 1;
        vibe.vibrate(100);
        tampil(mCounter);

    }

    public void mcc(View view) {
        Mcc = Mcc + 1;
        vibe.vibrate(100);
        tampil2(Mcc);

    }

    public void mcc2(View view) {
        Mcc2 = Mcc2 + 1;
        vibe.vibrate(100);
        tampil3(Mcc2);
    }

    public void mcc3(View view) {
        Mcc3 = Mcc3 + 1;
        vibe.vibrate(100);
        tampil4(Mcc3);
    }

    public void mcc4(View view) {
        Mcc4 = Mcc4 + 1;
        vibe.vibrate(100);
        tampil5(Mcc4);
    }

    public void mcc5(View view) {
        Mcc5 = Mcc5 + 1;
        vibe.vibrate(100);
        tampil6(Mcc5);
    }

    public void mcc6(View view) {
        Mcc6 = Mcc6 + 1;
        vibe.vibrate(100);
        tampil7(Mcc6);
    }

    @SuppressLint("SetTextI18n")
    public void tampil(int z) {
        tx.setText("" + z);

    }

    @SuppressLint("SetTextI18n")
    public void tampil2(int z1) {
        tx1.setText("" + z1);
    }

    @SuppressLint("SetTextI18n")
    public void tampil3(int z2) {
        tx2.setText("" + z2);
    }

    @SuppressLint("SetTextI18n")
    public void tampil4(int z3) {
        tx3.setText("" + z3);
    }

    @SuppressLint("SetTextI18n")
    public void tampil5(int z4) {
        tx4.setText("" + z4);
    }

    @SuppressLint("SetTextI18n")
    public void tampil6(int z5) {
        tx5.setText("" + z5);
    }

    @SuppressLint("SetTextI18n")
    public void tampil7(int z6) {
        tx6.setText("" + z6);
    }

    @SuppressLint("SetTextI18n")
    public void tampil8(int z7) {
        focus.setText("" + z7);
    }




    @SuppressLint("CutPasteId")
    public void total(MenuItem item) {
        Intent intent = new Intent(this, PopActivity.class);

        TextView edit = findViewById(R.id.tx);
        String message = edit.getText().toString();

        TextView edit1 = findViewById(R.id.tx1);
        String message1 = edit1.getText().toString();

        TextView edit2 = findViewById(R.id.tx2);
        String message2 = edit2.getText().toString();

        TextView edit3 = findViewById(R.id.tx3);
        String message3 = edit3.getText().toString();

        TextView edit4 = findViewById(R.id.tx4);
        String message4 = edit4.getText().toString();

        TextView edit5 = findViewById(R.id.tx5);
        String message5 = edit5.getText().toString();

        TextView edit6 = findViewById(R.id.tx6);
        String message6 = edit6.getText().toString();

        Chronometer edit7 = findViewById(R.id.mfocus);
        String message7 = edit7.getText().toString();


        intent.putExtra(EXTRA_MESSAGE, message);
        intent.putExtra(EXTRA_MESSAGE1, message1);
        intent.putExtra(EXTRA_MESSAGE2, message2);
        intent.putExtra(EXTRA_MESSAGE3, message3);
        intent.putExtra(EXTRA_MESSAGE4, message4);
        intent.putExtra(EXTRA_MESSAGE5, message5);
        intent.putExtra(EXTRA_MESSAGE6, message6);
        intent.putExtra(EXTRA_MESSAGE7, message7);



        int num1 = Integer.parseInt(tx.getText().toString());
        int num2 = Integer.parseInt(tx1.getText().toString());
        int num3 = Integer.parseInt(tx2.getText().toString());
        int num4 = Integer.parseInt(tx3.getText().toString());
        int num5 = Integer.parseInt(tx4.getText().toString());
        int num6 = Integer.parseInt(tx5.getText().toString());
        int num7 = Integer.parseInt(tx6.getText().toString());
        int sum = num1 + num2 + num3 + num4 + num5 + num6 + num7;







        intent.putExtra("key", sum);
        startActivity(intent);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu drawermenu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.drawermenu, drawermenu);
        return true;
    }
    @SuppressLint("SetTextI18n")
    public void rs(MenuItem item) {
        start.setEnabled(true);
        start.setText("START SESION");
        mCounter = 0;
        tampil(mCounter);
        Mcc = 0;
        tampil2(Mcc);
        Mcc2 = 0;
        tampil3(Mcc2);
        Mcc3 = 0;
        tampil4(Mcc3);
        Mcc4 = 0;
        tampil5(Mcc4);
        Mcc5 = 0;
        tampil6(Mcc5);
        Mcc6 = 0;
        tampil7(Mcc6);
        focuss = 0;
        tampil8(focuss);
        Context context = getApplicationContext();
        CharSequence text = "Reset !";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

    }
    public void quit(MenuItem item) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Yakin Ingin Keluar?");
        builder.setCancelable(true);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        builder.setNegativeButton("Batal", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}



