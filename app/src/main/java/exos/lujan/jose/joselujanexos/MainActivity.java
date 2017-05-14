package exos.lujan.jose.joselujanexos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button boton;
    CheckBox checkR,checkA,checkAm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boton = (Button) findViewById(R.id.button);
        boton.setOnClickListener(this);

        checkR = (CheckBox)  findViewById(R.id.uno);
        checkA = (CheckBox)  findViewById(R.id.dos);
        checkAm = (CheckBox)  findViewById(R.id.tres);


    }

    @Override
    public void onClick(View v) {
        StringBuffer result = new StringBuffer();
        result.append("Rojo: ").append(checkR.isChecked());
        result.append("Azul: ").append(checkA.isChecked());
        result.append("Amarillo: ").append(checkAm.isChecked());
       // Toast.makeText(getApplicationContext(),"Hola eso es un toast",Toast.LENGTH_SHORT).show() ;
        //Toast.makeText(MainActivity.this,result.toString(),Toast.LENGTH_SHORT).show();
        Toast.makeText(getApplicationContext(),result.toString(),Toast.LENGTH_SHORT).show();
    }
}
