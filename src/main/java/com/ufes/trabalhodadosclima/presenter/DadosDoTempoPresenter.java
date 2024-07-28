/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.trabalhodadosclima.presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.ufes.trabalhodadosclima.model.DadoClima;
import com.ufes.trabalhodadosclima.view.DadosDoTempoView;

/**
 *
 * @author talles.h.santos
 */
public class DadosDoTempoPresenter {

    private final DadosDoTempoView view;

    public DadosDoTempoPresenter() {
        view = new DadosDoTempoView();
        configurarTela();
    }

    private void handleButtonClick() {
        float temperatura = Float.parseFloat(view.getTemp().getText());
        float umidade= Float.parseFloat(view.getHumidity().getText());
        float pressao = Float.parseFloat(view.getPressure().getText());
        String dataString = view.getData().getText();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate data = LocalDate.parse(dataString, formatter);
        
        DadoClima dados = new DadoClima(temperatura, umidade, pressao, data);
        
        System.out.println(temperatura + " " + umidade + " " + pressao + " " + data);
        view.getTemp().setText("");
        view.getHumidity().setText("");
        view.getPressure().setText("");
        view.getData().setText("");
    }

    private void configurarTela() {
        view.getBotao().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                handleButtonClick();
            }
        });
    }

    public DadosDoTempoView getView() {
        if (view == null) {
            System.err.println("dadosTempoView não foi inicializado.");
        }
        return view;
    }
}
