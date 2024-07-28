/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.trabalhodadosclima.presenter;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import com.ufes.trabalhodadosclima.view.DadosDoTempoView;
import com.ufes.trabalhodadosclima.view.DadosMediosView;
import com.ufes.trabalhodadosclima.view.MaximasMinimasView;
import com.ufes.trabalhodadosclima.view.RegistrosView;
import com.ufes.trabalhodadosclima.view.TelaPrincipalView;
import com.ufes.trabalhodadosclima.view.UltimaAtualizacaoTempoView;

/**
 * Main presenter for the application
 */
public class TelaPrincipalPresenter {
    private TelaPrincipalView view;
    private JDesktopPane desktopPane;

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
            desktopPane = view.getDesktopPane();
            
            if (desktopPane == null) {
                System.err.println("JDesktopPane é null.");
                return;
            }
            
            MaximasMinimasView maximasMinimasView = maximasMinimasPresenter.getView();
            RegistrosView registrosView = registrosPresenter.getView();
            UltimaAtualizacaoTempoView ultimaAtualizacaoView = ultimaAtualizacaoTempoPresenter.getView();
            DadosDoTempoView dadosTempoView = dadosDoTempoPresenter.getView();
            DadosMediosView dadosMediosView = dadosMediosPresenter.getView();
            
            final ArrayList<JInternalFrame> janelas = new ArrayList<>();
            Collections.addAll(janelas, maximasMinimasView, registrosView, ultimaAtualizacaoView, dadosMediosView, dadosTempoView);
            
            desktopPane.setLayout(new GridLayout(2, 3, 15, 10)); // 1 row, all frames in columns

            int x = 0; // variable to keep track of horizontal position
            for (int i = 0; i < janelas.size(); i++) {
                JInternalFrame janela = janelas.get(i);
                desktopPane.add(janela);
                janela.setVisible(true);
                // janela.setSize(400, 150);
                janela.setLayer(i); // Assign different layers to each frame

                janela.setLocation(x, 0); // Set initial position on x-axis (0 for vertical alignment)
                x += janela.getWidth() + 10; // Increase x by frame width and a gap of 10 pixels
            }
            view.add(desktopPane, BorderLayout.CENTER);
            view.setMinimumSize(new Dimension(800, 600)); // Adjust minimum size as needed
            view.pack();
            view.setVisible(true);
            view.setExtendedState(TelaPrincipalView.MAXIMIZED_BOTH);
        });
    }
}
