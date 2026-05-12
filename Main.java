public class Main {
    public static void main(String[] args) {
        Passageiro ana = new Passageiro("Ana Silva", "123.456.789-00", "ana@fiap.com.br", 50.0);

        // Carro e Moto sao filhos de Veiculo (heranca)
        Carro c = new Carro("ABC1D23", "Fiat Mobi", 2022, 4);
        Moto m  = new Moto("XYZ4E56", "Honda CG 160", 2023, 160);

        c.exibirInfo(); // herdado de Veiculo
        m.exibirInfo();

        Viagem v = new Viagem("Paulista", "Vila Madalena", 8.5, ana, c);
        v.exibirResumo();
        v.finalizar();
        v.exibirResumo();
    }
}
