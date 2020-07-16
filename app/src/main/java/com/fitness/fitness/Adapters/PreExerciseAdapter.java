package com.fitness.fitness.Adapters;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.fitness.fitness.ExerciseGetter.Workout;
import com.fitness.fitness.R;

import java.util.List;

public class PreExerciseAdapter extends RecyclerView.Adapter<PreExerciseAdapter.PreExerciseViewHolder> {

    private final List<Workout> exerciseList;
    private Context context;

    public PreExerciseAdapter(Context ctx, List<Workout> plan)
    {
        context = ctx;
        exerciseList = plan;
    }

    @NonNull
    @Override
    public PreExerciseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.pre_exercise_view_holder,parent,false);
        return new PreExerciseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PreExerciseViewHolder holder, int position) {
            holder.mExerciseName.setText(exerciseList.get(position).getExercise().getExerciseName());
            if(exerciseList.get(position).getType())
                holder.mExerciseCount.setText("00:"+String.valueOf(exerciseList.get(position).getCount()));
            else
                holder.mExerciseCount.setText("x"+String.valueOf(exerciseList.get(position).getCount()));
            holder.SetImage();
            holder.OnItemClick();

    }

    @Override
    public int getItemCount() {
        return exerciseList.size();
    }

    class PreExerciseViewHolder extends RecyclerView.ViewHolder {
        TextView mExerciseName,mExerciseCount;
        ImageView mExerciseImage;
        CardView mCardViewPreHolder;
        public PreExerciseViewHolder(@NonNull View itemView) {
            super(itemView);
            mExerciseImage = itemView.findViewById(R.id.image_pre_holder);
            mExerciseName = itemView.findViewById(R.id.exercise_name_pre_holder);
            mExerciseCount = itemView.findViewById(R.id.exercise_count_pre_holder);
            mCardViewPreHolder = itemView.findViewById(R.id.cardView_pre_holder);
        }

        public void SetImage()
        {
            Glide.with(context).load(exerciseList.get(getLayoutPosition()).getExercise().getImageLocation()).into(mExerciseImage);
        }

        public void OnItemClick()
        {
            mCardViewPreHolder.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Dialog preDialog = new Dialog(context);
                    preDialog.setContentView(R.layout.dialog_pre_exercise_holder);
                    ImageView imageInDialog = preDialog.findViewById(R.id.image_dialog_pre_holder);
                    TextView nameInDialog = preDialog.findViewById(R.id.text_name_dialog_pre_holder);
                    TextView detailInDialog = preDialog.findViewById(R.id.text_detail_dialog_pre_holder);

                    Glide.with(context).load(exerciseList.get(getLayoutPosition()).getExercise().getImageLocation()).into(imageInDialog);
                    nameInDialog.setText(exerciseList.get(getLayoutPosition()).getExercise().getExerciseName());
                    detailInDialog.setText(exerciseList.get(getLayoutPosition()).getExercise().getExerciseInfo());

                    if(preDialog!=null&&!preDialog.isShowing())
                    {
                        preDialog.show();
                    }
                }
            });
        }
    }
}
