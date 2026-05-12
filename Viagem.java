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
        this.finalizada = false;
        this.valor = 3.0 + (2.50 * this.distanciaKm);
    }

    public boolean finalizar() {
        if (this.finalizada) {
            System.out.println("[ERRO] Viagem ja foi finalizada.");
            return false;
        }
        boolean pagou = this.solicitante.descontarSaldo(this.valor);
        if (!pagou) {
            System.out.println("[ERRO] Cobranca falhou pra " + this.solicitante.getNome());
            return false;
        }
        this.finalizada = true;
        System.out.println("Viagem finalizada!");
        return true;
    }

    public void exibirResumo() {
        System.out.println("====== Resumo da Viagem ======");
        System.out.println("Passageiro: " + this.solicitante.getNome());
        System.out.println("Veiculo:    " + this.veiculo.getModelo() + " (" + this.veiculo.getPlaca() + ")");
        System.out.println("Trajeto:    " + this.origem + " -> " + this.destino);
        System.out.println("Distancia:  " + this.distanciaKm + " km");
        System.out.println("Valor:      R$ " + this.valor);
        System.out.println("Status:     " + (this.finalizada ? "Finalizada" : "Em andamento"));
        System.out.println("==============================");
    }

    public double getValor() { return valor; }
    public boolean isFinalizada() { return finalizada; }
    public Passageiro getSolicitante() { return solicitante; }
    public Veiculo getVeiculo() { return veiculo; }
}
