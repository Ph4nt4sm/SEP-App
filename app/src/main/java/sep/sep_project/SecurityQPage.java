package sep.sep_project;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SecurityQPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_security_qpage);
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

    public void createAccount(View view) {
        if (username.getText().toString().equals("admin") && password.getText().toString().equals("admin")) {
            //correct password
            Toast.makeText(getApplicationContext(), "New User Registered",Toast.LENGTH_SHORT).show();

            //Redirects to the HomePage
            Intent intent = new Intent(this, SecurityQPage.class);
            startActivity(intent);
        }
    }
}