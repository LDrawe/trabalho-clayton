/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.trabalhodadosclima.presenter;

import java.util.ArrayList;

import javax.swing.JLabel;

import com.ufes.trabalhodadosclima.model.DadoClima;
import com.ufes.trabalhodadosclima.model.DadosCollection;
import com.ufes.trabalhodadosclima.model.IPainel;
import com.ufes.trabalhodadosclima.observer.EstacaoClimaticaObservavel;
import com.ufes.trabalhodadosclima.view.DadosMediosView;

/**
 *
 * @author talles.h.santos
 */
public class DadosMediosPresenter implements IPainel {
    private DadosMediosView view;
    private EstacaoClimaticaObservavel observavel;
    private DadosCollection colecao;

    private float somaTemperaturas = 0;
    private float somaUmidades = 0;
    private float somaPressoes = 0;

    public DadosMediosPresenter(DadosMediosView view, EstacaoClimaticaObservavel observavel) {
        this.view = view;
        this.observavel = observavel;
        view.setTitle("Dados Médios");

        observavel.registrarPainel(this);
        colecao = DadosCollection.getInstance();
    }
    
    @Override
    public void atualizar(DadoClima dadoClima) {
        int tamanho = colecao.getSize();
        somaTemperaturas += dadoClima.getTemperatura();
        somaUmidades += dadoClima.getUmidade();
        somaPressoes += dadoClima.getPressao();

        view.getTempLabel().setText(String.valueOf(somaTemperaturas / tamanho));
        view.getHumidityLabel().setText(String.valueOf(somaUmidades / tamanho));
        view.getPressureLabel().setText(String.valueOf(somaPressoes / tamanho));
    }
}
