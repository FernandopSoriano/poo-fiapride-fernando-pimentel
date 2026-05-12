public class Passageiro {
    // tudo private agora - nao pode mexer de fora
    private String nome;
    private String cpf;
    private String email;
    private double saldo;

    // getters
    public String getNome()  { return nome; }
    public String getCpf()   { return cpf; }
    public String getEmail() { return email; }
    public double getSaldo() { return saldo; }

    // setters com validacao
    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            System.out.println("[ERRO] nome vazio");
            return;
        }
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        if (cpf == null || cpf.length() != 14) {
            System.out.println("[ERRO] cpf invalido (formato 000.000.000-00)");
            return;
        }
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        if (email == null || !email.contains("@")) {
            System.out.println("[ERRO] email invalido");
            return;
        }
        this.email = email;
    }

    public boolean adicionarSaldo(double valor) {
        if (valor <= 0) { return false; }
        this.saldo += valor;
        return true;
    }

    public boolean descontarSaldo(double valor) {
        if (valor <= 0 || valor > this.saldo) { return false; }
        this.saldo -= valor;
        return true;
    }

    public void exibirDados() {
        System.out.println("Nome: " + nome + " | Saldo: R$ " + saldo);
    }
}
