/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.trabalhodadosclima.observer;

import com.ufes.trabalhodadosclima.model.IPainel;
import com.ufes.trabalhodadosclima.model.DadoClima;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tallesh
 */
public class EstacaoClimaticaObservavel {
    
    private List<IPainel> paineis;

   public EstacaoClimaticaObservavel() {
       paineis = new ArrayList<>();
   }

   public void registrarPainel(IPainel painel) {
       paineis.add(painel);
   }

   public void removerPainel(IPainel painel) {
       paineis.remove(painel);
   }

   public void atualizarMedicoes(float temperatura, float umidade, float pressao, LocalDate data) {
       DadoClima dadoClima = new DadoClima(temperatura, umidade, pressao, data);
       notificarPaineis(dadoClima);
   }

   private void notificarPaineis(DadoClima dadoClima) {
       for (IPainel painel : paineis) {
           painel.atualizar(dadoClima);
       }
   }

}
