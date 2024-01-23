package Biblioteca.Books;

public abstract class Livro {
    private String titulo;
    private String autor;
    private String editora ;
    private  int id;
    private int numeroCaps;
    private int numeroPaginas;
    private int exemplares;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getExemplares() {
        return exemplares;
    }

    public void setExemplares(int exemplares) {
        this.exemplares = exemplares;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public int getNumeroCaps() {
        return numeroCaps;
    }

    public void setNumeroCaps(int numeroCaps) {
        this.numeroCaps = numeroCaps;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "titulo=" + titulo + '\n' +
                ", autor=" + autor + '\n' +
                ", editora=" + editora + '\n' +
                ", numeroCaps=" + numeroCaps +"\n"+
                ", numeroPaginas=" + numeroPaginas +"\n"+
                '}'+"\n\n";
    }
}
