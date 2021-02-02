package mysales.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import mysales.controls.Memoria;
import mysales.database.Repositorio;
import mysales.database.entities.CategoriaProduto;

public class AlterarCategoriaController {
    @FXML
    private TextField txf_nome_categoria;
    @FXML
    private Button btn_cadastrar_categoria;

    @FXML
    private void initialize(){
        atualizarCampos();
        btn_cadastrar_categoria.setOnAction(e -> {
            String nome_categoria = txf_nome_categoria.getText().toString();
            if(nome_categoria.equals("")){
                System.out.println("Preencha os campos primeiramente");
                return;
            }
            CategoriaProduto nova_categoria = new CategoriaProduto(nome_categoria);
            nova_categoria.setCodigo(Memoria.getCategoria().getCodigo());
            Repositorio.atualizar(nova_categoria);
            System.out.println("Categoria atualizada.");
        });
    }
    public void atualizarCampos(){
        txf_nome_categoria.setText(Memoria.getCategoria().getNome());
    }
}
