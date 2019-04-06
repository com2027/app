package com.kierigby.bountyhunter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class StatsActivity extends AppCompatActivity {

    private ArrayList<String> mStatName = new ArrayList<>();
    private ArrayList<String> mActualStat = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);
        initStatList();
    }

    private void initStatList() {
        mStatName.add("Games Played");
        mActualStat.add("-");

        mStatName.add("Total Points");
        mActualStat.add("-");

        mStatName.add("Challenges Completed");
        mActualStat.add("-");

        mStatName.add("Challenges Failed");
        mActualStat.add("-");

        mStatName.add("Games Won");
        mActualStat.add("-");

        initRecyclerView();
    }

    private void initRecyclerView(){

        RecyclerView recyclerView = findViewById(R.id.fugitive_recycler_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mStatName, mActualStat);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
