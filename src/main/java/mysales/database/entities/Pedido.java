package mysales.database.entities;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int codigo;
    @ManyToOne
    Usuario vendedor;
    @Column(nullable = false)
    Date data_pedido;
    @Column(nullable = false)
    Time horario_pedido;
    @OneToMany
    List<ItemPedido> itens;

    public Pedido() {
    }

    public Pedido(Usuario vendedor, Date data_pedido, Time horario_pedido, List<ItemPedido> itens) {
        this.vendedor = vendedor;
        this.data_pedido = data_pedido;
        this.horario_pedido = horario_pedido;
        this.itens = itens;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Usuario getVendedor() {
        return vendedor;
    }

    public void setVendedor(Usuario vendedor) {
        this.vendedor = vendedor;
    }

    public Date getData_pedido() {
        return data_pedido;
    }

    public void setData_pedido(Date data_pedido) {
        this.data_pedido = data_pedido;
    }

    public Time getHorario_pedido() {
        return horario_pedido;
    }

    public void setHorario_pedido(Time horario_pedido) {
        this.horario_pedido = horario_pedido;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }
}
