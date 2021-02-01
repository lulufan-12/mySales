package mysales.database.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class ItemPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int codigo;
    @Column(nullable = false)
    int quantidade;
    @ManyToOne
    Produto produto;
    @Column(nullable = false)
    BigDecimal preco;

    public ItemPedido() {
    }

    public ItemPedido(int quantidade, Produto produto, BigDecimal preco) {
        this.quantidade = quantidade;
        this.produto = produto;
        this.preco = preco;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
}
