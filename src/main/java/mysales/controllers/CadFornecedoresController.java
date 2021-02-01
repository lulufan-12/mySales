package mysales.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import mysales.database.Repositorio;
import mysales.database.entities.Fornecedores;
import mysales.stages.CadastroFornecedoresStage;

public class CadFornecedoresController {
    @FXML
    private TextField txf_nome;
    @FXML
    private TextField txf_endereco;
    @FXML
    private TextField txf_bairro;
    @FXML
    private TextField txf_complemento;
    @FXML
    private TextField txf_numero;
    @FXML
    private TextField txf_cep;
    @FXML
    private TextField txf_cnpj;
    @FXML
    private TextField txf_contato_local;
    @FXML
    private TextField txf_telefone;
    @FXML
    private TextField txf_celular;
    @FXML
    private TextField txf_email;
    @FXML
    private Button btn_cadastrar;

    @FXML
    private void initialize(){
        CadastroFornecedoresStage.getInstance().setOnShown(e -> {
            limparCampos();
        });
        btn_cadastrar.setOnAction(e -> {
            String nome = txf_nome.getText().toString();
            String endereco = txf_endereco.getText().toString();
            String numero = txf_numero.getText().toString();
            String bairro = txf_bairro.getText().toString();
            String complemento = txf_complemento.getText().toString();
            String cep = txf_cep.getText().toString();
            String contato_local = txf_contato_local.getText().toString();
            String telefone = txf_telefone.getText().toString();
            String celular = txf_celular.getText().toString();
            String email = txf_email.getText().toString();
            String cnpj = txf_cnpj.getText().toString();

            if(nome.equals("") || endereco.equals("") || numero.equals("") || bairro.equals("") || cep.equals("") || contato_local.equals("") ||
            telefone.equals("") || celular.equals("") || email.equals("") || cnpj.equals("")){
                System.out.println("Preencha todos os campos obrigatórios");
                return;
            }
            Fornecedores fornecedor = new Fornecedores(nome, cnpj, contato_local, telefone, celular, email, endereco,
                    complemento, Integer.parseInt(numero), cep, bairro);

            Repositorio.cadastrar(fornecedor);
            System.out.println("Fornecedor cadastrado com sucesso.");
            limparCampos();
        });
    }

    private void limparCampos(){
        txf_bairro.setText("");
        txf_celular.setText("");
        txf_contato_local.setText("");
        txf_cep.setText("");
        txf_telefone.setText("");
        txf_cnpj.setText("");
        txf_complemento.setText("");
        txf_email.setText("");
        txf_endereco.setText("");
        txf_nome.setText("");
        txf_numero.setText("");
        txf_nome.requestFocus();
    }
}
