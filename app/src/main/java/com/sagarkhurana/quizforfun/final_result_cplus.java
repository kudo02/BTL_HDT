package com.sagarkhurana.quizforfun;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.sagarkhurana.quizforfun.other.Utils;

import java.util.Calendar;

public class final_result_cplus extends AppCompatActivity {

    private TextView tvCorrect, tvIncorrect, tvScore, tvDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_result_cplus);

        tvCorrect = findViewById(R.id.tvCorrect);
        tvIncorrect = findViewById(R.id.tvIncorrect);
        tvScore = findViewById(R.id.textView28);
        tvDate = findViewById(R.id.tvDate);

        StringBuffer sb = new StringBuffer();
        sb.append(com.sagarkhurana.quizforfun.Question_Cplus.correct + "\n");
        StringBuffer sb2 = new StringBuffer();
        sb2.append(com.sagarkhurana.quizforfun.Question_Cplus.wrong + "\n");
        StringBuffer sb3 = new StringBuffer();
        sb3.append(com.sagarkhurana.quizforfun.Question_Cplus.correct + "\n");
        tvCorrect.setText(sb);
        tvIncorrect.setText(sb2);
        tvScore.setText(sb3);
        tvDate.setText(Utils.formatDate(Calendar.getInstance().getTimeInMillis()));

        com.sagarkhurana.quizforfun.Question_Cplus.correct=0;
        com.sagarkhurana.quizforfun.Question_Cplus.wrong=0;

        findViewById(R.id.imageViewFinalResultQuiz).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(final_result_cplus.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        findViewById(R.id.btnFinishQuiz).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(final_result_cplus.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}