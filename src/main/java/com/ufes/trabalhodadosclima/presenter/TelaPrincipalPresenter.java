/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.trabalhodadosclima.presenter;

import com.ufes.trabalhodadosclima.log.Log;
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
    Log log;

    public TelaPrincipalPresenter() {
        configurarTela();
        log = new Log();
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

        DadosDoTempoPresenter dadosDoTempoPresenter = new DadosDoTempoPresenter(dadosTempoView, estacaoClimatica);
        
        MaximasMinimasPresenter maximasMinimasPresenter = new MaximasMinimasPresenter(maximasMinimasView, estacaoClimatica);
        RegistrosPresenter registrosPresenter = new RegistrosPresenter(registrosView, estacaoClimatica);
        UltimaAtualizacaoTempoPresenter ultimaAtualizacaoTempoPresenter = new UltimaAtualizacaoTempoPresenter(ultimaAtualizacaoView, estacaoClimatica);
        DadosMediosPresenter dadosMediosPresenter = new DadosMediosPresenter(dadosMediosView, estacaoClimatica);
        ConfiguracoesPresenter configuracoesPresenter = new ConfiguracoesPresenter();

        SwingUtilities.invokeLater(() -> {
            desktopPane = view.getDesktopPane();

            if (desktopPane == null) {
                System.err.println("JDesktopPane é null.");
                return;
            }

            final ArrayList<JInternalFrame> janelas = new ArrayList<>();
            Collections.addAll(janelas, maximasMinimasView, registrosView, ultimaAtualizacaoView, dadosMediosView,
                dadosTempoView);

            desktopPane.setLayout(new GridLayout(2, 3, 20, 20));

            for (int i = 0; i < janelas.size(); i++) {
                JInternalFrame janela = janelas.get(i);
                desktopPane.add(janela);
                janela.setLayer(i);
            }
            view.add(desktopPane, BorderLayout.CENTER);
            view.setMinimumSize(new Dimension(1024, 600));
        });
    }
}
