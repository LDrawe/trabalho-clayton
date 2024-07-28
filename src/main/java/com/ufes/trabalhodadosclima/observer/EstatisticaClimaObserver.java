/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.trabalhodadosclima.observer;

import com.ufes.trabalhodadosclima.model.IPainel;
import com.ufes.trabalhodadosclima.model.DadoClima;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tallesh
 */
public class EstatisticaClimaObserver implements IPainel {

    private List<DadoClima> dadosClima;

    public EstatisticaClimaObserver() {
        dadosClima = new ArrayList<>();
    }

    @Override
    public void atualizar(DadoClima dadoClima) {
        dadosClima.add(dadoClima);
        exibirMedia();
    }

    private void exibirMedia() {
        float somaTemperaturas = 0;
        float somaUmidades = 0;
        float somaPressoes = 0;

        for (DadoClima dadoClima : dadosClima) {
            somaTemperaturas += dadoClima.getTemperatura();
            somaUmidades += dadoClima.getUmidade();
            somaPressoes += dadoClima.getPressao();
        }

        int tamanho = dadosClima.size();

        System.out.println("Estatísticas Clima - Média Temperatura: " + (somaTemperaturas / tamanho)
                + ", Média Umidade: " + (somaUmidades / tamanho)
                + ", Média Pressão: " + (somaPressoes / tamanho));
    }

}
