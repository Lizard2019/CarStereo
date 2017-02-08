package cs371.carstereo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
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
    ImageButton upButt;
    ImageButton downButt;
    boolean powerOn;
    boolean amButton;
    double FMval = 530.0;
    double AMval = 88.1;


    /*TextView  = "" + radioNum
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        upButt = (ImageButton) findViewById(R.id.upButton);
        downButt = (ImageButton) findViewById(R.id.downButton);
        power = (ToggleButton)findViewById(R.id.Power);
        amfm =  (ToggleButton)findViewById(R.id.AMFM);
        top = (LinearLayout)findViewById(R.id.AHH);
        bottom = (LinearLayout)findViewById(R.id.sonofagun);
        subuttom = (LinearLayout)findViewById(R.id.imsad);
        TextView radioText = (TextView)findViewById(R.id.Radio);

        amfm.setOnClickListener(new AmButtonListener());
        upButt.setOnClickListener(new upButtonListener());
        downButt.setOnClickListener(new downButtonListener());
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

    private class AmButtonListener implements View.OnClickListener {



        public void onClick(View v) {
            if (amButton == true) {

                TextView text = (TextView) findViewById(R.id.Radio);
                text.setText("" + AMval);
                //radioText.setText("Hello");

            } else {

                TextView text = (TextView) findViewById(R.id.Radio);
                text.setText("" + FMval);
                //radioText.setText("Salsa");

            }
            amButton = !amButton;

        }

    }

    public class upButtonListener implements View.OnClickListener{

        public void onClick(View v)
        {
            ImageButton upbutton = (ImageButton) findViewById(R.id.upButton);
            TextView radioText = (TextView) findViewById(R.id.Radio);

            // up button
            if (AMval == 1700){
                AMval = 530;
            }
            if (amButton == true) {
                // on am station
               AMval = AMval + 10;
               radioText.setText("" + AMval);

            }
            else if (FMval == 107.9){
                FMval = 88.1;
            }
            else {
                // on fm station
                FMval = FMval + .2;
                radioText.setText(""+ FMval);

            }




        }
    }

    public class downButtonListener implements View.OnClickListener{

        public void onClick(View v)
        {

            ImageButton downbutton = (ImageButton) findViewById(R.id.downButton);
            TextView radioText = (TextView) findViewById(R.id.Radio);



            // down button
            if (AMval == 530){
                AMval = 1700;
            }
            else if (amButton == true) {
            // on am station
            AMval = AMval - 10;
            radioText.setText("" + AMval);
            }
            else if (FMval == 88.1){
                FMval = 107.9;
            }
            else {
            // on fm station
            FMval = FMval - .2;
            radioText.setText(""+ FMval);

        }

        }
    }


}
