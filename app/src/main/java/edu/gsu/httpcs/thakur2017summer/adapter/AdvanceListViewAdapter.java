package edu.gsu.httpcs.thakur2017summer.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;

import java.util.ArrayList;

import edu.gsu.httpcs.thakur2017summer.R;

/**
 * Created by thaku on 6/15/2017.
 */

public class AdvanceListViewAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<String> list;
    private LayoutInflater inflater;

    public AdvanceListViewAdapter(Context context, ArrayList<String> list)
    {
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
        return list.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView= inflater.inflate(R.layout.activity_advance_list_item,parent,false);
        RelativeLayout rl_odd=(RelativeLayout)convertView.findViewById(R.id.odd);
        RelativeLayout rl_even=(RelativeLayout)convertView.findViewById(R.id.even);
        if(position%2==0)
        {
            rl_odd.setVisibility(View.INVISIBLE);
            rl_even.setVisibility(View.VISIBLE);
        }else {
            rl_odd.setVisibility(View.VISIBLE);
            rl_even.setVisibility(View.INVISIBLE);
        }
        return convertView;
    }
}
