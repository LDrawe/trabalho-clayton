public class Main {
    public static void main(String[] args) {
        EstacaoClimatica estacaoClimatica = new EstacaoClimatica();
        
        estacaoClimatica.registarPainel(new PainelClimaObserver());
        estacaoClimatica.registarPainel(new EstatisticaClimaObserver());
        estacaoClimatica.registarPainel(new MaximasMinimasObserver());
    }
}
