package edu.gsu.httpcs.thakur2017summer;

import android.os.Bundle;
import android.widget.ListView;

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
    }
}
