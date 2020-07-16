package com.fitness.fitness.ExerciseGetter;

public class Workout {
    Exercise mExercise;
    int count;
    boolean mTypeTime;


    public Exercise getExercise() {
        return mExercise;
    }

    public int getCount() {
        return count;
    }

    public boolean getType() {
        return mTypeTime;
    }

    public Workout(Exercise exercise,int count1,boolean type1)
    {
        mExercise = exercise;
        count = count1;
        mTypeTime = type1;
    }
}
