package com.jg.leaguetrackingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.jg.leaguetrackingapp.Adapters.MyAdapterTwo;
import com.jg.leaguetrackingapp.Adapters.MyAdapterfour;
import com.jg.leaguetrackingapp.Model.Player;

import java.util.ArrayList;

public class ScoreBoardActivity extends AppCompatActivity {

    ListView l4;
    MyAdapterfour adapter;
    ArrayList<Player> arrayList= null;
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_board);

        databaseHelper = new DatabaseHelper(this);

        l4 = findViewById(R.id.scoreBoardListView);

        arrayList =  databaseHelper.getAllData();

        adapter = new MyAdapterfour(this, arrayList);
        l4.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }
}