package mysales.database.entities;

import javax.persistence.*;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int codigo;
    @Column(nullable = false)
    String nome;
    @Column(nullable = false, unique = true)
    String login;
    @Column(nullable = false)
    String senha;
    @Column(nullable = false, unique = true)
    String email;
    @Column(nullable = false)
    String endereco;
    @Column(nullable = false)
    int numero;
    String complemento;
    @Column(nullable = false)
    String CEP;
    @Column(nullable = false)
    String bairro;
    @Column(nullable = false)
    boolean super_usuario;
    @Column(nullable = false)
    String CPF;
    @Column(nullable = false)
    String RG;
    @ManyToOne
    Funcao funcao;

    public Usuario() {
    }

    public Usuario(String nome, String login, String senha, String email, String endereco,
                   int numero, String complemento, String CEP, String bairro, boolean super_usuario,
                   String CPF, String RG, Funcao funcao) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.email = email;
        this.endereco = endereco;
        this.numero = numero;
        this.complemento = complemento;
        this.CEP = CEP;
        this.bairro = bairro;
        this.super_usuario = super_usuario;
        this.CPF = CPF;
        this.RG = RG;
        this.funcao = funcao;
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public boolean isSuper_usuario() {
        return super_usuario;
    }

    public void setSuper_usuario(boolean super_usuario) {
        this.super_usuario = super_usuario;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public Funcao getFuncao() {
        return funcao;
    }

    public void setFuncao(Funcao funcao) {
        this.funcao = funcao;
    }
}
