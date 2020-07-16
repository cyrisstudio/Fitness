package com.fitness.fitness;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.fitness.fitness.Adapters.Plan30Adapter;

import java.util.ArrayList;
import java.util.List;

public class Plan30Day extends AppCompatActivity {

    RecyclerView mRecyclerViewWk1,mRecyclerViewWk2,mRecyclerViewWk3,mRecyclerViewWk4;
    String mPlanName;
    String LOG = getClass().getName();
    ImageView imageMenuBar;
    int imageId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_plan30_day);

        Toolbar toolbar = findViewById(R.id.toolbar_plan_30_day);
        toolbar.setTitle(mPlanName);
        setSupportActionBar(toolbar);
        mPlanName = getIntent().getStringExtra(getString(R.string.name_intent));
        imageMenuBar = findViewById(R.id.image_plan_30_day);
        imageId = getIntent().getIntExtra(getString(R.string.image_intent),0);
        try{
            imageMenuBar.setImageDrawable(getDrawable(imageId));
        }catch (Exception e)
        {
            Log.i(LOG,e.getMessage());
        }



        SharedPreferences preferences = getApplicationContext().getSharedPreferences(mPlanName,MODE_PRIVATE);
        Log.i("dayCount",String.valueOf(preferences.getInt(mPlanName,0))+mPlanName);
        RecyclerViewOperation();



    }

    private void RecyclerViewOperation() {
        mRecyclerViewWk1 = findViewById(R.id.recyclerview_plan_30_wk1);
        mRecyclerViewWk2 = findViewById(R.id.recyclerview_plan_30_wk2);
        mRecyclerViewWk3 = findViewById(R.id.recyclerview_plan_30_wk3);
        mRecyclerViewWk4 = findViewById(R.id.recyclerview_plan_30_wk4);

        mRecyclerViewWk1.setLayoutManager(new GridLayoutManager(this,4));
        mRecyclerViewWk2.setLayoutManager(new GridLayoutManager(this,4));
        mRecyclerViewWk3.setLayoutManager(new GridLayoutManager(this,4));
        mRecyclerViewWk4.setLayoutManager(new GridLayoutManager(this,4));

        Plan30Adapter adapter1,adapter2,adapter3,adapter4;
        adapter1 = new Plan30Adapter(this,mPlanName,getString(R.string.week1));
        adapter2 = new Plan30Adapter(this,mPlanName,getString(R.string.week2));
        adapter3 = new Plan30Adapter(this,mPlanName,getString(R.string.week3));
        adapter4 = new Plan30Adapter(this,mPlanName,getString(R.string.week4));

        mRecyclerViewWk1.setAdapter(adapter1);
        mRecyclerViewWk2.setAdapter(adapter2);
        mRecyclerViewWk3.setAdapter(adapter3);
        mRecyclerViewWk4.setAdapter(adapter4);


    }
}