package mysales.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import mysales.database.Repositorio;
import mysales.database.entities.*;
import java.math.BigDecimal;
import java.util.List;

public class AlterarDadosController {
    @FXML
    private ComboBox<String> cbx_tipo;
    @FXML
    private Button btn_pesquisar;
    @FXML
    private Button btn_alterar;
    @FXML
    private Button btn_excluir;
    @FXML
    private TextField txf_nome;
    @FXML
    private TableView tbl_conteudo;
    private List<Produto> lista_produtos;
    private ObservableList<Produto> lista_produtos_obs;
    private List<Usuario> lista_usuarios;
    private ObservableList<Usuario> lista_usuarios_obs;
    private List<CategoriaProduto> lista_categorias;
    private ObservableList<CategoriaProduto> lista_categorias_obs;
    private List<Fornecedores> lista_fornecedores;
    private ObservableList<Fornecedores> lista_fornecedores_obs;
    private List<Funcao> lista_funcoes;
    private ObservableList<Funcao> lista_funcoes_obs;

    @FXML
    private void initialize(){
        btn_pesquisar.setOnAction(e -> {
            if(cbx_tipo.getSelectionModel().isEmpty()){
                System.out.println("Não há nenhum item selecionado.");
                return;
            }
            switch (cbx_tipo.getSelectionModel().getSelectedItem()){
                case "Produto":
                    criarTabelaProduto(tbl_conteudo);
                    break;
                case "Usuário":
                    criarTabelaUsuario(tbl_conteudo);
                    break;
                case "Fornecedor":
                    criarTabelaFornecedor(tbl_conteudo);
                    break;
                case "Função":
                    criarTabelaFuncao(tbl_conteudo);
                    break;
                case "Categorias de Produtos":
                    criarTabelaCategoria(tbl_conteudo);
                    break;
            }
        });
        btn_alterar.setOnAction(e -> {
            Object celula = tbl_conteudo.getSelectionModel().getSelectedItem();
            if(celula == null){
                System.out.println("Não há célula selecionada.");
                return;
            }
        });
        btn_excluir.setOnAction(e -> {
            Object linha = tbl_conteudo.getSelectionModel().getSelectedItem();
            if(linha == null){
                System.out.println("Não há célula selecionada.");
                return;
            }
            excluirLinha(linha);
        });
    }
    private void excluirLinha(Object linha){
        if(linha instanceof Usuario)
            excluirUsuario(linha);
        else if(linha instanceof Produto)
            excluirProduto(linha);
        else if(linha instanceof Fornecedores)
            excluirFornecedor(linha);
        else if(linha instanceof CategoriaProduto)
            excluirCategoria(linha);
        else if(linha instanceof Funcao)
            excluirFuncao(linha);
    }
    private void excluirUsuario(Object linha){
        Usuario usuario = (Usuario) linha;
        for(Usuario u : lista_usuarios)
            if(u.getCodigo() == usuario.getCodigo()){
                Repositorio.deletar(usuario);
                atualizarListaUsuarios(tbl_conteudo);
            }
    }
    private void excluirFuncao(Object linha){
        Funcao funcao = (Funcao) linha;
        for(Funcao u : lista_funcoes)
            if(u.getCodigo() == funcao.getCodigo()){
                Repositorio.deletar(funcao);
                atualizarListaFuncoes(tbl_conteudo);
            }
    }
    private void excluirCategoria(Object linha){
        CategoriaProduto categoriaProduto = (CategoriaProduto) linha;
        for(CategoriaProduto u : lista_categorias)
            if(u.getCodigo() == categoriaProduto.getCodigo()){
                Repositorio.deletar(categoriaProduto);
                atualizarListaCategorias(tbl_conteudo);
            }
    }
    private void excluirFornecedor(Object linha){
        Fornecedores fornecedores = (Fornecedores) linha;
        for(Fornecedores u : lista_fornecedores)
            if(u.getCodigo() == fornecedores.getCodigo()){
                Repositorio.deletar(fornecedores);
                atualizarListaFornecedores(tbl_conteudo);
            }
    }
    private void excluirProduto(Object linha){
        Produto produto = (Produto) linha;
        for(Produto u : lista_produtos)
            if(u.getCodigo() == produto.getCodigo()){
                Repositorio.deletar(produto);
                atualizarListaProdutos(tbl_conteudo);
            }
    }
    private void atualizarListaUsuarios(TableView table){
        lista_usuarios = Repositorio.obterTodosUsuarios();
        lista_usuarios_obs = FXCollections.observableList(lista_usuarios);
        table.setItems(lista_usuarios_obs);
    }
    private void atualizarListaProdutos(TableView table){
        lista_produtos = Repositorio.obterTodosProdutos();
        lista_produtos_obs = FXCollections.observableList(lista_produtos);
        table.setItems(lista_produtos_obs);
    }
    private void atualizarListaFornecedores(TableView table){
        lista_fornecedores = Repositorio.obterTodosFornecedores();
        lista_fornecedores_obs = FXCollections.observableList(lista_fornecedores);
        table.setItems(lista_fornecedores_obs);
    }
    private void atualizarListaCategorias(TableView table){
        lista_categorias = Repositorio.obterTodasCategorias();
        lista_categorias_obs = FXCollections.observableList(lista_categorias);
        table.setItems(lista_categorias_obs);
    }
    private void atualizarListaFuncoes(TableView table){
        lista_funcoes = Repositorio.obterTodasFuncaos();
        lista_funcoes_obs = FXCollections.observableList(lista_funcoes);
        table.setItems(lista_funcoes_obs);
    }
    private void criarTabelaProduto(TableView table){
        atualizarListaProdutos(table);
        table.getColumns().remove(0, table.getColumns().size());
        TableColumn<Produto, String> col_nome = new TableColumn<>();
        col_nome.setText("Nome");
        col_nome.setCellValueFactory(new PropertyValueFactory<Produto, String>("Nome"));
        TableColumn<Produto, String> col_descricao = new TableColumn<>();
        col_descricao.setText("Descrição");
        col_descricao.setCellValueFactory(new PropertyValueFactory<Produto, String>("Descricao"));
        TableColumn<Produto, BigDecimal> col_preco = new TableColumn<>();
        col_preco.setText("Preço");
        col_preco.setCellValueFactory(new PropertyValueFactory<Produto, BigDecimal>("Preco"));
        TableColumn<Produto, String> col_codigo = new TableColumn<>();
        col_codigo.setText("Código de Barras");
        col_codigo.setCellValueFactory(new PropertyValueFactory<Produto, String>("codigo_barras"));
        table.getColumns().addAll(col_nome, col_preco, col_descricao, col_codigo);
    }
    private void criarTabelaUsuario(TableView table){
        atualizarListaUsuarios(tbl_conteudo);
        table.getColumns().remove(0, table.getColumns().size());
        TableColumn<Usuario, String> col_nome = new TableColumn<>();
        col_nome.setText("Nome");
        col_nome.setCellValueFactory(new PropertyValueFactory<Usuario, String>("Nome"));
        TableColumn<Usuario, String> col_login = new TableColumn<>();
        col_login.setText("Login");
        col_login.setCellValueFactory(new PropertyValueFactory<Usuario, String>("Login"));
        TableColumn<Usuario, String> col_email = new TableColumn<>();
        col_email.setText("Email");
        col_email.setCellValueFactory(new PropertyValueFactory<Usuario, String>("Email"));
        TableColumn<Usuario, String> col_cpf = new TableColumn<>();
        col_cpf.setText("CPF");
        col_cpf.setCellValueFactory(new PropertyValueFactory<Usuario, String>("CPF"));
        TableColumn<Usuario, String> col_rg = new TableColumn<>();
        col_rg.setText("RG");
        col_rg.setCellValueFactory(new PropertyValueFactory<Usuario, String>("RG"));
        TableColumn<Usuario, String> col_endereco = new TableColumn<>();
        col_endereco.setText("Endereço");
        col_endereco.setCellValueFactory(new PropertyValueFactory<Usuario, String>("endereco"));
        TableColumn<Usuario, Integer> col_numero = new TableColumn<>();
        col_numero.setText("Número");
        col_numero.setCellValueFactory(new PropertyValueFactory<Usuario, Integer>("numero"));
        TableColumn<Usuario, String> col_complemento = new TableColumn<>();
        col_complemento.setText("Complemento");
        col_complemento.setCellValueFactory(new PropertyValueFactory<Usuario, String>("complemento"));
        TableColumn<Usuario, String> col_cep = new TableColumn<>();
        col_cep.setText("CEP");
        col_cep.setCellValueFactory(new PropertyValueFactory<Usuario, String>("cep"));
        TableColumn<Usuario, String> col_bairro = new TableColumn<>();
        col_bairro.setText("Bairro");
        col_bairro.setCellValueFactory(new PropertyValueFactory<Usuario, String>("bairro"));
        TableColumn<Usuario, Boolean> col_su = new TableColumn<>();
        col_su.setText("Super Usuário");
        col_su.setCellValueFactory(new PropertyValueFactory<Usuario, Boolean>("super_usuario"));

        table.getColumns().addAll(col_nome, col_login, col_email, col_cpf, col_rg, col_endereco, col_numero, col_complemento,
                col_bairro, col_su);
    }
    private void criarTabelaFornecedor(TableView table){
        atualizarListaFornecedores(table);
        table.getColumns().remove(0, table.getColumns().size());
        TableColumn<Fornecedores, String> col_nome = new TableColumn<>();
        col_nome.setText("Nome da Empresa");
        col_nome.setCellValueFactory(new PropertyValueFactory<Fornecedores, String>("Nome_empresa"));
        TableColumn<Fornecedores, String> col_contato = new TableColumn<>();
        col_contato.setText("Contato Local");
        col_contato.setCellValueFactory(new PropertyValueFactory<Fornecedores, String>("Contato_local"));
        TableColumn<Fornecedores, String> col_email = new TableColumn<>();
        col_email.setText("Email");
        col_email.setCellValueFactory(new PropertyValueFactory<Fornecedores, String>("Email"));
        TableColumn<Fornecedores, String> col_telefone = new TableColumn<>();
        col_telefone.setText("Telefone");
        col_telefone.setCellValueFactory(new PropertyValueFactory<Fornecedores, String>("Telefone"));
        TableColumn<Fornecedores, String> col_celular = new TableColumn<>();
        col_celular.setText("Celular");
        col_celular.setCellValueFactory(new PropertyValueFactory<Fornecedores, String>("Celular"));
        TableColumn<Fornecedores, String> col_cnpj = new TableColumn<>();
        col_cnpj.setText("CNPJ");
        col_cnpj.setCellValueFactory(new PropertyValueFactory<Fornecedores, String>("CNPJ"));
        TableColumn<Fornecedores, String> col_endereco = new TableColumn<>();
        col_endereco.setText("Endereço");
        col_endereco.setCellValueFactory(new PropertyValueFactory<Fornecedores, String>("endereco"));
        TableColumn<Fornecedores, String> col_complemento = new TableColumn<>();
        col_complemento.setText("Complemento");
        col_complemento.setCellValueFactory(new PropertyValueFactory<Fornecedores, String>("complemento"));
        TableColumn<Fornecedores, Integer> col_numero = new TableColumn<>();
        col_numero.setText("Número");
        col_numero.setCellValueFactory(new PropertyValueFactory<Fornecedores, Integer>("numero"));
        TableColumn<Fornecedores, String> col_cep = new TableColumn<>();
        col_cep.setText("CEP");
        col_cep.setCellValueFactory(new PropertyValueFactory<Fornecedores, String>("CEP"));
        TableColumn<Fornecedores, String> col_bairro = new TableColumn<>();
        col_bairro.setText("Bairro");
        col_bairro.setCellValueFactory(new PropertyValueFactory<Fornecedores, String>("bairro"));


        table.getColumns().addAll(col_nome, col_contato, col_email, col_telefone, col_celular, col_cnpj, col_endereco, col_complemento,
                col_numero, col_cep, col_bairro);
    }
    private void criarTabelaFuncao(TableView table){
        atualizarListaFuncoes(table);
        table.getColumns().remove(0, table.getColumns().size());
        TableColumn<Funcao, String> col_nome = new TableColumn<>();
        col_nome.setText("Nome");
        col_nome.setCellValueFactory(new PropertyValueFactory<Funcao, String>("nome"));
        TableColumn<Funcao, String> col_descricao = new TableColumn<>();
        col_descricao.setText("Descrição");
        col_descricao.setCellValueFactory(new PropertyValueFactory<Funcao, String>("descricao"));
        TableColumn<Funcao, String> col_carga = new TableColumn<>();
        col_carga.setText("Carga Horária");
        col_carga.setCellValueFactory(new PropertyValueFactory<Funcao, String>("carga_horaria"));
        TableColumn<Funcao, BigDecimal> col_salario = new TableColumn<>();
        col_salario.setText("Salário");
        col_salario.setCellValueFactory(new PropertyValueFactory<Funcao, BigDecimal>("salario"));
        table.getColumns().addAll(col_nome, col_carga, col_salario, col_descricao);
    }
    private void criarTabelaCategoria(TableView table){
        atualizarListaCategorias(table);
        table.getColumns().remove(0, table.getColumns().size());
        TableColumn<CategoriaProduto, String> col_nome = new TableColumn<>();
        col_nome.setText("Nome");
        col_nome.setCellValueFactory(new PropertyValueFactory<CategoriaProduto, String>("nome"));
        table.getColumns().add(col_nome);
    }
}
