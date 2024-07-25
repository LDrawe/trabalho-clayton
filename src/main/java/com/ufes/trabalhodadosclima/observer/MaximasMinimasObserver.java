/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.trabalhodadosclima.observer;

import com.ufes.trabalhodadosclima.model.IPainel;
import com.ufes.trabalhodadosclima.model.DadoClima;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tallesh
 */
public class MaximasMinimasObserver implements IPainel {

   private List<DadoClima> dadosClima;

   public MaximasMinimasObserver() {
       dadosClima = new ArrayList<>();
   }
   @Override
   public void atualizar(DadoClima dadoClima) {
       dadosClima.add(dadoClima);
       exibirMaximasMinimas();
   }
   private void exibirMaximasMinimas() {
     //Obtem máximas e mínimas
   }

}
