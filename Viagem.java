public class Viagem {
    private String origem;
    private String destino;
    private double distanciaKm;
    private double valor;
    private boolean finalizada;

    private Passageiro solicitante;
    private Veiculo veiculo;

    public Viagem(String origem, String destino, double distanciaKm,
                  Passageiro solicitante, Veiculo veiculo) {
        this.origem = origem;
        this.destino = destino;
        this.distanciaKm = distanciaKm;
        this.solicitante = solicitante;
        this.veiculo = veiculo;
        this.valor = 3.0 + (2.50 * distanciaKm);
        this.finalizada = false;
    }

    public boolean finalizar() {
        if (this.finalizada) { return false; }
        if (!this.solicitante.descontarSaldo(this.valor)) { return false; }
        this.finalizada = true;
        return true;
    }

    public void exibirResumo() {
        System.out.println(solicitante.getNome() + " | " + veiculo.getModelo()
                + " | " + origem + " -> " + destino + " | R$ " + valor);
    }
}
