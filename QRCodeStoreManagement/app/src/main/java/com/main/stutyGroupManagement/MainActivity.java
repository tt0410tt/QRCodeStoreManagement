package com.main.stutyGroupManagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView main_Create_Manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        main_Create_Manager = (TextView) findViewById(R.id.main_Create_Manager);
        main_Create_Manager.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.main_Create_Manager:
                intent=new Intent(this, activity_Main.class);
                startActivity(intent);
        }
    }
}
