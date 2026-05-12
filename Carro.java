// classe filha - usa extends
public class Carro extends Veiculo {

    private int numeroDePortas;

    public Carro(String placa, String modelo, int ano, int numeroDePortas) {
        super(placa, modelo, ano); // chama construtor da mae
        this.numeroDePortas = numeroDePortas;
    }

    public int getNumeroDePortas() { return numeroDePortas; }
}
