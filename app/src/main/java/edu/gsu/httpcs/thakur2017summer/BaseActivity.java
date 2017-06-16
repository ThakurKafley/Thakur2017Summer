package edu.gsu.httpcs.thakur2017summer;

import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by thaku on 6/14/2017.
 */

public class BaseActivity extends AppCompatActivity {
    public void showTost(String s){
        Toast.makeText(this,s,Toast.LENGTH_SHORT).show();
    }
}
