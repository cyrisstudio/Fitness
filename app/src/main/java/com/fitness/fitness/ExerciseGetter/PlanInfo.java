package com.fitness.fitness.ExerciseGetter;

public class PlanInfo {

    String mPlanName;
    String mLevel;
    int mPhoto;
    String mTime;
    public String getTime() {
        return mTime;
    }


    public PlanInfo(String planName, String level, int photo, String time)
    {
        mPlanName = planName;
        mLevel = level;
        mPhoto = photo;
        mTime = time;
    }
    public String getPlanName() {
        return mPlanName;
    }

    public String getLevel() {
        return mLevel;
    }

    public int getPhotoId() {
        return mPhoto;
    }

}
