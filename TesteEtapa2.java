public class TesteEtapa2 {
    public static void main(String[] args) {
        Livro livro1 = new Livro("978-85-430-0067-8", "Estruturas de Dados", "Goodrich", 2013);
        Livro livro2 = new Livro("978-85-7522-238-5", "Algoritmos em Java", "Sedgewick", 2011);

        ListaDupla acervo = new ListaDupla();
        acervo.insereFim(livro1);
        acervo.insereFim(livro2);

        Usuario usuario1 = new Usuario(1001, "Ana Silva", "ana@email.com");
        Usuario usuario2 = new Usuario(1002, "Bruno Souza", "bruno@email.com");

        GestorEmprestimos gestor = new GestorEmprestimos(acervo);

        System.out.println("=== Situacao inicial do livro ===");
        System.out.println(acervo.buscarPorIsbn("978-85-430-0067-8"));
        System.out.println();

        System.out.println("=== 1) Emprestimo de um livro disponivel ===");
        gestor.solicitarEmprestimo("978-85-430-0067-8", usuario1);
        System.out.println(acervo.buscarPorIsbn("978-85-430-0067-8"));
        System.out.println();

        System.out.println("=== 2) Tentativa de emprestar o mesmo livro (vai para fila) ===");
        gestor.solicitarEmprestimo("978-85-430-0067-8", usuario2);
        gestor.listarFilaDeEspera("978-85-430-0067-8");
        System.out.println();

        System.out.println("=== 3) Devolucao com atendimento automatico ===");
        gestor.devolverLivro("978-85-430-0067-8");
        System.out.println(acervo.buscarPorIsbn("978-85-430-0067-8"));
        gestor.listarFilaDeEspera("978-85-430-0067-8");
        System.out.println();

        System.out.println("=== 4) Segunda devolucao com fila vazia ===");
        gestor.devolverLivro("978-85-430-0067-8");
        System.out.println(acervo.buscarPorIsbn("978-85-430-0067-8"));
    }
}
