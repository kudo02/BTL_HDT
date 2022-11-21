package com.sagarkhurana.quizforfun;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.sagarkhurana.quizforfun.other.Utils;

import java.util.Calendar;

public class Final_result_c extends AppCompatActivity {
    private TextView tvCorrect, tvIncorrect, tvScore, tvDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_result_c);

        tvCorrect = findViewById(R.id.tvCorrect);
        tvIncorrect = findViewById(R.id.tvIncorrect);
        tvScore = findViewById(R.id.textView28);
        tvDate = findViewById(R.id.tvDate);

        StringBuffer sb = new StringBuffer();
        sb.append(question_c.correct + "\n");
        StringBuffer sb2 = new StringBuffer();
        sb2.append(question_c.wrong + "\n");
        StringBuffer sb3 = new StringBuffer();
        sb3.append(question_c.correct + "\n");
        tvCorrect.setText(sb);
        tvIncorrect.setText(sb2);
        tvScore.setText(sb3);
        tvDate.setText(Utils.formatDate(Calendar.getInstance().getTimeInMillis()));

        question_c.correct=0;
        question_c.wrong=0;

        findViewById(R.id.imageViewFinalResultQuiz).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Final_result_c.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        findViewById(R.id.btnFinishQuiz).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Final_result_c.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}