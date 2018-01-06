package com.trappist.logintdd.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.support.design.widget.Snackbar;

import com.trappist.logintdd.R;
import com.trappist.logintdd.presenter.LoginPresenter;
import com.trappist.logintdd.presenter.LoginView;

public class LoginActivity extends AppCompatActivity implements LoginView {

    private EditText editUsername;
    private EditText editPassword;
    private LoginPresenter loginPresenter;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initializePresenter();
        initializeViews();
    }

    private void initializeViews() {

        editUsername = (EditText) findViewById(R.id.editUsername);
        editPassword = (EditText) findViewById(R.id.editPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginPresenter.doLogin(editUsername.getText().toString().trim(), editPassword.getText().toString().trim());
            }
        });
    }

    private void initializePresenter() {
        loginPresenter = new LoginPresenter(this);
    }

    @Override
    public void showErrorMessageForWrongUsernamePassword() {
        Snackbar.make(editPassword, "Please check Username or Password.", Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showErrorMessageForMaxLoginAttempt() {
        Toast.makeText(this, "You've exceeded Maximum limit", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoginSuccessMessage() {
        Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show();
    }
}