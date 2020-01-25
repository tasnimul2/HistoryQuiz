package com.example.historyquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class IndiaActivity extends AppCompatActivity {

    private  MainActivity mainActivity = new MainActivity();
    private Button fifteenHundredGeneralBTN,fifteenHundredArtBTN,fifteenHundredReligionBTN,fifteenHundredSocioBTN;
    private Button addToTimelineBTN,skipToNextBTN,submitBTN;
    private ImageView topImageView;
    private TextView eventShowerTV, timeTV;
    private ArrayList <String> ancientIndiaEvents = new ArrayList<>();
    private int elementCounter = 0;
    private boolean gameOver = false;
    private static int minute = 0, second = 0;
    private Handler handler = new Handler();
    private Runnable run;


    //******************************************************************************************************//
    //                        METHODS FOR COMPUTATIONS/ OTHER TASKS (Helper Methods )                       //
    //******************************************************************************************************//

    /*
     * the addAllEvents method loads up all the possible events for game 2 in to the arrayList game2Events
     */
    public void addAllEvents() {
        AncientIndia game = new AncientIndia();
        for (int i = 0; i < 4; i++) {
            ancientIndiaEvents.add(game.date1(i));
            ancientIndiaEvents.add(game.date2(i));
            ancientIndiaEvents.add(game.date3(i));
            ancientIndiaEvents.add(game.date4(i));
        }

    }


    public void loadNextEvent(int elementCounter, ArrayList eventsArray){
        if (elementCounter == eventsArray.size()) {
            eventShowerTV.setText("All Events Shown");
            gameOver = true;
        } else {
            eventShowerTV.setText(""+eventsArray.get(elementCounter));
        }
    }


    /*
     * Tag #s to Note:
     * Tag # 15001 (ie 1500-1) = 1500 BCE – 500 BCE (General)
     * Tag # 15002 (ie 1500-2) = 1500 BCE – 400 CE (Art and Culture)
     * Tag # 15003 (ie 1500-3) = 1500 BCE – 500 BCE (Religion)
     * Tag # 15004 (ie 1500-4) = 1500 BCE – 500 BCE (Socio-Political)
     *
     */

    protected ArrayList answerKeyIndia(int year) {
        ArrayList<String> tempList = new ArrayList<>();
        AncientIndia game = new AncientIndia();

        switch (year) {
            case 15001:
                for (int i = 0; i < 4; i++) {
                    tempList.add(game.date1(i));
                }
                break;
            case 15002:
                for (int i = 0; i < 4; i++) {
                    tempList.add(game.date2(i));
                }
                break;

            case 15003:
                for (int i = 0; i < 4; i++) {
                    tempList.add(game.date3(i));
                }
                break;

            case 15004:
                for (int i = 0; i < 4; i++) {
                    tempList.add(game.date4(i));
                }
                break;

            default:
                Toast.makeText(this, "Error has Occurred", Toast.LENGTH_SHORT).show();

        }
        return tempList;
    }

    /* the startClock method uses the handler to run the runnable by scheduling messages from the runnable.
     *   the .post() method causes the Runnable run to be added to the message queue. */
    public void startClock(){
        handler.post(run);
    }

    /* runRunnable method initializes the Runnable to update the minute and seconds variables */
    public void runRunnable(){
        run = new Runnable() {
            @Override
            public void run() {
                ++second;
                if(second == 60){
                    second = 0;
                    ++minute;
                }
                if(second < 10 && minute < 10){
                    timeTV.setText("0"+ minute + " : 0"+ second);
                }else if(second < 10 && minute >= 10){
                    timeTV.setText(""+ minute + " : 0"+ second);
                }else if(second > 10 && minute < 10){
                    timeTV.setText("0"+ minute + " : "+ second);
                }else{
                    timeTV.setText(""+ minute + " : "+ second);
                }


                handler.postDelayed(this,1000);
            }
        };
    }




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
            startClock();



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
        page1visibility(false);
        page2visibility(true);
        eventShowerTV.setText(ancientIndiaEvents.get(elementCounter));


    }

    public void submitOnClick(View view){
        Intent intent = new Intent(this,Timeline.class);
        startActivity(intent);
        handler.removeCallbacks(run); //uses the handler to tell runnable called "run" to stop running.
        mainActivity.setSecond(second);
        mainActivity.setMinute(minute);
        second = 0;
        minute = 0;
    }

    public void skipTonextOnClick(View view){
        if(!gameOver){
            ++elementCounter;
            loadNextEvent(elementCounter,ancientIndiaEvents);
        }
    }

    public void addToTimelineOnClick(View view){
        if(!gameOver) {
            mainActivity.setSelectedEvents(ancientIndiaEvents.get(elementCounter));
            ++elementCounter;
            loadNextEvent(elementCounter, ancientIndiaEvents);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_india);
        getSupportActionBar().hide();
        addAllEvents();




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

        //TextView initialization
        eventShowerTV = findViewById(R.id.eventShowerTV);
        timeTV = findViewById(R.id.timeTV);


        //Button alpha
        fifteenHundredGeneralBTN.setAlpha(1);
        fifteenHundredArtBTN.setAlpha(1);
        fifteenHundredReligionBTN.setAlpha(1);
        fifteenHundredSocioBTN.setAlpha(1);

        page1visibility(true);
        runRunnable();


    }
}
