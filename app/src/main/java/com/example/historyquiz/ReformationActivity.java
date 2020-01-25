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

public class ReformationActivity extends AppCompatActivity {
    private  MainActivity mainActivity = new MainActivity();
    private Button fifteenSeventeenBTN,fifteenTwentysevenBTN,fifteenThirtyfourPeopleBTN,fifteenThirtyfourInstitutionsBTN;
    private Button addToTimelineBTN,skipToNextBTN,submitBTN;
    private ImageView topImageView;
    private TextView eventShowerTV, timeTV;
    private ArrayList<String> reformationEvents = new ArrayList<>();
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
        EuropeReformation game = new EuropeReformation();
        for (int i = 0; i < 4; i++) {
            reformationEvents.add(game.date1(i));
            reformationEvents.add(game.date2(i));
            reformationEvents.add(game.date3(i));
            reformationEvents.add(game.date4(i));
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
     * Tag # 1517                 =  1517 – 1564 (Martin Luther and John Calvin)
     * Tag # 1527                 =  1527-1559 (English Reformation)
     * Tag # 15341 (ie. 1534 - 1) =  1534-1563 (Catholic Reformation, People)
     * Tag # 15342 (ie. 1534 - 2) =  1534-1563 (Catholic Reformation, Institutions)
     *
     */

    protected ArrayList answerKeyEuropeReformation(int year) {
        ArrayList<String> tempList = new ArrayList<>();
        EuropeReformation game = new EuropeReformation();

        switch (year) {
            case 1517:
                for (int i = 0; i < 4; i++) {
                    tempList.add(game.date1(i));
                }
                break;
            case 1527:
                for (int i = 0; i < 4; i++) {
                    tempList.add(game.date2(i));
                }
                break;

            case 15341:
                for (int i = 0; i < 4; i++) {
                    tempList.add(game.date3(i));
                }
                break;

            case 15342:
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


            fifteenSeventeenBTN.setVisibility(View.VISIBLE);
            fifteenTwentysevenBTN.setVisibility(View.VISIBLE);
            fifteenThirtyfourPeopleBTN.setVisibility(View.VISIBLE);
            fifteenThirtyfourInstitutionsBTN.setVisibility(View.VISIBLE);


            fifteenSeventeenBTN.setEnabled(true);
            fifteenTwentysevenBTN.setEnabled(true);
            fifteenThirtyfourPeopleBTN.setEnabled(true);
            fifteenThirtyfourInstitutionsBTN.setEnabled(true);


            topImageView.setImageResource(R.drawable.selectyear);

            addToTimelineBTN.setEnabled(false);
            skipToNextBTN.setEnabled(false);
            submitBTN.setEnabled(false);




        }

        if(!visible){

            fifteenSeventeenBTN.setVisibility(View.INVISIBLE);
            fifteenTwentysevenBTN.setVisibility(View.INVISIBLE);
            fifteenThirtyfourPeopleBTN.setVisibility(View.INVISIBLE);
            fifteenThirtyfourInstitutionsBTN.setVisibility(View.INVISIBLE);

            fifteenSeventeenBTN.setEnabled(false);
            fifteenTwentysevenBTN.setEnabled(false);
            fifteenThirtyfourPeopleBTN.setEnabled(false);
            fifteenThirtyfourInstitutionsBTN.setEnabled(false);

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
     * Tag # 1517                 =  1517 – 1564 (Martin Luther and John Calvin)
     * Tag # 1527                 =  1527-1559 (English Reformation)
     * Tag # 15341 (ie. 1534 - 1) =  1534-1563 (Catholic Reformation, People)
     * Tag # 15342 (ie. 1534 - 2) =  1534-1563 (Catholic Reformation, Institutions)
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
        eventShowerTV.setText(reformationEvents.get(elementCounter));
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
            loadNextEvent(elementCounter,reformationEvents);
        }

    }

    public void addToTimelineOnClick(View view){

        if(!gameOver) {
            mainActivity.setSelectedEvents(reformationEvents.get(elementCounter));
            ++elementCounter;
            loadNextEvent(elementCounter, reformationEvents);
        }


    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reformation);

        getSupportActionBar().hide();
        addAllEvents();

        //Button Initialization

        fifteenSeventeenBTN = findViewById(R.id.fifteenSeventeenBTN);
        fifteenTwentysevenBTN = findViewById(R.id.fifteenTwentysevenBTN);
        fifteenThirtyfourPeopleBTN = findViewById(R.id.fifteenThirtyfourPeopleBTN);
        fifteenThirtyfourInstitutionsBTN = findViewById(R.id.fifteenThirtyfourInstitutionsBTN);


        fifteenSeventeenBTN.setAlpha(1);
        fifteenTwentysevenBTN.setAlpha(1);
        fifteenThirtyfourPeopleBTN.setAlpha(1);
        fifteenThirtyfourInstitutionsBTN.setAlpha(1);


        addToTimelineBTN = findViewById(R.id.addToTimelineBTN);
        skipToNextBTN = findViewById(R.id.skipToNextBTN);
        submitBTN = findViewById(R.id.submitBTN);

        //ImageView initialization
        topImageView = findViewById(R.id.topImageView);

        //TextView initialization
        eventShowerTV = findViewById(R.id.eventShowerTV);
        timeTV = findViewById(R.id.timeTV);


        page1visibility(true);
        runRunnable();
    }
}
