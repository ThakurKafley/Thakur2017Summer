package edu.gsu.httpcs.thakur2017summer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityB extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        showTost("onCreate");
        setListener();
    }
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        showTost("onNewIntent");
    }
    public void setListener()
    {
        Button buttonA = (Button)findViewById(R.id.lunch_mode_single_top_a);
        Button buttonB = (Button)findViewById(R.id.lunch_mode_single_top_b);
        Button buttonC = (Button)findViewById(R.id.lunch_mode_single_top_c);
        Button buttonD = (Button)findViewById(R.id.lunch_mode_single_top_d);
        buttonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityB.this,ActivityA.class));
            }
        });
        buttonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityB.this,ActivityB.class));
            }
        });
        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityB.this,ActivityC.class));
            }
        });
        buttonD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityB.this,ActivityD.class));
            }
        });

    }
}
