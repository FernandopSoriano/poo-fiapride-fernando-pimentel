// herda de Carro E implementa Recarregavel
public class CarroEletrico extends Carro implements Recarregavel {

    private int nivelBateria;

    public CarroEletrico(String placa, String modelo, int ano,
                         int numeroDePortas, double autonomiaKmComCargaCheia) {
        super(placa, modelo, ano, numeroDePortas, autonomiaKmComCargaCheia / 100.0, 100.0);
        this.nivelBateria = CAPACIDADE_MAXIMA;
    }

    @Override
    public void recarregar(int percentual) {
        if (percentual <= 0) {
            System.out.println("[ERRO] Percentual invalido.");
            return;
        }
        this.nivelBateria += percentual;
        if (this.nivelBateria > CAPACIDADE_MAXIMA) {
            this.nivelBateria = CAPACIDADE_MAXIMA;
        }
        System.out.println("Bateria do " + getModelo() + " agora: " + this.nivelBateria + "%");
    }

    @Override
    public int getNivelBateria() {
        return this.nivelBateria;
    }

    @Override
    public double calcularAutonomia() {
        return super.calcularAutonomia() * (this.nivelBateria / 100.0);
    }

    @Override
    public void exibirInfo() {
        System.out.println("Placa: " + getPlaca() + " | Modelo: " + getModelo() + " | Ano: " + getAno());
        System.out.println("  Tipo: Carro Eletrico | Bateria: " + this.nivelBateria + "%"
                + " | Autonomia: " + this.calcularAutonomia() + " km");
        if (precisaRecarregar()) {
            System.out.println("  >> bateria baixa, vai precisar recarregar");
        }
    }
}
