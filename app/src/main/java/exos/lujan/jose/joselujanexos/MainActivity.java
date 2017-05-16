package exos.lujan.jose.joselujanexos;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import com.google.api.client.json.gson.GsonFactory;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DefaultHttpClient client = null;
        HttpPost mRequest = new HttpPost("http://127.0.0.1);

        DefaultHttpClient client = new DefaultHttpClient();


        try {
            HttpResponse response = client.execute(mRequest);

            InputStream source = response.getEntity().getContent();
            Reader reader = new InputStreamReader(source);

            //GSON is one of the best alternatives for JSON parsing
            Gson gson = new Gson();

            User user = gson.fromJson(reader, User.class);

            //At this point you can do whatever you need with your parsed object.

        } catch (IOException e) {
            mRequest.abort();
        }

    }
}
