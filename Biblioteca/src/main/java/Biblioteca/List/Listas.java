package Biblioteca.List;

import Biblioteca.Books.Livros;
import Biblioteca.User.Usuario;

import java.util.ArrayList;

public class Listas {// armazenamento de usuarios e libros
    private ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    private ArrayList<Livros> listaLivros = new ArrayList<>();

    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public ArrayList<Livros> getListaLivros() {
        return listaLivros;
    }

    public void setListaLivros(ArrayList<Livros> listaLivros) {
        this.listaLivros = listaLivros;
    }
}
