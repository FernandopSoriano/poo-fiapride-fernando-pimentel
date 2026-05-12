public class Main {
    public static void main(String[] args) {
        // criando um passageiro e acessando os atributos direto
        Passageiro p = new Passageiro();
        p.nome = "Ana Silva";
        p.cpf = "123.456.789-00";
        p.email = "ana@fiap.com.br";
        p.saldo = 50.0;

        System.out.println("Passageiro criado:");
        System.out.println("Nome:  " + p.nome);
        System.out.println("CPF:   " + p.cpf);
        System.out.println("Email: " + p.email);
        System.out.println("Saldo: R$ " + p.saldo);
    }
}
