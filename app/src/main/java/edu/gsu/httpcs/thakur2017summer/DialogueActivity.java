package edu.gsu.httpcs.thakur2017summer;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.IdRes;
import android.support.v7.app.AlertDialog;
import android.widget.EditText;
import android.widget.RadioGroup;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.gsu.httpcs.thakur2017summer.dialog.CostumnDialogue;

public class DialogueActivity extends BaseActivity {
    private final int DIALOG=12345;
    Handler mHandler=new Handler(){
        /**
         * Subclasses must implement this to receive messages.
         *
         * @param msg
         */
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case DIALOG:
                    Bundle bundle=msg.getData();
                    String s=bundle.getString("msg");
                    showTost("Dialog Message "+s);
                    break;
                default:

            }
            super.handleMessage(msg);
        }
    };

    private int checkedID;
    @BindView(R.id.activity_dialogue_group)
    RadioGroup radioGroup;
    @OnClick(R.id.activity_dialogue_group_submit)
    public void ok()
    {
        switch (checkedID)
        {
            case R.id.activity_dialogue_radio1:
                normalDialog();
                break;
            case R.id.activity_dialogue_radio2:
                listDialog();
                break;
            case R.id.activity_dialogue_radio3:
                singleChoiceDialog();
                break;
            case R.id.activity_dialogue_radio4:
                multiChoiceDialog();
                break;
            case R.id.activity_dialogue_radio5:
                waitingDialog();
                break;
            case R.id.activity_dialogue_radio6:
                progressingDialog();
                break;
            case R.id.activity_dialogue_radio7:
                inputDialog();
                break;
            case R.id.activity_dialogue_radio8:
                CostumnDialogue costumnDialogue=new CostumnDialogue(this, new CostumnDialogue.ICustomDialogListener() {
                    @Override
                    public void onOKClicked(String msg) {
                        showTost(msg);
                    }
                });
                costumnDialogue.setCanceledOnTouchOutside(false);
                costumnDialogue.show();
                break;
            default:

        }
        showTost(""+ checkedID);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogue);
        ButterKnife.bind(this);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                checkedID=checkedId;
                //showTost(checkedId+"");
            }
        });
    }
    public void normalDialog()
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle("Normal Dialog");
        builder.setMessage("This is the normal builder message");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                showTost("you Clicked yes");
            }
        });
        builder.setNeutralButton("NeutralBtn", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                showTost("you Clicked neutral");
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                showTost("you Clicked cancel");
            }
        });
        builder.show();
    }

    public void listDialog()
    {
        final String[] items= new String[]{"Item1","Item2","Item4","Item5","Item6","Item7"};
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle("List Builder");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                showTost("you clicked "+ items[which]);
            }
        });
        builder.show();
    }
    ProgressDialog waitingDialog;
    public void waitingDialog()
    {
        waitingDialog=new ProgressDialog(this);
        waitingDialog.setTitle("Downloading");
        waitingDialog.setMessage("Waiting");
        waitingDialog.setCancelable(true);
        waitingDialog.show();
        waitingDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                showTost("Dialog is cancelled");

            }
        });
    }
    ArrayList <Integer> choice = new ArrayList<>();
    public void multiChoiceDialog()
    {
        final String[] items={"Item1", "Item2","Item3","Item4","Item5","Item6"};
        final boolean initChoiceSets[]={false,false,false,false,false,false};
        choice.clear();
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setTitle("Multi Choice Builder");
       // builder.setIcon(R.mipmap.ic_launcher);
        builder.setMultiChoiceItems(items, initChoiceSets, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if(isChecked)
                {choice.add(which);
                    showTost(which+"");
                }
                else
                    {
                        showTost(which+"");
                        choice.remove(which);
                    }
            }
        });

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                int size=choice.size();
                String str = " ";
                for(int i=0;i<size;i++)
                {
                    str+= choice.get(i)+" ";
                }
                showTost("You choose "+str);
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                showTost("Cancel was Clicked");
            }
        });
        builder.show();
    }
    ProgressDialog progress;
    public void progressingDialog() {
        final int MAX_PROGRESS = 100;
        progress = new ProgressDialog(this);
        progress.setTitle("Downloading");
        progress.setMessage("Waiting");
        progress.setProgressStyle(progress.STYLE_HORIZONTAL);
        // progress.setCancelable(true);
        progress.setMax(MAX_PROGRESS);
        progress.show();

        new Thread(new Runnable() {
            @Override
            public void run() {
                int progresVal = 0;
                while (progresVal < MAX_PROGRESS) {
                    try {
                        Thread.sleep(100);
                        progresVal++;
                        progress.setProgress(progresVal);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if(progresVal==100)
                {
                   progress.cancel();
                }
            }
        }).start();
    }
    int choose=2;
    public void singleChoiceDialog()
    {
        final String[] items= new String[]{"item1","item2","item3","item4","item5"};
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle("Single Choice dialog");
        builder.setSingleChoiceItems(items, choose, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                choose=which;
            }
        });
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                showTost("You clicked "+ choose);
            }
        });
        builder.show();
    }
    public void inputDialog()
    {
        final EditText editText=new EditText(this);
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle("Input Builder").setView(editText);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                showTost(editText.getText().toString());
            }
        });
        builder.setNegativeButton("Cancel", null).show();
        //builder.show();
    }
}