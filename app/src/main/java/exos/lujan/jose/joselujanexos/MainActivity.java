package exos.lujan.jose.joselujanexos;

import android.app.Dialog;
//import android.support.v4.media.MediaDescriptionCompatApi21;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button boton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boton = (Button) findViewById(R.id.button);
        boton.setOnClickListener(this);
    }

    protected Dialog onCreateDialog(int id){
        Dialog dialog = null;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder = builder.setIcon(R.drawable.ic_launcher);
        builder = builder.setTitle("Mi primer Dialog!");
        dialog = builder.create();
        return dialog;
    }

    @Override
    public void onClick(View v) {
        onCreateDialog(1).show();
        //Toast.makeText(getApplicationContext(),"Hola eso es un toast",Toast.LENGTH_SHORT).show() ;

    }
}
