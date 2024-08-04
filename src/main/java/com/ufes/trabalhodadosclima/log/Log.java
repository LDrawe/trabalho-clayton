/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.trabalhodadosclima.log;

import com.ufes.trabalhodadosclima.model.DadoClima;
import com.ufes.trabalhodadosclima.presenter.ErrorPresenter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author tallesh
 */
public class Log {
    private final ILog logAdapter;
    private final String filePath;

    public Log(ILog logAdapter, String filePath) {
        this.logAdapter = logAdapter;
        this.filePath = filePath;
    }

    public void log(DadoClima dado, Boolean removido) {
        String logMessage = logAdapter.getLogMensagem(dado, removido);
        salvarEmArquivo(logMessage);
    }

    private void salvarEmArquivo(String logMessage) {
        try (FileWriter fileWriter = new FileWriter(filePath, true);
                PrintWriter printWriter = new PrintWriter(fileWriter)) {
                printWriter.println(logMessage);
        } catch (IOException e) {
            new ErrorPresenter("Erro ao salvar o arquivo de log.");
        }
    }
}
