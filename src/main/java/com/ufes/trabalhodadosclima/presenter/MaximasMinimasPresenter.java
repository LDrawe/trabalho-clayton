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
import com.ufes.trabalhodadosclima.view.MaximasMinimasView;

/**
 *
 * @author talles.h.santos
 */
public class MaximasMinimasPresenter {
    private MaximasMinimasView view;
    private DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    
    public CategoryDataset getDataset() {
        return dataset;
    }

    public MaximasMinimasPresenter() {
        view = new MaximasMinimasView();
        ChartPanel grafico = new ChartPanel(
            ChartFactory.createBarChart(
            "Máximas e Mínimas",
            "",
            "",
            dataset,          
            PlotOrientation.VERTICAL,           
            true, true, false
        ));
        grafico.setVisible(true);
        grafico.setSize(400, 300);
        view.add(grafico);
    }

    public MaximasMinimasView getView() {
        return view;
    }
}
