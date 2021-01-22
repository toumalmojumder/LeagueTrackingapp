package com.jg.leaguetrackingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditActivity extends AppCompatActivity {
EditText updateET;
Button cancelbtn,editbtn;
String sessionid,sessionname,sessionwin,sessionlosses,sessiontie;
DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        updateET = findViewById(R.id.editTexteditPlayer);
        cancelbtn = findViewById(R.id.btnCancel);
        editbtn = findViewById(R.id.btnedit);
        databaseHelper = new DatabaseHelper(EditActivity.this);

        sessionid = getIntent().getStringExtra("idToUpdate");
        sessionname = getIntent().getStringExtra("nameToUpdate");
        sessionwin = getIntent().getStringExtra("winToUpdate");
        sessionlosses = getIntent().getStringExtra("lossesToUpdate");
        sessiontie = getIntent().getStringExtra("tieToUpdate");

        updateET.setText(sessionname);
        cancelbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EditActivity.this,AddPlayerActivity.class);
                startActivity(intent);
            }
        });

        editbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String updatedName = updateET.getText().toString();

                if(updatedName!=null){
                    Toast.makeText(EditActivity.this, updatedName, Toast.LENGTH_SHORT).show();
try {

    databaseHelper.updateData(sessionid,updatedName,Integer.parseInt(sessionwin),Integer.parseInt(sessionlosses),Integer.parseInt(sessiontie));
}catch (Exception e){
    Toast.makeText(EditActivity.this, e.toString(), Toast.LENGTH_LONG).show();
}
Intent intent = new Intent(EditActivity.this,AddPlayerActivity.class);
startActivity(intent);

                }
                else {
                    Toast.makeText(EditActivity.this, "Please Add a Name", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}