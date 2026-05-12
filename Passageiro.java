public class Passageiro {
    String nome;
    String cpf;
    String email;
    double saldo;

    // metodo com parametro e retorno + validacao
    public boolean adicionarSaldo(double valor) {
        if (valor <= 0) {
            System.out.println("[ERRO] valor tem que ser maior que zero");
            return false;
        }
        this.saldo += valor;
        System.out.println("recarga de R$ " + valor + " feita pra " + this.nome);
        return true;
    }

    public boolean descontarSaldo(double valor) {
        if (valor <= 0) {
            System.out.println("[ERRO] valor invalido");
            return false;
        }
        if (valor > this.saldo) {
            System.out.println("[ERRO] saldo insuficiente");
            return false;
        }
        this.saldo -= valor;
        return true;
    }

    public void exibirDados() {
        System.out.println("Nome: " + nome + " | Saldo: R$ " + saldo);
    }
}
