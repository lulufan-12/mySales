package mysales.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import mysales.database.Sessao;
import javafx.scene.control.Label;
import mysales.stages.*;

public class PrincipalController {
    @FXML
    private Label lbl_nomeusuario;
    @FXML
    private Button btn_encerrar_sessao;
    @FXML
    private Button btn_cadastro_cat_produtos;
    @FXML
    private Button btn_cadastro_produtos;
    @FXML
    private Button btn_cadastro_funcao;
    @FXML
    private Button btn_cadastro_usuario;
    @FXML
    private Button btn_cadastro_fornecedores;
    @FXML
    private TitledPane titled_vendas;
    @FXML
    private Button btn_alterar_dados;
    @FXML
    private void initialize(){
        PrincipalStage.getInstance().setOnShown(e -> {
            lbl_nomeusuario.setText(Sessao.getUsuario().getNome());
            titled_vendas.setExpanded(true);
        });
        btn_cadastro_cat_produtos.setOnAction(e -> {
            CadastroCategoriasStage.abrir();
        });
        btn_cadastro_produtos.setOnAction(e -> {
            CadastroProdutosStage.abrir();
        });
        btn_encerrar_sessao.setOnAction(e -> {
            Sessao.finalizarSessao();
            PrincipalStage.fechar();
            LoginStage.abrir();
        });
        btn_cadastro_funcao.setOnAction(e -> {
            CadastroFuncaoStage.abrir();
        });
        btn_cadastro_usuario.setOnAction(e -> {
            CadastroUsuarioStage.abrir();
        });
        btn_cadastro_fornecedores.setOnAction(e -> {
            CadastroFornecedoresStage.abrir();
        });
        btn_alterar_dados.setOnAction(e -> {
            AlterarDadosStage.abrir();
        });
    }
}
