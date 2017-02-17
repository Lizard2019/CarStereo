package cs371.carstereo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ToggleButton;



public class MainActivity extends AppCompatActivity
{
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
    //double FMval = 530.0;
    int FMvalMin = 881;
    int FMvalMax = 1079;
    int FMcur = 881;
    int AMvalMin = 530;
    int AMvalMax = 1700;
    int AMcur = 530;
    //int AMval = 881;
    SeekBar volume;

    /*TextView  = "" + radioNum
    */

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        upButt = (ImageButton) findViewById(R.id.upButton);
        downButt = (ImageButton) findViewById(R.id.downButton);
        power = (ToggleButton)findViewById(R.id.Power);
        amfm =  (ToggleButton)findViewById(R.id.AMFM);
        TextView radioText = (TextView) findViewById(R.id.Radio);
        top = (LinearLayout)findViewById(R.id.AHH);
        bottom = (LinearLayout)findViewById(R.id.sonofagun);
        subuttom = (LinearLayout)findViewById(R.id.imsad);
        volume = (SeekBar)findViewById(R.id.Volume);
//        int maxVal = volume.getMax();
//        int seekBarVal = volume.getProgress();

        amfm.setOnClickListener(new AmButtonListener());
        upButt.setOnClickListener(new upButtonListener());
        downButt.setOnClickListener(new downButtonListener());
        //powerOn = true;
        //amButton = true;

        power.setBackgroundColor(Color.BLACK);
        bottom.setBackgroundColor(Color.DKGRAY);
        amfm.setBackgroundColor(Color.GRAY);
        subuttom.setBackgroundColor(Color.BLACK);


    }

    public void powerButtonListener(View v)
    {

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

//    public void volumeBarListener(SeekBar volume)//View v)
//    public void volumeBar()
//    {
////        volume = (SeekBar)findViewById(R.id.Volume);
//
//        volume.setOnSeekBarChangeListener(
//                    int progressVal;
//                    new SeekBar.OnSeekBarChangeListener()
//                    {
//                        @Override
//                        public void onProgressChanged(SeekBar volume, int progress, boolean fromUser)
//                        {
//                            progressVal = progress;
//                        }
//
//                        @Override
//                        public void onStartTrackingTouch(SeekBar volume)
//                        {
//
//                        }
//
//                        @Override
//                        public void onStopTrackingTouch(SeekBar volume)
//                        {
//
//                        }
//                    }
//                )
        //^from https://www.youtube.com/watch?v=l5FrTkGoeX8
        //source code: http://www.codebind.com/android-tutorials-and-examples/android-studio-android-seekbar-example/
//        int maxVal = volume.getMax();
//        int seekBarVal = volume.getProgress();
//    }

//    public class volumeBarListener implements SeekBar.OnSeekBarChangeListener //onProgressChanged, onStartTrackingTouch, onStopTrackingTouch
//    {
//        public void onClick(View v)
//        {
//            int maxVal = volume.getMax();
//            int seekBarVal = volume.getProgress();
//            onProgressChanged(volume, progress, true);
//        }
//    }

    public class AmButtonListener implements View.OnClickListener
    {
        public void onClick(View v)
        {
            if (amButton == true)
            {
                radioText.setText("" + AMcur);

            }
            else
            {
                radioText.setText("" + FMcur);
                //radioText.setText("Salsa");
            }
            amButton = !amButton;
        }
    }

    public class upButtonListener implements View.OnClickListener
    {
        public void onClick(View v)
        {
            //ImageButton upbutton = (ImageButton) findViewById(R.id.upButton);

            int ten = 10;
            //int pointTwo = 2;
            FMcur = ((int)FMval)*10;

            // up button
            if (AMval >= 1700)
            {
                AMval = 530;
            }
            if(amButton == true) //on am station
            {

                AMval = AMval + ten;
                radioText.setText("" + AMval);

            }
            else if (FMval >= 107.9){
                FMval = 88.1;
            }
            else //on fm station
            {
                FMcur = FMcur + 2;
                FMval = ((double)FMcur/10);
                radioText.setText(""+ (double)FMval);
            }
        }
    }

    public class downButtonListener implements View.OnClickListener
    {
        public void onClick(View v)
        {
            //ImageButton downbutton = (ImageButton) findViewById(R.id.downButton);
            TextView radioText = (TextView) findViewById(R.id.Radio);
            //int ten = 10;
            //int pointTwo = 2;
            FMcur = ((int)FMval)*10;


            // down button
            if (AMval <= 530){
                AMval = 1700;
            }
            else if (amButton == true) //on am station
            {
                AMval = AMval - 10;
                radioText.setText("" + (double)AMval);
            }
            else if (FMval <= 88.1){
                FMval = 107.9;
            }
            else // on fm station
            {
                FMcur = FMcur - 2;
                FMval = ((double)FMcur/10);

            radioText.setText(""+ FMval);

            }

        }
    }
}
