package mysales.stages;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class PrincipalStage extends Stage {
    private static PrincipalStage stage = null;
    private static String css_path = "/mysales/css/styles.css";
    private static String fxml_path = "/mysales/fxml/principalView.fxml";
    private static final String icon_path = "/mysales/imgs/icone.png";


    private PrincipalStage(){
        super();
    }
    public static Stage getInstance(){
        if(stage == null){
            stage = new PrincipalStage();
            setup();
        }
        return stage;
    }
    public static void abrir(){
        if(stage == null){
            stage = new PrincipalStage();
            setup();
        }
        stage.show();
    }
    public static void fechar(){
        if(stage != null) stage.close();
    }
    private static void setup(){
        try{
            BorderPane root = FXMLLoader.load(LoginStage.class.getResource(fxml_path));
            Scene cena = new Scene(root, 800, 600);
            cena.getStylesheets().add(css_path);
            stage.setScene(cena);
            stage.getIcons().add(new Image(icon_path));
            stage.setTitle("mySales - Menu Principal");
        }catch (IOException e){
            System.out.println("Erro ao carregar o FXML do stage menu principal");
        }
    }
}
