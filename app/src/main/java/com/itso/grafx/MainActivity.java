package com.itso.grafx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ListView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.ValueDependentColor;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;

import java.util.LinkedList;
import java.util.Random;


public class MainActivity extends AppCompatActivity {
    public LinkedList<String> stringList;
    ListView lv;
    //Intent i = getIntent();
    //int _id = i.getExtras().getInt("pos_or_id");
    double start, end,step, ymax, ymin;
    private static MainActivity instance;
    GraphView gv;
    //Dal dal = new Dal(MainActivity.this);
    //int[] n = dal.valueToInt(dal.getValue(_id));
    int i = 0;
    int range1 = new Random().nextInt(19) + 1;
    int[] n = new int[range1];
    n = RandomTesting(int range1);

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instance = this;
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        start= -10;//default settings
        end= 10;
        ymin=-10;
        ymax=10;
        step=0.1;

        gv = findViewById(R.id.gv_graph);
        gv.getViewport().setYAxisBoundsManual(true);
        gv.getViewport().setXAxisBoundsManual(true);
        gv.getViewport().setMaxX(end);
        gv.getViewport().setMinX(start);
        gv.getViewport().setMinY(ymin);
        gv.getViewport().setMaxY(ymax);
//----------------
        DataPoint[] dp = new DataPoint[n.length];
        int s;
        for (s = 0; s < dp.length; s++){
            dp[s]= new DataPoint(s + 1, n[s]);
        }
        BarGraphSeries<DataPoint> series = new BarGraphSeries<>(dp);
        gv.addSeries(series);
// styling
        series.setValueDependentColor(new ValueDependentColor<DataPoint>() {
            @Override
            public int get(DataPoint data) {
                return Color.rgb((int) data.getX()*255/4, (int) Math.abs(data.getY()*255/6), 100);
            }
        });
        series.setSpacing(50);
// draw values on top
        series.setDrawValuesOnTop(true);
        series.setValuesOnTopColor(Color.RED);
//series.setValuesOnTopSize(50);
    }
    public int[] IntToInt(int[] n){
        int[] temp = new int[n.length];
        int s;
        for(s=0; s < n.length; s++){
            temp[s] = n[s];
        }
        return temp;
    }
    public int[] RandomTesting(int range1){
        Random r = new Random();
        int range2;
        int[] n = new int[range1];
        for (i = 0; i < range1; i++) {
            range2 = r.nextInt(256);
            n[i] = range2;
        }
        return n;
    }
}
