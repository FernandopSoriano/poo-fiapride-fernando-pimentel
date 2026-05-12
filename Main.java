public class Main {
    public static void main(String[] args) {
        Passageiro p = new Passageiro();
        // agora nao tem como fazer p.nome = "..." direto, tem que usar o setter
        p.setNome("Ana Silva");
        p.setCpf("123.456.789-00");
        p.setEmail("ana@fiap.com.br");

        // testes que tem que falhar:
        p.setEmail("email-sem-arroba");
        p.setNome("");

        p.adicionarSaldo(100);
        p.exibirDados();
    }
}
