package mysales;

import javafx.application.Application;
import javafx.stage.Stage;
import mysales.stages.LoginStage;

public class AppFX extends Application {
    public static void init(String[] args){
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        stage = LoginStage.getInstance();
        stage.show();
    }
}
