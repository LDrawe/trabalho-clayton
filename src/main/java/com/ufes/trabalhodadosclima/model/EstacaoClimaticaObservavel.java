/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.trabalhodadosclima.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tallesh
 */
public class EstacaoClimaticaObservavel {

    private ArrayList<DadoClima> dados = new ArrayList<>();
    private List<IPainel> paineis = new ArrayList<>();

    public ArrayList<DadoClima> getLista() {
        return dados;
    }

    public int getSize() {
        return dados.size();
    }

    public void addDado(DadoClima dado) {
        dados.add(dado);
        notificarPaineis(dados);
    }

    public void removeDado(int index) {
        dados.remove(index);
        System.err.println("ta chegando no remove");
        notificarPaineis(dados);
    }

    public void registrarPainel(IPainel painel) {
        paineis.add(painel);
    }

    public void removerPainel(IPainel painel) {
        paineis.remove(painel);
    }

    private void notificarPaineis(ArrayList<DadoClima> dados) {
        for (IPainel painel : paineis) {
            System.err.println("notificando todos os paineis");
            painel.atualizar(dados);
        }
    }
}
