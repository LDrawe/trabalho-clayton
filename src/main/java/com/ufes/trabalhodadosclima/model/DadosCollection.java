package com.ufes.trabalhodadosclima.model;

import java.util.ArrayList;

public class DadosCollection {
    private static DadosCollection dadosCollection;    
    private ArrayList<DadoClima> dados = new ArrayList<>();

    private DadosCollection(){
    }

    public ArrayList<DadoClima> getLista() {
        return dados;
    }

    public int getSize() {
        return dados.size();
    }

    public void addDado(DadoClima dado) {
        dados.add(dado);
    }

    public void removeDado(int index) {
        dados.remove(index);
    }

    public static DadosCollection getInstance() {
        if (dadosCollection == null) {
            dadosCollection = new DadosCollection();
        }
        return dadosCollection;
    }
}
