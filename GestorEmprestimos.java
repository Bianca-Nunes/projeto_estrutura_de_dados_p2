public class GestorEmprestimos {

    private ListaDupla acervo;
    private Fila<Usuario> filaEspera;

    public GestorEmprestimos(ListaDupla acervo) {
        this.acervo = acervo;
        this.filaEspera = new Fila<>();
    }

    public void solicitarEmprestimo(String isbn, Usuario u) {

        Livro livro = acervo.buscarPorIsbn(isbn);

        if (livro == null) {
            System.out.println("Livro não encontrado.");
            return;
        }

        if (livro.isDisponivel()) {
            livro.setDisponivel(false);
            System.out.println(u.getNome() +
                    " realizou empréstimo do livro: "
                    + livro.getTitulo());
        }
        else {
            filaEspera.enfileira(u);

            System.out.println(
                    "Livro indisponível. Usuário adicionado à fila."
            );
        }
    }

    public void devolverLivro(String isbn) {

        Livro livro = acervo.buscarPorIsbn(isbn);

        if (livro == null) {
            System.out.println("Livro não encontrado.");
            return;
        }

        livro.setDisponivel(true);

        System.out.println(
                "Livro devolvido: " + livro.getTitulo()
        );

        if (!filaEspera.filaVazia()) {

            try {

                Usuario proximo =
                        filaEspera.desenfileira();

                livro.setDisponivel(false);

                System.out.println(
                        "Novo empréstimo para: "
                                + proximo.getNome()
                );

            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void listarFilaDeEspera(String isbn) {

        Livro livro = acervo.buscarPorIsbn(isbn);

        if (livro == null) {
            System.out.println("Livro não encontrado.");
            return;
        }

        System.out.println(filaEspera);
    }
}