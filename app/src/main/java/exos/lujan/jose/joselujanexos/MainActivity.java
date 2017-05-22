package exos.lujan.jose.joselujanexos;
import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.io.IOException;
import java.util.List;

import exos.lujan.jose.joselujanexos.model.Pelicula;
import exos.lujan.jose.joselujanexos.service.PeliculaServicio;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.OkClient;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {

    EditText editName;
    TextView textDetails;
    Button btnGetData, btnInsertData;

    private ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textDetails = (TextView) findViewById(R.id.textDetails);

        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint("http://10.75.92.209:8787/").build();

        PeliculaServicio servicio = restAdapter.create(PeliculaServicio.class);
        servicio.getPelicula(new Callback<List<Pelicula>>() {
                                 @Override
                                 public void success(List<Pelicula> peliculas, Response response) {
                                     textDetails.setText("SUCCESS : ");
                                 }

                                 @Override
                                 public void failure(RetrofitError error) {
                                     textDetails.setText("FAILURE : "+error.getMessage());
                                 }
                             });

    }
}

