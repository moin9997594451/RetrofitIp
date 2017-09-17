package com.complexity.moinkhan.retrofitip;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.complexity.moinkhan.retrofitip.Model.Ip;
import com.complexity.moinkhan.retrofitip.Remote.IpService;

import dmax.dialog.SpotsDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    IpService mService;
    TextView txtIp;
    Button btnGetIp;
    android.app.AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mService = Common.getIpService();
        btnGetIp = (Button) findViewById(R.id.button);
        txtIp = (TextView) findViewById(R.id.editText);
        dialog = new SpotsDialog(MainActivity.this);

        btnGetIp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
                getIpAddress();
            }
        });


    }

    private void getIpAddress() {

        mService.getIp().enqueue(new Callback<Ip>() {
            @Override
            public void onResponse(Call<Ip> call, Response<Ip> response) {
                dialog.dismiss();
                txtIp.setText(response.body().getIp());
            }

            @Override
            public void onFailure(Call<Ip> call, Throwable t) {
                Log.e("ERROR",t.getMessage());
                dialog.dismiss();
            }
        });

    }
}
