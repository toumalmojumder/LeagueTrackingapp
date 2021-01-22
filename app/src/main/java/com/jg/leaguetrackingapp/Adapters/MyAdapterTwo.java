package com.jg.leaguetrackingapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.jg.leaguetrackingapp.DatabaseHelper;
import com.jg.leaguetrackingapp.MainActivity;
import com.jg.leaguetrackingapp.Model.Player;
import com.jg.leaguetrackingapp.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MyAdapterTwo extends BaseAdapter {
    Context context;
    ArrayList<Player> arrayList;

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String PlayerONE = "sharedPrefone";
    public static final String PlayerONEWin = "PlayerONEWin";
    public static final String PlayerONELosses = "PlayerONELosses";
    public static final String PlayerONETie = "PlayerONETie";

    String text;


    public MyAdapterTwo(Context context, ArrayList<Player> arrayList){
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return this.arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int i, View convertView, ViewGroup viewGroup) {
        final LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.select_player_listview_row,null);
        final TextView t1_id = convertView.findViewById(R.id.playerSelectListViewRowId);
        final TextView t1_name = convertView.findViewById(R.id.playerSelectListViewRowName);
        Button t1_select = convertView.findViewById(R.id.t1_select);
        Button t1_Cancel = convertView.findViewById(R.id.t1_Cancel);



        final Player player = arrayList.get(i);

        t1_id.setText(String.valueOf(player.get_id()));
        t1_name.setText(player.getName());

        t1_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFS,Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(PlayerONE,player.getName());
                editor.putInt(PlayerONEWin,player.getWins());
                editor.putInt(PlayerONELosses,player.getLosses());
                editor.putInt(PlayerONETie,player.getTies());
                editor.apply();

                Toast.makeText(context, "Player One Selected", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, MainActivity.class);
                context.startActivity(intent);

            }
        });

        t1_Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFS,Context.MODE_PRIVATE);
                text = sharedPreferences.getString(PlayerONE,"");
                Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
                */

                Intent intent = new Intent(context, MainActivity.class);
                context.startActivity(intent);
            }
        });
        return convertView;
    }
}
