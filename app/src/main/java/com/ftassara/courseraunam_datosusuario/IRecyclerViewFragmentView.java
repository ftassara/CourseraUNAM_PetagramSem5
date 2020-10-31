package com.ftassara.courseraunam_datosusuario;

import com.ftassara.courseraunam_datosusuario.adapter.ContactoAdapter;
import com.ftassara.courseraunam_datosusuario.adapter.MascotaAdapter;
import com.ftassara.courseraunam_datosusuario.pojo.Mascotas;

import java.util.ArrayList;

public interface IRecyclerViewFragmentView  {

    public void generarLayoutVertical();

    public ContactoAdapter crearAdaptador(ArrayList<Mascotas> mascotas);

    public void inicializarAdaptador(ContactoAdapter adaptador);
}
