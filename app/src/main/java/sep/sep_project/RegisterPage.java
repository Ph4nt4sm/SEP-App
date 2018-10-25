package sep.sep_project;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class RegisterPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    EditText username = (EditText) findViewById(R.id.registerEmail);
    EditText password = (EditText) findViewById(R.id.registerPassword);
    Button b1 = (Button)findViewById(R.id.RegisterBtn);

    public void createAccount(View view) {
        if (username.getText().toString().equals("admin") && password.getText().toString().equals("admin")) {
            //correct password
            Toast.makeText(getApplicationContext(), "New User Registered",Toast.LENGTH_SHORT).show();

            //Redirects to the HomePage
            Intent intent = new Intent(this, HomePage.class);
            startActivity(intent);
        }
    }
}