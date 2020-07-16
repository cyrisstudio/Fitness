package com.fitness.fitness.ExerciseData;

import android.content.Context;

import com.fitness.fitness.ExerciseGetter.Exercise;
import com.fitness.fitness.R;

public class AllExercise {


    private Context context;
    Exercise mQuadStretch,mRightSidePlankCrunch,mShoulderCircle,mShoulderPushUp,mStraightArmp,mBicepsStretch,
            mBridge,mCalfRaise,mCrossPunchRoll,mCrunch,mHamstringStretch,mItbandStretch,mJogInPlace,mJumpSquat,
            mJupingJack,mKickBack,mLeftLegRaise,mLeftSideLying,mLeftSidePlankCrunch,mLegLoweringDrill,mLowerSideToSideLunge
            ,mLungeWithArmReach,mLunges,mMountainClimb,mPlankWithLegLift,mPushUpAmpRotation,mRightLegRaise,mSquats,
            mWideStandSquats,mStepUpOntoChair,mSumoSquats,mTableTopDip,mWallMountainClimber,mWallExercise,mPushUp;
    public AllExercise(Context ctx)
    {
        context = ctx;
        mQuadStretch = new Exercise(context.getDrawable(R.drawable.quad_stretch), context.getString(R.string.quad_stretch_name), context.getString(R.string.quad_stretch));
        mRightSidePlankCrunch = new Exercise(context.getDrawable(R.drawable.right_side_plank_crunch), context.getString(R.string.right_side_plank_crunch_name), context.getString(R.string.right_side_plank_crunch));
        mShoulderCircle = new Exercise(context.getDrawable(R.drawable.shoulder_circle), context.getString(R.string.shoulder_circle_name), context.getString(R.string.shoulder_circle));
        mShoulderPushUp = new Exercise(context.getDrawable(R.drawable.shoulder_push_up), context.getString(R.string.shoulder_pushup_name), context.getString(R.string.shoulder_push_up));
        mStraightArmp = new Exercise(context.getDrawable(R.drawable.straight_arm_plank), context.getString(R.string.straight_armp_name), context.getString(R.string.straight_armp));
        mWallExercise = new Exercise(context.getDrawable(R.drawable.wall_mountain_climber), context.getString(R.string.wall_mountain_climber_name), context.getString(R.string.wall_exercise));
        mPushUp = new Exercise(context.getDrawable(R.drawable.push_up), context.getString(R.string.pushup_name), context.getString(R.string.push_up));
        mBicepsStretch = new Exercise(context.getDrawable(R.drawable.biceps_stretch), context.getString(R.string.biceps_stretch_name), context.getString(R.string.push_up));
        mBridge = new Exercise(context.getDrawable(R.drawable.bridge), context.getString(R.string.bridge_name), context.getString(R.string.push_up));
        mCalfRaise = new Exercise(context.getDrawable(R.drawable.calf_raise), context.getString(R.string.calf_raise_name), context.getString(R.string.push_up));
        mCrossPunchRoll = new Exercise(context.getDrawable(R.drawable.cross_punch_roll), context.getString(R.string.cross_punch_roll_name), context.getString(R.string.push_up));
        mCrunch = new Exercise(context.getDrawable(R.drawable.crunch), context.getString(R.string.crunch_name), context.getString(R.string.push_up));
        mHamstringStretch = new Exercise(context.getDrawable(R.drawable.hamstring_stretch), context.getString(R.string.hamstring_stretch_name), context.getString(R.string.push_up));
        mItbandStretch = new Exercise(context.getDrawable(R.drawable.itbend_stretch), context.getString(R.string.itband_stretch_name), context.getString(R.string.push_up));
        mJogInPlace = new Exercise(context.getDrawable(R.drawable.jog_in_place), context.getString(R.string.jog_in_place_name), context.getString(R.string.push_up));
        mJumpSquat = new Exercise(context.getDrawable(R.drawable.jump_squat), context.getString(R.string.jump_squat_name), context.getString(R.string.push_up));
        mJupingJack = new Exercise(context.getDrawable(R.drawable.jumping_jack), context.getString(R.string.jumping_jack_name), context.getString(R.string.push_up));
        mKickBack = new Exercise(context.getDrawable(R.drawable.kickback), context.getString(R.string.kick_back_name), context.getString(R.string.push_up));
        mLeftLegRaise = new Exercise(context.getDrawable(R.drawable.left_leg_raise), context.getString(R.string.left_leg_raise_name), context.getString(R.string.push_up));
        mLeftSideLying = new Exercise(context.getDrawable(R.drawable.left_side_lying), context.getString(R.string.left_leg_side_lying_name), context.getString(R.string.push_up));
        mLeftSidePlankCrunch = new Exercise(context.getDrawable(R.drawable.left_side_plank_crunch), context.getString(R.string.left_side_plank_crunch_name), context.getString(R.string.push_up));
        mLegLoweringDrill = new Exercise(context.getDrawable(R.drawable.leg_lowering_drill), context.getString(R.string.leg_lowering_drill_name), context.getString(R.string.push_up));
        mLowerSideToSideLunge = new Exercise(context.getDrawable(R.drawable.lower_side_to_side_lunge), context.getString(R.string.lower_side_to_side_lunge_name), context.getString(R.string.push_up));
        mLungeWithArmReach = new Exercise(context.getDrawable(R.drawable.lunge_with_arm_reach), context.getString(R.string.lunge_with_arm_reach_name), context.getString(R.string.push_up));
        mLunges = new Exercise(context.getDrawable(R.drawable.lunges), context.getString(R.string.lunges_name), context.getString(R.string.push_up));
        mMountainClimb = new Exercise(context.getDrawable(R.drawable.mountain_climber), context.getString(R.string.mountain_climb_name), context.getString(R.string.push_up));
        mPlankWithLegLift = new Exercise(context.getDrawable(R.drawable.plank_with_leg_lift), context.getString(R.string.plank_with_leg_lift_name), context.getString(R.string.push_up));
        mPushUpAmpRotation = new Exercise(context.getDrawable(R.drawable.push_up_amp_rotation), context.getString(R.string.pushup_amp_rotation_name), context.getString(R.string.push_up));
        mSquats = new Exercise(context.getDrawable(R.drawable.squats), context.getString(R.string.squats_name), context.getString(R.string.push_up));
        mRightLegRaise = new Exercise(context.getDrawable(R.drawable.right_leg_raise), context.getString(R.string.right_leg_raise_name), context.getString(R.string.push_up));
        mWideStandSquats = new Exercise(context.getDrawable(R.drawable.wide_stand_squats), context.getString(R.string.wide_stand_squats_name), context.getString(R.string.push_up));
        mStepUpOntoChair = new Exercise(context.getDrawable(R.drawable.step_up_onto_chair), context.getString(R.string.step_up_onto_chair_name), context.getString(R.string.push_up));
        mSumoSquats = new Exercise(context.getDrawable(R.drawable.sumo_squats), context.getString(R.string.sumo_squats_name), context.getString(R.string.push_up));
        mTableTopDip = new Exercise(context.getDrawable(R.drawable.table_top_dip), context.getString(R.string.table_top_dip_name), context.getString(R.string.push_up));
        mWallMountainClimber = new Exercise(context.getDrawable(R.drawable.wall_mountain_climber), context.getString(R.string.wall_mountain_climber_name), context.getString(R.string.push_up));
    }




}
