package com.example.d_odo.jsonparser.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.d_odo.jsonparser.R;

/**
 * Created by d-odo on 02/03/2017.
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.list_user_btn).setOnClickListener(this);
        findViewById(R.id.sample_api_btn).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        int id = v.getId();
        if(id == R.id.sample_api_btn){
            startActivity(new Intent(this,SampleApiActivity.class));
        }
        if(id == R.id.list_user_btn){
            startActivity(new Intent(this,StudentsActivity.class));
        }
    }
}
