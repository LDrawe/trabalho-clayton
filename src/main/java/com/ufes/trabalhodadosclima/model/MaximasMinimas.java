/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.trabalhodadosclima.model;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author talles.h.santos
 */
public class MaximasMinimas {

    private final Float minimaTemperatura;
    private final Float maximaTemperatura;
    private final Float minimaPressao;
    private final Float maximaPressao;
    private final Float minimaUmidade;
    private final Float maximaUmidade;

    public Float getMinimaTemperatura() {
        return minimaTemperatura;
    }

    public Float getMaximaTemperatura() {
        return maximaTemperatura;
    }

    public Float getMinimaPressao() {
        return minimaPressao;
    }

    public Float getMaximaPressao() {
        return maximaPressao;
    }

    public Float getMinimaUmidade() {
        return minimaUmidade;
    }

    public Float getMaximaUmidade() {
        return maximaUmidade;
    }

    public MaximasMinimas(Float minimaTemperatura, Float maximaTemperatura, Float minimaPressao, Float maximaPressao, Float minimaUmidade, Float maximaUmidade) {
        this.minimaTemperatura = minimaTemperatura;
        this.maximaTemperatura = maximaTemperatura;
        this.minimaPressao = minimaPressao;
        this.maximaPressao = maximaPressao;
        this.minimaUmidade = minimaUmidade;
        this.maximaUmidade = maximaUmidade;
    }
}
