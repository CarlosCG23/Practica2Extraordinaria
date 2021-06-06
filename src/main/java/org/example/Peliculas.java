package org.example;

import java.util.ArrayList;

public class Peliculas {

    private ArrayList<Pelicula> peliculas;

    public Peliculas() {
        peliculas = new ArrayList<Pelicula>();
    }

    public ArrayList<Pelicula> getPeliculas() {
        return peliculas;
    }

    public void setPelicula(ArrayList<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }

    public void AddPelicula(Pelicula u) {
        peliculas.add(u);
    }

    public String getPelicula(int n) {
        return peliculas.get(n).toString() ;
    }

    public void updatepelicula(int n, Pelicula u) {
        peliculas.set(n, u);
    }
    public void deletepelicula(int n) {
        peliculas.remove(n);
    }

    public int listasize() {
        // TODO Auto-generated method stub
        return peliculas.size();
    }

    public void mostrarlista() {
        for (int i = 0; i < peliculas.size(); i++) {
            System.out.println(i + "-" + peliculas.get(i).toString());
        }
    }
}
