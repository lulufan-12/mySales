package mysales.stages;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class CadastroCategoriasStage extends Stage {
    private static CadastroCategoriasStage stage = null;
    private static final String fxml_path = "/mysales/fxml/cadCategoriaProdView.fxml";
    private static final String css_path = "/mysales/css/styles.css";
    private static final String icon_path = "/mysales/imgs/icone.png";

    private CadastroCategoriasStage(){
        super();
    }
    public static Stage getInstance(){
        if(stage == null){
            stage = new CadastroCategoriasStage();
            setup();
        }
        return stage;
    }
    public static void abrir(){
        if(stage == null){
            stage = new CadastroCategoriasStage();
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
            Scene cena = new Scene(root, 400, 300);
            cena.getStylesheets().add(css_path);
            stage.setScene(cena);
            stage.getIcons().add(new Image(icon_path));
            stage.setResizable(false);
            stage.initOwner(PrincipalStage.getInstance());
            stage.setTitle("mySales - Cadastro de Categorias de Produtos");
        }catch (IOException e){
            System.out.println("Erro ao carregar o FXML do stage cadastro de categorias de produtos");
        }
    }
}
