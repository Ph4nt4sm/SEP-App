package sep.sep_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class  MainPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        getDatabaseData database = new getDatabaseData();


        final TextView textViewToChange = (TextView) findViewById(R.id.testText);
        new GetUrlContentTask(textViewToChange).execute("http://sisyphus.sytes.net/index.php?get_restaraunts");

    }
    public void GoTo (View v){
        Intent intent = new Intent( this, HomePage.class);
        startActivity(intent);
    }
    public void restaurants (View v) {
        Intent intent = new Intent(this, restaurants.class);
        startActivity(intent);
    }

}
