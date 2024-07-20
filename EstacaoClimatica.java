import java.time.LocalDate;
import java.util.ArrayList;

public class EstacaoClimatica {
    private ArrayList<Painel> paineis;

    public void registarPainel(Painel painel) {
        paineis.add(painel);
    }

    public void removerPainel(Painel painel) {
        paineis.remove(painel);
    }

    public void atualizarMedicoes(float temperatura, float umidade, float pressao, LocalDate data) {
        
    }

    private void notificarPaineis(DadosClima dadosClima) {

    }

}
