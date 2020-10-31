package com.ftassara.courseraunam_datosusuario.viewholder;

import android.media.Image;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ftassara.courseraunam_datosusuario.R;
import com.ftassara.courseraunam_datosusuario.adapter.ContactoAdapter;

public class ContactoViewHolder extends RecyclerView.ViewHolder {

    public ImageView imgFoto;
    public TextView  tvNombre;
    public static TextView tvRating;
    public static ImageView imgRating;

    public ContactoViewHolder(@NonNull View itemView) {
        super(itemView);

        //aca defino todos los views dentro del "cardview layout"
        imgFoto = (ImageView) itemView.findViewById(R.id.foto);
        tvNombre = (TextView) itemView.findViewById(R.id.cvnombre);
        tvRating = (TextView) itemView.findViewById(R.id.cvrating);
        imgRating = (ImageView) itemView.findViewById(R.id.imgRating);
    }



}
