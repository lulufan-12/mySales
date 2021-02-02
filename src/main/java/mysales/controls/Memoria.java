package mysales.controls;

import mysales.database.entities.*;

public class Memoria {
    private static Produto produto;
    private static CategoriaProduto categoria;
    private static Funcao funcao;
    private static Usuario usuario;
    private static Fornecedores fornecedor;

    public static void setProduto(Produto produto){
        Memoria.produto = produto;
    }
    public static Produto getProduto(){
        return Memoria.produto;
    }
    public static CategoriaProduto getCategoria() { return categoria; }

    public static void setCategoria(CategoriaProduto categoria) {
        Memoria.categoria = categoria;
    }

    public static Funcao getFuncao() {
        return funcao;
    }

    public static void setFuncao(Funcao funcao) {
        Memoria.funcao = funcao;
    }

    public static Usuario getUsuario() {
        return usuario;
    }

    public static void setUsuario(Usuario usuario) {
        Memoria.usuario = usuario;
    }

    public static Fornecedores getFornecedor() {
        return fornecedor;
    }

    public static void setFornecedor(Fornecedores fornecedor) {
        Memoria.fornecedor = fornecedor;
    }
}
