/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.trabalhodadosclima.log;

import com.ufes.trabalhodadosclima.model.DadoClima;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author talle
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class LogEntry {
    @XmlElement(name = "dadoClima")
    private DadoClima dado;
    
    @XmlElement(name = "operacao")    
    private String operacao;

    public LogEntry(DadoClima dado, String operacao) {
        this.dado = dado;
        this.operacao = operacao;
    }

    public LogEntry() {
    }

    @Override
    public String toString() {
        return "DadoClima: " + dado.toString() + ", Operação: " + operacao;
    }    
}
