/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.trabalhodadosclima.log.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ufes.trabalhodadosclima.log.adapter.LocalDateJsonAdapter;
import com.ufes.trabalhodadosclima.log.ILog;
import com.ufes.trabalhodadosclima.log.LogEntry;
import com.ufes.trabalhodadosclima.model.DadoClima;
import java.time.LocalDate;

/**
 *
 * @author tallesh
 */
public class LogJSON implements ILog {
    private final Gson gson;

    public LogJSON() {
        this.gson = new GsonBuilder()
            .registerTypeAdapter(LocalDate.class, new LocalDateJsonAdapter())
            .create();
    }

    @Override
    public String getLogMensagem(DadoClima dado, Boolean removido) {
        String operacao = removido ? "Removido" : "Adicionado";
        return gson.toJson(new LogEntry(dado, operacao));
    }
}
