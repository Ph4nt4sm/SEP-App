package sep.sep_project;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import android.os.AsyncTask;
import android.widget.TextView;
import com.google.gson.*;

public class getDatabaseData{
    public int id;
    public String name;
    public int postcode;
    public String address;
    public String state;
    public String category;
    public String details;
    public String image_location;

}


class GetUrlContentTask extends AsyncTask<String, Integer, String> {
    public String output = null;
    public TextView mTextView = null;
    GetUrlContentTask(TextView tv){
        mTextView = tv;
    }
    protected String doInBackground(String... urls) {
        URL url = null;
        try {
            url = new URL(urls[0]);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection) url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            connection.setRequestMethod("GET");
        } catch (ProtocolException e) {
            e.printStackTrace();
        }
        connection.setDoOutput(true);
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);
        try {
            connection.connect();
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedReader rd = null;
        try {
            rd = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String content = "", line;
        try {
        while ((line = rd.readLine()) != null) {
            content += line + "\n";
        }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return content;
    }

    protected void onProgressUpdate(Integer... progress) {
    }

    protected void onPostExecute(String result) {

        Gson gson = new Gson();
        getDatabaseData[] databaseRes = gson.fromJson(result, getDatabaseData[].class);
        mTextView.setText(databaseRes[0].address);
    }
}


