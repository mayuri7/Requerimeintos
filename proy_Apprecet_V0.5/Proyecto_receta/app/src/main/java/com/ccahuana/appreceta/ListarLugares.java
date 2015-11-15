package com.ccahuana.appreceta;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ramiromadriaga.viewpagerlistviewactivity.R;

public class ListarLugares extends ActionBarActivity {

    private ImageView imgImagen;
    private TextView txtTitulo, txtContenido;
    String[] titulo;
    String[] contenido;

    private int[] imagenCircuitoapurimac = {
            R.drawable.chicharron_chanco,
            R.drawable.cuy_chactado,
            R.drawable.estofado_de_gallina,
            R.drawable.sopa_de_chairo,
            R.drawable.tamales,
            R.drawable.sopa_de_olluco,
            R.drawable.picante_de_atajo,
            R.drawable.olluquito_con_charqui
    };

    private int[] imagenCircuitocusco = {
            R.drawable.chiri_uchu,
            R.drawable.pepian_de_cuy,
            R.drawable.queso_kapchi,
            R.drawable.puchero
    };

    private int[] imagenhuancavelica = {
            R.drawable.mondongo,
            R.drawable.pachamanca,
            R.drawable.elpuchero,
            R.drawable.carnero_al_palo,
            R.drawable.patachi
    };

    private int[] imagenCircuitoayacucho = {
            R.drawable.puca_picante,
            R.drawable.patasca,
            R.drawable.qapchi,
            R.drawable.teqte,
            R.drawable.sopa_chochoca,
            R.drawable.patachiss
    };

    private int[] imagenCircuitoarequipa = {
            R.drawable.ocopa,
            R.drawable.rocoto_relleno,
            R.drawable.cauche,
            R.drawable.chaque_tripas,
            R.drawable.solterito,
            R.drawable.chupe_camarones,
            R.drawable.adobo
    };

    private int[] imagenCircuitoamazonas = {
            R.drawable.cazuela,
            R.drawable.carne_arrollada,
            R.drawable.juanes_de_yuca,
            R.drawable.tacachos_cecina
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listar_lugares);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        Bundle extras = getIntent().getExtras();
        int idcircuito = extras.getInt("idcircuito");
        final int position = extras.getInt("position");
        String nombreCircuito = extras.getString("nombreCircuito");
        String nombreSubCircuito = extras.getString("nombreSubCircuito");

        /**INDICAR TITULO Y SUBTITULO**/
        actionBar.setTitle(nombreCircuito);
        actionBar.setSubtitle(nombreSubCircuito);

        txtTitulo = (TextView) findViewById(R.id.tv_titulo_listaruncircuito);
        txtContenido = (TextView) findViewById(R.id.tv_contenido_listaruncircuito);
        imgImagen = (ImageView) findViewById(R.id.iv_imagen_listaruncircuito);

        switch (idcircuito){
            case 0: //circuito apurimac
                titulo = getResources().getStringArray(R.array.circuitoapurimac_titulo);
                contenido = getResources().getStringArray(R.array.circuitoapurimac_contenido_completo);
                imgImagen.setImageResource(imagenCircuitoapurimac[position]);
                break;
            case 1: //circuito
                titulo = getResources().getStringArray(R.array.circuitocusco_titulo);
                contenido = getResources().getStringArray(R.array.circuitocusco_contenido_completo);
                imgImagen.setImageResource(imagenCircuitocusco[position]);
                break;

            case 2: //ruta huancavelica
                titulo = getResources().getStringArray(R.array.rutahuancavelica_titulo);
                contenido = getResources().getStringArray(R.array.rutahuancavelica_contenido_completo);
                imgImagen.setImageResource(imagenhuancavelica[position]);
                break;

            case 3: //circuito ayacucho
                titulo = getResources().getStringArray(R.array.circuitoayacucho_titulo);
                contenido = getResources().getStringArray(R.array.circuitoayacucho_contenido_completo);
                imgImagen.setImageResource(imagenCircuitoayacucho[position]);
                break;

            case 4: //circuito arequipa
                titulo = getResources().getStringArray(R.array.circuitoarequipa_titulo);
                contenido = getResources().getStringArray(R.array.circuitoarequipa_contenido_completo);
                imgImagen.setImageResource(imagenCircuitoarequipa[position]);
                break;

            case 5: //circuito amazonas
                titulo = getResources().getStringArray(R.array.circuitoamazonas_titulo);
                contenido = getResources().getStringArray(R.array.circuitoamazonas_contenido_completo);
                imgImagen.setImageResource(imagenCircuitoamazonas[position]);
                break;

            default:
                Toast.makeText(getApplicationContext(), "no esta cargado, pronto lo estará", Toast.LENGTH_SHORT).show();
        }
        txtTitulo.setText(titulo[position]);
        txtContenido.setText(contenido[position]);
    }
}
