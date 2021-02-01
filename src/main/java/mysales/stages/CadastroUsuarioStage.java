package mysales.stages;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class CadastroUsuarioStage extends Stage {
    private static CadastroUsuarioStage stage = null;

    private static String css_path = "/mysales/css/styles.css";
    private static String fxml_path = "/mysales/fxml/cadUsuarioView.fxml";
    private static final String icon_path = "/mysales/imgs/icone.png";

    private CadastroUsuarioStage(){
        super();
    }
    public static Stage getInstance(){
        if(stage == null){
            stage = new CadastroUsuarioStage();
            setup();
        }
        return stage;
    }
    public static void abrir(){
        if(stage == null){
            stage = new CadastroUsuarioStage();
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
            stage.getIcons().add(new Image(icon_path));
            stage.initOwner(PrincipalStage.getInstance());
            stage.setResizable(false);
            stage.setScene(cena);
            stage.setTitle("mySales - Cadastro de Usuário");
        }catch (IOException e){
            System.out.println("Erro ao carregar o FXML do stage cadastro de usuários.");
        }
    }
}
