package com.example.loginapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editTextone,editTexttwo;
    private Button button;
    private TextView textView;
    private int counter = 3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            ((Window) window).addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.black));
        }

        editTextone = findViewById(R.id.emailid);
        editTexttwo = findViewById(R.id.passwordid);
        button = findViewById(R.id.loginbtn);
        textView = findViewById(R.id.attemptthree);
        textView.setText("number of attempt : 3");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = editTextone.getText().toString();
                String password = editTexttwo.getText().toString();
                if(email.equals("admin") && password.equals("1234")){
                    Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                    startActivity(intent);
                }else{
                    counter--;
                    textView.setText("number of attempt :" + counter);
                    if(counter == 0){
                        button.setEnabled(false);
                    }
                }
            }
        });


    }
}