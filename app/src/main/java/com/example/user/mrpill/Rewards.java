package com.example.user.mrpill;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Rewards extends AppCompatActivity implements View.OnClickListener{
    ImageView bean, pear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rewards);
        bean = (ImageView) findViewById(R.id.beanvoucher);
        pear = (ImageView) findViewById(R.id.pearvoucher);
        bean.setOnClickListener(this);
        pear.setOnClickListener(this);


    }
    public void onClick(View v) {


        switch (v.getId()) {
            case R.id.beanvoucher:
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Rewards.this);
                alertDialogBuilder
                        .setMessage("Congratulations! You have successfully claimed the eBean vouchers!")
                        .setCancelable(false)
                        .setPositiveButton("Exit", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startActivity(new Intent(getApplicationContext(), Rewards.class));
                            }
                        });
                alertDialogBuilder.show();
                bean.setVisibility(View.GONE);
                bean.setEnabled(false);

            case R.id.pearvoucher:
                alertDialogBuilder = new AlertDialog.Builder(Rewards.this);
                alertDialogBuilder
                        .setMessage("Congratulations! You have successfully claimed the Jollipear vouchers!")
                        .setCancelable(false)
                        .setPositiveButton("Exit", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startActivity(new Intent(getApplicationContext(), Rewards.class));
                            }
                        });
                alertDialogBuilder.show();
                pear.setVisibility(View.GONE);
                pear.setEnabled(false);

        }
    }
}
