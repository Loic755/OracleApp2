package exos.lujan.jose.joselujanexos;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button boton;
    AutoCompleteTextView auto;
    TextView texto;
    String cambio2;

    String[] nombres = {"Juanito","Juan","Maria Fernanda","Laura","Miguel"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boton = (Button) findViewById(R.id.boton);
        boton.setOnClickListener(this);

        auto = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        texto = (TextView) findViewById(R.id.texto);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,nombres);
        auto.setThreshold(3);
        auto.setAdapter(adapter);

        Log.d("RESPONSE 3 : ","RESPONSE 3 : ");
        new AsyncTask<Void, Void, String>(){

            @Override
            protected String doInBackground(Void... params){
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url("http://10.75.92.209:8787/rs/msr/sub/MSISDN/6668901223/data/")
                        // .url("http://72.41.28.2/rs/msr/sub/MSISDN/6668901223/data/")
                        .build();

                Response response = null;
                try {
                    response = client.newCall(request).execute();
                    Log.d("RESPONSE4 : ",response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }
        }.execute();
        //String cambio3 = "3";
        //texto.setText("testttt");
    }

    protected void onPostExecute(Void result) {
        Toast.makeText(MainActivity.this, "test", Toast.LENGTH_SHORT)
                .show();
    }
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.boton:
                String cambio = auto.getText().toString();
                texto.setText(cambio);
                break;
        }
    }



}