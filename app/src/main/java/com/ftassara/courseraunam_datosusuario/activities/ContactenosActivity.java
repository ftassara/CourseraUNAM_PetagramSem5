package com.ftassara.courseraunam_datosusuario.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.ftassara.courseraunam_datosusuario.R;
import com.ftassara.courseraunam_datosusuario.mailsender.GMailSender;

public class ContactenosActivity extends AppCompatActivity {

    Button btnComentario;
    EditText mNombre;
    EditText mMail;
    EditText mComentario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactenos);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //inicializo mis variables relacionadolas con el objeto del layout correspondiente
        btnComentario = (Button) findViewById(R.id.button);
        mNombre = (EditText) findViewById(R.id.editNombre);
        mMail = (EditText) findViewById(R.id.editMail);
        mComentario = (EditText) findViewById(R.id.editComentario);

        btnComentario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ContactenosActivity.this, "Comentario Enviado", Toast.LENGTH_SHORT).show();
                sendEmail();
            }
        });

    }
    private void sendEmail() {
        try {
            GMailSender sender = new GMailSender("username@gmail.com", "password");
            sender.sendMail(mNombre.toString(),
                    mComentario.toString(),
                    "user@gmail.com",
                    mMail.toString());
        } catch (Exception e) {
            Log.e("SendMail", e.getMessage(), e);
        }
    }
}