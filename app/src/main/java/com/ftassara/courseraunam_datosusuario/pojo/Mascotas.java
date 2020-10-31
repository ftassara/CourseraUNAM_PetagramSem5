package com.ftassara.courseraunam_datosusuario.pojo;

public class Mascotas {

    private String Nombre;
    private int Rating;
//    private String Mail;
    private int Foto;
    private int id;


    public Mascotas(int foto, String contacto, int rating) {
        Nombre = contacto;
        Rating = rating;
//        Mail = mail;
        Foto = foto;
    }

    public Mascotas() {

    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getRating() {
        return Rating;
    }

    public void setRating(int rating) {
        Rating = rating;
    }


    public int getFoto() {
        return Foto;
    }

    public void setFoto(int foto) {
        Foto = foto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
