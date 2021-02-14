package controller;

import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import util.SetUi;

import java.io.IOException;

public class DashboardController {
    public ImageView imgClose;
    public AnchorPane pnCourse;
    public AnchorPane pnStudent;

    public void close(MouseEvent mouseEvent) {
      close();
    }

    public void course(MouseEvent mouseEvent) throws IOException {
        SetUi.setUi("/view/Course.fxml");
        close();
    }
    void close(){
        Stage stage= (Stage) imgClose.getScene().getWindow();
        stage.close();
    }

    public void student(MouseEvent mouseEvent) throws IOException {
        SetUi.setUi("/view/Student.fxml");
        close();
    }
}
