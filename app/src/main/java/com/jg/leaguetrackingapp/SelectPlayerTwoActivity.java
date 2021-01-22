package com.jg.leaguetrackingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.jg.leaguetrackingapp.Adapters.MyAdapterThree;
import com.jg.leaguetrackingapp.Adapters.MyAdapterTwo;
import com.jg.leaguetrackingapp.Model.Player;

import java.util.ArrayList;

public class SelectPlayerTwoActivity extends AppCompatActivity {
    ListView l2;
    MyAdapterThree adapter;
    ArrayList<Player> arrayList= null;
    DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_player_two);

        databaseHelper = new DatabaseHelper(this);

        l2 = findViewById(R.id.playerSelectListView);

        arrayList =  databaseHelper.getAllData();

        adapter = new MyAdapterThree(this, arrayList);
        l2.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}