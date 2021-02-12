package util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class SetUi {
    public static void setUi(String location) throws IOException {
        Stage stage=new Stage();
        stage.setScene(new Scene(FXMLLoader.load(SetUi.class.getResource(location))));
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }
}
