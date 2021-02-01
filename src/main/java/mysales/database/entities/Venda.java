package mysales.database.entities;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int codigo;
    @OneToOne
    Pedido pedido;
    @ManyToOne
    Usuario vendedor;
    @Column(nullable = false)
    Date  data_venda;
    @Column(nullable = false)
    Time horario_venda;
    @ManyToOne
    CategoriaPagamento pagamento;

    public Venda() {

    }

    public Venda(Pedido pedido, Usuario vendedor, Date data_venda, Time horario_venda, CategoriaPagamento pagamento) {
        this.pedido = pedido;
        this.vendedor = vendedor;
        this.data_venda = data_venda;
        this.horario_venda = horario_venda;
        this.pagamento = pagamento;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Usuario getVendedor() {
        return vendedor;
    }

    public void setVendedor(Usuario vendedor) {
        this.vendedor = vendedor;
    }

    public Date getData_venda() {
        return data_venda;
    }

    public void setData_venda(Date data_venda) {
        this.data_venda = data_venda;
    }

    public Time getHorario_venda() {
        return horario_venda;
    }

    public void setHorario_venda(Time horario_venda) {
        this.horario_venda = horario_venda;
    }

    public CategoriaPagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(CategoriaPagamento pagamento) {
        this.pagamento = pagamento;
    }
}
