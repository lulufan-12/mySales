package mysales.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import mysales.controls.Memoria;
import mysales.database.Repositorio;
import mysales.database.entities.Fornecedores;

public class AlterarFornecedoresController {
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
        atualizarCampos();
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
            fornecedor.setCodigo(Memoria.getFornecedor().getCodigo());

            Repositorio.atualizar(fornecedor);
            System.out.println("Fornecedor atualizado.");
        });
    }

    private void atualizarCampos(){
        Fornecedores f = Memoria.getFornecedor();
        txf_bairro.setText(f.getBairro());
        txf_celular.setText(f.getCelular());
        txf_contato_local.setText(f.getContato_local());
        txf_cep.setText(f.getCEP());
        txf_telefone.setText(f.getTelefone());
        txf_cnpj.setText(f.getCNPJ());
        txf_complemento.setText(f.getComplemento());
        txf_email.setText(f.getEmail());
        txf_endereco.setText(f.getEndereco());
        txf_nome.setText(f.getNome_empresa());
        txf_numero.setText(Integer.toString(f.getNumero()));
    }
}
