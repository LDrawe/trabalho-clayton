/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.trabalhodadosclima.model;

import com.ufes.trabalhodadosclima.adapter.LocalDateXmlAdapter;
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

    private float temperatura;
    private float umidade;
    private float pressao;
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
    
    @XmlElement
    public float getTemperatura() {
        return temperatura;
    }

    @XmlElement
    public float getUmidade() {
        return umidade;
    }
    
    @XmlElement
    public float getPressao() {
        return pressao;
    }
    
    @XmlElement
    @XmlJavaTypeAdapter(LocalDateXmlAdapter.class)
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
