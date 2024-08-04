/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.trabalhodadosclima.presenter;


import com.ufes.trabalhodadosclima.log.ILog;
import com.ufes.trabalhodadosclima.log.Log;
import com.ufes.trabalhodadosclima.log.json.LogJSON;
import com.ufes.trabalhodadosclima.log.xml.LogXML;
import com.ufes.trabalhodadosclima.view.ConfiguracoesView;

/**
 *
 * @author talles.h.santos
 */
public class ConfiguracoesPresenter {
    private ConfiguracoesView view;
    private Log log;
    private ILog logAdapter;

    public ConfiguracoesPresenter(ConfiguracoesView view) {
        this.view = view;
        logAdapter = new LogJSON();
        log = new Log(logAdapter, "dados_climaticos.json");

        view.setTitle("Mudar Log");
        view.getSalvarJButton().addActionListener(e -> salvarConfiguracoes());
        view.getLogOptionsJComboBox().addActionListener(e -> selecionarLog());

        // Adiciona as opções de log ao JComboBox
        view.getLogOptionsJComboBox().addItem("JSON");
        view.getLogOptionsJComboBox().addItem("XML");
    }
    
    private void selecionarLog() {
        String selectedLog = (String) view.getLogOptionsJComboBox().getSelectedItem();

        if (selectedLog != null) {
            switch (selectedLog) {
                case "JSON":
                    logAdapter = new LogJSON();
                    log = new Log(logAdapter, "dados_climaticos.json");
                    break;
                case "XML":
                    logAdapter = new LogXML();
                    log = new Log(logAdapter, "dados_climaticos.xml");
                    break;
                default:
                    logAdapter = new LogJSON();
                    log = new Log(logAdapter, "dados_climaticos.json");
                    break;
            }
        }
    }

    private void salvarConfiguracoes() {
        javax.swing.JOptionPane.showMessageDialog(view, "Configurações salvas com sucesso!");
    }

    public Log getLog() {
        return log;
    }
}
