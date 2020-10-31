package com.ftassara.courseraunam_datosusuario;

import com.ftassara.courseraunam_datosusuario.adapter.ContactoAdapter;
import com.ftassara.courseraunam_datosusuario.adapter.MascotaAdapter;
import com.ftassara.courseraunam_datosusuario.pojo.Mascotas;

import java.util.ArrayList;

public interface IMascotasFragmentView {

    public void generarLayoutGrid();

    public MascotaAdapter crearAdaptador(ArrayList<Mascotas> mascotas);

    public void inicializarAdaptador(MascotaAdapter adaptador);
}
