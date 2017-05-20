package exos.lujan.jose.joselujanexos;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.Settings.System;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;
import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new LongOperation().execute("");
    }

    private class LongOperation extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {

            String msisdn = "6668901223";
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    //.url("http://10.75.92.209:8787/rs/msr/sub/MSISDN/6668901223/data/")
                    .url("http://10.75.92.209:8787/rs/msr/sub/MSISDN/"+msisdn+"/data/")
                    .build();

            Log.d("RESPONSE5 : ","RESPONSE5 : ");

            Response response = null;
            String Fresponse = "Nothing to return";

            try {
                response = client.newCall(request).execute();
                Fresponse = response.body().string();
                Log.d("RESPONSE4 : ",Fresponse);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return Fresponse;
        }

        @Override
        protected void onPostExecute(String result) {
            TextView txt = (TextView) findViewById(R.id.output);
            txt.setText("OCUDR responded to REST GET request: "+result);
        }

        @Override
        protected void onPreExecute() {
        }

        @Override
        protected void onProgressUpdate(Void... values) {
        }

    }

}





