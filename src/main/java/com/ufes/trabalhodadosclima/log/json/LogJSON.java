/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.trabalhodadosclima.log.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ufes.trabalhodadosclima.log.ILog;
import com.ufes.trabalhodadosclima.model.DadoClima;
import java.time.LocalDate;

/**
 *
 * @author tallesh
 */
public class LogJSON implements ILog{

    public LogJSON() {
    }

    @Override
    public String getLogMessage(DadoClima dadoClima, boolean adicionado){
        DadoClimaJSON dadoJson = new DadoClimaJSON(dadoClima, adicionado);
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateSerializer())
                .create();


        String json = gson.toJson(dadoJson);

        return json;        
    }
    
    
}
