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

public class question_c extends AppCompatActivity {
    TextView tv;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;


    String questions[] = {
            "Kiểu dữ liệu nào dưới đây được coi là kiểu dữ liệu cơ bản trong ngôn ngữ lập trình C:",
            "Xâu định dạng nào dưới đây dùng để in ra một kí tự:",
            "Dữ liệu kí tự bao gồm :",
            "Kiểu dữ liệu nào dưới đây không được coi là kiểu dữ liệu cơ bản trong ngôn ngữ lập trình C :",
            "Giả sử có câu lệnh ch=’A’. Vậy ch sẽ chứa bao nhiêu byte :",
            "Phép toán % có ý nghĩa gì:",
            "Các kí hiệu đặc trưng cho sự tác động lên dữ liệu được gọi là:",
            "Định dạng nào dưới đây dùng để hiển thị một số thực:",
            "Hàm nào dưới đây chỉ dùng để ghi 1 xâu kí tự vào tệp:",
            "Cơ chế nào dưới đây được cài đặt cho hàng đợi:"

    };
    String answers[] = {"Kiểu double.","%c","Cả a,b và c.","Kiểu mảng.","1.","Lấy phần dư của phép chia hai số nguyên.","Toán tử.","%f","fputs();","FIFO"};
    String opt[] = {
            "Kiểu double.","Kiểu con trỏ.","Kiểu hợp.","Kiểu mảng.",
            "%f","%x","%d","%c",
            "Các kí tự số chữ số.","Các kí tự chữ cái.","Các kí tự đặc biệt.","Cả a,b và c.",
            "Kiểu mảng.","Kiểu enum."," Kiểu short int.","Kiểu unsigned.",
            "1.","2.","3.","4.",
            "Đổi dấu một số thực hoặc một số nguyên.","Chia hai số thực hoặc nguyên.","Lấy phần dư của phép chia hai số nguyên.","1 và 2.",
            "Toán tử.","Biểu thức.","Hàm.","Biến.",
            "%f","%d","%c","%x",
            " putch();","puts();","fputc();","fputs();",
            "FIFO","FILO","Tuần Tự","Round Robin"
    };

    int flag=0;
    public static int marks=0,correct=0,wrong=0, res = 0;
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
                    res = 0;
                    marks=correct;
                    Intent in = new Intent(getApplicationContext(),Final_result_c.class);
                    startActivity(in);
                }
                radio_g.clearCheck();
            }
        });

        quitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Final_result_c.class);
                startActivity(intent);
            }
        });
    }
}