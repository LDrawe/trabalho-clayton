/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.trabalhodadosclima.model;

import java.time.LocalDate;

/**
 *
 * @author tallesh
 */
public class DadoClima {
    
    private float temperatura;
    private float umidade;
    private float pressao;
    private LocalDate data;

   public DadoClima(float temperatura, float umidade, float pressao, LocalDate data) {
       this.temperatura = temperatura;
       this.umidade = umidade;
       this.pressao = pressao;
       this.data = data;
   }

    public float getTemperatura() {
        return temperatura;
    }

    public float getUmidade() {
        return umidade;
    }

    public float getPressao() {
        return pressao;
    }

    public LocalDate getData() {
        return data;
    }
   
   

    
}
