/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.trabalhodadosclima.presenter;

import com.ufes.trabalhodadosclima.model.DadoClima;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tallesh
 */
public class EstacaoClimaticaObservavel {
    
    private List<Painel> paineis;

   public EstacaoClimaticaObservavel() {
       paineis = new ArrayList<>();
   }

   public void registrarPainel(Painel painel) {
       paineis.add(painel);
   }

   public void removerPainel(Painel painel) {
       paineis.remove(painel);
   }

   public void atualizarMedicoes(float temperatura, float umidade, float pressao, LocalDate data) {
       DadoClima dadoClima = new DadoClima(temperatura, umidade, pressao, data);
       notificarPaineis(dadoClima);
   }

   private void notificarPaineis(DadoClima dadoClima) {
       for (Painel painel : paineis) {
           painel.atualizar(dadoClima);
       }
   }

}
