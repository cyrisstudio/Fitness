package com.fitness.fitness.ExerciseData;

import android.content.Context;
import android.util.Log;

import com.fitness.fitness.ExerciseGetter.Exercise;
import com.fitness.fitness.ExerciseGetter.Workout;
import com.fitness.fitness.ExercisePreDetail;

import java.util.ArrayList;
import java.util.List;

public class ExercisePlans {
    private  List<Workout> mAbsBeginner = new ArrayList<>();
    private Context context;

    public ExercisePlans(Context ctx)
    {
        context = ctx;
    }

    public List<Workout> getAbsBeginner()
    {
        Log.i("check","Correct0");
        if(context instanceof ExercisePreDetail)
            Log.i("check","Correct1");
        AllExercise allExercise = new AllExercise(context);
        Workout wk1 = new Workout(allExercise.mQuadStretch,20,false);
        mAbsBeginner.add(wk1);
         Workout wk2 = new Workout(allExercise.mRightSidePlankCrunch,25,true);
        mAbsBeginner.add(wk2);
         Workout wk3 = new Workout(allExercise.mShoulderCircle,10,false);
        mAbsBeginner.add(wk3);
         Workout wk4 = new Workout(allExercise.mShoulderPushUp,25,true);
        mAbsBeginner.add(wk4);
         Workout wk5 = new Workout(allExercise.mStraightArmp,20,false);
        mAbsBeginner.add(wk5);
         Workout wk6 = new Workout(allExercise.mWallExercise,10,false);
        mAbsBeginner.add(wk6);
        Workout wk7 = new Workout(allExercise.mPushUp,10,false);
                mAbsBeginner.add(wk7);

        return mAbsBeginner;
    }

    public List<Workout> getFullBodyWorkout()
    {
        Log.i("check","Correct0");
        if(context instanceof ExercisePreDetail)
            Log.i("check","Correct1");
        AllExercise allExercise = new AllExercise(context);
        Workout wk1 = new Workout(allExercise.mQuadStretch,20,false);
        mAbsBeginner.add(wk1);
         Workout wk2 = new Workout(allExercise.mRightSidePlankCrunch,25,true);
        mAbsBeginner.add(wk2);
         Workout wk3 = new Workout(allExercise.mShoulderCircle,10,false);
        mAbsBeginner.add(wk3);
         Workout wk4 = new Workout(allExercise.mShoulderPushUp,25,true);
        mAbsBeginner.add(wk4);
         Workout wk5 = new Workout(allExercise.mStraightArmp,20,false);
        mAbsBeginner.add(wk5);
         Workout wk6 = new Workout(allExercise.mWallExercise,10,false);
        mAbsBeginner.add(wk6);
        Workout wk7 = new Workout(allExercise.mPushUp,10,false);
                mAbsBeginner.add(wk7);

        return mAbsBeginner;
    }
public List<Workout> getFitDay1()
    {
        Log.i("check","Correct0");
        if(context instanceof ExercisePreDetail)
            Log.i("check","Correct1");
        AllExercise allExercise = new AllExercise(context);
        Workout wk1 = new Workout(allExercise.mQuadStretch,20,false);
        mAbsBeginner.add(wk1);
         Workout wk2 = new Workout(allExercise.mRightSidePlankCrunch,25,true);
        mAbsBeginner.add(wk2);
         Workout wk3 = new Workout(allExercise.mShoulderCircle,10,false);
        mAbsBeginner.add(wk3);
         Workout wk4 = new Workout(allExercise.mShoulderPushUp,25,true);
        mAbsBeginner.add(wk4);
         Workout wk5 = new Workout(allExercise.mStraightArmp,20,false);
        mAbsBeginner.add(wk5);
         Workout wk6 = new Workout(allExercise.mWallExercise,10,false);
        mAbsBeginner.add(wk6);
        Workout wk7 = new Workout(allExercise.mPushUp,10,false);
                mAbsBeginner.add(wk7);

        return mAbsBeginner;
    }
public List<Workout> getFitDay2()
    {
        Log.i("check","Correct0");
        if(context instanceof ExercisePreDetail)
            Log.i("check","Correct1");
        AllExercise allExercise = new AllExercise(context);
        Workout wk1 = new Workout(allExercise.mQuadStretch,20,false);
        mAbsBeginner.add(wk1);
         Workout wk2 = new Workout(allExercise.mRightSidePlankCrunch,25,true);
        mAbsBeginner.add(wk2);
         Workout wk3 = new Workout(allExercise.mShoulderCircle,10,false);
        mAbsBeginner.add(wk3);
         Workout wk4 = new Workout(allExercise.mShoulderPushUp,25,true);
        mAbsBeginner.add(wk4);
         Workout wk5 = new Workout(allExercise.mStraightArmp,20,false);
        mAbsBeginner.add(wk5);
         Workout wk6 = new Workout(allExercise.mWallExercise,10,false);
        mAbsBeginner.add(wk6);
        Workout wk7 = new Workout(allExercise.mPushUp,10,false);
                mAbsBeginner.add(wk7);

        return mAbsBeginner;
    }

}
