/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.trabalhodadosclima.presenter;

import com.ufes.trabalhodadosclima.log.Log;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import com.ufes.trabalhodadosclima.model.DadoClima;
import com.ufes.trabalhodadosclima.observer.EstacaoClimaticaObservavel;
import com.ufes.trabalhodadosclima.model.DadosCollection;

import com.ufes.trabalhodadosclima.view.DadosDoTempoView;

/**
 *
 * @author talles.h.santos
 */
public class DadosDoTempoPresenter {

    private DadosDoTempoView view;
    private EstacaoClimaticaObservavel observavel;
    Log log;

    public DadosDoTempoPresenter(DadosDoTempoView view, EstacaoClimaticaObservavel observavel) {
        this.view = view;
        this.observavel = observavel;
        view.setTitle("Dados do Tempo");
        view.getBotao().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleButtonClick();
            }
        });
    }

    private void handleButtonClick() {
        try {
            float temperatura = Float.parseFloat(view.getTemp().getText());
            float umidade = Float.parseFloat(view.getHumidity().getText());
            float pressao = Float.parseFloat(view.getPressure().getText());
            String dataString = view.getData().getText();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate data = LocalDate.parse(dataString, formatter);

            DadoClima dados = new DadoClima(temperatura, umidade, pressao, data);
            DadosCollection.getInstance().addDado(dados);

            observavel.atualizarMedicoes(dados);

            view.getTemp().setText("");
            view.getHumidity().setText("");
            view.getPressure().setText("");
            view.getData().setText("");
            log.makeLog(dados, true);
        } catch (DateTimeParseException e) {
            System.out.println("O formato de data inserido não é válido");
        } catch (NumberFormatException e) {
            System.out.println("O formato de um dos valores inserido não é válido");
        }
    }

    public DadosDoTempoView getView() {
        if (view == null) {
            System.err.println("dadosTempoView não foi inicializado.");
        }
        return view;
    }
}
