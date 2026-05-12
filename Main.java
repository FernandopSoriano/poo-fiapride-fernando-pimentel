public class Main {
    public static void main(String[] args) {
        Passageiro ana = new Passageiro("Ana Silva", "123.456.789-00", "ana@fiap.com.br", 50.0);

        // passa a Ana inteira pra Viagem (associacao)
        Viagem v = new Viagem("Paulista", "Vila Madalena", 8.5, ana);
        v.exibirResumo();
        v.finalizar();
        v.exibirResumo();

        ana.exibirDados(); // saldo descontou
    }
}
