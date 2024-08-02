/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.trabalhodadosclima.model;

import com.ufes.trabalhodadosclima.adapter.LocalDateXmlAdapter;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;
import java.util.List;

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

    private List<IPainel> observers;


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

    public void registrarPainel(IPainel painel) {
        observers.add(painel);
    }

    public void removerPainel(IPainel painel) {
        observers.remove(painel);
    }

    public void atualizarMedicoes(DadoClima dados) {
        notificarObservers(dados);
    }

    private void notificarObservers(DadoClima dadoClima) {
        for (IPainel painel : observers) {
            painel.atualizar(dadoClima);
        }
    }
}
