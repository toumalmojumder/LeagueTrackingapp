package com.jg.leaguetrackingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button addplayerButton,startGameButton,scoreBoardButton,selectPlayerOneButton,selectPlayertwoButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addplayerButton=findViewById(R.id.add_player_button);
        startGameButton=findViewById(R.id.start_game_button);
        scoreBoardButton=findViewById(R.id.view_score_board_button);
        selectPlayerOneButton=findViewById(R.id.select_player_one_button);
        selectPlayertwoButton=findViewById(R.id.select_player_two_button);

        addplayerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAddPlayerDialog();
            }
        });
        selectPlayerOneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        selectPlayerOneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,PlayerSelectActivity.class);
                startActivity(intent);
            }
        });

        selectPlayertwoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SelectPlayerTwoActivity.class);
                startActivity(intent);
            }
        });

        startGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,GameActivity.class);
                startActivity(intent);
            }
        });
        scoreBoardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ScoreBoardActivity.class);
                startActivity(intent);
            }
        });


    }
    public void openAddPlayerDialog(){
        Intent intent = new Intent(MainActivity.this,AddPlayerActivity.class);
        startActivity(intent);
    }


}