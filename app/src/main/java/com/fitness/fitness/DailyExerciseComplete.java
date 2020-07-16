package com.fitness.fitness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.fitness.fitness.database.DataBase;
import com.fitness.fitness.database.DataEntity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DailyExerciseComplete extends AppCompatActivity {

    SharedPreferences preferences;
    String mPlanName,mWeek;
    int mDay;
    int mDayCount;
    TextView mExerciseNameText,mWeekText,mDayText,mExerciseCountText,mDateText;
    Button mDoneButton;
    int mExerciseCount,mSeekbarProgress=0;
    DataBase dataBase;
    Date myDate;
    RadioGroup radioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_exercise_complete);

        mExerciseNameText = findViewById(R.id.exercise_name_complete);
        mWeekText = findViewById(R.id.week_complete);
        mDayText = findViewById(R.id.exercise_day_complete);
        mExerciseCountText = findViewById(R.id.exercise_count_complete);
        mDateText = findViewById(R.id.today_date_complete);
        mDoneButton = findViewById(R.id.done_complete);
        radioGroup = findViewById(R.id.radio_group_exercise_complete);

        mPlanName = getIntent().getStringExtra(getString(R.string.name_intent));
        mWeek = getIntent().getStringExtra(getString(R.string.week_count_intent));
        mDay = getIntent().getIntExtra(getString(R.string.day_count_intent),1);
        mExerciseCount = getIntent().getIntExtra(getString(R.string.exercise_count_intent),1);
        preferences = getApplicationContext().getSharedPreferences(mPlanName,MODE_PRIVATE);
        mDayCount = preferences.getInt(mPlanName,0);
        Log.i("dayCheck",String.valueOf(mDay));
        dataBase = DataBase.getInstance(this);

        SetValues();
        if(mWeek!=null&&!(mDay%7<preferences.getInt(mPlanName,0)%7))
            SharedPreferencesOperation();



    }

    private void SetValues() {
        mExerciseNameText.setText(mPlanName);
        if(mWeek!=null) {
            mDayText.setVisibility(View.VISIBLE);
            mWeekText.setVisibility(View.VISIBLE);
            mDayText.setText("Day "+String.valueOf(mDay+1));
            mWeekText.setText(mWeek);
        }
        mExerciseCountText.setText(String.valueOf(mExerciseCount));
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
              switch (i)
              {
                  case R.id.radio_one: mSeekbarProgress = 1;break;
                  case R.id.radio_two: mSeekbarProgress = 2;break;
                  case R.id.radio_three: mSeekbarProgress = 3;break;
                  case R.id.radio_four: mSeekbarProgress = 4;break;
                  case R.id.radio_five: mSeekbarProgress = 5;break;
              }
            }
        });

        SimpleDateFormat timeStampFormat = new SimpleDateFormat("dd/MM/yyyy");
         myDate = new Date();
        String date = timeStampFormat.format(myDate);
        mDateText.setText(date);
        mDoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SaveAndExit();
            }
        });



    }

    private void SharedPreferencesOperation() {
        if(mDayCount<28)
        {
            Log.i("dayCount",String.valueOf(mDayCount)+mPlanName);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt(mPlanName,++mDayCount);
            editor.apply();
        }
       /* if(mDayCount==28)
        {
            SharedPreferences weekPreference = getApplicationContext().getSharedPreferences(mPlanName+getString(R.string.week1),MODE_PRIVATE);
            SharedPreferences.Editor edt = weekPreference.edit();
            edt.putBoolean(mPlanName+getString(R.string.week1),true);
            edt.apply();
        }*/
      /*  if(mDayCount>=21)
        {
            SharedPreferences weekPreference = getApplicationContext().getSharedPreferences(mPlanName+getString(R.string.week4),MODE_PRIVATE);
            SharedPreferences.Editor edt = weekPreference.edit();
            edt.putBoolean(mPlanName+getString(R.string.week4),true);
            edt.apply();
        }
        if(mDayCount>=14)
        {
            SharedPreferences weekPreference = getApplicationContext().getSharedPreferences(mPlanName+getString(R.string.week3),MODE_PRIVATE);
            SharedPreferences.Editor edt = weekPreference.edit();
            edt.putBoolean(mPlanName+getString(R.string.week3),true);
            edt.apply();
        }
        if(mDayCount>=6)
        {
            SharedPreferences weekPreference = getApplicationContext().getSharedPreferences(mPlanName+getString(R.string.week2),MODE_PRIVATE);
            SharedPreferences.Editor edt = weekPreference.edit();
            edt.putBoolean(mPlanName+getString(R.string.week2),true);
            edt.apply();
        }
        if(mDayCount<7)
        {
            SharedPreferences weekPreference = getApplicationContext().getSharedPreferences(mPlanName+getString(R.string.week1),MODE_PRIVATE);
            SharedPreferences.Editor edt = weekPreference.edit();
            edt.putBoolean(mPlanName+getString(R.string.week1),true);
            edt.apply();
        }*/
    }

    @Override
    public void onBackPressed() {
        SaveAndExit();

    }

    private void SaveAndExit() {
        if(mSeekbarProgress>0) {
            DataEntity entity = new DataEntity();
            entity.mDay = mDay;
            entity.mExerciseCount = mExerciseCount;
            entity.mPlanName = mPlanName;
            entity.mWeek = mWeek;
            entity.date = myDate;
            entity.mTiredness = mSeekbarProgress;
            new SetHistory().execute(entity);
            super.onBackPressed();
        }
        else
        {
            Toast.makeText(DailyExerciseComplete.this,"Please Select Tiredness",Toast.LENGTH_SHORT).show();
        }
    }

    class SetHistory extends AsyncTask<DataEntity,Void,Void>{

        @Override
        protected Void doInBackground(DataEntity... dataEntities) {
            dataBase.daoInterface().Insert(dataEntities[0]);
            return null;
        }
    }
}