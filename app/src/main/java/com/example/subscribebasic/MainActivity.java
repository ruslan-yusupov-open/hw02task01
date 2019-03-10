package com.example.subscribebasic;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText nameEditText;
    EditText emailEditText;
    TextView resultTextView;
    Button okButton;
    Button resetButton;
    Button repeatButton;

    ProgressBar subscribeProgress;
    ScrollView subscribeForm;
    ScrollView resultView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = findViewById(R.id.nameEditText);
        emailEditText = findViewById(R.id.emailEditText);
        resultTextView = findViewById(R.id.resultTextView);
        okButton = findViewById(R.id.okButton);
        resetButton = findViewById(R.id.resetButton);
        repeatButton = findViewById(R.id.repeatButton);

        subscribeProgress = findViewById(R.id.subscribeProgress);
        subscribeForm = findViewById(R.id.subscribeForm);
        resultView = findViewById(R.id.resultView);

        resetButton.setOnClickListener((view) -> {
            nameEditText.setText("");
            emailEditText.setText("");
        });

        repeatButton.setOnClickListener((view) -> {
            subscribeForm.setVisibility(View.VISIBLE);
            resultView.setVisibility(View.GONE);
        });

        okButton.setOnClickListener((view) -> {
            String name = nameEditText.getText().toString();
            String email = emailEditText.getText().toString();

            subscribeProgress.setVisibility(View.VISIBLE);
            subscribeForm.setVisibility(View.GONE);

            Handler handler = new Handler(Looper.getMainLooper());

            handler.postDelayed(() -> {
                subscribeProgress.setVisibility(View.GONE);
                resultView.setVisibility(View.VISIBLE);

                String result = String.format("Подписка на рассылку успешно оформлена" +
                        " для пользователя %s на электронный адрес %s", name, email);

                resultTextView.setText(result);
            }, 2000);
        });
    }
}
