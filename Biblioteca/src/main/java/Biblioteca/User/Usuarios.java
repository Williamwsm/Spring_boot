package Biblioteca.User;

public abstract class Usuarios {

   private String nome;
   private String email;
   private String  telefone;
   private String dataNascimento;

   private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return "Usuarios{" +
                "nome=" + nome + '\n' +
                ", email=" + email + '\n' +
                ", telefone=" + telefone + '\n' +
                ", dataNascimento=" + dataNascimento + '\n' +
                '}'+'\n';
    }
}
