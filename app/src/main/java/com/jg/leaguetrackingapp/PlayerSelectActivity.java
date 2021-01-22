package com.jg.leaguetrackingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.jg.leaguetrackingapp.Adapters.MyAdapter;
import com.jg.leaguetrackingapp.Adapters.MyAdapterTwo;
import com.jg.leaguetrackingapp.Model.Player;

import java.util.ArrayList;

public class PlayerSelectActivity extends AppCompatActivity {
    ListView l2;
    MyAdapterTwo adapter;
    ArrayList<Player> arrayList= null;
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_select);


        databaseHelper = new DatabaseHelper(this);

        l2 = findViewById(R.id.playerSelectListView);

        arrayList =  databaseHelper.getAllData();

        adapter = new MyAdapterTwo(this, arrayList);
        l2.setAdapter(adapter);
        adapter.notifyDataSetChanged();



    }
}