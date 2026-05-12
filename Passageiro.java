public class Passageiro {
    private String nome;
    private String cpf;
    private String email;
    private double saldo;

    // construtor padrao - chama o outro construtor usando this()
    public Passageiro() {
        this("Sem Nome", "000.000.000-00", "sememail@fiapride.com", 0.0);
    }

    // construtor customizado - usa this. pra diferenciar parametro de atributo
    public Passageiro(String nome, String cpf, String email, double saldoInicial) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.setSaldo(saldoInicial);
    }

    public String getNome()  { return nome; }
    public String getCpf()   { return cpf; }
    public String getEmail() { return email; }
    public double getSaldo() { return saldo; }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) { return; }
        this.nome = nome;
    }
    public void setCpf(String cpf) {
        if (cpf == null || cpf.length() != 14) { return; }
        this.cpf = cpf;
    }
    public void setEmail(String email) {
        if (email == null || !email.contains("@")) { return; }
        this.email = email;
    }
    // setter private de saldo - so mexe via adicionarSaldo/descontarSaldo
    private void setSaldo(double saldo) {
        if (saldo < 0) { this.saldo = 0; return; }
        this.saldo = saldo;
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
