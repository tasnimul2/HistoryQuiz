package com.example.historyquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class IndiaActivity extends AppCompatActivity {

    private  MainActivity mainActivity = new MainActivity();
    private Button fifteenHundredGeneralBTN,fifteenHundredArtBTN,fifteenHundredReligionBTN,fifteenHundredSocioBTN;
    private Button addToTimelineBTN,skipToNextBTN,submitBTN;
    private ImageView topImageView;


    //*******************************************************************************************************//
    //                                      METHODS FOR VIEW VISIBILITY                                      //
    //******************************************************************************************************//

    public void page1visibility(boolean visible){
        if(visible){
            fifteenHundredGeneralBTN.setVisibility(View.VISIBLE);
            fifteenHundredArtBTN.setVisibility(View.VISIBLE);
            fifteenHundredReligionBTN.setVisibility(View.VISIBLE);
            fifteenHundredSocioBTN.setVisibility(View.VISIBLE);



            fifteenHundredGeneralBTN.setEnabled(true);
            fifteenHundredArtBTN.setEnabled(true);
            fifteenHundredReligionBTN.setEnabled(true);
            fifteenHundredSocioBTN.setEnabled(true);

            topImageView.setImageResource(R.drawable.selectyear);

            addToTimelineBTN.setEnabled(false);
            skipToNextBTN.setEnabled(false);
            submitBTN.setEnabled(false);


        }

        if(!visible){

            fifteenHundredGeneralBTN.setVisibility(View.INVISIBLE);
            fifteenHundredArtBTN.setVisibility(View.INVISIBLE);
            fifteenHundredReligionBTN.setVisibility(View.INVISIBLE);
            fifteenHundredSocioBTN.setVisibility(View.INVISIBLE);

            fifteenHundredGeneralBTN.setEnabled(false);
            fifteenHundredArtBTN.setEnabled(false);
            fifteenHundredReligionBTN.setEnabled(false);
            fifteenHundredSocioBTN.setEnabled(false);

        }
    }



    public void page2visibility(boolean visible){
        if(visible){

            topImageView.setImageResource(R.drawable.doesthisbelonginthetimeline);
            addToTimelineBTN.setAlpha(1);
            skipToNextBTN.setAlpha(1);
            submitBTN.setAlpha(1);

            addToTimelineBTN.setVisibility(View.VISIBLE);
            skipToNextBTN.setVisibility(View.VISIBLE);
            submitBTN.setVisibility(View.VISIBLE);

            addToTimelineBTN.setEnabled(true);
            skipToNextBTN.setEnabled(true);
            submitBTN.setEnabled(true);
            //startClock();



        }

        if(!visible){
            addToTimelineBTN.setVisibility(View.INVISIBLE);
            skipToNextBTN.setVisibility(View.INVISIBLE);
            submitBTN.setVisibility(View.INVISIBLE);

        }
    }



    //*******************************************************************************************************//
    //                METHODS FOR BUTTON ON-CLICKS   (Methods that make the app work)                      //
    //         The Methods written above are used to add functionality to the methods listed below          //
    //******************************************************************************************************//



    /*
     * Tag #s to Note:
     * Tag # 15001 (ie 1500-1) = 1500 BCE – 500 BCE (General)
     * Tag # 15002 (ie 1500-2) = 1500 BCE – 400 CE (Art and Culture)
     * Tag # 15003 (ie 1500-3) = 1500 BCE – 500 BCE (Religion)
     * Tag # 15004 (ie 1500-4) = 1500 BCE – 500 BCE (Socio-Political)
     *
     */


    /*
     * yearOnClick method is the onClick method for all the the year selection buttons
     *  It is responsible for keeping track of which year button on pressed
     */
    public void yearOnClick(View view){

        //sets the button that is currently being pressed into the variable "buttonPressed"
        Button buttonPressed = (Button) view;
        //saves the tag number of that specific button that is pressed into "buttonYear"
        int year = Integer.parseInt(buttonPressed.getTag().toString());
        mainActivity.setButtonYear(year);
        Toast.makeText(this,"Year# " + year, Toast.LENGTH_SHORT).show();
        page1visibility(false);
        page2visibility(true);
        //eventShowerTV.setText(ancientGreeceEvents.get(elementCounter));

    }

    public void submitOnClick(View view){

    }

    public void skipTonextOnClick(View view){

    }

    public void addToTimelineOnClick(View view){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_india);
        getSupportActionBar().hide();




        //Button initialization
        fifteenHundredGeneralBTN = findViewById(R.id.fifteenHundredGeneralBTN);
        fifteenHundredArtBTN = findViewById(R.id.fifteenHundredArtBTN);
        fifteenHundredReligionBTN = findViewById(R.id.fifteenHundredReligionBTN);
        fifteenHundredSocioBTN = findViewById(R.id.fifteenHundredSocioBTN);

        addToTimelineBTN = findViewById(R.id.addToTimelineBTN);
        skipToNextBTN = findViewById(R.id.skipToNextBTN);
        submitBTN = findViewById(R.id.submitBTN);

        //ImageView initialization
        topImageView = findViewById(R.id.topImageView);


        //Button alpha
        fifteenHundredGeneralBTN.setAlpha(1);
        fifteenHundredArtBTN.setAlpha(1);
        fifteenHundredReligionBTN.setAlpha(1);
        fifteenHundredSocioBTN.setAlpha(1);


    }
}
