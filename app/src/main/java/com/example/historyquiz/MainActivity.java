package com.example.historyquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity  {

    private ArrayList<String> allOptionsGame1 = new ArrayList<>();
    private static ArrayList<String> selectedEvents = new ArrayList<>();
    private Game1 game1Options = new Game1();
    private TextView topTextBarTV, eventShowerTV , timeTV;
    private Button  game1SelectionBTN, game2SelectionBTN, addToTimelineBTN, skipToNextBTN,showTimelineBTN;
    private Button nineteenTwentiesBTN,twentynineTo33BTN,nineteenThirtiesBTN,twentyEightTo32BTN;
    private Button AncientEgyptBTN;
    private static int elementCounter = 0;
    private static int buttonYear;
    private boolean gameOver = false;
    private ImageView topImageView;
    private static int minute =0, second = 0;
    private  Handler handler = new Handler();
    private Runnable run;
    private MediaPlayer music;
    //******************************************************************************************************//
    //                                           GETTERS / SETTERS                                          //
    //******************************************************************************************************//

    public ArrayList getSelectedEvents(){
        return selectedEvents;
    }

    public int getButtonYear(){
        return buttonYear;
    }


    public int getMinute(){
        return minute;
    }

    public int getSecond(){
        return  second;
    }



    public void setMinute(int min){
        minute = min;
    }

    public void setSecond(int sec){
        second = sec;
    }

    public void setButtonYear(int year){
        buttonYear = year;
    }

    public void setElementCounter(int newValue){
        elementCounter = newValue;
    }


    public void setGameOver(boolean isGameOver){
        gameOver = isGameOver;
    }

    public void setSelectedEvents(String insert){
        selectedEvents.add(insert);
    }







    //******************************************************************************************************//
    //                        METHODS FOR COMPUTATIONS/ OTHER TASKS (Helper Methods )                       //
    //******************************************************************************************************//


    //uses a for loop to loop through all the answer options in game one and  adds it to "allOptions" array list.
    private void addAllOptions(){
        for(int i = 0; i < 4; i++){
            allOptionsGame1.add(game1Options.date1(i));
            allOptionsGame1.add(game1Options.date2(i));
            allOptionsGame1.add(game1Options.date3(i));
            allOptionsGame1.add(game1Options.date4(i));
        }
    }

    /* the answerKeyGame1 function creates an arrayList that holds the answer key for
    *  the specific time period selected*/
    protected ArrayList answerKeyGame1(int year) {
        ArrayList<String> tempList = new ArrayList<>();

        switch (year) {
            case 1928:
                for (int i = 0; i < 4; i++) {
                    tempList.add(game1Options.date4(i));
                }
                break;
            case 1930:
                for (int i = 0; i < 4; i++) {
                    tempList.add(game1Options.date3(i));
                }
                break;

            case 1929:
                for (int i = 0; i < 4; i++) {
                    tempList.add(game1Options.date2(i));
                }
                break;

            case 1920:
                for (int i = 0; i < 4; i++) {
                    tempList.add(game1Options.date1(i));
                }
                break;

            default:
                Toast.makeText(this, "Error has Occurred", Toast.LENGTH_SHORT).show();

        }
        return tempList;
    }


    /*
    * the loadNextEvent method loads the next event on the timeline. If all events are used up (ie. all events were shown to the user)
    * then the game is over.
    *
    * */
    public void loadNextEvent(int elementCounter, ArrayList eventsArray){
        if (elementCounter == eventsArray.size()) {
            eventShowerTV.setText("All Events Shown");
            gameOver = true;
        } else {
            eventShowerTV.setText(""+eventsArray.get(elementCounter));
        }
    }

    /*
    * this method, when called, opens the "Timeline" activity/class
    * */
    public void openTimelineActivity(){
        Intent intent = new Intent(this,Timeline.class);
        startActivity(intent);
    }

    /* method that is used to clear an arrayList*/
    public void clearArrayList(ArrayList list){
        list.clear();
    }


    /*uses the handler, a message queue which you post a message to it (ie "run"), and it will eventually
    process it by calling its run method and passing the message to it*/
    public void clock(){
        handler.post(run);
    }


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

    /*This is for the visibility for page 1. When set to true, it will make the game one and game two buttons visible. Invisible if false. */
    public void page1Visibility(boolean visible){
        if(visible){
            game1SelectionBTN.setVisibility(View.VISIBLE);
            game2SelectionBTN.setVisibility(View.VISIBLE);
            AncientEgyptBTN.setVisibility(View.VISIBLE);
            topTextBarTV.setText("");
            game1SelectionBTN.setEnabled(true);
            game2SelectionBTN.setEnabled(true);
            AncientEgyptBTN.setEnabled(true);
            topImageView.setImageResource(R.drawable.selectgame);
        }
        if(!visible){
            game1SelectionBTN.setVisibility(View.INVISIBLE);
            game2SelectionBTN.setVisibility(View.INVISIBLE);
            AncientEgyptBTN.setVisibility(View.INVISIBLE);
            game1SelectionBTN.setEnabled(false);
            game2SelectionBTN.setEnabled(false);
            AncientEgyptBTN.setEnabled(false);

        }

    }

    /*if visible is set to "true", it will make page 2 visible,if it is set to false, then it will make it invisible.
     Page 2 includes the years on the timeline, ie. 1920s, 1930s etc. */
    public void page2Visibility(boolean visible){

        if(visible){
            nineteenTwentiesBTN.setAlpha(1);
            twentynineTo33BTN.setAlpha(1);
            nineteenThirtiesBTN.setAlpha(1);
            twentyEightTo32BTN.setAlpha(1);
            nineteenTwentiesBTN.setVisibility(View.VISIBLE);
            twentynineTo33BTN.setVisibility(View.VISIBLE);
            nineteenThirtiesBTN.setVisibility(View.VISIBLE);
            twentyEightTo32BTN.setVisibility(View.VISIBLE);
            topTextBarTV.setText("");
            topImageView.setImageResource(R.drawable.selectyear);

            nineteenTwentiesBTN.setEnabled(true);
            twentynineTo33BTN.setEnabled(true);
            nineteenThirtiesBTN.setEnabled(true);
            twentyEightTo32BTN.setEnabled(true);
        }

        if(!visible){
            nineteenTwentiesBTN.setVisibility(View.INVISIBLE);
            twentynineTo33BTN.setVisibility(View.INVISIBLE);
            nineteenThirtiesBTN.setVisibility(View.INVISIBLE);
            twentyEightTo32BTN.setVisibility(View.INVISIBLE);
            nineteenTwentiesBTN.setEnabled(false);
            twentynineTo33BTN.setEnabled(false);
            nineteenThirtiesBTN.setEnabled(false);
            twentyEightTo32BTN.setEnabled(false);
        }
    }

    /*
    * yesAndNoButtonVisibility makes the "add event to timeline" and "go to the next event" buttons
    * either visible or invisible
    * */
    public void page3Visibility(boolean visible){
        if(visible){
            addToTimelineBTN.setAlpha(1);
            skipToNextBTN.setAlpha(1);
            showTimelineBTN.setAlpha(1);
            addToTimelineBTN.setVisibility(View.VISIBLE);
            skipToNextBTN.setVisibility(View.VISIBLE);
            showTimelineBTN.setVisibility(View.VISIBLE);

            addToTimelineBTN.setEnabled(true);
            skipToNextBTN.setEnabled(true);
            showTimelineBTN.setEnabled(true);
            clock();
        }
        if(!visible){
            addToTimelineBTN.setVisibility(View.INVISIBLE);
            skipToNextBTN.setVisibility(View.INVISIBLE);
            showTimelineBTN.setVisibility(View.VISIBLE);
            addToTimelineBTN.setEnabled(false);
            skipToNextBTN.setEnabled(false);
            showTimelineBTN.setEnabled(false);
        }
    }

    //*******************************************************************************************************//
    //                METHODS FOR BUTTON ON-CLICKS   (Methods that make the app work)                      //
    //         The Methods written above are used to add functionality to the methods listed below          //
    //******************************************************************************************************//



    /*When gameOneOnClick is pressed, it starts game one. This will display all the years associated with game one */
    public void gameOneOnClick(View view){
        page1Visibility(false);
        page2Visibility(true);
    }

    /*When nineteenTwentiesOnClick button is clicked, an event is produced to be used for the "Add to timeline button"
    * Tag #'s to Note :
    * Tag # 1928 = year 1928 -1932
    * Tag # 1930 = year 1930s
    * Tag # 1929 = year 1929 -1933
    * Tag # 1920 = year 1920s
    * */
    public void yearOnClick(View view){

        //sets the button that is currently being pressed into the variable "buttonPressed"
        Button buttonPressed = (Button) view;
        //saves the tag number of that specific button that is pressed into "buttonYear"
        buttonYear = Integer.parseInt(buttonPressed.getTag().toString());
        page2Visibility(false);
        topTextBarTV.setText("");
        topImageView.setImageResource(R.drawable.doesthisbelonginthetimeline);
        eventShowerTV.setText(allOptionsGame1.get(elementCounter));
        page3Visibility(true);

    }


    /*
        1) Make a  "Yes, Add to timeline" Button ✓
        2) make a "Nope, Next Event" Button ✓
        3) On the yes button (addToTimeLineOnClick method), make a new array list. In the new arrayList (selectedEventsGame1), put allOptionsGame1.get(elementCounter), then ++element counter
        4) On the No Button (shipToNextOnClick method), show the next event
    */

    public void addToTimeLineOnClick(View view){
        if(!gameOver) {
            selectedEvents.add(allOptionsGame1.get(elementCounter));
            ++elementCounter;
            loadNextEvent(elementCounter,allOptionsGame1);
        }
    }

    public void skipToNextOnClick(View view){
        if(!gameOver) {
            ++elementCounter;
            loadNextEvent(elementCounter,allOptionsGame1);
        }
    }


    /*
    * the showTimelineOnClick method for the show timeline button. When pressed, it will open a new page that will display the timeline
    */
    public void showTimelineOnClick(View view){

        openTimelineActivity();
        music.pause();
        gameOver = true;
        handler.removeCallbacks(run); //uses the handler to tell runnable called "run" to stop running.

    }


    /*once game two is selected, a separate game two page is opened*/
    public void gameTwoOnClick(View view){
        Intent intent = new Intent(this,Game2Page2.class);
        startActivity(intent);
        music.pause();
    }

    public void AncientEgyptOnClick(View view){

    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        addAllOptions(); // loads all the answer options of game one into the app.

        //MediaPlayer initialization
        music = MediaPlayer.create(this,R.raw.music);
        music.start();


        //Button initializations
        nineteenTwentiesBTN = findViewById(R.id.nineteenTwentiesBTN);
        twentynineTo33BTN = findViewById(R.id.twentynineTo33BTN);
        nineteenThirtiesBTN = findViewById(R.id.nineteenThirtiesBTN);
        twentyEightTo32BTN = findViewById(R.id.twentyEightTo32BTN);
        
        game1SelectionBTN = findViewById(R.id.game1BTN);
        game2SelectionBTN =  findViewById(R.id.game2BTN);
        addToTimelineBTN = findViewById(R.id.addToTimelineBTN);
        skipToNextBTN = findViewById(R.id.skipToNextBTN);
        AncientEgyptBTN = findViewById(R.id.AncientEgyptBTN);

        showTimelineBTN = findViewById(R.id.showTimelineBTN);
        //Text View initializations
        topTextBarTV = findViewById(R.id.topTextBarTV);
        eventShowerTV = findViewById(R.id.EventShowerTV);
        timeTV = findViewById(R.id.timeTV);

        //image view
        topImageView = findViewById(R.id.topImageView);

        //set alpha
        game1SelectionBTN.setAlpha(1);
        game2SelectionBTN.setAlpha(1);

        page2Visibility(false);
        page3Visibility(false);




        //runnable used to run the timer

       runRunnable();

    }
}
