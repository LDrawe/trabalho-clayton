/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.trabalhodadosclima.presenter;

import java.time.format.DateTimeFormatter;

import com.ufes.trabalhodadosclima.model.DadoClima;
import com.ufes.trabalhodadosclima.model.DadosCollection;
import com.ufes.trabalhodadosclima.model.IPainel;
import com.ufes.trabalhodadosclima.observer.EstacaoClimaticaObservavel;
import com.ufes.trabalhodadosclima.view.UltimaAtualizacaoTempoView;

/**
 *
 * @author talles.h.santos
 */
public class UltimaAtualizacaoTempoPresenter implements IPainel{
    private UltimaAtualizacaoTempoView view;
    private EstacaoClimaticaObservavel observavel;
    private DadosCollection colecao = DadosCollection.getInstance();

    DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    public UltimaAtualizacaoTempoPresenter(UltimaAtualizacaoTempoView view, EstacaoClimaticaObservavel observavel) {
        this.view = view;
        this.observavel = observavel;
        this.observavel.registrarPainel(this);
    }

    @Override
    public void atualizar(DadoClima dadoClima) {
        int tamanho = colecao.getLista().size();

        view.getTempLabel().setText(String.valueOf(dadoClima.getTemperatura()));
        view.getHumidityLabel().setText(String.valueOf(dadoClima.getUmidade()));
        view.getPressureLabel().setText(String.valueOf(dadoClima.getPressao()));
        view.getDataLabel().setText(dadoClima.getData().format(outputFormatter));
        view.getNumOfRegistersLabel().setText(String.valueOf(tamanho));
    }
}
