public class GestorEmprestimos {
    private NossoHash<String, Fila<Usuario>> filasDeEspera;
    private ListaDupla acervo;

    public GestorEmprestimos(ListaDupla acervo) {
        this.filasDeEspera = new NossoHash<>();
        this.acervo = acervo;
    }

    public void solicitarEmprestimo(String isbn, Usuario u) {
        Livro livro = acervo.buscarPorIsbn(isbn);

        if (livro == null) {
            System.out.println("Livro nao encontrado: " + isbn);
            return;
        }

        if (livro.isDisponivel()) {
            livro.setDisponivel(false);
            System.out.println("Emprestimo realizado para " + u.getNome() + ": " + livro);
            return;
        }

        Fila<Usuario> fila = filasDeEspera.get(isbn);
        if (fila == null) {
            fila = new Fila<>();
            filasDeEspera.put(isbn, fila);
        }

        fila.enfileira(u);
        System.out.println("Livro indisponivel. Usuario adicionado na fila: " + u);
    }

    public void devolverLivro(String isbn) {
        Livro livro = acervo.buscarPorIsbn(isbn);

        if (livro == null) {
            System.out.println("Livro nao encontrado: " + isbn);
            return;
        }

        Fila<Usuario> fila = filasDeEspera.get(isbn);

        if (fila != null && !fila.filaVazia()) {
            try {
                Usuario proximo = fila.desenfileira();
                System.out.println("Livro devolvido: " + livro.getTitulo());
                System.out.println("Emprestimo transferido automaticamente para: " + proximo);
                livro.setDisponivel(false);
            } catch (FilaVaziaException e) {
                livro.setDisponivel(true);
            }
        } else {
            livro.setDisponivel(true);
            System.out.println("Livro devolvido e agora esta disponivel: " + livro);
        }
    }

    public void listarFilaDeEspera(String isbn) {
        Fila<Usuario> fila = filasDeEspera.get(isbn);

        if (fila == null || fila.filaVazia()) {
            System.out.println("Nao ha fila de espera para o ISBN " + isbn);
            return;
        }

        System.out.println("Fila de espera do ISBN " + isbn + ": " + fila);
    }
}
