package mysales.controls;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;

public class TextFieldDouble extends TextField {
    public TextFieldDouble(){
        super();

        textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                if(!t1.matches("\\d{0,7}([\\.]\\d{0,2})?"))
                    setText(s);
            }
        });
    }
}
