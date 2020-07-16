package com.fitness.fitness.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.fitness.fitness.R;
import com.fitness.fitness.database.DataEntity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder> {


    private final String LOG = getClass().getName();
    private Context context;
    private List<DataEntity> mWorkoutList;

    public HistoryAdapter(Context ctx,List<DataEntity> list)
    {
        context = ctx;
        mWorkoutList = list;
    }

    @NonNull
    @Override
    public HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.workout_history_view_holder,parent,false);
        return new HistoryViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull HistoryViewHolder holder, int position) {

        DataEntity entity = mWorkoutList.get(position);
        if(position==0) {
            Date dateToday = new Date();
            SimpleDateFormat timeStampFormat = new SimpleDateFormat("dd/MM/yyyy");
            String date2 = timeStampFormat.format(entity.date);
            String dateTodayStr = timeStampFormat.format(dateToday);
            if(date2.equals(dateTodayStr))
                holder.mDateHistoryView.setText("Today");
            else
                holder.mDateHistoryView.setText(date2);

            holder.mDateHistoryView.setVisibility(View.VISIBLE);
            holder.mExerciseName.setText(entity.mPlanName);
            holder.mExerciseCount.setText("Exercise done: "+ entity.mExerciseCount);
            if(mWorkoutList.get(position).mDay>1)
            {
                holder.mExerciseWeekDay.setText("Day "+ mWorkoutList.get(position).mDay);
            }
            else
                holder.mExerciseWeekDay.setVisibility(View.GONE);

        }

        if(position>0)
        {
            DataEntity entityPrev = mWorkoutList.get(position-1);
            SimpleDateFormat timeStampFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date yesterdayDate = new Date(System.currentTimeMillis() - (long) 24 * 3600 * 1000);
            String yesterdayDateStr = timeStampFormat.format(yesterdayDate);
            String date = timeStampFormat.format(entityPrev.date);
            String date2 = timeStampFormat.format(entity.date);
            Log.i("dateCheck",date+","+date2);
            if (!date.equals(date2)) {
                if(yesterdayDateStr.equals(entity))
                    holder.mDateHistoryView.setText("Yesterday");
                else
                    holder.mDateHistoryView.setText(date2);
                holder.mDateHistoryView.setVisibility(View.VISIBLE);

            }
            else {
                holder.mDateHistoryView.setVisibility(View.GONE);
            }
            Log.i(LOG,String.valueOf(mWorkoutList.get(position).mTiredness));
            switch (mWorkoutList.get(position).mTiredness)
            {
                case 1:
                    DrawableCompat.setTint(holder.imageWorkoutHistory.getDrawable(), ContextCompat.getColor(context, R.color.darkGreen));
                    break;
                 case 2: DrawableCompat.setTint(holder.imageWorkoutHistory.getDrawable(), ContextCompat.getColor(context, R.color.lightGreen));
                     break;
                 case 3: DrawableCompat.setTint(holder.imageWorkoutHistory.getDrawable(), ContextCompat.getColor(context, R.color.yellow));
                     break;
                 case 4:DrawableCompat.setTint(holder.imageWorkoutHistory.getDrawable(), ContextCompat.getColor(context, R.color.orange));
                    break;
                 case 5: DrawableCompat.setTint(holder.imageWorkoutHistory.getDrawable(), ContextCompat.getColor(context, R.color.darkRed));
                     break;
            }
            holder.mExerciseName.setText(entity.mPlanName);
            holder.mExerciseCount.setText("Exercise done: "+ entity.mExerciseCount);
            if(mWorkoutList.get(position).mDay>1)
            {
                holder.mExerciseWeekDay.setText("Day "+ mWorkoutList.get(position).mDay);
            }
            else
                holder.mExerciseWeekDay.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {

        return mWorkoutList.size();
    }

    class HistoryViewHolder extends RecyclerView.ViewHolder {
        TextView mExerciseName,mExerciseCount,mExerciseWeekDay,mDateHistoryView;
        ImageView imageWorkoutHistory;
        public HistoryViewHolder(@NonNull View itemView) {
            super(itemView);
            imageWorkoutHistory = itemView.findViewById(R.id.image_workout_history_view_holder);
            mExerciseCount = itemView.findViewById(R.id.exercise_count_history_view_holder);
            mExerciseName = itemView.findViewById(R.id.exercise_name_history_view_holder);
            mExerciseWeekDay = itemView.findViewById(R.id.exercise_week_day_history_view_holder);
            mDateHistoryView = itemView.findViewById(R.id.date_history_view_holder);
        }
    }
}
