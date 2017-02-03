package cs371.carstereo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;



public class MainActivity extends AppCompatActivity {
    int radioNum = 100;
    ToggleButton power;
    ToggleButton amfm;
    LinearLayout top;
    LinearLayout bottom;
    LinearLayout subuttom;
    TextView radioText;
    boolean powerOn;
    boolean amButton;

    /*TextView  = "" + radioNum
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        power = (ToggleButton)findViewById(R.id.Power);
        amfm =  (ToggleButton)findViewById(R.id.AMFM);
        top = (LinearLayout)findViewById(R.id.AHH);
        bottom = (LinearLayout)findViewById(R.id.sonofagun);
        subuttom = (LinearLayout)findViewById(R.id.imsad);
        TextView radioText = (TextView)findViewById(R.id.Radio);

        amfm.setOnClickListener(new AmButtonListener());
        powerOn = true;
        amButton = true;


    }

    public void powerButtonListener(View v){

        if(powerOn == true)
        {
            power.setBackgroundColor(Color.CYAN);
            bottom.setBackgroundColor(Color.GREEN);
            amfm.setBackgroundColor(Color.MAGENTA);
            subuttom.setBackgroundColor(Color.BLUE);
        }
        else
        {
            power.setBackgroundColor(Color.BLACK);
            bottom.setBackgroundColor(Color.DKGRAY);
            amfm.setBackgroundColor(Color.GRAY);
            subuttom.setBackgroundColor(Color.BLACK);
        }
        powerOn = !powerOn;

    }

    private class AmButtonListener implements View.OnClickListener{

int val = 10.3;


    public void onClick(View v){
        if (amButton == true){

            radioText.setText("%d", val);

        }
        else{

            radioText.setText("Salsa");

        }
        amButton = !amButton;
    }}



}
