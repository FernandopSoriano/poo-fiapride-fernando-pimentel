public class Main {
    public static void main(String[] args) {
        Passageiro p = new Passageiro();
        p.nome = "Ana Silva";
        p.saldo = 50.0;

        p.exibirDados();

        // testando os metodos
        p.adicionarSaldo(100);
        p.adicionarSaldo(-30);   // tem que dar erro
        p.descontarSaldo(80);
        p.descontarSaldo(1000);  // tem que dar erro (sem saldo)

        p.exibirDados();
    }
}
