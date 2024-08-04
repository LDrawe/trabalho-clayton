/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.trabalhodadosclima.presenter;

import com.ufes.trabalhodadosclima.model.DadoClima;
import com.ufes.trabalhodadosclima.model.EstacaoClimaticaObservavel;
import com.ufes.trabalhodadosclima.model.IPainel;
import com.ufes.trabalhodadosclima.view.RegistrosView;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author talles.h.santos
 */
public class RegistrosPresenter implements IPainel {
    private RegistrosView view;
    private EstacaoClimaticaObservavel observavel;
    private ConfiguracoesPresenter configuracoesPresenter;
    private int numOfRegisters = 0;

    public RegistrosPresenter(RegistrosView view, EstacaoClimaticaObservavel observavel,
            ConfiguracoesPresenter configuracoesPresenter) {
        this.view = view;
        this.observavel = observavel;
        this.configuracoesPresenter = configuracoesPresenter;
        this.observavel.registrarPainel(this);
        view.getBotao().addActionListener(e -> {
            try {
                handleRemoveButtonClick();
            } catch (Exception ex) {
                Logger.getLogger(RegistrosPresenter.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    @Override
    public void atualizar(ArrayList<DadoClima> dados) {
        int tamanho = dados.size();
        if (tamanho > numOfRegisters) {
            DadoClima dadoClima = dados.get(tamanho - 1);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String dataString = dadoClima.getData().format(formatter);
            view.getTable().addRow(new Object[] { dataString, dadoClima.getTemperatura(), dadoClima.getUmidade(),
                    dadoClima.getPressao() });
        }
        numOfRegisters = tamanho;
    }

    private void handleRemoveButtonClick() throws Exception {
        try {
            int selectedRow = view.getjTabela().getSelectedRow();

            if (selectedRow >= 0) {
                String dataString = (String) view.getjTabela().getValueAt(selectedRow, 0);
                float temperatura = Float.parseFloat(view.getjTabela().getValueAt(selectedRow, 1).toString());
                float umidade = Float.parseFloat(view.getjTabela().getValueAt(selectedRow, 2).toString());
                float pressao = Float.parseFloat(view.getjTabela().getValueAt(selectedRow, 3).toString());

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate data = LocalDate.parse(dataString, formatter);

                DadoClima dadoRemovido = new DadoClima(temperatura, umidade, pressao, data);

                DefaultTableModel model = (DefaultTableModel) view.getjTabela().getModel();
                model.removeRow(selectedRow);
                observavel.removeDado(selectedRow);

                configuracoesPresenter.getLog().log(dadoRemovido, true);
            } else {
                new ErrorPresenter("Nenhuma linha selecionada para remoção.");
            }
        } catch (DateTimeParseException e) {
            new ErrorPresenter("Formato de data inválido.");
        } catch (NumberFormatException e) {
            new ErrorPresenter("Formato de um ou mais valores numéricos inválido.");
        } catch (Exception e) {
            new ErrorPresenter("Erro ao remover o dado.");
            throw new Exception(e);
        }
    }
}
