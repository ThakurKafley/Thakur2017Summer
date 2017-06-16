package edu.gsu.httpcs.thakur2017summer.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import edu.gsu.httpcs.thakur2017summer.ActivityA;
import edu.gsu.httpcs.thakur2017summer.AdvanceListViewActivity;
import edu.gsu.httpcs.thakur2017summer.NotificationActivity;
import edu.gsu.httpcs.thakur2017summer.R;
import edu.gsu.httpcs.thakur2017summer.ScaleTypeActivity;
import edu.gsu.httpcs.thakur2017summer.ViewPagerActivity;
import edu.gsu.httpcs.thakur2017summer.adapter.ListNormalAdapter;

public class DemoFragment extends Fragment {

    private final ArrayList<String> contentList;
    private final Context context;
    private ListView listView;


    public DemoFragment() {
        context=getContext();
        contentList=new ArrayList<String>();
        contentList.add("ViewPager");
        contentList.add("ImageScaleType");
        contentList.add("9patch");
        contentList.add("NotificationActivity");
        contentList.add("AdvanceListView");
        contentList.add("C");
        contentList.add("LaunchMode");
        contentList.add("E");
        contentList.add("F");
        contentList.add("G");
        contentList.add("H");
        contentList.add("I");
        contentList.add("J");
        contentList.add("K");
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_demo, container, false);
        listView = (ListView) view.findViewById(R.id.fragment_demo_lv);
        ListNormalAdapter adapter = new ListNormalAdapter(this.getContext(),contentList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0:
                        Intent intent = new Intent(getActivity(),ViewPagerActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Intent intent1 = new Intent(getActivity(), ScaleTypeActivity.class);
                        startActivity(intent1);
                        break;
                    case 3:
                        Intent intent3 = new Intent(getActivity(), NotificationActivity.class);
                        startActivity(intent3);
                        break;
                    case 4:
                        Intent intent4 = new Intent(getActivity(), AdvanceListViewActivity.class);
                        startActivity(intent4);
                        break;

                    case 6:
                        Intent intent6 = new Intent(getActivity(),ActivityA.class);
                        startActivity(intent6);
                        break;
                    default:


                }
            }
        });
        // Inflate the layout for this fragment
        return view;
    }

}
