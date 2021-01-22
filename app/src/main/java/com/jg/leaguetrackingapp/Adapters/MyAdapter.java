package com.jg.leaguetrackingapp.Adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.jg.leaguetrackingapp.AddPlayerActivity;
import com.jg.leaguetrackingapp.DatabaseHelper;
import com.jg.leaguetrackingapp.EditActivity;
import com.jg.leaguetrackingapp.MainActivity;
import com.jg.leaguetrackingapp.Model.Player;
import com.jg.leaguetrackingapp.R;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    Context context;

    ArrayList<Player> arrayList;

    DatabaseHelper databaseHelper;

    public MyAdapter(Context context, ArrayList<Player> arrayList, DatabaseHelper databaseHelper){
        this.context = context;
        this.arrayList = arrayList;
        this.databaseHelper = databaseHelper;

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
    public View getView(int i, View convertView, final ViewGroup viewGroup) {

            final LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_view_row_layout,null);
            final TextView t1_id = convertView.findViewById(R.id.t1_id);
            final TextView t1_name = convertView.findViewById(R.id.t1_name);
            Button t1_Edit = convertView.findViewById(R.id.t1_edit);
            Button t1_Delete = convertView.findViewById(R.id.t1_delete);



        final Player player = arrayList.get(i);

            t1_id.setText(String.valueOf(player.get_id()));
            t1_name.setText(player.getName());

t1_Edit.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(context, EditActivity.class);
        intent.putExtra("idToUpdate",String.valueOf(player.get_id()));
        intent.putExtra("nameToUpdate",String.valueOf(player.getName()));
        intent.putExtra("winToUpdate",String.valueOf(player.getWins()) );
        intent.putExtra("lossesToUpdate",String.valueOf(player.getLosses()));
        intent.putExtra("tieToUpdate",String.valueOf(player.getTies()));

        context.startActivity(intent);


    }
});
t1_Delete.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        databaseHelper.deleteData(t1_name.getText().toString());
        Intent intent =new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }
});

        return convertView;
    }
}
