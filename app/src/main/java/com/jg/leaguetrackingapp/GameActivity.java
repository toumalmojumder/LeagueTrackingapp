package com.jg.leaguetrackingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity {

    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,back;
    TextView plOne,plTwo,info;

    public String btnLabel = "X";
    int count = 0;
    String playerOneName,playerTwoName;
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String PlayerONE = "sharedPrefone";
    public static final String PlayerONEWin = "PlayerONEWin";
    public static final String PlayerONELosses = "PlayerONELosses";
    public static final String PlayerONETie = "PlayerONETie";


    public static final String PlayerTwo = "sharedPreftwo";
    public static final String PlayerTwoWin = "PlayerTwoWin";
    public static final String PlayerTwoLosses = "PlayerTwoLosses";
    public static final String PlayerTwoTie = "PlayerTwoTie";


    DatabaseHelper databaseHelper;
    int ploneWin,plonelosses,plonetie,pltwoWin,pltwoLosses,pltwoTie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        back = findViewById(R.id.gamecancel);

        plOne = findViewById(R.id.playerOneName);
        plTwo = findViewById(R.id.playerTwoName);

        info= findViewById(R.id.playerInfo);
        databaseHelper = new DatabaseHelper(this);

        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        playerOneName = sharedPreferences.getString(PlayerONE,"");
        ploneWin =sharedPreferences.getInt(PlayerONEWin,0);
        plonelosses =sharedPreferences.getInt(PlayerONELosses,0);
        plonetie =sharedPreferences.getInt(PlayerONETie,0);


        playerTwoName = sharedPreferences.getString(PlayerTwo,"");
        pltwoWin =sharedPreferences.getInt(PlayerTwoWin,0);
        pltwoLosses =sharedPreferences.getInt(PlayerTwoLosses,0);
        pltwoTie =sharedPreferences.getInt(PlayerTwoTie,0);

        plOne.setText(playerOneName);
        plTwo.setText(playerTwoName);




        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn1.setText(btnLabel);
                if(btnLabel=="X"){

                    btnLabel = "O";
                    info.setText( "Now player Two turn!");
                }
                else{
                    btnLabel = "X";
                    info.setText( "Now player One turn!");
                }
                btn1.setEnabled(false);
                count++;
                if(count==9){
                    gameResult();
                }
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn2.setText(btnLabel);
                if(btnLabel=="X"){
                    btnLabel = "O";
                    info.setText( "Now player Two turn!");
                }
                else{
                    btnLabel = "X";
                    info.setText( "Now player One turn!");
                }
                btn2.setEnabled(false);
                count++;
                if(count==9){
                    gameResult();
                }

            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn3.setText(btnLabel);
                if(btnLabel=="X"){
                    btnLabel = "O";
                    info.setText( "Now player Two turn!");
                }
                else{
                    btnLabel = "X";
                    info.setText( "Now player One turn!");
                }
                btn3.setEnabled(false);
                count++;
                if(count==9){
                    gameResult();
                }
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn4.setText(btnLabel);
                if(btnLabel=="X"){
                    btnLabel = "O";
                    info.setText( "Now player Two turn!");
                }
                else{
                    btnLabel = "X";
                    info.setText( "Now player One turn!");
                }
                btn4.setEnabled(false);
                count++;
                if(count==9){
                    gameResult();
                }
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn5.setText(btnLabel);
                if(btnLabel=="X"){
                    btnLabel = "O";
                    info.setText( "Now player Two turn!");
                }
                else{
                    btnLabel = "X";
                    info.setText( "Now player One turn!");
                }
                btn5.setEnabled(false);
                count++;
                if(count==9){
                    gameResult();
                }
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn6.setText(btnLabel);
                if(btnLabel=="X"){
                    btnLabel = "O";
                    info.setText( "Now player Two turn!");
                }
                else{
                    btnLabel = "X";
                    info.setText( "Now player One turn!");
                }
                btn6.setEnabled(false);
                count++;
                if(count==9){
                    gameResult();
                }
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn7.setText(btnLabel);
                if(btnLabel=="X"){
                    btnLabel = "O";
                    info.setText( "Now player Two turn!");
                }
                else{
                    btnLabel = "X";
                    info.setText( "Now player One turn!");
                }
                btn7.setEnabled(false);
                count++;
                if(count==9){
                    gameResult();
                }

            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn8.setText(btnLabel);
                if(btnLabel=="X"){
                    btnLabel = "O";
                    info.setText( "Now player Two turn!");
                }
                else{
                    btnLabel = "X";
                    info.setText( "Now player One turn!");
                }
                btn8.setEnabled(false);
                count++;
                if(count==9){
                    gameResult();
                }
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn9.setText(btnLabel);
                if(btnLabel=="X"){
                    btnLabel = "O";
                    info.setText( "Now player Two turn!");
                }
                else{
                    btnLabel = "X";
                    info.setText( "Now player One turn!");
                }
                btn9.setEnabled(false);
                count++;
                if(count==9){
                    gameResult();
                }
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GameActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });


    }
    public void gameResult(){


            if(btn1.getText()=="X" &&btn2.getText()=="X" &&btn3.getText()=="X"){
                info.setText("Player One Win!");
                ploneWin = ploneWin +1;
                pltwoLosses =pltwoLosses+1;
                try {
                    databaseHelper.updateScore(playerOneName,ploneWin,plonelosses,plonetie);
                    databaseHelper.updateScore(playerTwoName,pltwoWin,pltwoLosses,pltwoTie);
                    Toast.makeText(this, "Score Updated", Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
                }


            }
            else if(btn1.getText()=="O" &&btn2.getText()=="O" &&btn3.getText()=="O"){
                info.setText("Player Two Win!");
                pltwoWin = pltwoWin +1;
                plonelosses =plonelosses+1;
                try {
                    databaseHelper.updateScore(playerOneName,ploneWin,plonelosses,plonetie);
                    databaseHelper.updateScore(playerTwoName,pltwoWin,pltwoLosses,pltwoTie);
                    Toast.makeText(this, "Score Updated", Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
                }

            }
            else if(btn1.getText()=="X" &&btn4.getText()=="X" &&btn7.getText()=="X"){
                info.setText("Player One Win!");
                ploneWin = ploneWin +1;
                pltwoLosses =pltwoLosses+1;
                try {
                    databaseHelper.updateScore(playerOneName,ploneWin,plonelosses,plonetie);
                    databaseHelper.updateScore(playerTwoName,pltwoWin,pltwoLosses,pltwoTie);
                    Toast.makeText(this, "Score Updated", Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
                }

            }
            else if(btn1.getText()=="O" &&btn4.getText()=="O" &&btn7.getText()=="O"){
                info.setText("Player Two Win!");
                pltwoWin = pltwoWin +1;
                plonelosses =plonelosses+1;
                try {
                    databaseHelper.updateScore(playerOneName,ploneWin,plonelosses,plonetie);
                    databaseHelper.updateScore(playerTwoName,pltwoWin,pltwoLosses,pltwoTie);
                    Toast.makeText(this, "Score Updated", Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
                }

            }
            else if(btn1.getText()=="X" &&btn5.getText()=="X" &&btn9.getText()=="X"){
                info.setText("Player One Win!");
                ploneWin = ploneWin +1;
                pltwoLosses =pltwoLosses+1;
                try {
                    databaseHelper.updateScore(playerOneName,ploneWin,plonelosses,plonetie);
                    databaseHelper.updateScore(playerTwoName,pltwoWin,pltwoLosses,pltwoTie);
                    Toast.makeText(this, "Score Updated", Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
                }

            }
            else if(btn1.getText()=="O" &&btn5.getText()=="O" &&btn9.getText()=="O"){
                info.setText("Player Two Win!");
                pltwoWin = pltwoWin +1;
                plonelosses =plonelosses+1;
                try {
                    databaseHelper.updateScore(playerOneName,ploneWin,plonelosses,plonetie);
                    databaseHelper.updateScore(playerTwoName,pltwoWin,pltwoLosses,pltwoTie);
                    Toast.makeText(this, "Score Updated", Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
                }

            }
            else if(btn3.getText()=="X" &&btn6.getText()=="X" &&btn9.getText()=="X"){
                info.setText("Player One Win!");
                ploneWin = ploneWin +1;
                pltwoLosses =pltwoLosses+1;
                try {
                    databaseHelper.updateScore(playerOneName,ploneWin,plonelosses,plonetie);
                    databaseHelper.updateScore(playerTwoName,pltwoWin,pltwoLosses,pltwoTie);
                    Toast.makeText(this, "Score Updated", Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
                }

            }
            else if(btn3.getText()=="O" &&btn6.getText()=="O" &&btn9.getText()=="O"){
                info.setText("Player Two Win!");
                pltwoWin = pltwoWin +1;
                plonelosses =plonelosses+1;
                try {
                    databaseHelper.updateScore(playerOneName,ploneWin,plonelosses,plonetie);
                    databaseHelper.updateScore(playerTwoName,pltwoWin,pltwoLosses,pltwoTie);
                    Toast.makeText(this, "Score Updated", Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
                }

            }
            else if(btn7.getText()=="X" &&btn8.getText()=="X" &&btn9.getText()=="X"){
                info.setText("Player One Win!");
                ploneWin = ploneWin +1;
                pltwoLosses =pltwoLosses+1;
                try {
                    databaseHelper.updateScore(playerOneName,ploneWin,plonelosses,plonetie);
                    databaseHelper.updateScore(playerTwoName,pltwoWin,pltwoLosses,pltwoTie);
                    Toast.makeText(this, "Score Updated", Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
                }

            }
            else if(btn7.getText()=="O" &&btn8.getText()=="O" &&btn9.getText()=="O"){
                info.setText("Player Two Win!");
                pltwoWin = pltwoWin +1;
                plonelosses =plonelosses+1;
                try {
                    databaseHelper.updateScore(playerOneName,ploneWin,plonelosses,plonetie);
                    databaseHelper.updateScore(playerTwoName,pltwoWin,pltwoLosses,pltwoTie);
                    Toast.makeText(this, "Score Updated", Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
                }

            }

            else{
                info.setText("Game Tie!");
                plonetie= pltwoTie+1;
                pltwoTie= pltwoTie+1;
                try {
                    databaseHelper.updateScore(playerOneName,ploneWin,plonelosses,plonetie);
                    databaseHelper.updateScore(playerTwoName,pltwoWin,pltwoLosses,pltwoTie);
                    Toast.makeText(this, "Score Updated", Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
                }


            }



    }
}