package mysales.database.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Funcao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int codigo;
    @Column(nullable = false)
    String nome;
    @Column(nullable = false)
    String descricao;
    @Column(nullable = false)
    BigDecimal salario;
    @Column(nullable = false)
    int carga_horaria;

    public Funcao() {
    }

    public Funcao(String nome, String descricao, BigDecimal salario, int carga_horaria) {
        this.nome = nome;
        this.descricao = descricao;
        this.salario = salario;
        this.carga_horaria = carga_horaria;
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

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public int getCarga_horaria() {
        return carga_horaria;
    }

    public void setCarga_horaria(int carga_horaria) {
        this.carga_horaria = carga_horaria;
    }
}
