public class Main {
    public static void main(String[] args) {
        // construtor customizado
        Passageiro ana = new Passageiro("Ana Silva", "123.456.789-00", "ana@fiap.com.br", 50.0);
        ana.exibirDados();

        // construtor padrao
        Passageiro bruno = new Passageiro();
        bruno.setNome("Bruno Costa");
        bruno.exibirDados();
    }
}
