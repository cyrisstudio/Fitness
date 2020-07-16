package com.fitness.fitness;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.fitness.fitness.Adapters.PreExerciseAdapter;
import com.fitness.fitness.ExerciseData.ExercisePlans;
import com.fitness.fitness.ExerciseGetter.Exercise;
import com.fitness.fitness.ExerciseGetter.Workout;

import java.util.List;
import java.util.Locale;

public class StartExercise extends AppCompatActivity {

    String mPlanName;
    String mWeek;
    int mDay;
    List<Workout> workouts;
    private ExercisePlans exercisePlans;
    ImageView mExerciseImage,mPreviousImage,mNextImage,imageDialog,mVolumeOn,mMoreInfo;
    Button mStartButton,okDialog;
    TextView mNameText,mExerciseCountText,nameDialog,infoDialog,countDialog,timeDialog;
    int count=0,dialogTimeCount=0,exerciseTimeCounter=0;
    Dialog mDialogExerciseInfo;
    Handler handler;
    Runnable runnable;
    TextToSpeech textToSpeech;
    boolean ttsOn = true,isPrevious=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getSupportActionBar().hide();
        setContentView(R.layout.activity_start_exercise);
        mExerciseImage = findViewById(R.id.image_start_activity);
        mMoreInfo = findViewById(R.id.more_info_exercise);
        mVolumeOn = findViewById(R.id.volume_on);
        mPreviousImage = findViewById(R.id.image_previous_exercise_start);
        mNextImage = findViewById(R.id.image_next_exercise_start);
        mStartButton = findViewById(R.id.button_start_exercise);
        mNameText = findViewById(R.id.text_name_start_exercise);
        mExerciseCountText = findViewById(R.id.text_exercise_count_start);
        handler = new Handler();
        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if(i==TextToSpeech.SUCCESS)
                {
                    int ttsStatus = textToSpeech.setLanguage(Locale.US);
                    if(ttsStatus==TextToSpeech.LANG_MISSING_DATA||ttsStatus==TextToSpeech.LANG_NOT_SUPPORTED)
                    {
                        Log.i("LanguageStatus","Language Not Supported");
                    }
                    else
                    {
                        Log.i("LanguageStatus","Language Not Supported");
                    }

                }
            }
        });

        mPlanName = getIntent().getStringExtra(getString(R.string.name_intent));
        mWeek = getIntent().getStringExtra(getString(R.string.week_count_intent));
        mDay = getIntent().getIntExtra(getString(R.string.day_count_intent),1);
        Log.i("dayCount", String.valueOf(mDay));
        mNameText.setText(mPlanName);

        CreateDialog();
        WorkoutWorking();
        OnItemClicks();


    }

    @SuppressLint("ClickableViewAccessibility")
    private void OnItemClicks() {
        mNextImage.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction()==MotionEvent.ACTION_DOWN)
                {
                    mNextImage.setImageDrawable(getDrawable(R.drawable.next_selected));
                }
                if(motionEvent.getAction()==MotionEvent.ACTION_UP)
                {
                    mNextImage.setImageDrawable(getDrawable(R.drawable.next_unselected));
                    if(count<workouts.size()-1)
                    {
                        count++;
                        SetExercise();
                    }
                    else
                    {
                        Intent intent = new Intent(StartExercise.this,DailyExerciseComplete.class);
                        intent.putExtra(getString(R.string.name_intent),mPlanName);
                        intent.putExtra(getString(R.string.week_count_intent),mWeek);
                        intent.putExtra(getString(R.string.day_count_intent),mDay);
                        intent.putExtra(getString(R.string.exercise_count_intent),workouts.size());
                        startActivity(intent);
                        StartExercise.this.finish();
                    }
                }

                return true;
            }
        });

        mPreviousImage.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction()==MotionEvent.ACTION_DOWN)
                {
                    mPreviousImage.setImageDrawable(getDrawable(R.drawable.previous_selected));
                }
                if(motionEvent.getAction()==MotionEvent.ACTION_UP)
                {
                    mPreviousImage.setImageDrawable(getDrawable(R.drawable.previous_unselected));
                    if(workouts!=null&&count>0)
                    {
                        count--;
                        isPrevious = true;
                        SetExercise();
                    }
                    else
                    {

                    }
                }

                return true;
            }
        });

        mVolumeOn.setTag(getString(R.string.volume_on_tag));
        mVolumeOn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                if(motionEvent.getAction()==MotionEvent.ACTION_DOWN) {
                    Log.i("volumeTag",mVolumeOn.getTag().toString()+","+getString(R.string.volume_off_tag)+","+getString(R.string.volume_on_tag));

                    if (mVolumeOn.getTag().equals(getString(R.string.volume_off_tag))) {
                        mVolumeOn.setImageDrawable(getDrawable(R.drawable.volume_on));
                        mVolumeOn.setTag(getString(R.string.volume_on_tag));
                        ttsOn = true;
                    }
                    if (mVolumeOn.getTag().equals(getString(R.string.volume_on_tag)))
                    {
                        mVolumeOn.setImageDrawable(getDrawable(R.drawable.volume_off));
                        mVolumeOn.setTag(getString(R.string.volume_off_tag));
                        ttsOn = false;
                        if(textToSpeech!=null&&textToSpeech.isSpeaking())
                            textToSpeech.stop();

                    }
                }
                return true;
            }
        });

        mMoreInfo.setOnTouchListener(new View.OnTouchListener() {
            @RequiresApi(api = Build.VERSION_CODES.Q)
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction()==MotionEvent.ACTION_UP)
                {
                    isPrevious = true;
                    mMoreInfo.setImageDrawable(getDrawable(R.drawable.more_info));
                    if(runnable!=null&&handler.hasCallbacks(runnable))
                        handler.removeCallbacks(runnable);
                    CallDialog();
                }
                if(motionEvent.getAction()==MotionEvent.ACTION_DOWN)
                {
                    mMoreInfo.setImageDrawable(getDrawable(R.drawable.more_info_selected));
                }
                return true;
            }
        });

    }

    private void WorkoutWorking() {
        exercisePlans = new ExercisePlans(this);
        switch (mPlanName)
        {
            case "Abs Beginner": workouts = exercisePlans.getAbsBeginner();break;
            case "Our Plan": workouts = exercisePlans.getFitDay1();break;
            case "Fiit Plan": workouts = exercisePlans.getFitDay2();break;

           /* case "Abs Beginner": preExerciseAdapter = new PreExerciseAdapter(this, exercisePlans.getAbsBeginner());
                    mTextExerciseCount.setText(String.valueOf(exercisePlans.getAbsBeginner().size()));*/
        }
        SetExercise();

    }

    private void SetExercise() {
        if(workouts!=null)
        {
            CallDialog();
            Glide.with(this).load(workouts.get(count).getExercise().getImageLocation()).into(mExerciseImage);
            mNameText.setText(workouts.get(count).getExercise().getExerciseName());


            if(workouts.get(count).getType())
            {
                mExerciseCountText.setText("00:"+String.valueOf(workouts.get(count).getCount()));
                mStartButton.setText("Pause");
                mStartButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(mStartButton.getText().equals("Pause"))
                        {
                            mStartButton.setText("Play");
                            if(handler!=null&&runnable!=null)
                            {
                                handler.removeCallbacks(runnable);
                            }

                        }
                        else
                        {
                            mStartButton.setText("Pause");
                            ExerciseTimer(exerciseTimeCounter);
                        }
                    }
                });
                //ExerciseTimer(workouts.get(count).getCount());
            }
            else
            {
                mExerciseCountText.setText("x"+String.valueOf(workouts.get(count).getCount()));
                mStartButton.setText("Done");
                mStartButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(count<workouts.size()-1)
                        {
                            count++;
                            SetExercise();
                        }
                        else
                        {
                            Intent intent = new Intent(StartExercise.this,DailyExerciseComplete.class);
                            intent.putExtra(getString(R.string.name_intent),mPlanName);
                            intent.putExtra(getString(R.string.week_count_intent),mWeek);
                            intent.putExtra(getString(R.string.day_count_intent),mDay);
                            intent.putExtra(getString(R.string.exercise_count_intent),workouts.size());
                            startActivity(intent);
                            StartExercise.this.finish();
                        }
                    }
                });
            }
        }
    }

    private void ExerciseTimer(final int count1) {
        runnable =new Runnable() {
            @Override
            public void run() {
                if(count1<=0)
                {
                    count++;
                    SetExercise();
                    return;
                }


                if(workouts.get(count).getType()) {
                    if(count1<10)
                        mExerciseCountText.setText("00:0"+String.valueOf(count1));
                    else
                        mExerciseCountText.setText("00:"+String.valueOf(count1));
                    exerciseTimeCounter = count1-1;
                    ExerciseTimer(count1 - 1);

                }

            }
        };
        handler.postDelayed(runnable,1000);
    }

    private void CreateDialog() {
        mDialogExerciseInfo = new Dialog(this,R.style.Theme_AppCompat_Light_DialogWhenLarge);
        mDialogExerciseInfo.setContentView(R.layout.exercise_info_dialog);
         imageDialog = mDialogExerciseInfo.findViewById(R.id.image_exercise_dialog);
         nameDialog = mDialogExerciseInfo.findViewById(R.id.exercise_name_dialog);
         infoDialog = mDialogExerciseInfo.findViewById(R.id.exercise_info_dialog);
         timeDialog = mDialogExerciseInfo.findViewById(R.id.exercise_timer_dialog);
         okDialog = mDialogExerciseInfo.findViewById(R.id.ok_button_dialog);
         countDialog = mDialogExerciseInfo.findViewById(R.id.exercise_count_dialog);
    }

    private void CallDialog() {
        Glide.with(this).load(workouts.get(count).getExercise().getImageLocation()).into(imageDialog);
        nameDialog.setText(workouts.get(count).getExercise().getExerciseName());
        infoDialog.setText(workouts.get(count).getExercise().getExerciseInfo());

        if (!isPrevious) {
            if (ttsOn) {
                if (workouts.get(count).getType()) {
                    countDialog.setText("00:" + String.valueOf(workouts.get(count).getCount()));
                    String nextExercise = "The Next Exercise is " + workouts.get(count).getExercise().getExerciseName() + " for " +
                            String.valueOf(workouts.get(count).getCount()) + "Seconds. " + workouts.get(count).getExercise().getExerciseInfo();
                    textToSpeech.speak(nextExercise, TextToSpeech.QUEUE_FLUSH, null);


                } else {
                    countDialog.setText("x" + String.valueOf(workouts.get(count).getCount()));
                    String nextExercise = "The Next Exercise is " + workouts.get(count).getExercise().getExerciseName() + " of " +
                            String.valueOf(workouts.get(count).getCount()) + "Sets." + workouts.get(count).getExercise().getExerciseInfo();
                    textToSpeech.speak(nextExercise, TextToSpeech.QUEUE_FLUSH, null);
                }

                textToSpeech.playSilentUtterance(1000, TextToSpeech.QUEUE_ADD, workouts.get(count).getExercise().getExerciseInfo());
                //textToSpeech.speak(workouts.get(count).getExercise().getExerciseInfo(),TextToSpeech.QUEUE_FLUSH,null);
            }
        }
        else
            {isPrevious = false;}
        mDialogExerciseInfo.show();
        dialogTimeCount = 25;
        TimerCall();
        okDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDialogExerciseInfo.dismiss();
                if(workouts.get(count).getType())
                    ExerciseTimer(workouts.get(count).getCount());
            }
        });
    }

    Runnable runnable1;
    private void TimerCall() {
        Log.i("time_count",String.valueOf(dialogTimeCount));

            runnable1 =new Runnable() {
                @Override
                public void run() {
                    if(dialogTimeCount==0)
                    {
                        if(mDialogExerciseInfo!=null&&mDialogExerciseInfo.isShowing())
                            mDialogExerciseInfo.dismiss();
                        if(workouts.get(count).getType())
                            ExerciseTimer(workouts.get(count).getCount());

                        return;
                    }

                    timeDialog.setText(String.valueOf(dialogTimeCount));
                    dialogTimeCount--;
                    if(mDialogExerciseInfo!=null&&mDialogExerciseInfo.isShowing())
                        TimerCall();

                }
            };
            handler.postDelayed(runnable1,1000);
        }


    @Override
    protected void onStop() {
        super.onStop();
        if(textToSpeech!=null)
        {
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            if(handler.hasCallbacks(runnable))
                handler.removeCallbacks(runnable);
        }
    }
}