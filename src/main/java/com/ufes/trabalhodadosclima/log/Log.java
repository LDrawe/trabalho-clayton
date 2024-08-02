/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.trabalhodadosclima.log;

import com.ufes.trabalhodadosclima.log.json.LogJSON;
import com.ufes.trabalhodadosclima.log.xml.LogXML;
import com.ufes.trabalhodadosclima.model.DadoClima;
import com.ufes.trabalhodadosclima.presenter.ErrorPresenter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author tallesh
 */
public class Log {
    private final ILog logAdapter;

    public Log(ILog logAdapter) {
        this.logAdapter = logAdapter;
    }

    public void log(DadoClima dado) {
        String logMessage = logAdapter.getLogMensagem(dado);
        salvarEmArquivo(logMessage);
    }

    private void salvarEmArquivo(String logMessage) {
        try (FileWriter fileWriter = new FileWriter("dados_climaticos.log", true);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {
            printWriter.println(logMessage);
        } catch (IOException e) {
            new ErrorPresenter("Erro ao salvar o arquivo de log.");
        }
    }
}
