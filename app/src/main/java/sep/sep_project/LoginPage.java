package sep.sep_project;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class LoginPage extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recover_user_details);
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

    EditText username = (EditText) findViewById(R.id.username);
    EditText password = (EditText) findViewById(R.id.Password);
    Button b1 = (Button)findViewById(R.id.login);

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