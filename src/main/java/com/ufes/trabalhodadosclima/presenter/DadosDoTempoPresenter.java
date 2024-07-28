/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.trabalhodadosclima.presenter;

import com.ufes.trabalhodadosclima.view.DadosDoTempoView;

/**
 *
 * @author talles.h.santos
 */
public class DadosDoTempoPresenter {

    private final  DadosDoTempoView view;
    
    public DadosDoTempoPresenter() {
        view = new DadosDoTempoView();
    }
    
    public DadosDoTempoView getView() {
        if (view == null) {
            System.err.println("dadosTempoView não foi inicializado.");
        }
        return view;
    }
}
