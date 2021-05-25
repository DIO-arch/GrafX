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

public class MainActivity extends AppCompatActivity {
    public LinkedList<String> stringList;
    ListView lv;
    Intent i = getIntent();
    int _id = i.getExtras().getInt("pos_or_id");
    double start, end,step, ymax, ymin;
    private static MainActivity instance;
    GraphView gv;

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
        BarGraphSeries<DataPoint> series = new BarGraphSeries<>(new DataPoint[] {
                new DataPoint(0, -1),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
                new DataPoint(3, 2),
                new DataPoint(4, 6)
        });
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
}
