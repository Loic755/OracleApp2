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
import android.widget.EditText;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.widget.Toast;
import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static android.R.attr.data;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {

    Button boton;
    EditText edittext;
    EditText editTextOcudrIp;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boton = (Button) findViewById(R.id.button1);
        boton.setOnClickListener(this);

        edittext = (EditText) findViewById(R.id.editText);
        edittext.setText("6668901223");

        editTextOcudrIp  = (EditText) findViewById(R.id.editText2);
        editTextOcudrIp.setText("10.75.92.209");
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.button1:
                //Toast.makeText(getApplicationContext(),edittext.getText().toString(),Toast.LENGTH_SHORT).show();
                String[] myTaskParams = { edittext.getText().toString(),editTextOcudrIp.getText().toString()};
               new LongOperation().execute(myTaskParams);
                break;
        }
    }

    private class LongOperation extends AsyncTask<String, Void, String> {

        String msisdn = null;

        @Override
        protected String doInBackground(String... params) {
            String msisdn = params[0];
            String ocudrIp = params[1];
            //Toast.makeText(getApplicationContext(),"test",Toast.LENGTH_SHORT).show();

            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    //.url("http://10.75.92.209:8787/rs/msr/sub/MSISDN/6668901223/data/")
                    .url("http://"+ocudrIp+":8787/rs/msr/sub/MSISDN/"+msisdn+"/data/")
                    .build();

            Response response = null;
            String Fresponse = "Nothing to return";

            try {
                response = client.newCall(request).execute();
                Fresponse = response.body().string();
                Log.d("RESPONSE : ",Fresponse);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return Fresponse;
        }

        @Override
        protected void onPostExecute(String result) {
            TextView txt = (TextView) findViewById(R.id.output);
            txt.setText("OCUDR responded to REST request: "+result);
        }

        @Override
        protected void onPreExecute() {
        }

        @Override
        protected void onProgressUpdate(Void... values) {
        }

    }

}





