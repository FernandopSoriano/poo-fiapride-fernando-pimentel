public class Main {

    public static void main(String[] args) {

        System.out.println("======= FIAPRIDE =======\n");

        Passageiro ana = new Passageiro("Ana Silva", "123.456.789-00", "ana@fiap.com.br", 50.0);
        Passageiro bruno = new Passageiro();
        bruno.setNome("Bruno Costa");
        bruno.setEmail("bruno@fiap.com.br");
        bruno.setCpf("987.654.321-00");

        ana.exibirDados();
        bruno.exibirDados();

        System.out.println(">>> testando saldo:");
        ana.adicionarSaldo(100.0);
        ana.adicionarSaldo(-30);
        bruno.adicionarSaldo(40);

        System.out.println("\n>>> frota:");
        Veiculo carro1 = new Carro("ABC1D23", "Fiat Mobi", 2022, 4, 14.0, 40.0);
        Veiculo moto1  = new Moto("XYZ4E56", "Honda CG 160", 2023, 160, 45.0, 16.0);
        Veiculo eletrico = new CarroEletrico("ELE2024", "Tesla Model 3", 2024, 4, 450.0);

        Veiculo[] frota = { carro1, moto1, eletrico };
        for (Veiculo v : frota) {
            v.exibirInfo();
            System.out.println("  Autonomia: " + v.calcularAutonomia() + " km\n");
        }

        System.out.println(">>> recarga do eletrico:");
        CarroEletrico tesla = (CarroEletrico) eletrico;
        tesla.recarregar(15);
        tesla.exibirInfo();

        System.out.println("\n>>> viagem da Ana:");
        Viagem viagem1 = new Viagem("Paulista", "Vila Madalena", 8.5, ana, carro1);
        viagem1.exibirResumo();
        viagem1.finalizar();

        System.out.println("\n======= FIM =======");
    }
}
