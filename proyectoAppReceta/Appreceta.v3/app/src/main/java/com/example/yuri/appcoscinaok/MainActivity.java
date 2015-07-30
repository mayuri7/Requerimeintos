package com.example.yuri.appcoscinaok;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import java.util.ArrayList;


public class MainActivity extends Activity{


    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lista =(ListView) findViewById(R.id.listView_lista);
        ArrayList<Lista_recetas> arraydatos = new ArrayList<Lista_recetas>();
        Lista_recetas lista_recetas;

        //introdusco datoss

        lista_recetas = new Lista_recetas(getResources().getDrawable(R.drawable.foto1), "Foto nuemero 1","Imagen de tipo png");
        arraydatos.add(lista_recetas);

        lista_recetas = new Lista_recetas(getResources().getDrawable(R.drawable.foto1), "Foto  numero 2","Imagen de tipo png");
      arraydatos.add(lista_recetas);

        //creo el adapter perzonlizado
        AdapterDatos adapter = new AdapterDatos(this,arraydatos);

        //lo aplico
        lista.setAdapter(adapter);


        findViewById(R.id.BtnRecetas).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Lista_recetas.class));
            }
        });
    }



































   /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    */
}
