package mysales.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import mysales.database.Repositorio;
import mysales.database.entities.Funcao;
import mysales.database.entities.Usuario;
import mysales.stages.CadastroUsuarioStage;

import java.util.ArrayList;
import java.util.List;

public class CadUsuarioController {
    @FXML
    private TextField txf_nome;
    @FXML
    private TextField txf_usuario;
    @FXML
    private PasswordField pwf_senha;
    @FXML
    private PasswordField pwf_senha2;
    @FXML
    private TextField txf_email;
    @FXML
    private TextField txf_endereco;
    @FXML
    private TextField txf_numero;
    @FXML
    private TextField txf_complemento;
    @FXML
    private TextField txf_cep;
    @FXML
    private TextField txf_bairro;
    @FXML
    private TextField txf_cpf;
    @FXML
    private TextField txf_rg;
    @FXML
    private Button btn_cadastrar;
    @FXML
    private CheckBox ckb_superusuario;
    @FXML
    private ComboBox<String> cbx_funcao;
    private List<Funcao> funcoes;

    @FXML
    private void initialize(){
        CadastroUsuarioStage.getInstance().setOnShown(e -> {
            funcoes = Repositorio.obterTodasFuncaos();
            ObservableList<String> nome_funcoes = FXCollections.observableArrayList(obterNomeFuncoes(funcoes));
            cbx_funcao.setItems(nome_funcoes);
            cbx_funcao.getSelectionModel().select(0);
        });

        btn_cadastrar.setOnAction(e -> {
           String nome = txf_nome.getText().toString();
           String usuario = txf_usuario.getText().toString();
           String senha = pwf_senha.getText().toString();
           String senha2 = pwf_senha2.getText().toString();
           String endereco = txf_endereco.getText().toString();
           String bairro = txf_bairro.getText().toString();
           String complemento = txf_complemento.getText();
           String numero = txf_numero.getText().toString();
           String cep = txf_cep.getText().toString();
           String cpf = txf_cpf.getText().toString();
           String rg = txf_rg.getText().toString();
           String email = txf_email.getText().toString();
           boolean super_usuario = ckb_superusuario.isSelected();

           if(nome.equals("") || usuario.equals("") || senha.equals("") || senha2.equals("") || endereco.equals("") ||
           bairro.equals("") || numero.equals("") || cep.equals("") || cpf.equals("") || rg.equals("") || email.equals("")){
               System.out.println("Preencha todos os campos obrigatórios.");
               return;
           }
           if(!senha.equals(senha2)){
               System.out.println("As senhas são diferentes, por favor reconfirmar");
               return;
           }
           Funcao funcao = null;
           for(Funcao f: funcoes){
               if(f.getNome().equals(cbx_funcao.getSelectionModel().getSelectedItem())){
                   funcao = f;
               }
           }
            Usuario novo_usuario = new Usuario(nome, usuario, senha, email, endereco, Integer.parseInt(numero), complemento, cep,
                    bairro, super_usuario, cpf, rg, funcao);
            Repositorio.cadastrar(novo_usuario);
           limparCampos();
        });
    }
    private List<String> obterNomeFuncoes(List<Funcao> funcoes) {
        List<String> nome_funcoes = new ArrayList<>();
        for(Funcao f : funcoes)
            nome_funcoes.add(f.getNome());
        return nome_funcoes;
    }
    private void limparCampos(){
        txf_nome.setText("");
        txf_bairro.setText("");
        txf_usuario.setText("");
        txf_cep.setText("");
        txf_complemento.setText("");
        txf_cpf.setText("");
        txf_email.setText("");
        txf_endereco.setText("");
        txf_numero.setText("");
        txf_rg.setText("");
        pwf_senha.setText("");
        pwf_senha2.setText("");
        ckb_superusuario.setSelected(false);
    }
}
