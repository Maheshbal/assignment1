package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // we have two images left dice and right dice
        // link the code to those two image view inside your layout.....(activity main)
        final ImageView UserDie = findViewById(R.id.picture1);
        final ImageView ComputerDie = findViewById(R.id.picture2);
        Button higher_button = findViewById(R.id.button1);
        Button lower_button = findViewById(R.id.button2);
        TextView displayResult = (TextView) findViewById(R.id.Result);
        //-------------------------------------------------------------------

        final int [] diceArray = {R.drawable.dice1,
                R.drawable.dice2,
                R.drawable.dice3,
                R.drawable.dice4,
                R.drawable.dice5,
                R.drawable.dice6};

        higher_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String final_result = "";
                Random rand = new Random();
                int randLeftDie = rand.nextInt(6);//User
                int randRightDie = rand.nextInt(6);//Computer
                Log.d("left die",String.valueOf(randLeftDie));
                Log.d("right die",String.valueOf(randRightDie));

                UserDie.setImageResource(diceArray[randLeftDie]);
                ComputerDie.setImageResource(diceArray[randRightDie]);

                if(randLeftDie == randRightDie){
                    //Tie
                    final_result = "It’s a tie";
                }else if (randLeftDie > randRightDie){
                    //loose
                    final_result = "Computer Win!";
                }else {
                    //Win
                    final_result = "User Win!";
                }
                displayResult.setText(final_result);
            }
        });

        lower_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String final_result = "";
                Random rand = new Random();
                int randLeftDie = rand.nextInt(6);
                int randRightDie = rand.nextInt(6);
                Log.d("left die",String.valueOf(randLeftDie));
                Log.d("right die",String.valueOf(randRightDie));

                UserDie.setImageResource(diceArray[randLeftDie]);
                ComputerDie.setImageResource(diceArray[randRightDie]);

                if(randLeftDie == randRightDie){
                    //Tie
                    final_result = "It’s a tie";
                }else if (randLeftDie < randRightDie){
                    //loose
                    final_result = "Computer Win!";
                }else {
                    //Win
                    final_result = "User Win!";
                }
                displayResult.setText(final_result);
            }
        });
    }
}