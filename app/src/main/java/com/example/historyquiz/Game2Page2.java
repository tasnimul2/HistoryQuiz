package com.example.historyquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Game2Page2 extends AppCompatActivity {

    MainActivity mainActivity = new MainActivity();
    private Button sixHundredBTN,fiveFiftyBTN,fiveThrityBTN,fiveNintynineBTN,addToTimelineBTN,skipToNextBTN;
    private ImageView topImageView;
    private static ArrayList<String> game2Events = new ArrayList<>();
    private static int elementCounter = 0;
    private TextView eventShowerTV;
    private boolean gameOver = false;


    //******************************************************************************************************//
    //                                           GETTERS / SETTERS                                          //
    //******************************************************************************************************//

    public ArrayList getGame2Events(){
        return game2Events;
    }


    //******************************************************************************************************//
    //                        METHODS FOR COMPUTATIONS/ OTHER TASKS (Helper Methods )                       //
    //******************************************************************************************************//

    public void addAllEvents(){
        Game2 game2 = new Game2();
        for(int i = 0; i< 4; i++){
            game2Events.add(game2.date1(i));
            game2Events.add(game2.date2(i));
            game2Events.add(game2.date3(i));
            game2Events.add(game2.date4(i));
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






    //*******************************************************************************************************//
    //                                      METHODS FOR VIEW VISIBILITY                                      //
    //******************************************************************************************************//

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

    public void page2visibility(boolean visible){
        if(visible){
            topImageView.setImageResource(R.drawable.doesthisbelonginthetimeline);
            addToTimelineBTN.setAlpha(1);
            skipToNextBTN.setAlpha(1);
            addToTimelineBTN.setVisibility(View.VISIBLE);
            skipToNextBTN.setVisibility(View.VISIBLE);
        }

        if(!visible){
            addToTimelineBTN.setVisibility(View.INVISIBLE);
            skipToNextBTN.setVisibility(View.INVISIBLE);
        }
    }





    //*******************************************************************************************************//
    //                METHODS FOR BUTTON ON-CLICKS   (Methods that make the app work)                       //
    //         The Methods written above are used to add functionality to the methods listed below          //
    //******************************************************************************************************//

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

    public void addToTimelineOnClick(View view){
        if(!gameOver) {
            mainActivity.setSelectedEvents(game2Events.get(elementCounter));
            ++elementCounter;
            loadNextEvent(elementCounter, game2Events);
        }
    }

    public void skipTonextOnClick(View view){
        if(!gameOver){
            ++elementCounter;
            loadNextEvent(elementCounter,game2Events);
        }
    }

    /* 1) make a review and submit button
    *  2) add tags for game twos events on the "checkSolution" method for timeline Activity
    * */





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

        //ImageView initialization
        topImageView = findViewById(R.id.topImageView);

        //TextView initialization
        eventShowerTV = findViewById(R.id.eventShowerTV);

        //set alpha
        sixHundredBTN.setAlpha(1);
        fiveFiftyBTN.setAlpha(1);
        fiveThrityBTN.setAlpha(1);
        fiveNintynineBTN.setAlpha(1);
        page1visibility(true);



    }
}
