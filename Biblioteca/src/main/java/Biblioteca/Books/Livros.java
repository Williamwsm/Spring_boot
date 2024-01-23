package Biblioteca.Books;

import Biblioteca.Error.Exception;
import Biblioteca.User.Usuario;
import Biblioteca.Dao.LivroDAO;

public class Livros extends Livro {
    Exception erro = new Exception();
    LivroDAO livroDAO = new LivroDAO();


    public Livros(String titulo, String autor, String editora, int numeroCaps, int numeroPaginas) {
        this.setTitulo(titulo);
        this.setAutor(autor);
        this.setEditora(editora);
        this.setNumeroCaps(numeroCaps);
        this.setNumeroPaginas(numeroPaginas);
        this.setExemplares(5);

    }

    public Livros() {

    }


    public Livros contemLivro(String titulo) throws java.lang.Exception {

        if (encontrarLivro(titulo) == true) {

            for (Livros l : livroDAO.listarLivros()) {
                if (titulo.equalsIgnoreCase(l.getTitulo())) {
                    return l;
                }
            }
        } else {
            erro.livroNaoEncontrado();
        }
        return null;
    }

    private boolean encontrarLivro(String titulo) {
        for (Livros l : livroDAO.listarLivros()) {
            if (titulo.equalsIgnoreCase(l.getTitulo())) {
                return true;
            }
        }
        return false;
    }

    public void addLivro(Usuario usuario, Livros livro) throws java.lang.Exception {
        if (usuario.encontrarUsuario(usuario.getNome()) == usuario) {

        }
        if (livro.getExemplares() == 0) {
            erro.livroIndisponivel();

        } else {

            if (usuario.getNumeroDeLivros() < usuario.getLimiteLivros()) {
                usuario.livrosEmprestados.add(livro);
                usuario.setNumeroDeLivros(usuario.getNumeroDeLivros() + 1);
                livro.setExemplares(livro.getExemplares() - 1);
            } else {
                erro.listaCheia();
            }
        }

    }

    private boolean usuarioContemLivro(Usuario usuario, Livros livros) throws java.lang.Exception {
        for (Livros l : usuario.livrosEmprestados) {
            if (l.equals(livros)) {
                return true;

            }

        }
        erro.devolucaoInvalida();
        return false;
    }

    public void removerLivro(Usuario usuario, Livros livro) throws java.lang.Exception {
        if (usuario.encontrarUsuario(usuario.getNome()) != usuario) {
        }

        if (usuario.getNumeroDeLivros() > 0) {
            if (usuarioContemLivro(usuario,livro) == true) {
                usuario.livrosEmprestados.remove(livro);
                usuario.setNumeroDeLivros(usuario.getNumeroDeLivros() - 1);
                livro.setExemplares(livro.getExemplares() + 1);
            }
        } else {
            erro.listaVazia();
        }

    }


}
