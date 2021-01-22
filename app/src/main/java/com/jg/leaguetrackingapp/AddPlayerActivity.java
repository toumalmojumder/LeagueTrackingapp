package com.jg.leaguetrackingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.jg.leaguetrackingapp.Adapters.MyAdapter;
import com.jg.leaguetrackingapp.Model.Player;

import java.util.ArrayList;

public class AddPlayerActivity extends AppCompatActivity {
    EditText text_AddPlayer;
    Button btnAdd,btnClose;
    ListView l1;
    DatabaseHelper databaseHelper;
    MyAdapter adapter;
    ArrayList<Player> arrayList= null;
    String UpdatedName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_player);

          text_AddPlayer = findViewById(R.id.editTextAddPlayer);
          btnAdd = findViewById(R.id.btnAdd);
          btnClose = findViewById(R.id.btnClose);
          databaseHelper = new DatabaseHelper(this);
          UpdatedName = getIntent().getStringExtra("UpdatedName");


            arrayList =  databaseHelper.getAllData();
            l1 = findViewById(R.id.list_view);
            adapter = new MyAdapter(this, arrayList,databaseHelper);
            l1.setAdapter(adapter);
            adapter.notifyDataSetChanged();



btnAdd.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        String newPlayer = text_AddPlayer.getText().toString();
        if(newPlayer!= null){
            Boolean insertData= databaseHelper.addData(newPlayer,0,0,0);
            if(insertData){
                Toast.makeText(AddPlayerActivity.this, "Player Added", Toast.LENGTH_SHORT).show();

            }
            else{
                Toast.makeText(AddPlayerActivity.this, "Something Went wrong", Toast.LENGTH_SHORT).show();
            }
        }
        else{
            Toast.makeText(AddPlayerActivity.this, "Please Write a Name...", Toast.LENGTH_SHORT).show();
        }
        Intent intent =new Intent(AddPlayerActivity.this,MainActivity.class);
        startActivity(intent);
    }

});
btnClose.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent =new Intent(AddPlayerActivity.this,MainActivity.class);
        startActivity(intent);
    }
});
    }


}