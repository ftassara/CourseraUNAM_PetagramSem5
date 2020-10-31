package com.ftassara.courseraunam_datosusuario.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ftassara.courseraunam_datosusuario.R;
import com.ftassara.courseraunam_datosusuario.pojo.Mascotas;
import com.ftassara.courseraunam_datosusuario.viewholder.ContactoViewHolder;

import java.util.ArrayList;

public class MascotaAdapter extends RecyclerView.Adapter<ContactoViewHolder> {
    ArrayList<Mascotas> data;


    public MascotaAdapter(ArrayList<Mascotas> data) {
        this.data = data;


    }

    @NonNull
    @Override
    public ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_fotoscontacto,parent,false);
        return new ContactoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactoViewHolder holder, final int position) {
        //aca hago todos los setTExt en base a la posicion
        Mascotas mascota = data.get(position);
        holder.imgFoto.setImageResource(mascota.getFoto());
//        holder.tvRating.setText(mascota.getRating());


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public interface onContactoListener{
        void onContactoClic(int position);
    }
}
