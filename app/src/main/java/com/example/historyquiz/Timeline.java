package com.example.historyquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
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
    private Game2Page2 game2Page2 = new Game2Page2();
    private EgyptActivity ancientEgypt = new EgyptActivity();
    private GreeceActivity ancientGreece = new GreeceActivity();
    private IndiaActivity ancientIndia = new IndiaActivity();
    private MuslimActivity muslimCaliphates = new MuslimActivity();
    private ReformationActivity reformationActivity = new ReformationActivity();
    private MongolActivity mongolActivity = new MongolActivity();





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
            case 600:
                checkSolution(userSelection,game2Page2.answerKeyGame2(600));
                break;
            case 550:
                checkSolution(userSelection,game2Page2.answerKeyGame2(550));
                break;
            case 530:
                checkSolution(userSelection,game2Page2.answerKeyGame2(530));
                break;
            case 599:
                checkSolution(userSelection,game2Page2.answerKeyGame2(599));
                break;
            case 1640:
                checkSolution(userSelection,ancientEgypt.answerKeyEgypt(1640));
                break;
            case 15701:
                checkSolution(userSelection,ancientEgypt.answerKeyEgypt(15701));
                break;
            case 15702:
                checkSolution(userSelection,ancientEgypt.answerKeyEgypt(15702));
                break;
            case 1285:
                checkSolution(userSelection,ancientEgypt.answerKeyEgypt(1285));
                break;
            case 8001:
                checkSolution(userSelection,ancientGreece.answerKeyGreece(8001));
                break;
            case 8002:
                checkSolution(userSelection,ancientGreece.answerKeyGreece(8002));
                break;
            case 7001:
                checkSolution(userSelection,ancientGreece.answerKeyGreece(7001));
                break;
            case 7002:
                checkSolution(userSelection,ancientGreece.answerKeyGreece(7002));
                break;
            case 15001:
                checkSolution(userSelection,ancientIndia.answerKeyIndia(15001));
                break;
            case 15002:
                checkSolution(userSelection,ancientIndia.answerKeyIndia(15002));
                break;
            case 15003:
                checkSolution(userSelection,ancientIndia.answerKeyIndia(15003));
                break;
            case 15004:
                checkSolution(userSelection,ancientIndia.answerKeyIndia(15004));
                break;
            case 632:
                checkSolution(userSelection,muslimCaliphates.answerKeyMuslimCaliphates(632));
                break;
            case 661:
                checkSolution(userSelection,muslimCaliphates.answerKeyMuslimCaliphates(661));
                break;
            case 750:
                checkSolution(userSelection,muslimCaliphates.answerKeyMuslimCaliphates(750));
                break;
            case 756:
                checkSolution(userSelection,muslimCaliphates.answerKeyMuslimCaliphates(756));
                break;
            case 1517:
                checkSolution(userSelection,reformationActivity.answerKeyEuropeReformation(1517));
                break;
            case 1527:
                checkSolution(userSelection,reformationActivity.answerKeyEuropeReformation(1527));
                break;
            case 15341:
                checkSolution(userSelection,reformationActivity.answerKeyEuropeReformation(15341));
                break;
            case 15342:
                checkSolution(userSelection,reformationActivity.answerKeyEuropeReformation(15342));
                break;
            case 1206:
                checkSolution(userSelection,mongolActivity.answerKeyMongolKhanates(1206));
                break;
            case 1235:
                checkSolution(userSelection,mongolActivity.answerKeyMongolKhanates(1235));
                break;
            case 12511:
                checkSolution(userSelection,mongolActivity.answerKeyMongolKhanates(12511));
                break;
            case 12512:
                checkSolution(userSelection,mongolActivity.answerKeyMongolKhanates(12512));
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
        getSupportActionBar().hide();

        topTextBarTV = findViewById(R.id.topTextBarTV);
        timeTV = findViewById(R.id.timeTV);
        topImageView = findViewById(R.id.topImageView);


        ListView timelineListView = findViewById(R.id.timelineListView);
        topTextBarTV.setText("SELECTED TIMELINE");

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
