// classe mae - ainda nao e abstrata (aula 8 vai mudar isso)
public class Veiculo {

    private String placa;
    private String modelo;
    protected int ano; // protected pra filha poder mexer

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
        if (placa == null || placa.length() < 7) { return; }
        this.placa = placa.toUpperCase();
    }

    public void exibirInfo() {
        System.out.println("Placa: " + placa + " | Modelo: " + modelo + " | Ano: " + ano);
    }
}
