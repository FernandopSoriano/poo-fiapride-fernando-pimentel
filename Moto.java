public class Moto extends Veiculo {

    private int cilindradas;
    private double consumoKmPorLitro;
    private double tanqueLitros;

    public Moto() {
        super();
        this.cilindradas = 150;
        this.consumoKmPorLitro = 35.0;
        this.tanqueLitros = 14.0;
    }

    public Moto(String placa, String modelo, int ano,
                int cilindradas, double consumoKmPorLitro, double tanqueLitros) {
        super(placa, modelo, ano);
        this.cilindradas = cilindradas;
        this.consumoKmPorLitro = consumoKmPorLitro;
        this.tanqueLitros = tanqueLitros;
    }

    public int getCilindradas() { return cilindradas; }

    @Override
    public double calcularAutonomia() {
        return this.consumoKmPorLitro * this.tanqueLitros;
    }

    @Override
    public void exibirInfo() {
        super.exibirInfo();
        System.out.println("  Tipo: Moto | " + this.cilindradas
                + "cc | Autonomia: " + this.calcularAutonomia() + " km");
    }
}
