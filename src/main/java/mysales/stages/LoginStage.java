package mysales.stages;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginStage extends Stage {
    private static LoginStage stage = null;
    private static final String fxml_path = "/mysales/fxml/loginView.fxml";
    private static final String css_path = "/mysales/css/styles.css";
    private static final String icon_path = "/mysales/imgs/icone.png";

    private LoginStage(){
        super();
    }
    public static Stage getInstance(){
        if(stage == null){
            stage = new LoginStage();
            setup();
        }
        return stage;
    }
    public static void abrir(){
        if(stage == null){
            stage = new LoginStage();
            setup();
        }
        stage.show();
    }
    public static void fechar(){
        if(stage != null) stage.close();
    }
    private static void setup(){
        try{
            GridPane grid = FXMLLoader.load(LoginStage.class.getResource(fxml_path));
            Scene cena = new Scene(grid, 300, 250);
            cena.getStylesheets().add(css_path);
            stage.setScene(cena);
            stage.setResizable(false);
            stage.getIcons().add(new Image(LoginStage.class.getResource(icon_path).toExternalForm()));
            stage.setTitle("mySales - Login");
        }catch (IOException e){
            System.out.println("Erro ao carregar o FXML do stage login");
        }
    }
}
