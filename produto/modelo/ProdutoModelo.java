package produto.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "produtos")

public class ProdutoModelo {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)// autoincremeta
    private Long cod;
    private  String marca;
    private String nome;

    public Long getCod() {
        return cod;
    }

    public void setCod(Long cod) {
        this.cod = cod;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
