package com.techincubatorfreelance.historyquiz;

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

public class Game2Page2 extends AppCompatActivity {

    MainActivity mainActivity = new MainActivity();
    private Button sixHundredBTN,fiveFiftyBTN,fiveThrityBTN,fiveNintynineBTN,addToTimelineBTN,skipToNextBTN,submitBTN;
    private ImageView topImageView;
    private ArrayList<String> game2Events = new ArrayList<>();
    private int elementCounter = 0;
    private TextView eventShowerTV, timeTV;
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
    public void addAllEvents(){
        Game2 game2 = new Game2();
        for(int i = 0; i< 4; i++){
            game2Events.add(game2.date1(i));
            game2Events.add(game2.date2(i));
            game2Events.add(game2.date3(i));
            game2Events.add(game2.date4(i));
        }
    }

    /*
    * loadNextEvent method displays all the events to the user
    */
    public void loadNextEvent(int elementCounter, ArrayList eventsArray){
        if (elementCounter == eventsArray.size()) {
            eventShowerTV.setText("All Events Shown");
            gameOver = true;
        } else {
            eventShowerTV.setText(""+eventsArray.get(elementCounter));
        }
    }

    /* the answerKeyGame2 function creates an arrayList that holds the answer key for
     *  the specific time period selected
     */
    protected ArrayList answerKeyGame2(int year) {
        ArrayList<String> tempList = new ArrayList<>();
        Game2 game2 = new Game2();

        switch (year) {
            case 600:
                for (int i = 0; i < 4; i++) {
                    tempList.add(game2.date1(i));
                }
                break;
            case 550:
                for (int i = 0; i < 4; i++) {
                    tempList.add(game2.date2(i));
                }
                break;

            case 530:
                for (int i = 0; i < 4; i++) {
                    tempList.add(game2.date3(i));
                }
                break;

            case 599:
                for (int i = 0; i < 4; i++) {
                    tempList.add(game2.date4(i));
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

    /* page1Visibility method displays the year selection page for game 2 */
    public void page1visibility(boolean visible){

        if(visible) {
            sixHundredBTN.setVisibility(View.VISIBLE);
            fiveFiftyBTN.setVisibility(View.VISIBLE);
            fiveThrityBTN.setVisibility(View.VISIBLE);
            fiveNintynineBTN.setVisibility(View.VISIBLE);
            topImageView.setImageResource(R.drawable.selectyear);

            sixHundredBTN.setEnabled(true);
            fiveFiftyBTN.setEnabled(true);
            fiveThrityBTN.setEnabled(true);
            fiveNintynineBTN.setEnabled(true);
            addToTimelineBTN.setEnabled(false);
            skipToNextBTN.setEnabled(false);
            submitBTN.setEnabled(false);

        }

        if(!visible){
            sixHundredBTN.setVisibility(View.INVISIBLE);
            fiveFiftyBTN.setVisibility(View.INVISIBLE);
            fiveThrityBTN.setVisibility(View.INVISIBLE);
            fiveNintynineBTN.setVisibility(View.INVISIBLE);

            sixHundredBTN.setEnabled(false);
            fiveFiftyBTN.setEnabled(false);
            fiveThrityBTN.setEnabled(false);
            fiveNintynineBTN.setEnabled(false);
        }
    }

    /* page1Visibility method displays the event selection page for game 2 */
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
    * Tag # 600 = 600 BCE - 321BCE
    * Tag # 550 = 550 BCE - 321 BCE
    * Tag # 530 = c.530 BCE - c.327 BCE
    * Tag # 599 = c.599 BCE - c.483 BCE
    * */

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
        eventShowerTV.setText(game2Events.get(elementCounter));
    }

    /* addToTimeLineOnClick method adds the event that is currently being shown to the SelectedEvents array list
    *  in the Main Activity class. The SelectedEvents method stores the the events selected by the user to be added to the timeline */
    public void addToTimelineOnClick(View view){
        if(!gameOver) {
            mainActivity.setSelectedEvents(game2Events.get(elementCounter));
            ++elementCounter;
            loadNextEvent(elementCounter, game2Events);
        }
    }
    /* skipToNextOnClick method skips to the next event to be shown*/
    public void skipTonextOnClick(View view){
        if(!gameOver){
            ++elementCounter;
            loadNextEvent(elementCounter,game2Events);
        }
    }


    /* submitOnClick opens the TimeLine activity page.
    *  the .removeCallBacks() method removes any pending posts of Runnable run that are in the message queue.  */
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
        setContentView(R.layout.activity_game2_page2);

        getSupportActionBar().hide();
        addAllEvents(); // adds all the possible events for game two into an arrayList



        //button initialization
        sixHundredBTN = findViewById(R.id.sixHundredBTN);
        fiveFiftyBTN = findViewById(R.id.fiveFiftyBTN);
        fiveThrityBTN = findViewById(R.id.fiveThrityBTN);
        fiveNintynineBTN = findViewById(R.id.fiveNintynineBTN);
        skipToNextBTN = findViewById(R.id.skipToNextBTN);
        addToTimelineBTN = findViewById(R.id.addToTimelineBTN);
        submitBTN = findViewById(R.id.submitBTN);

        //ImageView initialization
        topImageView = findViewById(R.id.topImageView);

        //TextView initialization
        eventShowerTV = findViewById(R.id.eventShowerTV);
        timeTV = findViewById(R.id.timeTV);

        //set alpha
        sixHundredBTN.setAlpha(1);
        fiveFiftyBTN.setAlpha(1);
        fiveThrityBTN.setAlpha(1);
        fiveNintynineBTN.setAlpha(1);
        page1visibility(true);


        runRunnable();




    }
}
