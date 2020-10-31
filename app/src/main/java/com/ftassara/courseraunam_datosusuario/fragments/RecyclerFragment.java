package com.ftassara.courseraunam_datosusuario.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ftassara.courseraunam_datosusuario.IRecyclerViewFragmentView;
import com.ftassara.courseraunam_datosusuario.R;
import com.ftassara.courseraunam_datosusuario.activities.FavoritosActivity;
import com.ftassara.courseraunam_datosusuario.activities.MainActivity;
import com.ftassara.courseraunam_datosusuario.adapter.ContactoAdapter;
import com.ftassara.courseraunam_datosusuario.adapter.MascotaAdapter;
import com.ftassara.courseraunam_datosusuario.db.ConstrutorMascotas;
import com.ftassara.courseraunam_datosusuario.pojo.Mascotas;
import com.ftassara.courseraunam_datosusuario.presenter.IRecyclerViewFragmentPresenter;
import com.ftassara.courseraunam_datosusuario.presenter.RecylcerViewFragmentPresenter;
import com.ftassara.courseraunam_datosusuario.viewholder.ContactoViewHolder;

import java.util.ArrayList;

public class RecyclerFragment extends Fragment implements IRecyclerViewFragmentView {
    private RecyclerView listaMascotas;
    ArrayList<Mascotas> mMascotas;
    private IRecyclerViewFragmentPresenter presenter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_recycler,container,false);
        listaMascotas = (RecyclerView) v.findViewById(R.id.recyclerview);
        presenter= new RecylcerViewFragmentPresenter(this,getContext());
        return v;
    }



    @Override
    public void generarLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
    }

    @Override
    public ContactoAdapter crearAdaptador(ArrayList<Mascotas> mascotas) {
        ContactoAdapter adapter =  new ContactoAdapter(mascotas,getActivity());
        return adapter;
    }

    @Override
    public void inicializarAdaptador(ContactoAdapter adaptador) {
        listaMascotas.setAdapter(adaptador);
    }
}
