package com.example.yuri.appcoscinaok;

import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class Lista_recetas {

    //declarando los siguentes atributos
    protected Drawable foto;
    protected String nombre;
    protected String info;
    protected long id;

    //metodo consructor de la clase
    public Lista_recetas(Drawable foto, String nombre, String info) {

        //a los parametros le asignamos los parametros
        this.foto = foto;
        this.nombre = nombre;
        this.info = info;
      // this.id = id;

    }

    //metodo get y set
    //metodo get obtiene los datos
    public Drawable getFoto() {

        return foto;
    }

    //metodo set asigana o inicializa los datos o listas
    public void setFoto(Drawable foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;

    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String cargo) {

        this.info = cargo;
    }
public long getId(){
    return id;

}
    public void setId (long id){
        this.id =id;
    }

}

