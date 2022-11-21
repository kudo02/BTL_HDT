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

public class question_python extends AppCompatActivity {
    TextView tv;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;
    int ma;


    String questions[] = {
            "Chương trình Python là một tệp văn bản có đuôi mặc định là:",
            "Hàm nào sau đây là hàm tích hợp sẵn trong Python",
            "Hàm nào sau đây sẽ không xảy ra lỗi khi không truyền tham số cho nó?",
            "Từ khóa nào được sử dụng để bắt đầu hàm?",
            "Đâu không phải là kiểu dữ liệu tiêu chuẩn trong Python?",
            "Lệnh nào dùng để lấy dữ liệu đầu vào từ người dùng?",
            "Khẳng định nào sau đây về Python là đúng?",
            "Ý nghĩa của hàm __init__() trong Python là gì?",
            "Kí hiệu nào dùng để xác định các khối lệnh(khối lệnh của hàm,vòng lặp,..)trong Python?",
            "n = '5'. n thuộc kiểu dữ liệu nào ?"

    };
    String answers[] = {".py","print()","float()","def","Class","input()","Tất cả các đáp án đều đúng.","Được gọi khi một đối tượng mới được khởi tạo.","Thụt lề","string"};
    String opt[] = {
            ".pas",".py",".cpp",".java",
            "seed()","sqrt()","factorial()","print()",
            "min()","divmod()","all()","float()",
            "def","fun","define","function",
            "List","Dictionary","Class","Tuple",
            "cin","scanf()","input()","Tất cả phương án trên",
            "Python là một ngôn ngữ lập trình cấp cao.","Python là một ngôn ngữ thông dịch.","Python là ngôn ngữ lập trình hướng đối tượng.","Tất cả các đáp án đều đúng.",
            "Khởi tạo một lớp để sử dụng.","Được gọi khi một đối tượng mới được khởi tạo.","Khởi tạo và đưa tất cả các thuộc tính dữ liệu về 0 khi được gọi.","Không có đáp án đúng.",
            "Dấu ngoặc nhọn{}","Dấu ngoặc vuông[]","Thụt lề","Dấu ngoặc đơn ()",
            "integer","tuple","operator","string"
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
                    res = 0;
                    marks=correct;
                    Intent in = new Intent(getApplicationContext(),Final_result_python.class);
                    startActivity(in);
                }
                radio_g.clearCheck();
            }
        });


        quitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Final_result_python.class);
                startActivity(intent);
            }
        });
    }

}