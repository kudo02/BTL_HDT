package com.sagarkhurana.quizforfun;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Question_Cplus extends AppCompatActivity {
    TextView tv;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;
    int ma;


    String questions[] = {
            "Lệnh 'cout' trong C++ có tác dụng gì ?",
            "Kết thúc câu lệnh trong C++ ta dùng ký hiệu gì ?",
            "Lệnh cout trong C++ đi kèm với cặp dấu nào?",
            "Để chú thích trên một dòng ta dùng cặp dấu nào?",
            "Đâu là kiểu dữ liệu khai báo số nguyên ?",
            "Trong C++, toán tử nào sau đây dùng để so sánh hai biến?",
            "Trong C++ toán tử logic VÀ được kí hiệu bởi?",
            "Hàm căn bậc 2 của một giá trị x trong C++?",
            "Đâu không phải kiểu dữ liệu dùng trong C++?",
            "Các kiểu dữ liệu kiểu thực trong c++ là:"

    };
    String answers[] = {"Là stream đầu ra chuẩn trong C++.","Dấu ;","<<","//","int","==","&&","sqrt(x)","real","float, double, long double"};
    String opt[] = {
            "Là stream đầu ra chuẩn trong C++.","Là lệnh chú thích trong C++.","Là stream đầu vào chuẩn của C++.","Là lệnh khai báo một biến.",
            "Dấu .","Dấu ,","Dấu :","Dấu ;",
            ">>","||","&&","<<",
            "//",">>","<<","??",
            "float","int","double","char",
            ":=","=","equal","==",
            "&","&&","and","|&",
            "pow(x)","sqrt(x)","abs(x)","exp(x)",
            "float","real","int","double",
            "float, double","short int, double, long int","float, double, long double","double, long in, float"
    };

    int flag=0;
    public static int marks=0,correct=0,wrong=0, res = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_cplus);

        final TextView score = (TextView)findViewById(R.id.textView4);
        TextView textView=(TextView)findViewById(R.id.DispName);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");


        submitbutton=(Button)findViewById(R.id.button3);
        quitbutton=(Button)findViewById(R.id.buttonquit);
        tv=(TextView) findViewById(R.id.tvque);

        radio_g=(RadioGroup)findViewById(R.id.answersgrp);
        rb1=(RadioButton)findViewById(R.id.radioButton);
        rb2=(RadioButton)findViewById(R.id.radioButton2);
        rb3=(RadioButton)findViewById(R.id.radioButton3);
        rb4=(RadioButton)findViewById(R.id.radioButton4);
        tv.setText(questions[flag]);
        rb1.setText(opt[0]);
        rb2.setText(opt[1]);
        rb3.setText(opt[2]);
        rb4.setText(opt[3]);
        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(radio_g.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(getApplicationContext(), "Vui Lòng Chọn Câu Trả Lời!", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton uans = (RadioButton) findViewById(radio_g.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();
                if(ansText.equals(answers[flag])) {
                    res++;
                    correct++;
                }
                else {
                    wrong++;
                    res++;
                }

                flag++;

                if (score != null)
                    score.setText(res + "/10");

                if(flag<questions.length)
                {
                    tv.setText(questions[flag]);
                    rb1.setText(opt[flag*4]);
                    rb2.setText(opt[flag*4 +1]);
                    rb3.setText(opt[flag*4 +2]);
                    rb4.setText(opt[flag*4 +3]);
                }
                else
                {
                    res = 1;
                    marks=correct;
                    Intent in = new Intent(getApplicationContext(),final_result_cplus.class);
                    startActivity(in);
                }
                radio_g.clearCheck();
            }
        });


        quitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),final_result_cplus.class);
                startActivity(intent);
            }
        });
    }
}