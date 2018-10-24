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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    EditText username = (EditText) findViewById(R.id.registerEmail);
    EditText password = (EditText) findViewById(R.id.registerPassword);
    Button b1 = (Button)findViewById(R.id.RegisterBtn);

    public void login(View view) {
        if (username.getText().toString().equals("admin") && password.getText().toString().equals("admin")) {
            //correct password
        } else {
            //wrong password
            Toast.makeText(getApplicationContext(), "Wrong Credentials",Toast.LENGTH_SHORT).show();
            username.setVisibility(View.VISIBLE);
            username.setBackgroundColor(Color.RED);
            int counter = 3;
            counter--;
            username.setText(Integer.toString(counter));

            if(counter==0){
                //disables the button, sets timer to 60 seconds before the button reactivates
                new CountDownTimer(60000, 1000) {
                    @Override
                    public void onTick(long l) {
                        Toast.makeText(getApplicationContext(), "Try again in 60 seconds",Toast.LENGTH_SHORT).show();
                        username.setVisibility(View.VISIBLE);
                        username.setBackgroundColor(Color.RED);
                        b1.setEnabled(false);
                    }

                    public void onFinish() {
                        Toast.makeText(getApplicationContext(), "Done", Toast.LENGTH_SHORT).show();
                        b1.setEnabled(true);
                    }
                }.start();
            }
        }
    }

}
