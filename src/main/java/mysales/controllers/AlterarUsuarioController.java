package mysales.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import mysales.controls.Memoria;
import mysales.database.Repositorio;
import mysales.database.entities.Funcao;
import mysales.database.entities.Usuario;
import mysales.stages.CadastroUsuarioStage;

import java.util.ArrayList;
import java.util.List;

public class AlterarUsuarioController {
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
        funcoes = Repositorio.obterTodasFuncaos();
        ObservableList<String> nome_funcoes = FXCollections.observableArrayList(obterNomeFuncoes(funcoes));
        cbx_funcao.setItems(nome_funcoes);
        atualizarCampos();

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

            novo_usuario.setCodigo(Memoria.getUsuario().getCodigo());
            Repositorio.atualizar(novo_usuario);
            System.out.println("Usuário atualizado.");
        });
    }
    private List<String> obterNomeFuncoes(List<Funcao> funcoes) {
        List<String> nome_funcoes = new ArrayList<>();
        for(Funcao f : funcoes)
            nome_funcoes.add(f.getNome());
        return nome_funcoes;
    }
    private void atualizarCampos(){
        Usuario u = Memoria.getUsuario();
        txf_nome.setText(u.getNome());
        txf_bairro.setText(u.getBairro());
        txf_usuario.setText(u.getLogin());
        txf_cep.setText(u.getCEP());
        txf_complemento.setText(u.getComplemento());
        txf_cpf.setText(u.getCPF());
        txf_email.setText(u.getEmail());
        txf_endereco.setText(u.getEndereco());
        txf_numero.setText(Integer.toString(u.getNumero()));
        txf_rg.setText(u.getRG());
        pwf_senha.setText(u.getSenha());
        pwf_senha2.setText(u.getSenha());
        ckb_superusuario.setSelected(u.isSuper_usuario());
    }
}
