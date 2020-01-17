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

public class EgyptActivity extends AppCompatActivity {

    private MainActivity mainActivity = new MainActivity();
    private Button sixteenFortyBTN,fifteenSeventyMilitaryBTN,fifteenSeventyPoliticalBTN,twelveEightyfiveBTN;
    private Button addToTimelineBTN,skipToNextBTN,submitBTN;
    private ImageView topImageView;
    private ArrayList<String> ancientEgyptEvents = new ArrayList<>();
    private int elementCounter = 0;
    private TextView eventShowerTV, timeTV;
    private boolean gameOver = false; // this is not set to static because once we leave this activity, garbage collection will set this back to false.
                                      //this will allow us to not have to manually set game over to false from the timeline activate
    private static int minute = 0, second = 0;
    private Handler handler = new Handler();
    private Runnable run;




    //******************************************************************************************************//
    //                                           GETTERS / SETTERS                                          //
    //******************************************************************************************************//





    //******************************************************************************************************//
    //                        METHODS FOR COMPUTATIONS/ OTHER TASKS (Helper Methods )                       //
    //******************************************************************************************************//

    /*
     * the addAllEvents method loads up all the possible events for Ancient Egypt in to the arrayList ancientEgyptEvents
     */
    public void addAllEvents(){
        AncientEgypt game = new AncientEgypt();
        for(int i = 0; i< 4; i++){
            ancientEgyptEvents.add(game.date1(i));
            ancientEgyptEvents.add(game.date2(i));
            ancientEgyptEvents.add(game.date3(i));
            ancientEgyptEvents.add(game.date4(i));
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

    /* the answerKeyEgypt function creates an arrayList that holds the answer key for
     *  the specific time period selected
     */

    /*
     * Tag #s to Notes:
     * Tag # 1640              = 1640 BCE-1570 BCE
     * Tag # 15701 (ie 1570-1) = 1570 BCE – 1075 BCE (Military)
     * Tag # 15702 (ie 1570-2) = 1570 BCE – 1075 BCE (Political)
     * Tag # 1285              = 1285 BCE (Military, Art, Literature)
     *
     */

    protected ArrayList answerKeyEgypt(int year) {
        ArrayList<String> tempList = new ArrayList<>();
        AncientEgypt game = new AncientEgypt();

        switch (year) {
            case 1640:
                for (int i = 0; i < 4; i++) {
                    tempList.add(game.date1(i));
                }
                break;
            case 15701:
                for (int i = 0; i < 4; i++) {
                    tempList.add(game.date2(i));
                }
                break;

            case 15702:
                for (int i = 0; i < 4; i++) {
                    tempList.add(game.date3(i));
                }
                break;

            case 1285:
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
            sixteenFortyBTN.setVisibility(View.VISIBLE);
            fifteenSeventyMilitaryBTN.setVisibility(View.VISIBLE);
            fifteenSeventyPoliticalBTN.setVisibility(View.VISIBLE);
            twelveEightyfiveBTN.setVisibility(View.VISIBLE);
            topImageView.setImageResource(R.drawable.selectyear);

            sixteenFortyBTN.setEnabled(true);
            fifteenSeventyMilitaryBTN.setEnabled(true);
            fifteenSeventyPoliticalBTN.setEnabled(true);
            twelveEightyfiveBTN.setEnabled(true);

            addToTimelineBTN.setEnabled(false);
            skipToNextBTN.setEnabled(false);
            submitBTN.setEnabled(false);
        }

        if(!visible){
            sixteenFortyBTN.setVisibility(View.INVISIBLE);
            fifteenSeventyMilitaryBTN.setVisibility(View.INVISIBLE);
            fifteenSeventyPoliticalBTN.setVisibility(View.INVISIBLE);
            twelveEightyfiveBTN.setVisibility(View.INVISIBLE);


            sixteenFortyBTN.setEnabled(false);
            fifteenSeventyMilitaryBTN.setEnabled(false);
            fifteenSeventyPoliticalBTN.setEnabled(false);
            twelveEightyfiveBTN.setEnabled(false);
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
    //                METHODS FOR BUTTON ON-CLICKS   (Methods that make the app work)                       //
    //         The Methods written above are used to add functionality to the methods listed below          //
    //******************************************************************************************************//



    /*
     * Tag #s to Notes:
     * Tag # 1640              = 1640 BCE-1570 BCE
     * Tag # 15701 (ie 1570-1) = 1570 BCE – 1075 BCE (Military)
     * Tag # 15702 (ie 1570-2) = 1570 BCE – 1075 BCE (Political)
     * Tag # 1285              = 1285 BCE (Military, Art, Literature)
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
        eventShowerTV.setText(ancientEgyptEvents.get(elementCounter));
    }

    public void addToTimelineOnClick(View view){
        if(!gameOver) {
            mainActivity.setSelectedEvents(ancientEgyptEvents.get(elementCounter));
            ++elementCounter;
            loadNextEvent(elementCounter, ancientEgyptEvents);
        }

    }

    public void skipTonextOnClick(View view){
        if(!gameOver){
            ++elementCounter;
            loadNextEvent(elementCounter,ancientEgyptEvents);
        }

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




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_egypt);
        getSupportActionBar().hide();
        addAllEvents();


        //Button initialization
        sixteenFortyBTN = findViewById(R.id.sixteenFortyBTN);
        fifteenSeventyMilitaryBTN = findViewById(R.id.fifteenSeventyMilitaryBTN);
        fifteenSeventyPoliticalBTN = findViewById(R.id.fifteenSeventyPoliticalBTN);
        twelveEightyfiveBTN = findViewById(R.id.twelveEightyfiveBTN);
        addToTimelineBTN = findViewById(R.id.addToTimelineBTN);
        skipToNextBTN = findViewById(R.id.skipToNextBTN);
        submitBTN = findViewById(R.id.submitBTN);


        //ImageView Initialization
        topImageView = findViewById(R.id.topImageView);

        //TextView Initialization
        eventShowerTV = findViewById(R.id.eventShowerTV);
        timeTV = findViewById(R.id.timeTV);


        //setting alpha
        sixteenFortyBTN.setAlpha(1);
        fifteenSeventyMilitaryBTN.setAlpha(1);
        fifteenSeventyPoliticalBTN.setAlpha(1);
        twelveEightyfiveBTN.setAlpha(1);
        page1visibility(true);


        runRunnable();
    }
}
