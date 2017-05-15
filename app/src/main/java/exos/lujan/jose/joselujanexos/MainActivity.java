package exos.lujan.jose.joselujanexos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String[] elementos = {"Jose","Pedro","Mario","Miguel","Luis","Daniel","Elena","Sofia"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FrutasVerduras frutasVerduras_datos[] = new FrutasVerduras[]{
                new FrutasVerduras(R.mipmap.ic_launcher,"Manzana"),
                new FrutasVerduras(R.mipmap.ic_launcher,"Pepino"),
                new FrutasVerduras(R.mipmap.ic_launcher,"Mango"),
                new FrutasVerduras(R.mipmap.ic_launcher,"Pera"),


        };

        FrutasVerdurasAdapter adapter = new FrutasVerdurasAdapter(this, R.layout.listview_item_row,frutasVerduras_datos);
        listView = (ListView) findViewById(R.id.listview);

        View header = (View) getLayoutInflater().inflate(R.layout.list_header_row,null);

        listView.addHeaderView(header);
        listView.setAdapter(adapter);

    }
}
