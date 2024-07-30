/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.trabalhodadosclima.presenter;

import com.ufes.trabalhodadosclima.model.DadoClima;
import com.ufes.trabalhodadosclima.model.IPainel;
import com.ufes.trabalhodadosclima.observer.EstacaoClimaticaObservavel;
import com.ufes.trabalhodadosclima.view.RegistrosView;

/**
 *
 * @author talles.h.santos
 */
public class RegistrosPresenter implements IPainel {
    private RegistrosView view;
    private EstacaoClimaticaObservavel observavel;

    public RegistrosPresenter(RegistrosView view, EstacaoClimaticaObservavel observavel) {
        this.view = view;
        this.observavel = observavel;
        this.observavel.registrarPainel(this);
    }

    @Override
    public void atualizar(DadoClima dadoClima) {
        view.getTable().addRow(new Object[]{dadoClima.getData(), dadoClima.getTemperatura(), dadoClima.getUmidade(), dadoClima.getPressao()});
    }
}
