/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.trabalhodadosclima.presenter;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import com.ufes.trabalhodadosclima.model.DadoClima;
import com.ufes.trabalhodadosclima.model.EstacaoClimaticaObservavel;
import com.ufes.trabalhodadosclima.model.IPainel;
import com.ufes.trabalhodadosclima.view.UltimaAtualizacaoTempoView;

/**
 *
 * @author talles.h.santos
 */
public class UltimaAtualizacaoTempoPresenter implements IPainel{
    private UltimaAtualizacaoTempoView view;
    private EstacaoClimaticaObservavel observavel;

    DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    public UltimaAtualizacaoTempoPresenter(UltimaAtualizacaoTempoView view, EstacaoClimaticaObservavel observavel) {
        this.view = view;
        this.observavel = observavel;
        this.observavel.registrarPainel(this);
    }

    @Override
    public void atualizar(ArrayList<DadoClima> dados) {
        if (dados.size() == 0) {
            view.getTempLabel().setText("-");
            view.getHumidityLabel().setText("-");
            view.getPressureLabel().setText("-");
            view.getDataLabel().setText("-");
            return;
        }

        view.getTempLabel().setText(String.valueOf(dados.get(dados.size() - 1).getTemperatura()));
        view.getHumidityLabel().setText(String.valueOf(dados.get(dados.size() - 1).getUmidade()));
        view.getPressureLabel().setText(String.valueOf(dados.get(dados.size() - 1).getPressao()));
        view.getDataLabel().setText(dados.get(dados.size() - 1).getData().format(outputFormatter));
    }
}
