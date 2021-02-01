package mysales.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import mysales.database.Repositorio;
import mysales.database.entities.CategoriaProduto;
import mysales.database.entities.Produto;
import mysales.stages.CadastroProdutosStage;
import java.math.BigDecimal;
import java.util.List;


public class CadProdController {
    @FXML
    private ComboBox<String> cbx_categoria;
    @FXML
    private TextField txf_codigo;
    @FXML
    private TextField txf_nome;
    @FXML
    private TextField txf_preco;
    @FXML
    private TextArea txa_descricao;
    @FXML
    private Button btn_cadastrar_produto;
    private List<CategoriaProduto> categorias;


    @FXML
    private void initialize(){
        CadastroProdutosStage.getInstance().setOnShown(e -> {
            limparCampos();
            categorias = Repositorio.obterTodasCategorias();
            ObservableList<String> lista_categoria_observavel = obterNomeCategorias(categorias);
            cbx_categoria.setItems(lista_categoria_observavel);
            cbx_categoria.getSelectionModel().select(0);
        });

        btn_cadastrar_produto.setOnAction(e -> {
            String codigo = txf_codigo.getText().toString();
            String nome = txf_nome.getText().toString();
            String descricao = txa_descricao.getText().toString();
            String preco = txf_preco.getText().toString();
            String categoria = cbx_categoria.getSelectionModel().getSelectedItem();

            if(codigo.equals("") || nome.equals("") || descricao.equals("") || preco.equals("") || categoria.equals("") || categoria.equals(null)){
                System.out.println("Preencha todos os campos");
                return;
            }
            CategoriaProduto cat_produto = null;
            for(CategoriaProduto c : categorias){
                if(c.getNome().equals(categoria))
                    cat_produto = c;
            }
            Produto novo_produto = new Produto(nome, descricao, new BigDecimal(preco), cat_produto, codigo);
            Repositorio.cadastrar(novo_produto);
            limparCampos();
        });
    }

    private ObservableList<String> obterNomeCategorias(List<CategoriaProduto> lista_categoria){
        ObservableList<String> lista_nomes_categoria = FXCollections.observableArrayList();
        for(CategoriaProduto c : lista_categoria){
            lista_nomes_categoria.add(c.getNome());
        }
        return lista_nomes_categoria;
    }
    public void limparCampos(){
        txf_nome.setText("");
        txf_preco.setText("");
        txf_codigo.setText("");
        txf_preco.setText("");
        txa_descricao.setText("");
        txf_codigo.requestFocus();
    }
}
