package com.ftassara.courseraunam_datosusuario.presenter;

import android.content.Context;

import com.ftassara.courseraunam_datosusuario.IMascotasFragmentView;
import com.ftassara.courseraunam_datosusuario.IRecyclerViewFragmentView;
import com.ftassara.courseraunam_datosusuario.db.ConstrutorMascotas;
import com.ftassara.courseraunam_datosusuario.pojo.Mascotas;

import java.util.ArrayList;

public class MascotasFragmentPresenter implements IRecyclerViewFragmentPresenter {
    private IMascotasFragmentView mIMascotasFragmentView;
    private Context mContext;
    private ConstrutorMascotas mConstrutorMascotas;
    private ArrayList<Mascotas> mMascotas;

    public MascotasFragmentPresenter(IMascotasFragmentView iMascotasFragmentView, Context context) {
        this.mIMascotasFragmentView=iMascotasFragmentView;
        this.mContext=context;
        obtenerContactosBaseDatos();
    }

    @Override
    public void obtenerContactosBaseDatos() {
        mConstrutorMascotas = new ConstrutorMascotas(mContext);
        mMascotas= mConstrutorMascotas.obtenerMascotas();
        mostrarContactosRV();
    }

    @Override
    public void mostrarContactosRV() {
        mIMascotasFragmentView.inicializarAdaptador(mIMascotasFragmentView.crearAdaptador(mMascotas));
        mIMascotasFragmentView.generarLayoutGrid();
    }
}
