/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.trabalhodadosclima.presenter;

import com.ufes.trabalhodadosclima.log.ILog;
import com.ufes.trabalhodadosclima.log.Log;
import com.ufes.trabalhodadosclima.log.json.LogJSON;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import com.ufes.trabalhodadosclima.observer.EstacaoClimaticaObservavel;
import com.ufes.trabalhodadosclima.view.ConfiguracoesView;
import com.ufes.trabalhodadosclima.view.DadosDoTempoView;
import com.ufes.trabalhodadosclima.view.DadosMediosView;
import com.ufes.trabalhodadosclima.view.MaximasMinimasView;
import com.ufes.trabalhodadosclima.view.PrincipalView;
import com.ufes.trabalhodadosclima.view.RegistrosView;
import com.ufes.trabalhodadosclima.view.TelaPrincipalView;
import com.ufes.trabalhodadosclima.view.UltimaAtualizacaoTempoView;
import java.awt.Insets;
import javax.swing.border.EmptyBorder;

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

        EstacaoClimaticaObservavel estacaoClimatica = new EstacaoClimaticaObservavel();
        
        MaximasMinimasView maximasMinimasView = new MaximasMinimasView();
        RegistrosView registrosView = new RegistrosView();
        UltimaAtualizacaoTempoView ultimaAtualizacaoView = new UltimaAtualizacaoTempoView();
        DadosDoTempoView dadosTempoView = new DadosDoTempoView();
        DadosMediosView dadosMediosView = new DadosMediosView();
        ConfiguracoesView configuracoesView = new ConfiguracoesView();

        ConfiguracoesPresenter configuracoesPresenter = new ConfiguracoesPresenter(configuracoesView);
        DadosDoTempoPresenter dadosDoTempoPresenter = new DadosDoTempoPresenter(dadosTempoView, estacaoClimatica, configuracoesPresenter);
        MaximasMinimasPresenter maximasMinimasPresenter = new MaximasMinimasPresenter(maximasMinimasView, estacaoClimatica);
        RegistrosPresenter registrosPresenter = new RegistrosPresenter(registrosView, estacaoClimatica);
        UltimaAtualizacaoTempoPresenter ultimaAtualizacaoTempoPresenter = new UltimaAtualizacaoTempoPresenter(ultimaAtualizacaoView, estacaoClimatica);
        DadosMediosPresenter dadosMediosPresenter = new DadosMediosPresenter(dadosMediosView, estacaoClimatica);


        SwingUtilities.invokeLater(() -> {
            desktopPane = view.getDesktopPane();
            
            if (desktopPane == null) {
                System.err.println("JDesktopPane é null.");
                return;
            }

            final ArrayList<JInternalFrame> janelas = new ArrayList<>();
            Collections.addAll(janelas, maximasMinimasView, registrosView, ultimaAtualizacaoView, dadosMediosView,
                dadosTempoView, configuracoesView);

            desktopPane.setLayout(new GridLayout(2, 3, 20, 20));
            
            int maxWidth = 0;
            int maxHeight = 0;
            for (JInternalFrame janela : janelas) {
                Dimension size = janela.getPreferredSize();
                if (size.width > maxWidth) maxWidth = size.width;
                if (size.height > maxHeight) maxHeight = size.height;
            }

            // Resize all internal frames to the maximum size
            for (JInternalFrame janela : janelas) {
                janela.setPreferredSize(new Dimension(maxWidth, maxHeight));
                janela.setSize(new Dimension(maxWidth, maxHeight)); // Ensure the size is applied immediately
                desktopPane.add(janela);
                janela.setVisible(true);
            }
            
            view.add(desktopPane, BorderLayout.CENTER);
            view.setMinimumSize(new Dimension(1080, 700));
        });
    }
}
