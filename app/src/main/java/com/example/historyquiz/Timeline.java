package com.example.historyquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Timeline extends AppCompatActivity  {


    private ArrayList<String> userSelection = new ArrayList<>();
    private MainActivity mainActivity = new MainActivity();
    private TextView topTextBarTV,timeTV;
    private ImageView topImageView;





    //******************************************************************************************************//
    //                        METHODS FOR COMPUTATIONS/ OTHER TASKS (Helper Methods )                       //
    //******************************************************************************************************//

    /*
     * This is the checkSloution method checks if the user input it correct
     * This is exclusively for game 1
     */
    public void checkSolution(ArrayList userSelection, ArrayList answerKey){
        boolean correct = true;
        if(userSelection.size() != 4 ){
            correct = false;
            topTextBarTV.setText("Please Go back to the reading,\n Press Home Button to continue");
            topImageView.setImageResource(R.drawable.incorrect);
        }else {
            for(int i = 0; i < answerKey.size(); i ++){
                if( !(userSelection.contains(answerKey.get(i))) ) {
                    topTextBarTV.setText("Please Go back to the reading,\n Press Home Button to continue");
                    topImageView.setImageResource(R.drawable.incorrect);
                    correct = false;
                    break;
                }//end of if
            }//end of for loop
        }//end of else

        if(correct){
            topTextBarTV.setText("Please Take a Screenshot of Result,\n Press Home Button to continue");
            topImageView.setImageResource(R.drawable.correct);

        }
    }

    public void openMainActivity(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void showTimeTaken(){
        int second = mainActivity.getSecond();
        int minute = mainActivity.getMinute();

        if(second < 10 && minute < 10){
            timeTV.setText("0"+ minute + " : 0"+ second);
        }else if(second < 10 && minute >= 10){
            timeTV.setText(""+ minute + " : 0"+ second);
        }else if(second > 10 && minute < 10){
            timeTV.setText("0"+ minute + " : "+ second);
        }else{
            timeTV.setText(""+ minute + " : "+ second);
        }
    }

    //*******************************************************************************************************//
    //               METHODS FOR BUTTON ON-CLICKS   (Calls on All other methods on top)                      //
    //******************************************************************************************************//

    /* submit button that checks if the users input is correct*/
    public void timelineSubmitOnClick(View view){
        int buttonYear = mainActivity.getButtonYear();
        switch(buttonYear){
            case 1928:
                checkSolution(userSelection,mainActivity.answerKeyGame1(1928));
                break;
            case 1930:
               checkSolution(userSelection,mainActivity.answerKeyGame1(1930));
                break;

            case 1929:
                checkSolution(userSelection,mainActivity.answerKeyGame1(1929));
                break;

            case 1920:
                checkSolution(userSelection,mainActivity.answerKeyGame1(1920));
                break;

            default:
                Toast.makeText(this,"Error has Occurred",Toast.LENGTH_SHORT).show();

        }
    }


    /* when the home button is pressed go to the game selection page*/
    public void homeButtonOnClick (View view){
        openMainActivity();
        mainActivity.setElementCounter(0);
        mainActivity.clearArrayList(mainActivity.getSelectedEvents());
        mainActivity.setGameOver(false);
        mainActivity.setMinute(0);
        mainActivity.setSecond(0);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);

        topTextBarTV = findViewById(R.id.topTextBarTV);
        timeTV = findViewById(R.id.timeTV);
        topImageView = findViewById(R.id.topImageView);



        getSupportActionBar().setTitle("\tYOUR TIMELINE");
        ListView timelineListView = findViewById(R.id.timelineListView);


        /*
        * To make userSelection compatible with all games, put tag on game selection buttons
        * then make a switch statement and set "userSelection" to its correlating game number.
        * ex. if tag # = 1, then userSelection = mainActivity.getSelectedEventsGame1();
        */
        userSelection = mainActivity.getSelectedEvents();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, userSelection );
        timelineListView.setAdapter(adapter);


        //show the clock from mainActivity
        showTimeTaken();


    }

}
