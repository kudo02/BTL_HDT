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

public class question_java extends AppCompatActivity {
    TextView tv;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;
    int ma;


    String questions[] = {
            "Những class ……… sẽ không thể kế thừa được",
            "Đâu không phải là 1 tính chất của hướng đối tượng ?",
            "Các tính chất của hướng đối tượng là gì ?",
            "Từ khóa nào ném ra một ngoại lệ trong mã Java?",
            "Trong các phương án sau, phương án nào mô tả đối tượng:",
            "Có thể định nghĩa bao nhiêu lớp trong một chương trình?",
            "Từ khóa nào trong số này phải được sử dụng để kế thừa một lớp?",
            "Có mấy loại access modifier?",
            "Phương thức nào sau đây của lớp String được sử dụng để so sánh hai đối tượng String về đẳng thức của chúng?",
            "Kiểu dữ liệu số nguyên nguyên thủy trong Java?"

    };
    String answers[] = {"final","Tính đa lớp","Đóng gói, kế thừa, đa hình, trừu tượng","throw","Tất cả đều đúng","Không giới hạn","extends","4","equals()","int"};
    String opt[] = {
            "public","private","final","protected",
            "Tính đóng gói","Tính trừu tượng","Tính kế thừa","Tính đa lớp",
            "Đóng gói, đa hình, trừu tượng","Đóng gói, kế thừa, đa hình, trừu tượng","Bảo toàn, kế thừa, đóng gói","Đa dạng, trừu tượng, đóng gói, kế thừa",
            "try","break","throw","throws",
            "Máy tính","Xe đạp","Đồng hồ","Tất cả đều đúng",
            "1","999","100","Không giới hạn",
            "super","this","extent","extends",
            "2","3","4","5",
            "equals()","Equals()","isequal()","Isequal()",
            "int","String","byte","float"
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
                    Intent in = new Intent(getApplicationContext(),Final_result_java.class);
                    startActivity(in);
                }
                radio_g.clearCheck();
            }
        });


        quitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Final_result_java.class);
                startActivity(intent);
            }
        });
    }

}