/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.trabalhodadosclima.model;

import com.ufes.trabalhodadosclima.log.adapter.LocalDateXmlAdapter;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;

/**
 *
 * @author tallesh
 */
@XmlRootElement
public class DadoClima {

    @XmlElement(name = "temperatura")
    private float temperatura;
    
    @XmlElement(name = "umidade")
    private float umidade;
    
    @XmlElement(name = "pressao")
    private float pressao;
    
    @XmlElement(name = "data")
    @XmlJavaTypeAdapter(LocalDateXmlAdapter.class)
    private LocalDate data;

    public DadoClima(float temperatura, float umidade, float pressao, LocalDate data) {
        this.temperatura = temperatura;
        this.umidade = umidade;
        this.pressao = pressao;
        this.data = data;
    }
    
    public DadoClima() {
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
