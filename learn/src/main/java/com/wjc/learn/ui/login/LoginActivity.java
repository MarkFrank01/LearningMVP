package com.wjc.learn.ui.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.wjc.learn.ui.learning.HomeActivity;
import com.wjc.learn.R;


public class LoginActivity extends Activity implements LoginContract.View {

    TextInputEditText email;
    TextInputEditText password;
    Button button;
    LoginContract.Presenter presenter;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        presenter = new LoginPresenter(this);

        email = (TextInputEditText) findViewById(R.id.et_email);
        password = (TextInputEditText) findViewById(R.id.et_password);
        button = (Button) findViewById(R.id.btn_server_login);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onServerLoginClick(email.getText().toString(),
                        password.getText().toString());
            }
        });

    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void openMainActivity() {
        Intent intent = HomeActivity.getStartIntent(LoginActivity.this);
        startActivity(intent);
        finish();
    }

    @Override
    public void empty_email() {
        Toast.makeText(this, R.string.empty_email, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void invalid_email() {
        Toast.makeText(this, R.string.invalid_email, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void empty_password() {
        Toast.makeText(this, R.string.empty_password, Toast.LENGTH_SHORT).show();
    }

}
