package com.fitness.fitness.Adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.fitness.fitness.ExerciseGetter.PlanInfo;
import com.fitness.fitness.ExercisePreDetail;
import com.fitness.fitness.Plan30Day;
import com.fitness.fitness.R;

import java.util.List;

public class MainPlansAdapter extends RecyclerView.Adapter<MainPlansAdapter.MainPlanViewHolder> {

    boolean isBigImageView;
    List<PlanInfo> planInfo;
    Context context;
    public MainPlansAdapter(Context ctx, List<PlanInfo> info,boolean bigImageView)
    {
        isBigImageView = bigImageView;
        context = ctx;
        planInfo = info;
    }

    @NonNull
    @Override
    public MainPlanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=null;
        if(isBigImageView){
             view = LayoutInflater.from(context).inflate(R.layout.plan_view_holder_big_image,parent,false);
        }
        else{
             view = LayoutInflater.from(context).inflate(R.layout.plan_view_holder,parent,false);
        }
        return new MainPlanViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainPlanViewHolder holder, int position) {
        holder.SetImage();
        holder.mPlanName.setText(planInfo.get(position).getPlanName());
        holder.mPlanAbout.setText(planInfo.get(position).getLevel());
        Log.i("planInfo",planInfo.get(position).getPlanName());
        holder.OnItemClick();

    }

    @Override
    public int getItemCount() {
        return planInfo.size();
    }

    class MainPlanViewHolder extends RecyclerView.ViewHolder {
        ImageView mPlanImage;
        TextView mPlanName,mPlanAbout;
        CardView planHolderCardView;
        public MainPlanViewHolder(@NonNull View itemView) {
            super(itemView);
            mPlanImage = itemView.findViewById(R.id.plan_image_in_holder);
            mPlanName = itemView.findViewById(R.id.plan_name_in_holder);
            mPlanAbout = itemView.findViewById(R.id.plan_about_in_holder);
            planHolderCardView = itemView.findViewById(R.id.plan_holder_cardView);
        }

        public void SetImage()
        {
            Glide.with(context).load(context.getDrawable(planInfo.get(getLayoutPosition()).getPhotoId())).centerCrop().into(mPlanImage);
        }

        public void OnItemClick()
        {
            planHolderCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(isBigImageView) {
                        Intent intent = new Intent(context, Plan30Day.class);
                        intent.putExtra(context.getString(R.string.image_intent),planInfo.get(getLayoutPosition()).getPhotoId());
                        intent.putExtra(context.getString(R.string.name_intent), planInfo.get(getLayoutPosition()).getPlanName());
                        context.startActivity(intent);
                    }
                    else
                    {
                        Intent intent = new Intent(context, ExercisePreDetail.class);
                       // intent.putExtra(context.getString(R.string.time_intent), planInfo.get(getLayoutPosition()).getTime());
                        intent.putExtra(context.getString(R.string.image_intent),planInfo.get(getLayoutPosition()).getPhotoId());
                        intent.putExtra(context.getString(R.string.name_intent), planInfo.get(getLayoutPosition()).getPlanName());
                        context.startActivity(intent);
                    }
                }
            });
        }
    }
}
