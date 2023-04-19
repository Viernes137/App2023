package com.example.mysplash.json;

import java.io.Serializable;

public class infos implements Serializable {

    private int id_contra;
    private String contra;
    private String usuario;

    private double longitud;
    private double latitud;

    public int getId_contra() {
        return id_contra;
    }

    public void setId_contra(int id_contra) {
        this.id_contra = id_contra;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getId_usr() {
        return id_usr;
    }

    public void setId_usr(int id_usr) {
        this.id_usr = id_usr;
    }

    private int id_usr;

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }
}
