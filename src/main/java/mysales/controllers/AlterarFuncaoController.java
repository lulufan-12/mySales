package mysales.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import mysales.controls.Memoria;
import mysales.database.Repositorio;
import mysales.database.entities.Funcao;
import mysales.stages.CadastroFuncaoStage;

import java.math.BigDecimal;

public class AlterarFuncaoController {
    @FXML
    private TextField txf_nome;
    @FXML
    private TextArea txa_descricao;
    @FXML
    private TextField txf_salario;
    @FXML
    private TextField txf_carga_horaria;
    @FXML
    private Button btn_cadastrar;

    @FXML
    private void initialize(){
        atualizarCampos();
        btn_cadastrar.setOnAction(e -> {
            String nome = txf_nome.getText().toString();
            String descricao = txa_descricao.getText().toString();
            String carga_horaria = txf_carga_horaria.getText().toString();
            String salario = txf_salario.getText().toString();

            if(nome.equals("") || descricao.equals("") || carga_horaria.equals("") || salario.equals("")){
                System.out.println("Preencha todos os campos");
                return;
            }
            Funcao nova_funcao = new Funcao(nome, descricao, new BigDecimal(salario), Integer.parseInt(carga_horaria));
            nova_funcao.setCodigo(Memoria.getFuncao().getCodigo());
            Repositorio.atualizar(nova_funcao);
            System.out.println("Função atualizada");
            atualizarCampos();
        });
    }
    public void atualizarCampos(){
        Funcao f = Memoria.getFuncao();
        txf_nome.setText(f.getNome());
        txf_carga_horaria.setText(Integer.toString(f.getCarga_horaria()));
        txf_salario.setText(f.getSalario().toString());
        txa_descricao.setText(f.getDescricao());
    }
}
