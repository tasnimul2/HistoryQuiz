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

public class MongolActivity extends AppCompatActivity {

    private  MainActivity mainActivity = new MainActivity();
    private Button twelveSixBTN,twelveThirtyFiveBTN,twelveFiftyOneMiddleEastBTN,twelveFiftyOneAsiaBTN;
    private Button addToTimelineBTN,skipToNextBTN,submitBTN;
    private ImageView topImageView;
    private TextView eventShowerTV, timeTV;
    private ArrayList<String> MongolKhanatesEvents = new ArrayList<>();
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
        MongolKhanates game = new MongolKhanates();
        for (int i = 0; i < 4; i++) {
            MongolKhanatesEvents.add(game.date1(i));
            MongolKhanatesEvents.add(game.date2(i));
            MongolKhanatesEvents.add(game.date3(i));
            MongolKhanatesEvents.add(game.date4(i));
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
     * Tag # 1206               = 1206-1220 (Mongol Unification, Conquest)
     * Tag # 1235               = 1235-1241 (Mongol Invasion of Europe)
     * Tag # 12511 (ie. 1251-1) = 1251-1260 (Mongol Invasion of the Middle East)
     * Tag # 12512 (ie. 1251-2)=  1251-1292 (Mongol Invasion of East and Southeast Asia)
     *
     */

    protected ArrayList answerKeyMongolKhanates(int year) {
        ArrayList<String> tempList = new ArrayList<>();
        MongolKhanates game = new MongolKhanates();

        switch (year) {
            case 1206:
                for (int i = 0; i < 4; i++) {
                    tempList.add(game.date1(i));
                }
                break;
            case 1235:
                for (int i = 0; i < 4; i++) {
                    tempList.add(game.date2(i));
                }
                break;

            case 12511:
                for (int i = 0; i < 4; i++) {
                    tempList.add(game.date3(i));
                }
                break;

            case 12512:
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



            twelveSixBTN.setVisibility(View.VISIBLE);
            twelveThirtyFiveBTN.setVisibility(View.VISIBLE);
            twelveFiftyOneMiddleEastBTN.setVisibility(View.VISIBLE);
            twelveFiftyOneAsiaBTN.setVisibility(View.VISIBLE);


            twelveSixBTN.setEnabled(true);
            twelveThirtyFiveBTN.setEnabled(true);
            twelveFiftyOneMiddleEastBTN.setEnabled(true);
            twelveFiftyOneAsiaBTN.setEnabled(true);



            topImageView.setImageResource(R.drawable.selectyear);

            addToTimelineBTN.setEnabled(false);
            skipToNextBTN.setEnabled(false);
            submitBTN.setEnabled(false);




        }

        if(!visible){

            twelveSixBTN.setVisibility(View.INVISIBLE);
            twelveThirtyFiveBTN.setVisibility(View.INVISIBLE);
            twelveFiftyOneMiddleEastBTN.setVisibility(View.INVISIBLE);
            twelveFiftyOneAsiaBTN.setVisibility(View.INVISIBLE);

            twelveSixBTN.setEnabled(false);
            twelveThirtyFiveBTN.setEnabled(false);
            twelveFiftyOneMiddleEastBTN.setEnabled(false);
            twelveFiftyOneAsiaBTN.setEnabled(false);

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
     * Tag # 1206               = 1206-1220 (Mongol Unification, Conquest)
     * Tag # 1235               = 1235-1241 (Mongol Invasion of Europe)
     * Tag # 12511 (ie. 1251-1) = 1251-1260 (Mongol Invasion of the Middle East)
     * Tag # 12512 (ie. 1251-2)=  1251-1292 (Mongol Invasion of East and Southeast Asia)
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
        eventShowerTV.setText(MongolKhanatesEvents.get(elementCounter));
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
            loadNextEvent(elementCounter,MongolKhanatesEvents);
        }

    }

    public void addToTimelineOnClick(View view){

        if(!gameOver) {
            mainActivity.setSelectedEvents(MongolKhanatesEvents.get(elementCounter));
            ++elementCounter;
            loadNextEvent(elementCounter, MongolKhanatesEvents);
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mongol);
        getSupportActionBar().hide();
        addAllEvents();


        //Button initialization

        twelveSixBTN = findViewById(R.id.fifteenSeventyBTN);
        twelveThirtyFiveBTN = findViewById(R.id.fifteenSixtyBTN);
        twelveFiftyOneMiddleEastBTN = findViewById(R.id.twelveFiftyOneMiddleEastBTN);
        twelveFiftyOneAsiaBTN = findViewById(R.id.fifteenFiftyThreeBTN);


        addToTimelineBTN = findViewById(R.id.addToTimelineBTN);
        skipToNextBTN = findViewById(R.id.skipToNextBTN);
        submitBTN = findViewById(R.id.submitBTN);

        //ImageView initialization
        topImageView = findViewById(R.id.topImageView);

        //TextView initialization
        eventShowerTV = findViewById(R.id.eventShowerTV);
        timeTV = findViewById(R.id.timeTV);


        //button alpha
        twelveSixBTN.setAlpha(1);
        twelveThirtyFiveBTN.setAlpha(1);
        twelveFiftyOneMiddleEastBTN.setAlpha(1);
        twelveFiftyOneAsiaBTN.setAlpha(1);

        page1visibility(true);
        runRunnable();
    }
}
