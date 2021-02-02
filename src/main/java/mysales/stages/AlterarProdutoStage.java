package mysales.stages;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class AlterarProdutoStage extends Stage {
    private static AlterarProdutoStage stage = null;
    private static String css_path = "/mysales/css/styles.css";
    private static String fxml_path = "/mysales/fxml/alterarProdutoView.fxml";
    private static final String icon_path = "/mysales/imgs/icone.png";

    public static void abrir(){
        if(stage == null){
            stage = new AlterarProdutoStage();
            setup();
        }
        stage.show();
    }
    private AlterarProdutoStage(){
        super();
    }
    public static AlterarProdutoStage getInstance(){
        if(stage == null){
            stage = new AlterarProdutoStage();
            setup();
        }

        return stage;
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
            stage.initOwner(AlterarDadosStage.getInstance());
            stage.setResizable(false);
            stage.getIcons().add(new Image(icon_path));
            stage.setTitle("mySales - Alterar Produto");
        }catch (IOException e){
            System.out.println("Erro ao carregar o FXML do stage Alterar Produto");
        }
    }
}
