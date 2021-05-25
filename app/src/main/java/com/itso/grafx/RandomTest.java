package com.itso.grafx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class RandomTest extends AppCompatActivity {
    TextView title;
    Button rnd;
    Dal db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_test);

        title = findViewById(R.id.Title);
        rnd = findViewById(R.id.RND);
        db = new Dal(this);

        rnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rND;
                rND = title.getText().toString();
                if(rND.equals("")){
                    Toast.makeText(RandomTest.this, "Title is BLANK",Toast.LENGTH_LONG);
                } else { //Authenticaion
                    Boolean rndUp = random(rND);
                    if(rndUp == true) {
                        Toast.makeText(RandomTest.this, "Successful Random", Toast.LENGTH_LONG).show();
                    } else Toast.makeText(RandomTest.this, "Failed to Random", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    public Boolean random(String name)
    {
        int i;
        int range1 = new Random().nextInt(19) + 1;
        Random r = new Random();
        int range2;
        String s = "[";
        for (i = 0; i < range1; i++) {
            range2 = r.nextInt(256);
            if(i < range1 - 1)
                s = s + range2 + ",";
            else
                s = s + range2;
        }
        s = s + "]";
        db.insertData(name, s);
        Boolean checkUp = db.checkUps(name, s);
        if(i == range1)
            if (checkUp) //putting && didn't work and asked me to put ; at the end of the statement
                return true; //p.s removed the " == true" from last version
        return false;
    }
    public void onClick(View view) {
        Intent i = new Intent();
        if(view.getId()==R.id.ToMain1) i = new Intent(this, MainActivity.class);
        else if(view.getId()==R.id.ToDisplay) i = new Intent(this, Display_EXP.class);
        //else if(view.getId()==R.id.ToBT1)
        //i = new Intent(this, Bluetooth_Connecter.class);
        startActivity(i);
    }
}