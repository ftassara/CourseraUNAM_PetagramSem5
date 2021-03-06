package com.ftassara.courseraunam_datosusuario.presenter;

import android.content.Context;

import com.ftassara.courseraunam_datosusuario.IRecyclerViewFragmentView;
import com.ftassara.courseraunam_datosusuario.adapter.ContactoAdapter;
import com.ftassara.courseraunam_datosusuario.db.ConstrutorMascotas;
import com.ftassara.courseraunam_datosusuario.pojo.Mascotas;

import java.util.ArrayList;

public class RecylcerViewFragmentPresenter implements IRecyclerViewFragmentPresenter {
    private IRecyclerViewFragmentView mIRecyclerViewFragmentView;
    private Context mContext;
    private ConstrutorMascotas mConstrutorMascotas;
    private ArrayList<Mascotas> mMascotas;

    public RecylcerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context) {
        this.mIRecyclerViewFragmentView=iRecyclerViewFragmentView;
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
        mIRecyclerViewFragmentView.inicializarAdaptador(mIRecyclerViewFragmentView.crearAdaptador(mMascotas));
        mIRecyclerViewFragmentView.generarLayoutVertical();
    }
}
