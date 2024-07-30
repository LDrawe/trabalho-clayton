/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.trabalhodadosclima.presenter;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.plot.PlotOrientation;

import com.ufes.trabalhodadosclima.model.DadoClima;
import com.ufes.trabalhodadosclima.model.IPainel;
import com.ufes.trabalhodadosclima.model.MaximasMinimas;
import com.ufes.trabalhodadosclima.observer.EstacaoClimaticaObservavel;
import com.ufes.trabalhodadosclima.view.MaximasMinimasView;

/**
 *
 * @author talles.h.santos
 */
public class MaximasMinimasPresenter implements IPainel {
    private MaximasMinimasView view;
    private EstacaoClimaticaObservavel observavel;

    private MaximasMinimas maximasMinimas = new MaximasMinimas();
    private DefaultCategoryDataset dataset = new DefaultCategoryDataset();

    public MaximasMinimasPresenter(MaximasMinimasView view, EstacaoClimaticaObservavel observavel) {
        this.view = view;
        this.observavel = observavel;

        this.observavel.registrarPainel(this);
        ChartPanel grafico = new ChartPanel(
                ChartFactory.createBarChart(
                        "Máximas e Mínimas",
                        "",
                        "",
                        dataset,
                        PlotOrientation.VERTICAL,
                        true, true, false));
        grafico.setVisible(true);
        grafico.setSize(400, 300);
        this.view.add(grafico);
    }

    @Override
    public void atualizar(DadoClima dadoClima) {
        float temperatura = dadoClima.getTemperatura();
        float pressao = dadoClima.getPressao();
        float umidade = dadoClima.getUmidade();

        float mintemperatura = maximasMinimas.getMinimaTemperatura();
        float maxTemperatura = maximasMinimas.getMaximaTemperatura();
        float minPressao = maximasMinimas.getMinimaPressao();
        float maxPressao = maximasMinimas.getMaximaPressao();
        float minUmidade = maximasMinimas.getMinimaUmidade();
        float maxUmidade = maximasMinimas.getMaximaUmidade();

        // Update temperature
        if (temperatura > maxTemperatura) {
            maximasMinimas.setMaximaTemperatura(temperatura);
            dataset.addValue(temperatura, "Max", "Temperatura");
        }
        if (temperatura < mintemperatura) {
            maximasMinimas.setMinimaTemperatura(temperatura);
            dataset.addValue(temperatura, "Min", "Temperatura");
        }

        // Update humidity
        if (umidade > maxUmidade) {
            maximasMinimas.setMaximaUmidade(umidade);
            dataset.addValue(umidade, "Max", "Humidade");
        }
        if (umidade < minUmidade) {
            maximasMinimas.setMinimaUmidade(umidade);
            dataset.addValue(umidade, "Min", "Humidade");
        }

        // Update pressure
        if (pressao > maxPressao) {
            maximasMinimas.setMaximaPressao(pressao);
            dataset.addValue(pressao, "Max", "Pressão");
        }
        if (pressao < minPressao) {
            maximasMinimas.setMinimaPressao(pressao);
            dataset.addValue(pressao, "Min", "Pressão");
        }
    }
}
