package exos.lujan.jose.joselujanexos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listview);

        FrutasVerduras frutasVerduras_datos[] = new FrutasVerduras[]{
                new FrutasVerduras(R.mipmap.ic_launcher_round,"Manzana"),
                new FrutasVerduras(R.mipmap.ic_launcher,"Pepino"),
                new FrutasVerduras(R.mipmap.ic_launcher,"Mango"),
                new FrutasVerduras(R.mipmap.ic_launcher,"Pera")


        };
        View header = (View) getLayoutInflater().inflate(R.layout.list_header_row,null);
        listView.addHeaderView(header);

        FrutasVerdurasAdapter adapter = new FrutasVerdurasAdapter(this, R.layout.listview_item_row,frutasVerduras_datos);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView v = (TextView) view.findViewById(R.id.tv);
                Toast.makeText(getApplicationContext(), v.getText(), Toast.LENGTH_SHORT).show();
            }
        });



    }

}
