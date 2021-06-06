package org.example;

import java.util.ArrayList;

public class TitulosP {

    private ArrayList<TituloP> tituloPS;

    public TitulosP() {
        tituloPS = new ArrayList<TituloP>();
    }

    public ArrayList<TituloP> getTitulosP() {
        return tituloPS;
    }

    public void setTituloP(ArrayList<TituloP> tituloPS) {
        this.tituloPS = tituloPS;
    }

    public void AddTituloP(TituloP u) {
        tituloPS.add(u);
    }



    public String getTituloP(int n) {
        return tituloPS.get(n).toString() ;
    }

    public void updateTitulo(int n, TituloP u) {
        tituloPS.set(n, u);
    }
    public void deleteTitulo(int n) {
        tituloPS.remove(n);
    }



    public int listasizeT() {
        // TODO Auto-generated method stub
        return tituloPS.size();
    }

    /*
    public void mostrarlistaT() {
        for (int i = 0; i < tituloPS.size(); i++) {
            System.out.println(i + "-" + tituloPS.get(i).toString());
        }
    }
     */
}
