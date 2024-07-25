/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.trabalhodadosclima.observer;

import com.ufes.trabalhodadosclima.model.IPainel;
import com.ufes.trabalhodadosclima.model.DadoClima;
import java.time.LocalDate;

/**
 *
 * @author tallesh
 */
public class PainelClimaObserver implements IPainel{
    
    @Override
    public void atualizar(DadoClima dadoClima) {
       if (dadoClima.getData().isEqual(LocalDate.now())) {
           System.out.println("Painel Clima - Data: " + dadoClima.getData() 
            + ", Temperatura: " + dadoClima.getTemperatura() 
            + ", Umidade: " + dadoClima.getUmidade() 
            + ", Pressão: " + dadoClima.getPressao());
       }
   }

    
}
