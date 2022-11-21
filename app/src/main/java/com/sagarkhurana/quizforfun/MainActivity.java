package com.sagarkhurana.quizforfun;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.sagarkhurana.quizforfun.data.User;
import com.sagarkhurana.quizforfun.other.SharedPref;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvUsername = findViewById(R.id.tvUsernameHome);
        CardView cvLogout = findViewById(R.id.cvLogout);
        CardView cvCplus = findViewById(R.id.cvCplus);
        CardView cvJava = findViewById(R.id.cvJava);
        CardView cvPython = findViewById(R.id.cvPython);
        CardView cvC = findViewById(R.id.cvC);

        SharedPref sharedPref = SharedPref.getInstance();
        User user = sharedPref.getUser(this);
        tvUsername.setText("Hello, " + user.getUsername());


        cvCplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Question_Cplus.class));
            }
        });

        cvJava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,question_java.class));
            }
        });

        cvPython.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,question_python.class));
            }
        });
        cvC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,question_c.class));
            }
        });

        cvLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPref.clearSharedPref(MainActivity.this);
                Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });




    }


}