package com.ftassara.courseraunam_datosusuario.adapter;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.ftassara.courseraunam_datosusuario.db.ConstrutorMascotas;
import com.ftassara.courseraunam_datosusuario.viewholder.ContactoViewHolder;
import com.ftassara.courseraunam_datosusuario.pojo.Mascotas;
import com.ftassara.courseraunam_datosusuario.R;

import java.util.ArrayList;

public class ContactoAdapter extends RecyclerView.Adapter<ContactoViewHolder> {
    ArrayList<Mascotas> data;
    Activity activity;

    public ContactoAdapter(ArrayList<Mascotas> data,Activity activity) {
        this.data = data;
        this.activity = activity;

    }

    @NonNull
    @Override
    public ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_contacto,parent,false);
        return new ContactoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactoViewHolder holder, final int position) {
        //aca hago todos los setTExt en base a la posicion
        final Mascotas mascota = data.get(position);
        holder.imgFoto.setImageResource(mascota.getFoto());
        holder.tvNombre.setText(mascota.getNombre());
        holder.tvRating.setText(String.valueOf(mascota.getRating()));


        ContactoViewHolder.imgRating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Diste like a " + position,
                        Toast.LENGTH_SHORT).show();
                ConstrutorMascotas constructorMascotas = new ConstrutorMascotas(activity);
                constructorMascotas.darLikeCotnacto(mascota);
                ContactoViewHolder.tvRating.setText(String.valueOf(constructorMascotas.obtenerRating(mascota)));
                Log.d("Diste Like",String.valueOf(constructorMascotas.obtenerRating(mascota)));
            }
        });


    }

    @Override
    public int getItemCount() {
        Log.d("ItemCount", String.valueOf(data.size()));
        return data.size();

    }

}