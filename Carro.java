public class Carro extends Veiculo {

    private int numeroDePortas;
    private double consumoKmPorLitro;
    private double tanqueLitros;

    public Carro() {
        super();
        this.numeroDePortas = 4;
        this.consumoKmPorLitro = 12.0;
        this.tanqueLitros = 50.0;
    }

    public Carro(String placa, String modelo, int ano,
                 int numeroDePortas, double consumoKmPorLitro, double tanqueLitros) {
        super(placa, modelo, ano);
        this.numeroDePortas = numeroDePortas;
        this.consumoKmPorLitro = consumoKmPorLitro;
        this.tanqueLitros = tanqueLitros;
    }

    public int getNumeroDePortas() { return numeroDePortas; }
    public double getConsumoKmPorLitro() { return consumoKmPorLitro; }
    public double getTanqueLitros() { return tanqueLitros; }

    @Override
    public double calcularAutonomia() {
        return this.consumoKmPorLitro * this.tanqueLitros;
    }

    @Override
    public void exibirInfo() {
        super.exibirInfo();
        System.out.println("  Tipo: Carro | Portas: " + this.numeroDePortas
                + " | Autonomia: " + this.calcularAutonomia() + " km");
    }
}
