package edu.gsu.httpcs.thakur2017summer.adapter;

import android.content.Context;
import android.graphics.Color;
import android.provider.CalendarContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

import edu.gsu.httpcs.thakur2017summer.R;

/**
 * Created by thaku on 6/8/2017.
 */

public class ListNormalAdapter extends BaseAdapter {
    private final Context context;
    private final LayoutInflater inflater;
    private final ArrayList<String> list;

    public ListNormalAdapter(Context context, ArrayList<String> list) {
        this.context=context;
        this.list=list;
        inflater=(LayoutInflater)context.getSystemService
                (context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView=inflater.inflate(R.layout.list_normal_item,parent,false);
        TextView tv=(TextView)convertView.findViewById(R.id.item_normal_tv);
        tv.setText(list.get(position));
        tv.setTextColor(Color.RED);
        return tv;
    }

}
