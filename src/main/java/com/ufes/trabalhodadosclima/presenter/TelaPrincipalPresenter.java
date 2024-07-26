/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.trabalhodadosclima.presenter;

import com.ufes.trabalhodadosclima.view.DadosDoTempoView;
import com.ufes.trabalhodadosclima.view.DadosMediosView;
import com.ufes.trabalhodadosclima.view.MaximasMinimasView;
import com.ufes.trabalhodadosclima.view.RegistrosView;
import com.ufes.trabalhodadosclima.view.TelaPrincipalView;
import com.ufes.trabalhodadosclima.view.UltimaAtualizacaoTempoView;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JDesktopPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author talles.h.santos
 */
public class TelaPrincipalPresenter {
    TelaPrincipalView view;

    public TelaPrincipalPresenter() {
        configurarTela();
    }
    
private void configurarTela() {
    try {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch (Exception e) {
        e.printStackTrace();
    }
    
    view = new TelaPrincipalView();
    
    MaximasMinimasPresenter maximasMinimasPresenter = new MaximasMinimasPresenter();
    RegistrosPresenter registrosPresenter = new RegistrosPresenter();
    UltimaAtualizacaoTempoPresenter ultimaAtualizacaoTempoPresenter = new UltimaAtualizacaoTempoPresenter();
    DadosDoTempoPresenter dadosDoTempoPresenter = new DadosDoTempoPresenter();
    DadosMediosPresenter dadosMediosPresenter = new DadosMediosPresenter();
    
    SwingUtilities.invokeLater(() -> {
        JDesktopPane desktopPane = view.getDesktopPane();
        
        if (desktopPane == null) {
            System.err.println("JDesktopPane é null.");
            return;
        }
        
        MaximasMinimasView maximasMinimasView = maximasMinimasPresenter.getView();
        RegistrosView registrosView = registrosPresenter.getView();
        UltimaAtualizacaoTempoView ultimaAtualizacaoView = ultimaAtualizacaoTempoPresenter.getView();
        DadosDoTempoView dadosTempoView = dadosDoTempoPresenter.getView();
        DadosMediosView dadosMediosView = dadosMediosPresenter.getView();
        
        // Definir tamanho e posição dos JInternalFrames
        maximasMinimasView.setSize(300, 200);
        maximasMinimasView.setLocation(10, 10);
        
        registrosView.setSize(300, 200);
        registrosView.setLocation(320, 10);
        
        ultimaAtualizacaoView.setSize(300, 200);
        ultimaAtualizacaoView.setLocation(10, 220);
        
        dadosTempoView.setSize(300, 200);
        dadosTempoView.setLocation(320, 220);
        
        dadosMediosView.setSize(300, 200);
        dadosMediosView.setLocation(630, 10);
        
        // Adicionar os JInternalFrames ao JDesktopPane
        desktopPane.add(maximasMinimasView);
        desktopPane.add(registrosView);
        desktopPane.add(ultimaAtualizacaoView);
        desktopPane.add(dadosTempoView);
        desktopPane.add(dadosMediosView);
        
        // Tornar os JInternalFrames visíveis
        maximasMinimasView.setVisible(true);
        registrosView.setVisible(true);
        ultimaAtualizacaoView.setVisible(true);
        dadosTempoView.setVisible(true);
        dadosMediosView.setVisible(true);
        
        view.add(desktopPane, BorderLayout.CENTER);
        view.setMinimumSize(new Dimension(800, 600)); // Ajuste o tamanho mínimo conforme necessário
        view.pack();
        view.setVisible(true);
        view.setExtendedState(view.MAXIMIZED_BOTH);
    });
}


    
}
