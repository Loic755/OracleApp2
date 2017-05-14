package exos.lujan.jose.joselujanexos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button boton;
    AutoCompleteTextView auto;
    TextView texto;

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
