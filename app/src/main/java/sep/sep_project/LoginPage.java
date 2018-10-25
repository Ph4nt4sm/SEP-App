package sep.sep_project;

import android.content.Intent;
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
    }

    EditText username = (EditText) findViewById(R.id.username);
    EditText password = (EditText) findViewById(R.id.Password);
    Button b1 = (Button)findViewById(R.id.login);

    //Checks the Login in correct or not
    public void login(View view) {
        if (username.getText().toString().equals("admin") && password.getText().toString().equals("admin")) {
            //correct password
            Toast.makeText(getApplicationContext(), "Success",Toast.LENGTH_SHORT).show();

            //Goes to the HomePage
            Intent intent = new Intent(this, HomePage.class);
            startActivity(intent);
        } else {
            //wrong password
            Toast.makeText(getApplicationContext(), "Wrong Credentials",Toast.LENGTH_SHORT).show();
            username.setVisibility(View.VISIBLE);
            username.setBackgroundColor(Color.RED);
            int counter = 3;
            counter--;
            username.setText(Integer.toString(counter));

            if(counter==0){
                //disables the button, sets timer to 30 seconds before the button reactivates
                new CountDownTimer(30000, 1000) {
                    @Override
                    public void onTick(long l) {
                        //Timer is set to 30 seconds
                        Toast.makeText(getApplicationContext(), "Try again in 30 seconds",Toast.LENGTH_SHORT).show();
                        username.setVisibility(View.VISIBLE);
                        username.setBackgroundColor(Color.RED);
                        b1.setEnabled(false);
                    }

                    //Timer Finishes
                    public void onFinish() {
                        Toast.makeText(getApplicationContext(), "Done", Toast.LENGTH_SHORT).show();
                        b1.setEnabled(true);
                    }
                }.start();
            }
        }
    }

    //Redirect to Register Page
    public void GoToRegister(View view){
        Intent intent = new Intent(this, RegisterPage.class);
        startActivity(intent);
    }

    //Redirect to the Recovery Page
    public void GoToRecover(View view){
        Intent intent = new Intent(this, RecoverUserDetails.class);
        startActivity(intent);
    }
}