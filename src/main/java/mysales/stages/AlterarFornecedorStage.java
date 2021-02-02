package mysales.stages;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class AlterarFornecedorStage extends Stage {
    private static AlterarFornecedorStage stage = null;
    private static String css_path = "/mysales/css/styles.css";
    private static String fxml_path = "/mysales/fxml/alterarFornecedoresView.fxml";
    private static final String icon_path = "/mysales/imgs/icone.png";

    private AlterarFornecedorStage(){
        super();
    }
    public static Stage getInstance(){
        if(stage == null){
            stage = new AlterarFornecedorStage();
            setup();
        }
        return stage;
    }
    public static void abrir(){
        if(stage == null){
            stage = new AlterarFornecedorStage();
            setup();
        }
        stage.show();
    }
    public static void fechar(){
        if(stage != null) stage.close();
    }
    private static void setup(){
        try{
            GridPane root = FXMLLoader.load(LoginStage.class.getResource(fxml_path));
            Scene cena = new Scene(root);
            cena.getStylesheets().add(css_path);
            stage.setScene(cena);
            stage.initOwner(PrincipalStage.getInstance());
            stage.setResizable(false);
            stage.getIcons().add(new Image(icon_path));
            stage.setTitle("mySales - Alterar Fornecedor");
        }catch (IOException e){
            System.out.println("Erro ao carregar o FXML do stage Alterar Fornecedor");
        }
    }
}
