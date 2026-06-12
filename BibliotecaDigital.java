import java.util.Scanner;

public class BibliotecaDigital {
    private Catalogo catalogo;
    private ListaDupla acervo;
    private GestorEmprestimos gestor;

    public BibliotecaDigital() {
        this.catalogo = new Catalogo();
        this.acervo = new ListaDupla();
        this.gestor = new GestorEmprestimos(acervo);
    }

    public void cadastrarLivro(Livro livro) {
        if (catalogo.existe(livro.getIsbn())) {
            System.out.println("Ja existe um livro cadastrado com este ISBN.");
            return;
        }

        acervo.insereFim(livro);
        catalogo.cadastrar(livro);
        System.out.println("Livro cadastrado com sucesso.");
    }

    public void buscarLivro(String isbn) {
        Livro livro = catalogo.buscar(isbn);
        if (livro == null) {
            System.out.println("Livro nao encontrado.");
        } else {
            System.out.println(livro);
        }
    }

    public void listarAcervoInicio() {
        acervo.listarDoInicio();
    }

    public void listarAcervoFim() {
        acervo.listarDoFim();
    }

    public void solicitarEmprestimo(String isbn, Usuario usuario) {
        gestor.solicitarEmprestimo(isbn, usuario);
    }

    public void devolverLivro(String isbn) {
        gestor.devolverLivro(isbn);
    }

    public void listarFilaDeEspera(String isbn) {
        gestor.listarFilaDeEspera(isbn);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BibliotecaDigital sistema = new BibliotecaDigital();
        int opcao = -1;

        do {
            System.out.println();
            System.out.println("=== BIBLIOTECA DIGITAL ===");
            System.out.println("1 - Cadastrar livro");
            System.out.println("2 - Buscar livro por ISBN");
            System.out.println("3 - Listar acervo do inicio ao fim");
            System.out.println("4 - Listar acervo do fim ao inicio");
            System.out.println("5 - Solicitar emprestimo");
            System.out.println("6 - Devolver livro");
            System.out.println("7 - Ver fila de espera de um livro");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opcao: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                opcao = -1;
            }

            switch (opcao) {
                case 1:
                    System.out.print("ISBN: ");
                    String isbn = scanner.nextLine();
                    System.out.print("Titulo: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Autor: ");
                    String autor = scanner.nextLine();
                    System.out.print("Ano de publicacao: ");
                    int ano = Integer.parseInt(scanner.nextLine());

                    Livro livro = new Livro(isbn, titulo, autor, ano);
                    sistema.cadastrarLivro(livro);
                    break;

                case 2:
                    System.out.print("Digite o ISBN: ");
                    sistema.buscarLivro(scanner.nextLine());
                    break;

                case 3:
                    sistema.listarAcervoInicio();
                    break;

                case 4:
                    sistema.listarAcervoFim();
                    break;

                case 5:
                    System.out.print("ISBN do livro: ");
                    String isbnEmprestimo = scanner.nextLine();
                    System.out.print("Matricula: ");
                    int matricula = Integer.parseInt(scanner.nextLine());
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();

                    Usuario usuario = new Usuario(matricula, nome, email);
                    sistema.solicitarEmprestimo(isbnEmprestimo, usuario);
                    break;

                case 6:
                    System.out.print("ISBN do livro: ");
                    sistema.devolverLivro(scanner.nextLine());
                    break;

                case 7:
                    System.out.print("ISBN do livro: ");
                    sistema.listarFilaDeEspera(scanner.nextLine());
                    break;

                case 0:
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("Opcao invalida.");
                    break;
            }
        } while (opcao != 0);

        scanner.close();
    }
}
