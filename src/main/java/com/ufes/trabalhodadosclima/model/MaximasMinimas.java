/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.trabalhodadosclima.model;

/**
 *
 * @author talles.h.santos
 */
public class MaximasMinimas {

    private float maximaTemperatura = Float.MIN_VALUE;
    private float minimaTemperatura = Float.MAX_VALUE;
    private float maximaPressao = Float.MIN_VALUE;
    private float minimaPressao = Float.MAX_VALUE;
    private float maximaUmidade = Float.MIN_VALUE;
    private float minimaUmidade = Float.MAX_VALUE;

    public Float getMinimaTemperatura() {
        return minimaTemperatura;
    }

    public Float getMaximaTemperatura() {
        return maximaTemperatura;
    }

    public Float getMinimaPressao() {
        return minimaPressao;
    }

    public Float getMaximaPressao() {
        return maximaPressao;
    }

    public Float getMinimaUmidade() {
        return minimaUmidade;
    }

    public Float getMaximaUmidade() {
        return maximaUmidade;
    }

    public void setMinimaTemperatura(Float temp) {
        this.minimaTemperatura = temp;
    }

    public void setMaximaTemperatura(Float temp) {
        this.maximaTemperatura = temp;
    }

    public void setMinimaPressao(Float pressure) {
        this.minimaPressao = pressure;
    }

    public void setMaximaPressao(Float pressure) {
        this.maximaPressao = pressure;
    }

    public void setMinimaUmidade(Float humidity) {
        this.minimaUmidade = humidity;
    }

    public void setMaximaUmidade(Float humidity) {
        this.maximaUmidade = humidity;
    }
}
