package com.matias.mysharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etUsername, etPassword;
    Button btnSave, btnDisplay;
    TextView tvDisplay;
    SharedPreferences preference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etUsername = (EditText) findViewById(R.id.et_username);
        etPassword = (EditText) findViewById(R.id.et_password);
        btnSave = (Button) findViewById(R.id.btn_save);
        btnDisplay = (Button) findViewById(R.id.btn_display);
        tvDisplay = (TextView) findViewById(R.id.tv_display);
        preference = getPreferences(Context.MODE_PRIVATE);
    }

    public void saveInfo(View view) {
        SharedPreferences.Editor editor = preference.edit();
        editor.putString("user",etUsername.getText().toString());
        editor.putString("pwd",etPassword.getText().toString());
        editor.commit();
        Toast.makeText(this, "Saved in Shared Preferences!",Toast.LENGTH_LONG).show();
    }

    public void loadInfo(View view) {
        String user = preference.getString("user","");
        String pwd = preference.getString("pwd","");
        tvDisplay.setText("User is " + user + " and the Password is " + pwd);
    }
}
