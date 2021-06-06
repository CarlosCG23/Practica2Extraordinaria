package org.example;

import java.util.ArrayList;

public class Pelicula {

    public String Titulo;
    public String Sinopsis;
    public String Genero;
    public String Enlace;
    public String Reparto;
    public int id;


    public Pelicula(String titulo, String sinopsis, String genero, String enlace, String reparto) {
        Titulo = titulo;
        Sinopsis = sinopsis;
        Genero = genero;
        Enlace = enlace;
        Reparto = reparto;
        id = id;
    }

    public Pelicula() {

    }

    public int getId() {
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getTitulo() {
        return Titulo;
    }
    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getSinopsis() {
        return Sinopsis;
    }
    public void setSinopsis(String sinopsis) {
        Sinopsis = sinopsis;
    }
    public String getGenero() {
        return Genero;
    }
    public void setGenero(String genero) {
        Genero = genero;
    }
    public String getEnlace() {
        return Enlace;
    }
    public void setEnlace(String enlace) {
        Enlace = enlace;
    }
    public String getReparto() {
        return Reparto;
    }
    public void setReparto(String reparto) {
        Reparto = reparto;
    }

    public void nuevoID (int Nid){
        this.id = id + Nid;
    }
    @Override
    public String toString() {
        return "id: " + getId() +" Titulo: "+getTitulo()+" Sinopsis: "+getSinopsis()+ "Genero: "+ getGenero()+" Enlace: "+getEnlace()+" Reparto: "+getReparto()+ "";
        //return "Titulo: "+getTitulo();

    }
}
