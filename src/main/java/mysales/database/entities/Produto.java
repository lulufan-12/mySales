package mysales.database.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int codigo;
    @Column(unique = true, nullable = false)
    String nome;
    @Column(nullable = false)
    String descricao;
    @Column(nullable = false)
    BigDecimal preco;
    @ManyToOne
    CategoriaProduto categoria;
    @Column(unique = true, nullable = false)
    String codigo_barras;

    public Produto(String nome, String descricao, BigDecimal preco, CategoriaProduto categoria, String codigo_barras) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.categoria = categoria;
        this.codigo_barras = codigo_barras;
    }

    public Produto() {
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public CategoriaProduto getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaProduto categoria) {
        this.categoria = categoria;
    }

    public String getCodigo_barras() {
        return codigo_barras;
    }

    public void setCodigo_barras(String codigo_barras) {
        this.codigo_barras = codigo_barras;
    }
}
