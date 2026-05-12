public class Moto extends Veiculo {

    private int cilindradas;
    private double consumoKmPorLitro;
    private double tanqueLitros;

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
}
