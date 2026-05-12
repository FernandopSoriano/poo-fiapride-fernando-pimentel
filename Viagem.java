// nova classe que TEM-UM passageiro (associacao)
public class Viagem {
    private String origem;
    private String destino;
    private double distanciaKm;
    private double valor;
    private boolean finalizada;

    // o objeto Passageiro inteiro dentro da viagem
    private Passageiro solicitante;

    public Viagem(String origem, String destino, double distanciaKm, Passageiro solicitante) {
        this.origem = origem;
        this.destino = destino;
        this.distanciaKm = distanciaKm;
        this.solicitante = solicitante;
        this.valor = 3.0 + (2.50 * distanciaKm);
        this.finalizada = false;
    }

    public boolean finalizar() {
        if (this.finalizada) { return false; }
        // a viagem mexe direto no saldo do passageiro
        boolean pagou = this.solicitante.descontarSaldo(this.valor);
        if (!pagou) { return false; }
        this.finalizada = true;
        return true;
    }

    public void exibirResumo() {
        System.out.println("Passageiro: " + solicitante.getNome()
                + " | " + origem + " -> " + destino
                + " | R$ " + valor
                + " | " + (finalizada ? "OK" : "Em andamento"));
    }
}
