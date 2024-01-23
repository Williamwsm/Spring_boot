package Biblioteca.main;

import Biblioteca.Books.Livros;
import Biblioteca.User.Usuario;
import Biblioteca.Dao.LivroDAO;

public class main {
    public static void main(String[] args) {
        Usuario usuario = new Usuario("joao", "15/06/2000", "joaozinhogameplay@gmail.com", "(31)99927-3164");
        Usuario usuario1 = new Usuario("camile", "15/04/2003", "camilinha@gmail.com", "(79)99955-3412");
        Usuario usuario2 = new Usuario("julia", "05/06/2001", "julialimay@gmail.com", "(25)99827-3374");
        Usuario usuario3 = new Usuario("victor", "27/05/1999", "victorfernandes@gmail.com", "(31)99912-9164");
        Usuario usuario4 = new Usuario("vitoria", "22/06/2000", "vitoriaregia@gmail.com", "(11)99968-1419");
        Usuario usuario5 = new Usuario("fernanda", "18/11/2000", "fernandaLuisa@gmail.com", "(33)99906-3124");
        Usuario usuario6 = new Usuario("jorge", "03/04/2000", "jorgeRafael@gmail.com", "(35)99927-0753");
        Usuario usuario7 = new Usuario("maria", "19/09/2000", "mariasouza@gmail.com", "(75)99927-1121");
        Usuario usuario8 = new Usuario("lucas", "25/01/2000", "lucas12@gmail.com", "(66)99974-3188");

        Livros livros = new Livros("my heart racing", "", "panini", 21, 600);
        Livros livros1 = new Livros("lugar nenhum", "jorge cruz", "valin", 25, 1000);
        Livros livros2 = new Livros("Raduative", "janny raissa", "wordplay", 19, 520);
        Livros livros3 = new Livros("mente  a espreita", "luisa  fernandes", "mimi", 22, 498);
        Livros livros4 = new Livros("ordinary life", "ana calorina", "panini", 9, 290);
        Livros livros5 = new Livros("super summer", "rafa mattos", "wordplay", 32, 773);
        Livros livros6 = new Livros("luta diaria", "lucas santos", "mimi", 6, 271);
        Livros livros7 = new Livros("Spring", "junior pereira", "panda", 11, 414);
        Livros livros8 = new Livros("Orientacao a objetos", "emerson luis", "polis", 38, 296);

        LivroDAO livroDAO = new LivroDAO();
        livros1.setId(9);

      // livroDAO.atualizarLivro(livros1);

        for (Livros l: livroDAO.listarLivros()) {
            System.out.println(l.getTitulo());
        }

    }
}
