package com.ccahuana.appreceta;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ramiromadriaga.viewpagerlistviewactivity.R;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    ViewPagerAdapter mSectionsPagerAdapter;
    ViewPager mViewPager;
    public String[] mCircuito;

    protected static Integer[] mImageIds = {
            R.drawable.apurimac,
            R.drawable.cusco,
            R.drawable.abancay,
            R.drawable.ayacucho,
            R.drawable.arequipa,
            R.drawable.amazonas
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //VIEWPAGER
        mCircuito = getResources().getStringArray(R.array.circuito);

        mSectionsPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.pager);

        mSectionsPagerAdapter.addFragment(Fragmentos.newInstance(0, mCircuito[0], mImageIds[0]));
        mSectionsPagerAdapter.addFragment(Fragmentos.newInstance(1, mCircuito[1], mImageIds[1]));
        mSectionsPagerAdapter.addFragment(Fragmentos.newInstance(2, mCircuito[2], mImageIds[2]));
        mSectionsPagerAdapter.addFragment(Fragmentos.newInstance(3, mCircuito[3], mImageIds[3]));
        mSectionsPagerAdapter.addFragment(Fragmentos.newInstance(4, mCircuito[4], mImageIds[4]));
        mSectionsPagerAdapter.addFragment(Fragmentos.newInstance(5, mCircuito[5], mImageIds[5]));

        mViewPager.setAdapter(mSectionsPagerAdapter);

        findViewById(R.id.button5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, com.ramiromadriaga.viewpagerlistviewactivity.MapsActivity.class));
            }
        });
        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Splash.class));
            }
        });
        //FIN VIEWPAGER

    }


    /****************** VIEWPAGER *********************/
    public class ViewPagerAdapter extends FragmentPagerAdapter {
        List<Fragment> fragments; //acá voy a guardar los fragments

        //constructor
        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
            fragments = new ArrayList<Fragment>();
        }

        @Override
        public Fragment getItem(int position) {
            //return PlaceholderFragment.newInstance(position + 1);
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            //return 3;
            return this.fragments.size();
        }

        public void addFragment(Fragment xfragment){
            this.fragments.add(xfragment);
        }
    }
    /****************** FIN VIEWPAGER *********************/

    /****************** FRAGMENTOS *********************/
    public static class Fragmentos extends Fragment {
        /**
         Agregue "color"
         */
        private static final String CURRENT_VIEWVAPER ="currentviewpager";
        private static final String NOMBRE_CIRCUITO = "circuito";
        private static final String IMAGEVIEW = "image";

        private int currentViewPager;
        private String nombre_circuito;
        private int image;

        public static Fragmentos newInstance(int currentViewPager, String circuitoNombre, int image) {

            Fragmentos fragment = new Fragmentos();   //instanciamos un nuevo fragment

            Bundle args = new Bundle();                                 //guardamos los parametros
            args.putInt(CURRENT_VIEWVAPER, currentViewPager);
            args.putString(NOMBRE_CIRCUITO, circuitoNombre);
            args.putInt(IMAGEVIEW, image);
            fragment.setArguments(args);
            fragment.setRetainInstance(true);     //agrego para que no se pierda los valores de la instancia
            return fragment;
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            //cuando crea una instancia de tipo PlaceholderFragment
            //si lo enviamos parametros, guarda esos
            //si no le envio nada, toma el color gris y un número aleatroio
            if(getArguments() != null){
                this.currentViewPager = getArguments().getInt(CURRENT_VIEWVAPER);
                this.nombre_circuito = getArguments().getString(NOMBRE_CIRCUITO);
                this.image = getArguments().getInt(IMAGEVIEW);
            }
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_lugares, container, false);

            TextView tv_circuito = (TextView) rootView.findViewById(R.id.tv_circuito);
            tv_circuito.setText(nombre_circuito);

            ImageView frg_image = (ImageView) rootView.findViewById(R.id.frg_imageView);
            frg_image.setImageResource(image);
            frg_image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(getActivity(), Listarlugaresimg.class);
                    i.putExtra("currentViewPager", currentViewPager);
                    i.putExtra("nombreCircuito", nombre_circuito);
                    startActivity(i);

                }
            });
            return rootView;
        }
    }
    /****************** FIN FRAGMENTOS *********************/
}
