public class Catalogo {
    private NossoHash<String, Livro> catalogo;

    public Catalogo() {
        this.catalogo = new NossoHash<>();
    }
    public void cadastrar(Livro livro) {
        catalogo.put(livro.getIsbn(), livro);
    }
    public Livro buscar(String isbn) {
        return catalogo.get(isbn);
    }
    public boolean existe(String isbn) {
        return catalogo.containsKey(isbn);
    }
    public void exibirCatalogo() {
        catalogo.exibeMap();
    }
}
