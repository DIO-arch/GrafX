package com.itso.grafx;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class EXP_Adapter extends ArrayAdapter<EXP> {
    private Context ctx;
    private ArrayList<EXP> ary;
    private int resourceId;

    public EXP_Adapter(Context context, int resource, ArrayList<EXP> objects){
        super(context, resource, objects);

        this.ctx = context;
        this.resourceId = resource;
        this.ary = objects;
    }
    public int getCount(){
        return this.ary.size();
    }

    public View getView(int position, View convertView, ViewGroup parent){

        LayoutInflater li = (LayoutInflater) this.ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View v = li.inflate(this.resourceId, null);
        EXP exp = this.ary.get(position);

        TextView tvTitle = v.findViewById(R.id.textViewTitle);

        tvTitle.setText(exp.getName());
        return v;
    }
}
