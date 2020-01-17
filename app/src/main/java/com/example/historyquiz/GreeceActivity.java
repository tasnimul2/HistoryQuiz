package com.example.historyquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class GreeceActivity extends AppCompatActivity {


    private MainActivity mainActivity = new MainActivity();

    private Button eighthundredGeneralBTN,eighthundredCultureBTN,sevenhundredSocioBTN,sevenhundredMilitaryBTN;
    private Button addToTimelineBTN,skipToNextBTN , submitBTN;
    private ImageView topImageView;


    //*******************************************************************************************************//
    //                                      METHODS FOR VIEW VISIBILITY                                      //
    //******************************************************************************************************//


    public void page1visibility(boolean visible){
        if(visible){
            eighthundredGeneralBTN.setVisibility(View.VISIBLE);
            eighthundredCultureBTN.setVisibility(View.VISIBLE);
            sevenhundredSocioBTN.setVisibility(View.VISIBLE);
            sevenhundredMilitaryBTN.setVisibility(View.VISIBLE);

            topImageView.setImageResource(R.drawable.selectyear);

            eighthundredGeneralBTN.setEnabled(true);
            eighthundredCultureBTN.setEnabled(true);
            sevenhundredSocioBTN.setEnabled(true);
            sevenhundredMilitaryBTN.setEnabled(true);


            addToTimelineBTN.setEnabled(false);
            skipToNextBTN.setEnabled(false);
            submitBTN.setEnabled(false);


        }

        if(!visible){

            eighthundredGeneralBTN.setVisibility(View.INVISIBLE);
            eighthundredCultureBTN.setVisibility(View.INVISIBLE);
            sevenhundredSocioBTN.setVisibility(View.INVISIBLE);
            sevenhundredMilitaryBTN.setVisibility(View.INVISIBLE);

            eighthundredGeneralBTN.setEnabled(false);
            eighthundredCultureBTN.setEnabled(false);
            sevenhundredSocioBTN.setEnabled(false);
            sevenhundredMilitaryBTN.setEnabled(false);

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
    //                METHODS FOR BUTTON ON-CLICKS   (Methods that make the app work)                       //
    //         The Methods written above are used to add functionality to the methods listed below          //
    //******************************************************************************************************//



    /*
     * Tag #s to Note:
     * Tag # 8001 (ie 800-1) = 800 BCE-500 BCE (General)
     * Tag # 8002 (ie 800-2) = 800 BCE-500 BCE (Culture)
     * Tag # 7001 (ie 700-1) = 700 BCE – 479 BCE (Socio-political)
     * Tag # 7002 (ie 700-2) = 700 BCE -479 BCE (Military, Diplomacy)
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

        page1visibility(false);
        page2visibility(true);
        //eventShowerTV.setText(ancientEgyptEvents.get(elementCounter));

    }

    public void addToTimelineOnClick(View view){

    }

    public void skipTonextOnClick(View view){

    }

    public void submitOnClick(View view){

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greece);

        getSupportActionBar().hide();

        //button initialization
        eighthundredGeneralBTN = findViewById(R.id.eighthundredGeneralBTN);
        eighthundredCultureBTN = findViewById(R.id.eighthundredCultureBTN);
        sevenhundredSocioBTN = findViewById(R.id.sevenhundredSocioBTN);
        sevenhundredMilitaryBTN = findViewById(R.id.sevenhundredMilitaryBTN);
        addToTimelineBTN = findViewById(R.id.addToTimelineBTN);
        skipToNextBTN = findViewById(R.id.skipToNextBTN);
        submitBTN = findViewById(R.id.submitBTN);

        //ImageView initialization

        topImageView = findViewById(R.id.topImageView);



        //setAlplha

        eighthundredGeneralBTN.setAlpha(1);
        eighthundredCultureBTN.setAlpha(1);
        sevenhundredSocioBTN.setAlpha(1);
        sevenhundredMilitaryBTN.setAlpha(1);
    }
}
