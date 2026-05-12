// contrato pra coisas que tem bateria
public interface Recarregavel {

    // constantes (interface ja deixa public static final automatico)
    int CAPACIDADE_MAXIMA = 100;
    int NIVEL_MINIMO_SEGURO = 20;

    void recarregar(int percentual);
    int getNivelBateria();

    // default - todo Recarregavel ja ganha esse metodo de graca
    default boolean precisaRecarregar() {
        return getNivelBateria() < NIVEL_MINIMO_SEGURO;
    }
}
