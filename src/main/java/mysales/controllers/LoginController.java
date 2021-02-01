package mysales.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import mysales.database.Repositorio;
import mysales.database.Sessao;
import mysales.database.entities.Usuario;
import mysales.stages.LoginStage;
import mysales.stages.PrincipalStage;
import javax.persistence.NoResultException;

public class LoginController {
    @FXML
    private Button btn_entrar;
    @FXML
    private TextField txf_usuario;
    @FXML
    private PasswordField pwf_senha;
    @FXML
    private Label lbl_resposta;

    @FXML
    private void initialize(){
        btn_entrar.setOnAction(e -> {
            String login = txf_usuario.getText().toString();
            String senha = pwf_senha.getText().toString();
            if(login.equals("") || senha.equals("")){
                lbl_resposta.setText("Preencha os campos de usuário e senha");
                return;
            }
            try{
                Usuario usuario = Repositorio.logar(login, senha);
                Sessao.iniciarSessao(usuario);
                PrincipalStage.abrir();
                LoginStage.fechar();
                limparCampos(true);
            }
            catch (NoResultException exception){
                lbl_resposta.setText("Nome de usuário ou senha inválidos");
                limparCampos(false);
            }
        });
    }
    private void limparCampos(boolean resposta){
        txf_usuario.setText("");
        pwf_senha.setText("");
        if(resposta)
            lbl_resposta.setText("");
        txf_usuario.requestFocus();
    }
}
