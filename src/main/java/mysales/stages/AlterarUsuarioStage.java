package mysales.stages;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class AlterarUsuarioStage  extends Stage{
    private static AlterarUsuarioStage stage = null;
    private static String css_path = "/mysales/css/styles.css";
    private static String fxml_path = "/mysales/fxml/alterarUsuarioView.fxml";
    private static final String icon_path = "/mysales/imgs/icone.png";

    private AlterarUsuarioStage(){
        super();
    }
    public static Stage getInstance(){
        if(stage == null){
            stage = new AlterarUsuarioStage();
            setup();
        }
        return stage;
    }
    public static void abrir(){
        if(stage == null){
            stage = new AlterarUsuarioStage();
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
            Scene cena = new Scene(root, 600, 450);
            cena.getStylesheets().add(css_path);
            stage.setScene(cena);
            stage.initOwner(PrincipalStage.getInstance());
            stage.setResizable(false);
            stage.getIcons().add(new Image(icon_path));
            stage.setTitle("mySales - Alterar Usuário");
        }catch (IOException e){
            System.out.println("Erro ao carregar o FXML do stage Alterar Usuário");
        }
    }
}
