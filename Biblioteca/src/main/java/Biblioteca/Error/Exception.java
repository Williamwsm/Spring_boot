package Biblioteca.Error;

public class Exception {
    public java.lang.Exception listaVazia() throws java.lang.Exception {
        throw new java.lang.Exception("Sua lista estar vazia");
    }
    public java.lang.Exception listaCheia() throws java.lang.Exception {
        throw new java.lang.Exception("Sua lista estar Cheia");
    }
    public java.lang.Exception livroIndisponivel() throws java.lang.Exception {
        throw new java.lang.Exception("Livro nao disponivel no momento");
    }
public java.lang.Exception livroNaoEncontrado() throws java.lang.Exception {
        throw new java.lang.Exception("Livro nao encontrado no sistema");
    }
    public java.lang.Exception devolucaoInvalida() throws java.lang.Exception {
        throw new java.lang.Exception("Livro nao encontrado na sua lista");
    }
    public java.lang.Exception senhaInvalida() throws java.lang.Exception {
        throw new java.lang.Exception("Sua senha estar incorreta");
    }
    public java.lang.Exception usuarioNaoEncontrado() throws java.lang.Exception {
        throw new java.lang.Exception("Usuario nao encontrado no sistema");
    }


}
