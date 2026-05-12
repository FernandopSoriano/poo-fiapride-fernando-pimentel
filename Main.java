public class Main {
    public static void main(String[] args) {
        Passageiro ana = new Passageiro("Ana Silva", "123.456.789-00", "ana@fiap.com.br", 50.0);

        Veiculo carro = new Carro("ABC1D23", "Fiat Mobi", 2022, 4, 14.0, 40.0);
        Veiculo moto  = new Moto("XYZ4E56", "Honda CG 160", 2023, 160, 45.0, 16.0);

        // o pulo do gato: variavel Veiculo, mas o metodo certo (Carro/Moto) e chamado
        Veiculo[] frota = { carro, moto };
        for (Veiculo v : frota) {
            v.exibirInfo();
            System.out.println("  autonomia: " + v.calcularAutonomia() + " km");
        }

        Viagem viagem = new Viagem("Paulista", "Vila Madalena", 8.5, ana, carro);
        viagem.exibirResumo();
        viagem.finalizar();
    }
}
