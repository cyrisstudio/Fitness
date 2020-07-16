package com.fitness.fitness.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fitness.fitness.ExercisePreDetail;
import com.fitness.fitness.R;

public class Plan30Adapter extends RecyclerView.Adapter<Plan30Adapter.Plan30ViewHolder> {

    Context context;
    String mPlanName;
    String mWeek;
    int count=1;
    String LOG = getClass().getName();
    SharedPreferences preferences,weekPreferences;
    public Plan30Adapter(Context ctx,String name,String week)
    {
        context = ctx;
        mPlanName = name;
        mWeek = week;
        preferences = ctx.getSharedPreferences(mPlanName, Context.MODE_PRIVATE);

    }

    @NonNull
    @Override
    public Plan30ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.plan_30_holder,parent,false);
        return new Plan30ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Plan30ViewHolder holder, int position) {
        holder.mTextDayCount.setText(String.valueOf(position+1));
        holder.OnItemClick(position);
    }

    @Override
    public int getItemCount() {
        return 7;
    }

    class Plan30ViewHolder extends RecyclerView.ViewHolder {
        TextView mTextDayCount;
        public Plan30ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextDayCount = itemView.findViewById(R.id.text_in_plan_30_holder);
        }
        public void OnItemClick(final int position)
        {
            int mDayCount =preferences.getInt(mPlanName,0);


            switch(mWeek)
            {
                case "Week 1":
                    Log.i(LOG,String.valueOf(mDayCount));
                    if(mDayCount<7)
                    {
                        if(mDayCount%7>getAdapterPosition())
                        {
                            ExerciseCompleted(position);
                        }
                        if(mDayCount%7==getAdapterPosition()||(mDayCount%7==0&&getAdapterPosition()==0))
                            OnDayClick(getAdapterPosition());

                    }
                    else{
                        ExerciseCompleted(position);
                    }break;


            case "Week 2":

                    if(mDayCount<14&&mDayCount>=7)
                    {
                        if(mDayCount%7>getAdapterPosition())
                        {
                            ExerciseCompleted(position);
                        }
                        if(mDayCount%7==getAdapterPosition()||(mDayCount%7==0&&getAdapterPosition()==0))
                            OnDayClick(getAdapterPosition());
                    }
                    else if(mDayCount>7){
                        ExerciseCompleted(position);
                    }break;


            case "Week 3":

                    if(mDayCount<21&&mDayCount>=14)
                    {
                        if(mDayCount%7>getAdapterPosition())
                        {
                            ExerciseCompleted(position);
                        }
                        if(mDayCount%7==getAdapterPosition()||(mDayCount%7==0&&getAdapterPosition()==0))
                            OnDayClick(getAdapterPosition());

                    }
                    else if(mDayCount>14){
                        ExerciseCompleted(position);
                    }break;


            case "Week 4":

                    if(mDayCount<28&&mDayCount>=21)
                    {
                        if(mDayCount%7>getAdapterPosition())
                        {
                            ExerciseCompleted(position);
                        }
                        if(mDayCount%7==getAdapterPosition()||(mDayCount%7==0&&getAdapterPosition()==0))
                            OnDayClick(getAdapterPosition());
                    }
                    else if(mDayCount>21) {
                        ExerciseCompleted(position);
                    }break;
            }


        }

        private void ExerciseCompleted(final int position) {
            if(position+1<getItemCount())
            {

               // mTextDayCount.setText(String.valueOf(position+1));
               // mTextDayCount.setBackground(context.getDrawable(R.drawable.circle_30_day_uncompleted));
            }
            mTextDayCount.setText("");
            mTextDayCount.setBackground(context.getDrawable(R.drawable.circle_30_day_completed));

            OnDayClick(position);
        }

        private void OnDayClick(final int position) {
            mTextDayCount.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(context, ExercisePreDetail.class);
                    intent.putExtra(context.getString(R.string.name_intent), mPlanName);
                    intent.putExtra(context.getString(R.string.week_count_intent), mWeek);
                    intent.putExtra(context.getString(R.string.day_count_intent), position );
                    context.startActivity(intent);
                    Activity activity = (Activity) context;
                    activity.finish();
                }
            });
        }
    }


}
