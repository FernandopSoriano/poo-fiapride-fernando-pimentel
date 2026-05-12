public class Passageiro {

    // private pq nao quero que ninguem mexa direto de fora
    private String nome;
    private String cpf;
    private String email;
    private double saldo;

    // construtor padrao - chama o outro com valores tipo "vazio"
    public Passageiro() {
        this("Sem Nome", "000.000.000-00", "sememail@fiapride.com", 0.0);
    }

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
        if (nome == null || nome.trim().isEmpty()) {
            System.out.println("[ERRO] Nome nao pode ser vazio.");
            return;
        }
        this.nome = nome;
    }
    public void setCpf(String cpf) {
        if (cpf == null || cpf.length() != 14) {
            System.out.println("[ERRO] CPF invalido.");
            return;
        }
        this.cpf = cpf;
    }
    public void setEmail(String email) {
        if (email == null || !email.contains("@")) {
            System.out.println("[ERRO] Email invalido.");
            return;
        }
        this.email = email;
    }
    private void setSaldo(double saldo) {
        if (saldo < 0) {
            System.out.println("[ERRO] Saldo nao pode ser negativo. Zerando.");
            this.saldo = 0;
            return;
        }
        this.saldo = saldo;
    }

    public boolean adicionarSaldo(double valor) {
        if (valor <= 0) {
            System.out.println("[ERRO] Valor de recarga tem que ser maior que zero.");
            return false;
        }
        this.saldo += valor;
        System.out.println("Recarga de R$ " + valor + " feita pra " + this.nome + ". Saldo: R$ " + this.saldo);
        return true;
    }

    public boolean descontarSaldo(double valor) {
        if (valor <= 0) {
            System.out.println("[ERRO] Valor invalido.");
            return false;
        }
        if (valor > this.saldo) {
            System.out.println("[ERRO] " + this.nome + " nao tem saldo suficiente.");
            return false;
        }
        this.saldo -= valor;
        return true;
    }

    public void exibirDados() {
        System.out.println("------- Passageiro -------");
        System.out.println("Nome:  " + this.nome);
        System.out.println("CPF:   " + this.cpf);
        System.out.println("Email: " + this.email);
        System.out.println("Saldo: R$ " + this.saldo);
        System.out.println("--------------------------");
    }
}
