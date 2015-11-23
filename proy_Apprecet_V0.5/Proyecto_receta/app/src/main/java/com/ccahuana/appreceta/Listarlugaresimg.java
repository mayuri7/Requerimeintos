package com.ccahuana.appreceta;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.ramiromadriaga.viewpagerlistviewactivity.R;


public class Listarlugaresimg extends ActionBarActivity {

    int[] imagenCircuitoapurimac = {
            R.drawable.chicharron_chanco,
            R.drawable.cuy_chactado,
            R.drawable.estofado_de_gallina,
            R.drawable.sopa_de_chairo,
            R.drawable.tamales,
            R.drawable.sopa_de_olluco,
            R.drawable.picante_de_atajo,
            R.drawable.olluquito_con_charqui
    };

    int[] imagenCircuitocusco = {
            R.drawable.chiri_uchu,
            R.drawable.pepian_de_cuy,
            R.drawable.queso_kapchi,
            R.drawable.puchero
    };

    int[] imagenhuancavelica = {
            R.drawable.mondongo,
            R.drawable.pachamanca,
            R.drawable.elpuchero,
            R.drawable.carnero_al_palo,
            R.drawable.patachi
    };

    int[] imagenCircuitoayacucho = {
            R.drawable.puca_picante,
            R.drawable.patasca,
            R.drawable.qapchi,
            R.drawable.teqte,
            R.drawable.sopa_chochoca,
            R.drawable.patachi
    };

    int[] imagenCircuitoarequipa = {
            R.drawable.ocopa,
            R.drawable.rocoto_relleno,
            R.drawable.cauche,
            R.drawable.chaque_tripas,
            R.drawable.solterito,
            R.drawable.chupe_camarones,
            R.drawable.adobo
    };

    int[] imagenCircuitoamazonas = {
            R.drawable.cazuela,
            R.drawable.carne_arrollada,
            R.drawable.juanes_de_yuca,
            R.drawable.tacachos_cecina
    };

    String[] titulo;
    String[] contenido;

    private ListView lista;
    ListViewAdapter adapter;

    int currentViewPager;
    String nombreCircuito;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listar_lugares_img);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);  //ir atras

        Bundle extras = getIntent().getExtras();
        currentViewPager = extras.getInt("currentViewPager");
        nombreCircuito = extras.getString("nombreCircuito");
        Log.i("ramiro", "currentViewPager: " + currentViewPager);


        /**INDICAR TITULO **/
        actionBar.setTitle(nombreCircuito);

        lista = (ListView) findViewById(R.id.listView_listarCircuito);
        switch (currentViewPager){
            case 0: // ****************  APURIMAC  *************************************************
                titulo = getResources().getStringArray(R.array.circuitoapurimac_titulo);
                contenido = getResources().getStringArray(R.array.circuitoapurimac_contenido);
                adapter = new ListViewAdapter(this, imagenCircuitoapurimac, titulo, contenido);
                break;
            case 1: //********************CUSCO  ***************************************************
                titulo = getResources().getStringArray(R.array.circuitocusco_titulo);
                contenido = getResources().getStringArray(R.array.circuitocusco_contenido);
                adapter = new ListViewAdapter(this, imagenCircuitocusco, titulo, contenido);
                break;

            case 2: //*************************** HUANCAVELICA  ************************************
                titulo = getResources().getStringArray(R.array.rutahuancavelica_titulo);
                contenido = getResources().getStringArray(R.array.rutahuancavelica_contenido);
                adapter = new ListViewAdapter(this, imagenhuancavelica, titulo, contenido);
                break;

            case 3: //****************************** AYACUCHO  *************************************
                titulo = getResources().getStringArray(R.array.circuitoayacucho_titulo);
                contenido = getResources().getStringArray(R.array.circuitoayacucho_contenido);
                adapter = new ListViewAdapter(this, imagenCircuitoayacucho, titulo, contenido);
                break;

            case 4: //****************************** AREQUIPA  *************************************
                titulo = getResources().getStringArray(R.array.circuitoarequipa_titulo);
                contenido = getResources().getStringArray(R.array.circuitoarequipa_contenido);
                adapter = new ListViewAdapter(this, imagenCircuitoarequipa, titulo, contenido);
                break;

            case 5: //******************************* AMAZONAS *************************************
                titulo = getResources().getStringArray(R.array.circuitoamazonas_titulo);
                contenido = getResources().getStringArray(R.array.circuitoamazonas_contenido);
                adapter = new ListViewAdapter(this, imagenCircuitoamazonas, titulo, contenido);
                break;

            default:
                Toast.makeText(getApplicationContext(), "no esta cargado, pronto lo estará", Toast.LENGTH_SHORT).show();
        }
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getApplicationContext(), ListarLugares.class);
                i.putExtra("idcircuito",currentViewPager);
                i.putExtra("position", position);
                i.putExtra("nombreCircuito", nombreCircuito);
                i.putExtra("nombreSubCircuito", titulo[position]);
                startActivity(i);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);


            }
        });
    }


    /******************* LISTVIEW ADAPTER **************************/

    public class ListViewAdapter extends BaseAdapter {
        // Declare Variables
        Context context;
        int[] imagenes;
        String[] titulos;
        String[] contenido;
        LayoutInflater inflater;

        public ListViewAdapter(Context context, int[] imagenes, String[] titulos, String[] contenido ) {
            this.context = context;
            this.imagenes = imagenes;
            this.titulos = titulos;
            this.contenido = contenido;
        }

        @Override
        public int getCount() {
            return titulos.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        public View getView(int position, View convertView, ViewGroup parent) {

            // Declare Variables
            ImageView imgImg;
            TextView txtTitle;
            TextView txtContenido;

            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View itemView = inflater.inflate(R.layout.single_post_recetas, parent, false);

            imgImg = (ImageView) itemView.findViewById(R.id.imagen_single_post_circuito);
            txtTitle = (TextView) itemView.findViewById(R.id.tv_titulo_single_post_circuito);
            txtContenido = (TextView) itemView.findViewById(R.id.tv_contenido_single_post_circuito);

            //captura la posicion
            imgImg.setImageResource(imagenes[position]);
            txtTitle.setText(titulos[position]);
            txtContenido.setText(contenido[position]);

            return itemView;
        }
    }
}
