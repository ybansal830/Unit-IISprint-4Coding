package com.myfirst.unit_iisprint_4coding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText mEtEmail, mEtPassword;
    private CheckBox mCbRemember;
    private Button mBtnSubmit;
    private String emailValid = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savePreference.getStringFromPreference(this, "key1") != null) {
            Intent intent = new Intent(MainActivity.this, HomeScreen.class);
            startActivity(intent);
        }
        initViews();
        mBtnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate()) {
                    if (mCbRemember.isChecked()) {
                        savePreference.writeStringToPreference(MainActivity.this, "key1"
                                , mEtEmail.getText().toString());
                    }
                    Intent intent = new Intent(MainActivity.this, HomeScreen.class);
                    startActivity(intent);
                }
            }
        });
    }

    private void initViews() {
        mEtEmail = findViewById(R.id.etEmail);
        mEtPassword = findViewById(R.id.etPassword);
        mCbRemember = findViewById(R.id.cbRemember);
        mBtnSubmit = findViewById(R.id.btnSubmit);
    }

    private boolean validate() {
        if (!mEtEmail.getText().toString().matches(emailValid)){
            mEtEmail.setError("InValid Email");
            return false;
        }
        if (mEtPassword.getText().toString().length() < 6) {
            mEtPassword.setError("Password is very short");
            return false;
        }
        return true;
    }
}