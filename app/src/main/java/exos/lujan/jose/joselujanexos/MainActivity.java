package exos.lujan.jose.joselujanexos;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.service.chooser.ChooserTarget;
import android.service.chooser.ChooserTargetService;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    Intent intent;
   // ChooserTargetService chooser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /* intent = new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("mailto:"));
        String[] to = {"loic.roubaud@gmail.com"};
        intent.putExtra(Intent.EXTRA_EMAIL,to);
        intent.putExtra(Intent.EXTRA_SUBJECT, "Hi this is sent from android app");
        intent.putExtra(Intent.EXTRA_TEXT, "TEXT");
        intent.setType("message/rfc822");
        Intent chooser=Intent.createChooser(intent, "Send email");
        startActivity(chooser);*/

        intent = new Intent(Intent.ACTION_DIAL);
       intent.setData(Uri.parse("tel:30031201234"));


        startActivity(intent);


    }
}
