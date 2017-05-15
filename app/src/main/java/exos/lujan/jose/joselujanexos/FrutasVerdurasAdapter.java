package exos.lujan.jose.joselujanexos;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import static exos.lujan.jose.joselujanexos.R.id.parent;

/**
 * Created by Quezacoo on 5/15/2017.
 */

public class FrutasVerdurasAdapter extends ArrayAdapter<FrutasVerduras> {
    Context mycontext;
    int mylayoutRessourceID;
    FrutasVerduras mydata[] = null;

    public FrutasVerdurasAdapter (Context context,int layoutRessourceID, FrutasVerduras[] data){
        super(context, layoutRessourceID, data);
        this.mycontext = context;
        this.mylayoutRessourceID = layoutRessourceID;
        this.mydata = data;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        View row = convertView;
        FrutasVerdurasHolder holder = null;

        if (row == null){
            LayoutInflater inflater = ((Activity)mycontext).getLayoutInflater();
            row = inflater.inflate(mylayoutRessourceID,parent,false);
            holder = new FrutasVerdurasHolder();
            holder.imagen = (ImageView) row.findViewById(R.id.image);
            holder.textView=(TextView) row.findViewById(R.id.tv);
            row.setTag(holder);
        }
        else{
            holder = (FrutasVerdurasHolder)row.getTag();
        }

        FrutasVerduras frutasVerduras = mydata[position];
        holder.textView.setText(frutasVerduras.title);
        holder.imagen.setImageResource(frutasVerduras.icon);
        return row;
    }

    static class FrutasVerdurasHolder{
        ImageView imagen;
        TextView textView;
    }
}









