package com.fitness.fitness.ExerciseData;

import android.content.Context;

import com.fitness.fitness.ExerciseGetter.PlanInfo;
import com.fitness.fitness.R;

import java.util.ArrayList;
import java.util.List;

public class PlanData {

     Context context;
     List<PlanInfo> specialPlan,beginnerPlan,intermediatePlan,advancePlan;
    public PlanData(Context ctx)
    {
        context = ctx;
    }

//    public List<PlanInfo> SpecialPlan(){
//        specialPlan = new ArrayList<>();
//        PlanInfo info1 = new PlanInfo(context.getString(R.string.abs_beginner),context.getString(R.string.level_beginner),context.getDrawable(R.drawable.abs),"30");
//        specialPlan.add(info1);
//        PlanInfo info2 = new PlanInfo(context.getString(R.string.abs_beginner),context.getString(R.string.level_beginner),context.getDrawable(R.drawable.biceps),"15");
//        specialPlan.add(info2);
//        PlanInfo info3 = new PlanInfo(context.getString(R.string.abs_beginner),context.getString(R.string.level_beginner),context.getDrawable(R.drawable.main_photo),"20");
//        specialPlan.add(info3);
//        PlanInfo info4 = new PlanInfo(context.getString(R.string.abs_beginner),context.getString(R.string.level_beginner),context.getDrawable(R.drawable.chest),"10");
//        specialPlan.add(info4);
//
//
//        return specialPlan;
//    }
//
//    public List<PlanInfo> BeginnerPlan(){
//            beginnerPlan = new ArrayList<>();
//            PlanInfo info1 = new PlanInfo(context.getString(R.string.abs_beginner),context.getString(R.string.level_beginner),context.getDrawable(R.drawable.main_photo),"25");
//            beginnerPlan.add(info1);
//            PlanInfo info2 = new PlanInfo(context.getString(R.string.abs_beginner),context.getString(R.string.level_beginner),context.getDrawable(R.drawable.chest),"50");
//            beginnerPlan.add(info2);
//            PlanInfo info3 = new PlanInfo(context.getString(R.string.abs_beginner),context.getString(R.string.level_beginner),context.getDrawable(R.drawable.biceps),"30");
//            beginnerPlan.add(info3);
//            PlanInfo info4 = new PlanInfo(context.getString(R.string.abs_beginner),context.getString(R.string.level_beginner),context.getDrawable(R.drawable.abs),"20");
//            beginnerPlan.add(info4);
//
//
//            return beginnerPlan;
//        }
//
//        public List<PlanInfo> IntermediatePlan(){
//            intermediatePlan = new ArrayList<>();
//            PlanInfo info1 = new PlanInfo(context.getString(R.string.abs_beginner),context.getString(R.string.level_beginner),context.getDrawable(R.drawable.chest),"10");
//            intermediatePlan.add(info1);
//            PlanInfo info2 = new PlanInfo(context.getString(R.string.abs_beginner),context.getString(R.string.level_beginner),context.getDrawable(R.drawable.abs),"40");
//            intermediatePlan.add(info2);
//            PlanInfo info3 = new PlanInfo(context.getString(R.string.abs_beginner),context.getString(R.string.level_beginner),context.getDrawable(R.drawable.biceps),"30");
//            intermediatePlan.add(info3);
//            PlanInfo info4 = new PlanInfo(context.getString(R.string.abs_beginner),context.getString(R.string.level_beginner),context.getDrawable(R.drawable.main_photo),"20");
//            intermediatePlan.add(info4);
//
//
//            return intermediatePlan;
//        }
//
//        public List<PlanInfo> AdvancePlan(){
//            advancePlan = new ArrayList<>();
//            PlanInfo info1 = new PlanInfo(context.getString(R.string.abs_beginner),context.getString(R.string.level_beginner),context.getDrawable(R.drawable.chest),"20");
//            advancePlan.add(info1);
//            PlanInfo info2 = new PlanInfo(context.getString(R.string.abs_beginner),context.getString(R.string.level_beginner),context.getDrawable(R.drawable.main_photo),"10");
//            advancePlan.add(info2);
//            PlanInfo info3 = new PlanInfo(context.getString(R.string.abs_beginner),context.getString(R.string.level_beginner),context.getDrawable(R.drawable.abs),"30");
//            advancePlan.add(info3);
//            PlanInfo info4 = new PlanInfo(context.getString(R.string.abs_beginner),context.getString(R.string.level_beginner),context.getDrawable(R.drawable.biceps),"55");
//            advancePlan.add(info4);
//
//
//            return advancePlan;
//        }
//    public List<PlanInfo> OurPlan(){
//                advancePlan = new ArrayList<>();
//                PlanInfo info1 = new PlanInfo(context.getString(R.string.our_plan),context.getString(R.string.level_beginner),context.getDrawable(R.drawable.main_photo),"20");
//                advancePlan.add(info1);
//                PlanInfo info2 = new PlanInfo(context.getString(R.string.fiit_plan),context.getString(R.string.level_beginner),context.getDrawable(R.drawable.biceps),"20");
//                advancePlan.add(info2);
//                PlanInfo info3 = new PlanInfo(context.getString(R.string.hiit_plan),context.getString(R.string.level_beginner),context.getDrawable(R.drawable.chest),"30");
//                advancePlan.add(info3);
//                PlanInfo info4 = new PlanInfo(context.getString(R.string.set_plan),context.getString(R.string.level_beginner),context.getDrawable(R.drawable.abs),"55");
//                advancePlan.add(info4);
//
//
//                return advancePlan;
//            }

    public List<PlanInfo> SpecialPlan(){
        specialPlan = new ArrayList<>();
        PlanInfo info1 = new PlanInfo(context.getString(R.string.abs_beginner),context.getString(R.string.level_beginner),R.drawable.abs,"30");
        specialPlan.add(info1);
        PlanInfo info2 = new PlanInfo(context.getString(R.string.abs_beginner),context.getString(R.string.level_beginner),R.drawable.biceps,"15");
        specialPlan.add(info2);
        PlanInfo info3 = new PlanInfo(context.getString(R.string.abs_beginner),context.getString(R.string.level_beginner),R.drawable.main_photo,"20");
        specialPlan.add(info3);
        PlanInfo info4 = new PlanInfo(context.getString(R.string.abs_beginner),context.getString(R.string.level_beginner),R.drawable.chest,"10");
        specialPlan.add(info4);


        return specialPlan;
    }

    public List<PlanInfo> BeginnerPlan(){
            beginnerPlan = new ArrayList<>();
            PlanInfo info1 = new PlanInfo(context.getString(R.string.abs_beginner),context.getString(R.string.level_beginner),R.drawable.main_photo,"25");
            beginnerPlan.add(info1);
            PlanInfo info2 = new PlanInfo(context.getString(R.string.abs_beginner),context.getString(R.string.level_beginner),R.drawable.chest,"50");
            beginnerPlan.add(info2);
            PlanInfo info3 = new PlanInfo(context.getString(R.string.abs_beginner),context.getString(R.string.level_beginner),R.drawable.biceps,"30");
            beginnerPlan.add(info3);
            PlanInfo info4 = new PlanInfo(context.getString(R.string.abs_beginner),context.getString(R.string.level_beginner),R.drawable.abs,"20");
            beginnerPlan.add(info4);


            return beginnerPlan;
        }

        public List<PlanInfo> IntermediatePlan(){
            intermediatePlan = new ArrayList<>();
            PlanInfo info1 = new PlanInfo(context.getString(R.string.abs_beginner),context.getString(R.string.level_beginner),R.drawable.chest,"10");
            intermediatePlan.add(info1);
            PlanInfo info2 = new PlanInfo(context.getString(R.string.abs_beginner),context.getString(R.string.level_beginner),R.drawable.abs,"40");
            intermediatePlan.add(info2);
            PlanInfo info3 = new PlanInfo(context.getString(R.string.abs_beginner),context.getString(R.string.level_beginner),R.drawable.biceps,"30");
            intermediatePlan.add(info3);
            PlanInfo info4 = new PlanInfo(context.getString(R.string.abs_beginner),context.getString(R.string.level_beginner),R.drawable.main_photo,"20");
            intermediatePlan.add(info4);


            return intermediatePlan;
        }

        public List<PlanInfo> AdvancePlan(){
            advancePlan = new ArrayList<>();
            PlanInfo info1 = new PlanInfo(context.getString(R.string.abs_beginner),context.getString(R.string.level_beginner),R.drawable.chest,"20");
            advancePlan.add(info1);
            PlanInfo info2 = new PlanInfo(context.getString(R.string.abs_beginner),context.getString(R.string.level_beginner),R.drawable.main_photo,"10");
            advancePlan.add(info2);
            PlanInfo info3 = new PlanInfo(context.getString(R.string.abs_beginner),context.getString(R.string.level_beginner),R.drawable.abs,"30");
            advancePlan.add(info3);
            PlanInfo info4 = new PlanInfo(context.getString(R.string.abs_beginner),context.getString(R.string.level_beginner),R.drawable.biceps,"55");
            advancePlan.add(info4);


            return advancePlan;
        }
    public List<PlanInfo> OurPlan(){
                advancePlan = new ArrayList<>();
                PlanInfo info1 = new PlanInfo(context.getString(R.string.our_plan),context.getString(R.string.level_beginner),R.drawable.main_photo,"20");
                advancePlan.add(info1);
                PlanInfo info2 = new PlanInfo(context.getString(R.string.fiit_plan),context.getString(R.string.level_beginner),R.drawable.biceps,"20");
                advancePlan.add(info2);
                PlanInfo info3 = new PlanInfo(context.getString(R.string.hiit_plan),context.getString(R.string.level_beginner),R.drawable.chest,"30");
                advancePlan.add(info3);
                PlanInfo info4 = new PlanInfo(context.getString(R.string.set_plan),context.getString(R.string.level_beginner),R.drawable.abs,"55");
                advancePlan.add(info4);


                return advancePlan;
            }


}
