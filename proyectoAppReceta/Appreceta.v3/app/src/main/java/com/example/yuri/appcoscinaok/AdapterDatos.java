package com.example.yuri.appcoscinaok;

import android.app.Activity;
import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class AdapterDatos extends BaseAdapter {

    //DECLARAMOS LOS SIGUENTES
    protected Activity activity;

    //dentro del arraylist colocamos la clase datos
    protected ArrayList<Lista_recetas> items;

    //metodo costructor de la clase

    public AdapterDatos(Activity activity,ArrayList<Lista_recetas> items){

        this.activity = activity;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }
    @Override
    public Object getItem(int position) {
        //obtenemos la posicion del items
        return items.get(position);
    }
    @Override
    public long getItemId(int position)
    {
        return items.get(position).getId();
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //generaremos una convertview po eficiencia
        View v = convertView;
        //Asociamos el layout de las listas que hemos creado
      if(convertView == null) {
          LayoutInflater inf = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
          v = inf.inflate(R.layout.itemlista, null);
      }
        //creamos un objeto de la clase lista receta
        Lista_recetas lista_recetas = items.get(position);

        //creamos un objeto de la clase lista recetas
        Lista_recetas dir = items.get(position);
        //Rellenamos la fotografia
        ImageView foto = (ImageView) v.findViewById(R.id.imageView_Foto);
        foto.setImageDrawable(lista_recetas.getFoto());
        //Rellenamos el nombre
        TextView nombre = (TextView) v.findViewById(R.id.textView_nombre);
        nombre.setText(lista_recetas.getNombre());
        //Rellenamos con el info
        TextView info= (TextView) v.findViewById(R.id.textView_info);
        info.setText(lista_recetas.getInfo());
            //retornamos la vista
        return v;
    }
}
