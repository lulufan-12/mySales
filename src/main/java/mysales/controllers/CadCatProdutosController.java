package mysales.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import mysales.database.Repositorio;
import mysales.database.entities.CategoriaProduto;
import mysales.stages.CadastroCategoriasStage;

public class CadCatProdutosController {
    @FXML
    private TextField txf_nome_categoria;
    @FXML
    private Button btn_cadastrar_categoria;

    @FXML
    private void initialize(){
        CadastroCategoriasStage.getInstance().setOnHidden(e -> {
            limparCampos();
        });
        btn_cadastrar_categoria.setOnAction(e -> {
            String nome_categoria = txf_nome_categoria.getText().toString();
            if(nome_categoria.equals("")){
                System.out.println("Preencha os campos primeiramente");
                return;
            }
            CategoriaProduto nova_categoria = new CategoriaProduto(nome_categoria);
            Repositorio.cadastrar(nova_categoria);
            System.out.println("Categoria adicionada com sucesso: " + nome_categoria);
            limparCampos();
        });
    }
    public void limparCampos(){
        txf_nome_categoria.setText("");
        txf_nome_categoria.requestFocus();
    }
}
