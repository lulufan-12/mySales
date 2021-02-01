package mysales.database.entities;

import javax.persistence.*;

@Entity
public class CategoriaPagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int codigo;
    @Column(nullable = false)
    String nome;

    public CategoriaPagamento() {

    }

    public CategoriaPagamento(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
