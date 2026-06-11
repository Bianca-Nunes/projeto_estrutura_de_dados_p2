public class ListaDupla {
    private NoDuplo inicio;
    private NoDuplo fim;
    private int quantidade;

    public ListaDupla() {
        this.inicio = null;
        this.fim = null;
        this.quantidade = 0;
    }

    public void insereInicio(Livro livro) {
        NoDuplo novo = new NoDuplo(livro);

        if (inicio == null) {
            inicio = novo;
            fim = novo;
        } else {
            novo.setProximo(inicio);
            inicio.setAnterior(novo);
            inicio = novo;
        }

        quantidade++;
    }

    public void insereFim(Livro livro) {
        NoDuplo novo = new NoDuplo(livro);

        if (fim == null) {
            inicio = novo;
            fim = novo;
        } else {
            fim.setProximo(novo);
            novo.setAnterior(fim);
            fim = novo;
        }

        quantidade++;
    }

    public Livro removePrimeiro() {
        if (inicio == null) {
            return null;
        }

        Livro removido = inicio.getInfo();
        inicio = inicio.getProximo();

        if (inicio == null) {
            fim = null;
        } else {
            inicio.setAnterior(null);
        }

        quantidade--;
        return removido;
    }

    public Livro removeUltimo() {
        if (fim == null) {
            return null;
        }

        Livro removido = fim.getInfo();
        fim = fim.getAnterior();

        if (fim == null) {
            inicio = null;
        } else {
            fim.setProximo(null);
        }

        quantidade--;
        return removido;
    }

    public Livro buscarPorIsbn(String isbn) {
        NoDuplo atual = inicio;

        while (atual != null) {
            if (atual.getInfo() != null && atual.getInfo().getIsbn().equals(isbn)) {
                return atual.getInfo();
            }
            atual = atual.getProximo();
        }

        return null;
    }

    public void listarDoInicio() {
        if (inicio == null) {
            System.out.println("Lista vazia.");
            return;
        }

        NoDuplo atual = inicio;
        while (atual != null) {
            System.out.println(atual.getInfo());
            atual = atual.getProximo();
        }
    }

    public void listarDoFim() {
        if (fim == null) {
            System.out.println("Lista vazia.");
            return;
        }

        NoDuplo atual = fim;
        while (atual != null) {
            System.out.println(atual.getInfo());
            atual = atual.getAnterior();
        }
    }

    public int tamanho() {
        return quantidade;
    }
    
}
