/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.trabalhodadosclima.presenter;

import java.util.ArrayList;

import com.ufes.trabalhodadosclima.model.DadoClima;
import com.ufes.trabalhodadosclima.model.EstacaoClimaticaObservavel;
import com.ufes.trabalhodadosclima.model.IPainel;
import com.ufes.trabalhodadosclima.view.DadosMediosView;

/**
 *
 * @author talles.h.santos
 */
public class DadosMediosPresenter implements IPainel {
    private DadosMediosView view;
    private EstacaoClimaticaObservavel observavel;

    public DadosMediosPresenter(DadosMediosView view, EstacaoClimaticaObservavel observavel) {
        this.view = view;
        this.observavel = observavel;
        this.view.setTitle("Dados Médios");

        this.observavel.registrarPainel(this);
    }

    @Override
    public void atualizar(ArrayList<DadoClima> dados) {
        int tamanho = this.observavel.getSize();
        if (tamanho == 0) {
            view.getTempLabel().setText("0");
            view.getHumidityLabel().setText("0");
            view.getPressureLabel().setText("0");
            view.getNumOfRegistersLabel().setText("0");
        }
        float somaTemperaturas = 0;
        float somaUmidades = 0;
        float somaPressoes = 0;

        for (int i = 0; i < tamanho; i++) {
            somaTemperaturas += dados.get(i).getTemperatura();
            somaUmidades += dados.get(i).getUmidade();
            somaPressoes += dados.get(i).getPressao();
        }

        view.getTempLabel().setText(String.valueOf(somaTemperaturas / tamanho));
        view.getHumidityLabel().setText(String.valueOf(somaUmidades / tamanho));
        view.getPressureLabel().setText(String.valueOf(somaPressoes / tamanho));
        view.getNumOfRegistersLabel().setText(String.valueOf(tamanho));
    }
}
