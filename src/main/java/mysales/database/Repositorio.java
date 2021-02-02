package mysales.database;

import mysales.database.dao.DAO;
import mysales.database.dao.UsuarioDAO;
import mysales.database.entities.*;
import javax.persistence.NoResultException;
import java.util.List;

public class Repositorio {

    public static Usuario logar(String login, String senha) throws NoResultException {
        UsuarioDAO dao = new UsuarioDAO();
        Usuario usuario = dao.obterPorUsuarioSenha(login, senha);
        return usuario;
    }

    public static void cadastrar(Fornecedores novo){
        DAO<Fornecedores> dao = new DAO<>(Fornecedores.class);
        dao.inserir(novo);
    }
    public static void cadastrar(Usuario novo){
        DAO<Usuario> dao = new DAO<>(Usuario.class);
        dao.inserir(novo);
    }
    public static void cadastrar(Produto novo){
        DAO<Produto> dao = new DAO<>(Produto.class);
        dao.inserir(novo);
    }
    public static void cadastrar(Funcao novo){
        DAO<Funcao> dao = new DAO<>(Funcao.class);
        dao.inserir(novo);
    }
    public static void cadastrar(CategoriaProduto novo){
        DAO<CategoriaProduto> dao = new DAO<>(CategoriaProduto.class);
        dao.inserir(novo);
    }
    public static void atualizar(Fornecedores novo){
        DAO<Fornecedores> dao = new DAO<>(Fornecedores.class);
        dao.atualizar(novo);
    }
    public static void atualizar(Usuario novo){
        DAO<Usuario> dao = new DAO<>(Usuario.class);
        dao.atualizar(novo);
    }
    public static void atualizar(Produto novo){
        DAO<Produto> dao = new DAO<>(Produto.class);
        dao.atualizar(novo);
    }
    public static void atualizar(Funcao novo){
        DAO<Funcao> dao = new DAO<>(Funcao.class);
        dao.atualizar(novo);
    }
    public static void atualizar(CategoriaProduto novo){
        DAO<CategoriaProduto> dao = new DAO<>(CategoriaProduto.class);
        dao.atualizar(novo);
    }
    public static void deletar(CategoriaProduto deletado){
        DAO<CategoriaProduto> dao = new DAO<>(CategoriaProduto.class);
        dao.remover(deletado);
    }
    public static void deletar(Usuario deletado){
        DAO<Usuario> dao = new DAO<>(Usuario.class);
        dao.remover(deletado);
    }
    public static void deletar(Produto deletado){
        DAO<Produto> dao = new DAO<>(Produto.class);
        dao.remover(deletado);
    }
    public static void deletar(Fornecedores deletado){
        DAO<Fornecedores> dao = new DAO<>(Fornecedores.class);
        dao.remover(deletado);
    }
    public static void deletar(Funcao deletado){
        DAO<Funcao> dao = new DAO<>(Funcao.class);
        dao.remover(deletado);
    }
    public static List<Funcao> obterTodasFuncaos(){
        DAO<Funcao> dao = new DAO<>(Funcao.class);
        List<Funcao> lista = dao.obterTodos();
        return lista;
    }
    public static List<CategoriaProduto> obterTodasCategorias(){
        DAO<CategoriaProduto> dao = new DAO<>(CategoriaProduto.class);
        List<CategoriaProduto> lista = dao.obterTodos();
        return lista;
    }
    public static List<Produto> obterTodosProdutos(){
        DAO<Produto> dao = new DAO<>(Produto.class);
        List<Produto> lista = dao.obterTodos();
        return lista;
    }
    public static List<Usuario> obterTodosUsuarios(){
        DAO<Usuario> dao = new DAO<>(Usuario.class);
        List<Usuario> lista = dao.obterTodos();
        return lista;
    }
    public static List<Fornecedores> obterTodosFornecedores(){
        DAO<Fornecedores> dao = new DAO<>(Fornecedores.class);
        List<Fornecedores> lista = dao.obterTodos();
        return lista;
    }
}
