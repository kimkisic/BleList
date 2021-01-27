package com.choistec.blelist;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ConnectActivity extends AppCompatActivity {

    private TextView connectName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect);

        connectName = findViewById(R.id.connect_name);

        Intent intent = getIntent();

        connectName.setText(intent.getStringExtra("deviceName"));

    }
}