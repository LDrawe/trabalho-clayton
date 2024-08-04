/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.trabalhodadosclima.presenter;

import java.util.ArrayList;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.plot.PlotOrientation;

import com.ufes.trabalhodadosclima.model.DadoClima;
import com.ufes.trabalhodadosclima.model.EstacaoClimaticaObservavel;
import com.ufes.trabalhodadosclima.model.IPainel;
import com.ufes.trabalhodadosclima.model.MaximasMinimas;
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
    public void atualizar(ArrayList<DadoClima> dados) {
        float maximaTemperatura = Float.MIN_VALUE;
        float minimaTemperatura = Float.MAX_VALUE;
        float maximaPressao = Float.MIN_VALUE;
        float minimaPressao = Float.MAX_VALUE;
        float maximaUmidade = Float.MIN_VALUE;
        float minimaUmidade = Float.MAX_VALUE;
        dataset.clear();

        for (DadoClima dadoClima : dados) {
            float temperatura = dadoClima.getTemperatura();
            float pressao = dadoClima.getPressao();
            float umidade = dadoClima.getUmidade();

            // Update temperatura
            if (temperatura > maximaTemperatura) {
                maximaTemperatura = temperatura;
                dataset.addValue(temperatura, "Max", "Temperatura");
            }
            if (temperatura < minimaTemperatura) {
                minimaTemperatura = temperatura;
                maximasMinimas.setMinimaTemperatura(temperatura);
                dataset.addValue(temperatura, "Min", "Temperatura");
            }

            // Update umidade
            if (umidade > maximaUmidade) {
                maximaUmidade = umidade;
                dataset.addValue(umidade, "Max", "Umidade");
            }
            if (umidade < minimaUmidade) {
                minimaUmidade = umidade;
                dataset.addValue(umidade, "Min", "Umidade");
            }

            // Update pressão
            if (pressao > maximaPressao) {
                maximaPressao = pressao;
                dataset.addValue(pressao, "Max", "Pressão");
            }
            if (pressao < minimaPressao) {
                minimaPressao = pressao;
                dataset.addValue(pressao, "Min", "Pressão");
            }
        }
    }
}
