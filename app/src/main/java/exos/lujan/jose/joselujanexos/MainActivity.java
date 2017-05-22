package exos.lujan.jose.joselujanexos;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.List;
import exos.lujan.jose.joselujanexos.model.Student;
import exos.lujan.jose.joselujanexos.service.APIService;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

import static android.R.id.message;

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
        btnGetData = (Button) findViewById(R.id.btnGetData);
        btnInsertData = (Button) findViewById(R.id.buttbtnInsertData);
        editName = (EditText) findViewById(R.id.editname);
        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);
        Log.d("test3 : ", "test3 : ");
        btnGetData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    getPeopleDetails();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Log.d("test1 : ", "test1 : ");
            }
        });
    }
    private void getPeopleDetails () throws IOException {
        Log.d("test2 : ", "test2 : ");


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.75.92.209:8787/")
                .client(new OkHttpClient())
                .addConverterFactory()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
               // .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();
       /* Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.75.92.209:8787/")
                .client(new OkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build();*/

        APIService service = retrofit.create(APIService.class);
        Call<List<Student>> call = service.getPeopleDetails();

        call.enqueue(new Callback<List<Student>>() {
            // Log.d("test1 : ", "test1 : ");
            @Override
            public void onResponse(Call<List<Student>> call, Response<List<Student>> response) {
                List<Student> students = response.body();

                String details = "test";

                textDetails.setText(details);
                //  hidepDialog();
            }

            @Override
            public void onFailure(Call<List<Student>> call, Throwable t) {
                //  hidepDialog();
                textDetails.setText("FAILURE ! :"+t.getMessage());
            }
        });
    };
}
