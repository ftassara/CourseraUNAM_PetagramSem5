package com.ftassara.courseraunam_datosusuario.activities;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ftassara.courseraunam_datosusuario.IRecyclerViewFragmentView;
import com.ftassara.courseraunam_datosusuario.pojo.Mascotas;
import com.ftassara.courseraunam_datosusuario.R;
import com.ftassara.courseraunam_datosusuario.adapter.ContactoAdapter;
import com.ftassara.courseraunam_datosusuario.presenter.FavoritosFragmentPresenter;
import com.ftassara.courseraunam_datosusuario.presenter.IRecyclerViewFragmentPresenter;

import java.util.ArrayList;

public class FavoritosActivity extends AppCompatActivity implements IRecyclerViewFragmentView {
    ArrayList<Mascotas> mMascotasFav;
    private RecyclerView listaMascotasFav;
    private IRecyclerViewFragmentPresenter presenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);
        Log.d("Favoritos","Si, entro a favoritos");
        //Defino la toolbar
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    listaMascotasFav = (RecyclerView) findViewById(R.id.recyclerviewfav);
    //Creo el Layou Manager, en este caso lineal, y lo asocio al recycler view, asi pone una abajo de otra (porque es linear)
        presenter= new FavoritosFragmentPresenter(this,this);
    }



    private void initListaContactos() {
//        mMascotasFav = new ArrayList<Mascotas>();
//        mMascotasFav.add(new Mascotas(R.drawable.perro1,"Perro A",0));
//        mMascotasFav.add(new Mascotas(R.drawable.perro2,"Perro B",0));
//        mMascotasFav.add(new Mascotas(R.drawable.perro1,"Perro C",0));
//        mMascotasFav.add(new Mascotas(R.drawable.perro2,"Perro D",0));
//        mMascotasFav.add(new Mascotas(R.drawable.perro1,"Perro E",0));
    }
    @Override
    public void generarLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotasFav.setLayoutManager(llm);
    }

    @Override
    public ContactoAdapter crearAdaptador(ArrayList<Mascotas> mascotas) {
        ContactoAdapter adapter =  new ContactoAdapter(mascotas,this);
        return adapter;
    }

    @Override
    public void inicializarAdaptador(ContactoAdapter adaptador) {
        listaMascotasFav.setAdapter(adaptador);
    }



}
