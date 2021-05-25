package com.itso.grafx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class True_Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_true_main);
    }

    public void onClick(View view) {
        Intent i = new Intent();
        if(view.getId()==R.id.toRnd)
            i = new Intent(this, RandomTest.class);
        startActivity(i);
    }
}