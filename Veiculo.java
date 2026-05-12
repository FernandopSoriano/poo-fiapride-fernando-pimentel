// classe mae - abstract pq nao faz sentido criar "veiculo generico"
public abstract class Veiculo {

    private String placa;
    private String modelo;
    protected int ano;

    public Veiculo() {
        this("SEM-0000", "Modelo Desconhecido", 2020);
    }
    public Veiculo(String placa, String modelo, int ano) {
        this.setPlaca(placa);
        this.modelo = modelo;
        this.ano = ano;
    }

    public String getPlaca()  { return placa; }
    public String getModelo() { return modelo; }
    public int getAno()       { return ano; }

    private void setPlaca(String placa) {
        if (placa == null || placa.length() < 7) {
            System.out.println("[ERRO] Placa invalida.");
            return;
        }
        this.placa = placa.toUpperCase();
    }

    public boolean atualizarPlaca(String novaPlaca, String motivo) {
        if (motivo == null || motivo.trim().isEmpty()) {
            System.out.println("[ERRO] Precisa informar o motivo.");
            return false;
        }
        this.setPlaca(novaPlaca);
        System.out.println("Placa atualizada. Motivo: " + motivo);
        return true;
    }

    public abstract double calcularAutonomia();

    public void exibirInfo() {
        System.out.println("Placa: " + this.placa + " | Modelo: " + this.modelo + " | Ano: " + this.ano);
    }
}
