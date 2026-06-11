public class TesteEtapa1 {
    public static void main(String[] args) {
        System.out.println("=== TESTE DA CLASSE LIVRO ===");
        Livro livro1 = new Livro("978-85-430-0067-8", "Estruturas de Dados", "Goodrich", 2013);
        Livro livro2 = new Livro("978-85-7522-702-0", "Algoritmos", "Cormen", 2012);
        Livro livro3 = new Livro("978-85-362-4917-6", "Programacao Orientada a Objetos", "Deitel", 2017);
        Livro livro4 = new Livro("978-85-7522-541-5", "Java Como Programar", "Deitel", 2016);

        System.out.println(livro1);
        System.out.println(livro2);
        System.out.println(livro3);
        System.out.println(livro4);

        System.out.println("\n=== TESTE DA CLASSE USUARIO ===");
        Usuario usuario1 = new Usuario(1001, "Ana Souza", "ana@email.com");
        Usuario usuario2 = new Usuario(1002, "Bruno Lima", "bruno@email.com");

        System.out.println(usuario1);
        System.out.println(usuario2);

        System.out.println("\n=== TESTE DA LISTA DUPLA ===");
        ListaDupla lista = new ListaDupla();

        lista.insereInicio(livro1);
        lista.insereFim(livro2);
        lista.insereInicio(livro3);
        lista.insereFim(livro4);

        System.out.println("Tamanho da lista: " + lista.tamanho());

        System.out.println("\nListando do inicio para o fim:");
        lista.listarDoInicio();

        System.out.println("\nListando do fim para o inicio:");
        lista.listarDoFim();

        System.out.println("\nBuscando ISBN 978-85-7522-702-0:");
        Livro encontrado = lista.buscarPorIsbn("978-85-7522-702-0");
        if (encontrado != null) {
            System.out.println("Livro encontrado: " + encontrado);
        } else {
            System.out.println("Livro nao encontrado.");
        }

        System.out.println("\nRemovendo primeiro livro:");
        Livro removidoPrimeiro = lista.removePrimeiro();
        System.out.println(removidoPrimeiro);

        System.out.println("Removendo ultimo livro:");
        Livro removidoUltimo = lista.removeUltimo();
        System.out.println(removidoUltimo);

        System.out.println("\nLista apos as remocoes:");
        lista.listarDoInicio();

        System.out.println("\nTamanho final da lista: " + lista.tamanho());
    }
}
