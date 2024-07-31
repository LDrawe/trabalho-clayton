package com.ufes.trabalhodadosclima.presenter;

import com.ufes.trabalhodadosclima.view.ErrorView;

public class ErrorPresenter {
    private ErrorView view;

    public void fechaJanela() {
        this.view.dispose();
    }

    public ErrorPresenter(String message) {
        this.view = new ErrorView(message);
        view.getButton().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fechaJanela();
            }
        });
    }
}
