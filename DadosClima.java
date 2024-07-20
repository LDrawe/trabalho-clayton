import java.time.LocalDate;

public class DadosClima {
    private float temperatura;
    private float umidade;
    private float pressao;
    private LocalDate data;

    public DadosClima(float temperatura, float umidade, float pressao, LocalDate data) {
        this.temperatura = temperatura;
        this.umidade = umidade;
        this.pressao = pressao;
        this.data = data;
    }

    public float getTemperatura() {
        return this.temperatura;
    }

    public float getUmidade() {
        return this.umidade;
    }

    public float getPressao() {
        return this.pressao;
    }

    public LocalDate getData() {
        return this.data;
    }
    
}
