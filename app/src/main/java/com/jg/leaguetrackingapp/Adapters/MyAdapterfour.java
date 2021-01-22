package com.jg.leaguetrackingapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.jg.leaguetrackingapp.Model.Player;
import com.jg.leaguetrackingapp.R;

import java.util.ArrayList;

public class MyAdapterfour extends BaseAdapter {
    Context context;
    ArrayList<Player> arrayList;

    public MyAdapterfour(Context context, ArrayList<Player> arrayList){
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
    public View getView(int i, View convertView, ViewGroup viewGroup) {

        final LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.scoreboard_listview_row,null);
        final TextView scoreID = convertView.findViewById(R.id.scoreid);
        final TextView scoreName = convertView.findViewById(R.id.scoreName);
        final TextView scoreWin = convertView.findViewById(R.id.scoreWin);
        final TextView scoreLosses = convertView.findViewById(R.id.scoreLosses);
        final TextView scoreTie = convertView.findViewById(R.id.scoreTie);

        final Player player = arrayList.get(i);

        scoreID.setText(String.valueOf(player.get_id()));
        scoreName.setText(player.getName());
        scoreWin.setText(String.valueOf(player.getWins()));
        scoreLosses.setText(String.valueOf(player.getLosses()));
        scoreTie.setText(String.valueOf(player.getTies()));

        return convertView;
    }
}
