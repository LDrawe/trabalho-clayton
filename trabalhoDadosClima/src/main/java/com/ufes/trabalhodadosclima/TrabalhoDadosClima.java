/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.ufes.trabalhodadosclima;

import com.ufes.trabalhodadosclima.presenter.EstacaoClimaticaObservavel;
import com.ufes.trabalhodadosclima.presenter.EstatisticaClimaObserver;
import com.ufes.trabalhodadosclima.presenter.MaximasMinimasObserver;
import com.ufes.trabalhodadosclima.presenter.Painel;
import com.ufes.trabalhodadosclima.presenter.PainelClimaObserver;
import java.time.LocalDate;

/**
 *
 * @author tallesh
 */
public class TrabalhoDadosClima {
    
    public static void main(String[] args) {

        EstacaoClimaticaObservavel estacaoClimatica = new EstacaoClimaticaObservavel();


        estacaoClimatica.registrarPainel(new PainelClimaObserver());
        estacaoClimatica.registrarPainel(new EstatisticaClimaObserver());
        estacaoClimatica.registrarPainel(new MaximasMinimasObserver());

        estacaoClimatica.atualizarMedicoes(25.5f, 65f, 1013.1f, LocalDate.of(2023, 5, 1));
        estacaoClimatica.atualizarMedicoes(26.0f, 68f, 1012.5f, LocalDate.of(2023, 5, 2));
        estacaoClimatica.atualizarMedicoes(24.0f, 60f, 1015.5f, LocalDate.of(2023, 5, 3));
    }

}