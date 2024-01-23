package Biblioteca.User;

import Biblioteca.Books.Livros;
import Biblioteca.Error.Exception;
import Biblioteca.Dao.UsuarioDAO;


import java.util.ArrayList;

public class Usuario extends Usuarios {

    private final int limiteLivros;

    public int getLimiteLivros() {
        return limiteLivros;
    }

    public int getNumeroDeLivros() {
        return numeroDeLivros;
    }

    public void setNumeroDeLivros(int numeroDeLivros) {
        this.numeroDeLivros = numeroDeLivros;
    }

    private int numeroDeLivros;
    public ArrayList<Livros> livrosEmprestados = new ArrayList<Livros>();
    Exception erro = new Exception();
    UsuarioDAO usuarioDAO = new UsuarioDAO();

    public Usuario() {
        this.limiteLivros = 5;
    }

    public Usuario(String nome, String dataNascimento, String email, String telefone) {
        this.setNome(nome);
        this.setDataNascimento(dataNascimento);
        this.setEmail(email);
        this.setTelefone(telefone);
        this.limiteLivros = 5;
        this.numeroDeLivros = 0;

    }


    public Usuario encontrarUsuario(String nome) throws java.lang.Exception {
        if (contemUsuario(nome) == true) {

            for (Usuario u : usuarioDAO.listarUsuarios()) {
                if (u.getNome().equalsIgnoreCase(nome)) {

                    return u;
                }
            }
        }else {
            erro.usuarioNaoEncontrado();
        }
        return null;
    }

    private boolean contemUsuario(String nome) {
        for (Usuario u : usuarioDAO.listarUsuarios()) {
            if (u.getNome().equalsIgnoreCase(nome)) {
                return true;
            }
        }
        return false;
    }


}
