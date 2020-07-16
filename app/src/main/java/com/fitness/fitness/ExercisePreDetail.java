package com.fitness.fitness;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.fitness.fitness.Adapters.PreExerciseAdapter;
import com.fitness.fitness.ExerciseData.ExercisePlans;
import com.fitness.fitness.ExerciseGetter.Exercise;
import com.fitness.fitness.ExerciseGetter.Workout;
import com.google.android.material.appbar.AppBarLayout;

import java.util.ArrayList;
import java.util.List;

public class ExercisePreDetail extends AppCompatActivity {

    String LOG = getClass().getName();
    RecyclerView mRecyclerView;
    Button mButtonStart;
    String mExerciseName,mWeek;
    int mDay;
    TextView mTextExerciseCount;
    PreExerciseAdapter preExerciseAdapter;
    List<Workout> workouts;
    ImageView mImagePreDetail;
    AppBarLayout appBarLayout;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_pre_detail);
         Toolbar toolbar = findViewById(R.id.toolbar_exercise_pre_detail);

         appBarLayout = findViewById(R.id.appbar_layout_pre_exercise);

        mRecyclerView = findViewById(R.id.recyclerview_pre_plan);
        mButtonStart = findViewById(R.id.button_start_pre_plan);
        mImagePreDetail = findViewById(R.id.image_exercise_pre_detail);

        //mTextTime = findViewById(R.id.time_pre_exercise);
        mTextExerciseCount = findViewById(R.id.exercise_count_pre_exercise);
        mExerciseName = getIntent().getStringExtra(getString(R.string.name_intent));
        mWeek = getIntent().getStringExtra(getString(R.string.week_count_intent));
        mDay = getIntent().getIntExtra(getString(R.string.day_count_intent),1);
        Log.i(LOG,String.valueOf(mDay));
        toolbar.setTitle(mExerciseName);
        int imageLocation = getIntent().getIntExtra(getString(R.string.image_intent),0);
        //Glide.with(this).load()
        try{
            mImagePreDetail.setImageDrawable(getDrawable(imageLocation));
        }catch (Exception e)
        {
            Log.i(LOG,e.getMessage());
        }
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                
            }
        });



        //mTextExerciseName.setText(mExerciseName);
        Log.i("PlanInfo",mExerciseName+","+ mWeek+","+mDay);


        WorkoutPlans();
        mButtonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ExercisePreDetail.this,StartExercise.class);
                intent.putExtra(getString(R.string.name_intent),mExerciseName);
                intent.putExtra(getString(R.string.week_count_intent),mWeek);
                intent.putExtra(getString(R.string.day_count_intent),mDay);
                startActivity(intent);
                ExercisePreDetail.this.finish();
            }
        });




    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void WorkoutPlans() {
        mRecyclerView.setLayoutManager(new GridLayoutManager(this,3));
        ExercisePlans exercisePlans = new ExercisePlans(this);

        if(mExerciseName!=null)
        switch (mExerciseName)
        {
            case "Abs Beginner": workouts = exercisePlans.getAbsBeginner();
                preExerciseAdapter = new PreExerciseAdapter(this,workouts);

                SpannigTextview();
                // mTextExerciseCount.setText(String.valueOf(workouts.size())+" Exercises");
                break;
            case "Our Plan": OurPlanWeek();
                preExerciseAdapter = new PreExerciseAdapter(this,workouts);
                //SpannigTextview();
                //mTextExerciseCount.setText(String.valueOf(workouts.size())+" Exercises");
                    break;
            case "Fiit Plan":
                OurPlanWeek();
                preExerciseAdapter = new PreExerciseAdapter(this,workouts);
                SpannigTextview();
                //mTextExerciseCount.setText(String.valueOf(workouts.size())+" Exercises");
                break;
        }

        if(preExerciseAdapter!=null)
            mRecyclerView.setAdapter(preExerciseAdapter);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void SpannigTextview() {
        String string = String.valueOf(workouts.size())+" Exercises";
        Spannable spannable = new SpannableString(string);
        spannable.setSpan(new ForegroundColorSpan(getColor(R.color.darkBlue)),0,1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        mTextExerciseCount.setText(spannable, TextView.BufferType.SPANNABLE);
    }

    private void OurPlanWeek() {
        switch (mWeek)
        {
            case "Week 1": OurPlanWeek1();
                    Log.i("PlanInfo","Working");break;
            case "Week 2": OurPlanWeek2();break;
            case "Week 3": OurPlanWeek1();break;
            case "Week 4": OurPlanWeek2();break;
        }
    }

    private void OurPlanWeek1() {
        ExercisePlans exercisePlans = new ExercisePlans(this);
        switch (mDay)
        {
            case 0: workouts = exercisePlans.getFitDay1();break;
            case 1: workouts = exercisePlans.getFitDay1();break;
            case 2: workouts = exercisePlans.getFitDay1();break;
            case 3: workouts = exercisePlans.getFitDay1();break;
            case 4: workouts = exercisePlans.getFitDay1();break;
            case 5: workouts = exercisePlans.getFitDay1();break;
            case 6: workouts = exercisePlans.getFitDay1();break;
        }
    }
    private void OurPlanWeek2() {
        ExercisePlans exercisePlans = new ExercisePlans(this);
        Log.i(LOG+"Day",String.valueOf(mDay));
        switch (mDay)
        {
            case 0: workouts = exercisePlans.getFitDay1();break;
            case 1: workouts = exercisePlans.getFitDay2();break;
            case 2: workouts = exercisePlans.getFitDay1();break;
            case 3: workouts = exercisePlans.getFitDay2();break;
            case 4: workouts = exercisePlans.getFitDay2();break;
            case 5: workouts = exercisePlans.getFitDay2();break;
            case 6: workouts = exercisePlans.getFitDay1();break;
        }
    }
}