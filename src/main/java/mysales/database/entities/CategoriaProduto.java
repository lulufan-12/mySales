package mysales.database.entities;

import javax.persistence.*;

@Entity
public class CategoriaProduto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int codigo;
    @Column(nullable = false, unique = true)
    String nome;

    public CategoriaProduto() {
    }

    public CategoriaProduto(String nome) {
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
