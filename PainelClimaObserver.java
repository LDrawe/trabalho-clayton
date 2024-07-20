import java.time.LocalDate;

public class PainelClimaObserver implements Painel{
    
    @Override
    public void atualizar(DadosClima dadosClima) {
        if (dadosClima.getData().isEqual(LocalDate.now())) {
            System.out.println("\nPainel clima - Data: " + dadosClima.getData());
        }
    }    
}
