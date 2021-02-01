package mysales.database.entities;

import javax.persistence.*;

@Entity
public class Fornecedores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int codigo;
    @Column(nullable = false, unique = true)
    String nome_empresa;
    @Column(nullable = false, unique = true)
    String CNPJ;
    @Column(nullable = false)
    String contato_local;
    @Column(nullable = false)
    String telefone;
    String celular;
    @Column(nullable = false, unique = true)
    String email;
    @Column(nullable = false)
    String endereco;
    String complemento;
    int numero;
    @Column(nullable = false)
    String CEP;
    @Column(nullable = false)
    String bairro;

    public Fornecedores() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome_empresa() {
        return nome_empresa;
    }

    public void setNome_empresa(String nome_empresa) {
        this.nome_empresa = nome_empresa;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getContato_local() {
        return contato_local;
    }

    public void setContato_local(String contato_local) {
        this.contato_local = contato_local;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
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

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
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

    public Fornecedores(String nome_empresa, String CNPJ, String contato_local, String telefone,
                        String celular, String email, String endereco, String complemento, int numero,
                        String CEP, String bairro) {
        this.nome_empresa = nome_empresa;
        this.CNPJ = CNPJ;
        this.contato_local = contato_local;
        this.telefone = telefone;
        this.celular = celular;
        this.email = email;
        this.endereco = endereco;
        this.complemento = complemento;
        this.numero = numero;
        this.CEP = CEP;
        this.bairro = bairro;
    }
}
