package exos.lujan.jose.joselujanexos;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.androidplot.xy.LineAndPointFormatter;
import com.androidplot.xy.SimpleXYSeries;
import com.androidplot.xy.XYPlot;
import com.androidplot.xy.XYSeries;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private XYPlot myXYPlot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myXYPlot = (XYPlot) findViewById(R.id.myXYPlot);

        Number[] Memory={0,4,4,4,5,4,6};
        Number[] Cpu={0,2,6,3,2,7,2};

        XYSeries series1 = new SimpleXYSeries(
                Arrays.asList(Memory),
                SimpleXYSeries.ArrayFormat.Y_VALS_ONLY,
                "Memory");

        XYSeries series2 = new SimpleXYSeries(
                Arrays.asList(Cpu),
                SimpleXYSeries.ArrayFormat.Y_VALS_ONLY,
                "Cpu");

        LineAndPointFormatter series1Format = new LineAndPointFormatter(
                Color.rgb(0,200,0),
                Color.rgb(0,100,0),
                Color.rgb(150,190,150),null);

        myXYPlot.addSeries(series1,series1Format);

        LineAndPointFormatter series2Format = new LineAndPointFormatter(
                Color.rgb(0,0,200),
                Color.rgb(0,0,100),
                Color.rgb(150,150,190),null);

        myXYPlot.addSeries(series2,series2Format);


    }
}
