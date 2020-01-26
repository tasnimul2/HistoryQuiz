package com.example.historyquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class WarsOfReligionActivity extends AppCompatActivity {

    private  MainActivity mainActivity = new MainActivity();
    private Button fifteenSeventyBTN,fifteenSixtyBTN,fifteenFiftySixBTN,fifteenFiftyThreeBTN;
    private Button addToTimelineBTN,skipToNextBTN,submitBTN;
    private ImageView topImageView;
    private TextView eventShowerTV, timeTV;
    private ArrayList<String> warsOfReligionEvents = new ArrayList<>();
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
        WarsOfReligion game = new WarsOfReligion();
        for (int i = 0; i < 4; i++) {
            warsOfReligionEvents.add(game.date1(i));
            warsOfReligionEvents.add(game.date2(i));
            warsOfReligionEvents.add(game.date3(i));
            warsOfReligionEvents.add(game.date4(i));
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
     * Tag # 1570 = 1570-1700 (Environmental , Economic)
     * Tag # 1560 = 1560-1598 (French Wars of Religion)
     * Tag # 1556 = 1556-1648 (Spain and Netherlands)
     * Tag # 1553 = 1553-1648 (England, Thirty Years War)
     *
     */

    protected ArrayList answerKeywarsOfReligion(int year) {
        ArrayList<String> tempList = new ArrayList<>();
        WarsOfReligion game = new WarsOfReligion();

        switch (year) {
            case 1570:
                for (int i = 0; i < 4; i++) {
                    tempList.add(game.date1(i));
                }
                break;
            case 1560:
                for (int i = 0; i < 4; i++) {
                    tempList.add(game.date2(i));
                }
                break;

            case 1556:
                for (int i = 0; i < 4; i++) {
                    tempList.add(game.date3(i));
                }
                break;

            case 1553:
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


            fifteenSeventyBTN.setVisibility(View.VISIBLE);
            fifteenSixtyBTN.setVisibility(View.VISIBLE);
            fifteenFiftySixBTN.setVisibility(View.VISIBLE);
            fifteenFiftyThreeBTN.setVisibility(View.VISIBLE);


            fifteenSeventyBTN.setEnabled(true);
            fifteenSixtyBTN.setEnabled(true);
            fifteenFiftySixBTN.setEnabled(true);
            fifteenFiftyThreeBTN.setEnabled(true);



            topImageView.setImageResource(R.drawable.selectyear);

            addToTimelineBTN.setEnabled(false);
            skipToNextBTN.setEnabled(false);
            submitBTN.setEnabled(false);




        }

        if(!visible){

            fifteenSeventyBTN.setVisibility(View.INVISIBLE);
            fifteenSixtyBTN.setVisibility(View.INVISIBLE);
            fifteenFiftySixBTN.setVisibility(View.INVISIBLE);
            fifteenFiftyThreeBTN.setVisibility(View.INVISIBLE);

            fifteenSeventyBTN.setEnabled(false);
            fifteenSixtyBTN.setEnabled(false);
            fifteenFiftySixBTN.setEnabled(false);
            fifteenFiftyThreeBTN.setEnabled(false);

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
     * Tag # 1570 = 1570-1700 (Environmental , Economic)
     * Tag # 1560 = 1560-1598 (French Wars of Religion)
     * Tag # 1556 = 1556-1648 (Spain and Netherlands)
     * Tag # 1553 = 1553-1648 (England, Thirty Years War)
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
        eventShowerTV.setText(warsOfReligionEvents.get(elementCounter));
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
            loadNextEvent(elementCounter,warsOfReligionEvents);
        }

    }

    public void addToTimelineOnClick(View view){

        if(!gameOver) {
            mainActivity.setSelectedEvents(warsOfReligionEvents.get(elementCounter));
            ++elementCounter;
            loadNextEvent(elementCounter, warsOfReligionEvents);
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wars_of_religion);
        getSupportActionBar().hide();
        addAllEvents();


        //Button initialization
        fifteenSeventyBTN = findViewById(R.id.fifteenSeventyBTN);
        fifteenSixtyBTN = findViewById(R.id.fifteenSixtyBTN);
        fifteenFiftySixBTN = findViewById(R.id.fifteenFiftySixBTN);
        fifteenFiftyThreeBTN = findViewById(R.id.fifteenFiftyThreeBTN);


        addToTimelineBTN = findViewById(R.id.addToTimelineBTN);
        skipToNextBTN = findViewById(R.id.skipToNextBTN);
        submitBTN = findViewById(R.id.submitBTN);

        //ImageView initialization
        topImageView = findViewById(R.id.topImageView);

        //TextView initialization
        eventShowerTV = findViewById(R.id.eventShowerTV);
        timeTV = findViewById(R.id.timeTV);


        //button alpha
        fifteenSeventyBTN.setAlpha(1);
        fifteenSixtyBTN.setAlpha(1);
        fifteenFiftySixBTN.setAlpha(1);
        fifteenFiftyThreeBTN.setAlpha(1);

        page1visibility(true);
        runRunnable();
    }
}
