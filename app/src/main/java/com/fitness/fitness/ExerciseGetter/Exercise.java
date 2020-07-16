package com.fitness.fitness.ExerciseGetter;

import android.graphics.drawable.Drawable;

public class Exercise {
    Drawable mImageLocation;
    String mExerciseName;
    String mExerciseInfo;

    public Drawable getImageLocation() {
        return mImageLocation;
    }

    public String getExerciseName() {
        return mExerciseName;
    }

    public String getExerciseInfo() {
        return mExerciseInfo;
    }



    public Exercise(Drawable location,String name,String info)
    {
        mImageLocation =location;
        mExerciseName = name;
        mExerciseInfo = info;
    }

}
