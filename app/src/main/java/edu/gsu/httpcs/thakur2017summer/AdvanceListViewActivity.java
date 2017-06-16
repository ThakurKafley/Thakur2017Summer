package edu.gsu.httpcs.thakur2017summer;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import edu.gsu.httpcs.thakur2017summer.adapter.AdvanceListViewAdapter;

public class AdvanceListViewActivity extends BaseActivity {
    @BindView(R.id.activity_advance_list_view) ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advance);
        ButterKnife.bind(this);
        ArrayList<String>list = new ArrayList<>();
        list.add("Hello");
        list.add("Hello how are you?");
        list.add("I am fine, thank you!");
        list.add("Hello");
        list.add("Hello");
        list.add("Hello");
        list.add("Hello");
        list.add("Hello");
        list.add("Hello");
        list.add("Hello");
        list.add("Hello");
        list.add("Hello");
        list.add("Hello");
        list.add("Hello");
        list.add("Hello");
        AdvanceListViewAdapter adapter=new AdvanceListViewAdapter(this,list);
        lv.setAdapter(adapter);
        TextView tv= new TextView(this);
        tv.setText("Header View");
        tv.setTextSize(30);
        tv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        lv.addHeaderView(tv);

        TextView tv1= new TextView(this);
        tv1.setText("Footer View");
        tv1.setTextSize(30);
        tv1.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        lv.addFooterView(tv1);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showTost(String.valueOf(position));
            }
        });
    }
}
