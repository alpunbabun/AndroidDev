package com.example.androiddev;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private ProgressBar pbLoading;
    private TextView tvHello;
    private EditText etEmail;
    private EditText etPassword;
    private Button btnLogin;
    private TextView tvSignIn;
    float v = 0;

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pbLoading = (ProgressBar) findViewById(R.id.pb_loading);
        tvHello = (TextView) findViewById(R.id.tv_Hello);
        etEmail = (EditText) findViewById(R.id.et_email);
        etPassword = (EditText) findViewById(R.id.et_password);
        btnLogin = (Button) findViewById(R.id.btn_login);
        tvSignIn = (TextView) findViewById(R.id.tv_signIn);

        tvHello.setTranslationX(800);
        etEmail.setTranslationX(800);
        etPassword.setTranslationX(800);
        btnLogin.setTranslationX(800);
        tvSignIn.setTranslationX(800);

        tvHello.setAlpha(v);
        etEmail.setAlpha(v);
        etPassword.setAlpha(v);
        btnLogin.setAlpha(v);
        tvSignIn.setAlpha(v);

        tvHello.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(50).start();
        etEmail.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(50).start();
        etPassword.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(50).start();
        btnLogin.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(50).start();
        tvSignIn.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(50).start();

        auth = FirebaseAuth.getInstance();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pbLoading.setVisibility(View.VISIBLE);
                String et_Email = etEmail.getText().toString().trim();
                String et_Password = etPassword.getText().toString().trim();

                if (et_Email.isEmpty()) {
                    etEmail.setError("Email is Required!");
                    etPassword.requestFocus();
                    pbLoading.setVisibility(View.GONE);
                    return;
                }

                if (et_Password.isEmpty()) {
                    etPassword.setError("Password is Required!");
                    etPassword.requestFocus();
                    pbLoading.setVisibility(View.GONE);
                    return;
                }

                if (et_Password.length()<6) {
                    etPassword.setError("Incorrect Password");
                    etPassword.requestFocus();
                    pbLoading.setVisibility(View.GONE);
                }

                if (!Patterns.EMAIL_ADDRESS.matcher(et_Email).matches()) {
                    etEmail.setError("Please provide valid email!");
                    etEmail.requestFocus();
                    pbLoading.setVisibility(View.GONE);
                    return;
                }

                auth.signInWithEmailAndPassword(et_Email, et_Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        pbLoading.setVisibility(View.VISIBLE);
                        if (task.isSuccessful()){
                            Toast.makeText(MainActivity.this, "Logged in Successful", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(MainActivity.this, WelcomeActivity.class));
                        } else {
                            Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}