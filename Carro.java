public class Carro extends Veiculo {

    private int numeroDePortas;
    private double consumoKmPorLitro;
    private double tanqueLitros;

    public Carro(String placa, String modelo, int ano,
                 int numeroDePortas, double consumoKmPorLitro, double tanqueLitros) {
        super(placa, modelo, ano);
        this.numeroDePortas = numeroDePortas;
        this.consumoKmPorLitro = consumoKmPorLitro;
        this.tanqueLitros = tanqueLitros;
    }

    public int getNumeroDePortas() { return numeroDePortas; }

    // sobrescrita - polimorfismo
    @Override
    public double calcularAutonomia() {
        return this.consumoKmPorLitro * this.tanqueLitros;
    }
}
