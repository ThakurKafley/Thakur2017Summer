package edu.gsu.httpcs.thakur2017summer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ActivityA extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        Toast.makeText(this,"onCreate",Toast.LENGTH_SHORT).show();
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
        Button buttonA = (Button)findViewById(R.id.lunch_mode_standard_a);
        Button buttonB = (Button)findViewById(R.id.lunch_mode_standard_b);
        Button buttonC = (Button)findViewById(R.id.lunch_mode_standard_c);
        Button buttonD = (Button)findViewById(R.id.lunch_mode_standard_d);
        buttonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityA.this,ActivityA.class));
            }
        });
        buttonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityA.this,ActivityB.class));
            }
        });
        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityA.this,ActivityC.class));
            }
        });
        buttonD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityA.this,ActivityD.class));
            }
        });

    }

}
