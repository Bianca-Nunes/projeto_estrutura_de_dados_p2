public class Fila<T> {
    private No<T> primeiro;
    private No<T> ultimo;
    private int quantidade;

    public Fila() {
        this.primeiro = null;
        this.ultimo = null;
        this.quantidade = 0;
    }

    public boolean filaVazia() {
        return primeiro == null;
    }

    public void enfileira(T info) {
        No<T> novo = new No<>(info);

        if (filaVazia()) {
            primeiro = novo;
        } else {
            ultimo.setProximo(novo);
        }

        ultimo = novo;
        quantidade++;
    }
    public T desenfileira() throws FilaVaziaException {
        if (filaVazia()) {
            throw new FilaVaziaException();
        }

        T copia = primeiro.getInfo();
        primeiro = primeiro.getProximo();

        if (primeiro == null) {
            ultimo = null;
        }

        quantidade--;
        return copia;
    }

    public T primeiro() {
        if (filaVazia()) {
            return null;
        }
        return primeiro.getInfo();
    }

    public int tamanho() {
        return quantidade;
    }

    @Override
    public String toString() {
        if (filaVazia()) {
            return "fila vazia";
        }
        String s = "";
        No<T> runner = primeiro;
        while (runner != null) {
            s += runner + "->";
            runner = runner.getProximo();
        }
        return s + "\\\\";
    }
}
