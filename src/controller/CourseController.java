package controller;

import bo.BoFactory;
import bo.custom.CourseBo;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import dto.CourseDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.CourseTM;
import util.Notification;
import util.SetUi;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CourseController implements Initializable {
    @FXML
    public ImageView imgHome;
    @FXML
    public TableColumn colOperation;
    @FXML
    private ImageView imgClose;

    @FXML
    private Label lblId;

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtType;

    @FXML
    private JFXTextField txtDuration;

    @FXML
    private TextField txtSearch;

    @FXML
    private TableView<CourseTM> table;

    @FXML
    private TableColumn<?, ?> colid;

    @FXML
    private TableColumn<?, ?> colname;

    @FXML
    private TableColumn<?, ?> coltype;

    @FXML
    private TableColumn<?, ?> colduration;

    @FXML
    private JFXButton btnAdd;

    CourseBo courseBo = BoFactory.getInstance().getBo(BoFactory.BoType.COURSE);
    ObservableList<CourseTM> courseTm = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colid.setCellValueFactory(new PropertyValueFactory<>("id"));
        colname.setCellValueFactory(new PropertyValueFactory<>("name"));
        coltype.setCellValueFactory(new PropertyValueFactory<>("type"));
        colduration.setCellValueFactory(new PropertyValueFactory<>("duration"));
        colOperation.setCellValueFactory(new PropertyValueFactory<>("button"));

        try {

            ArrayList<CourseDto> all = courseBo.getAll();
            for (CourseDto courseDto : all) {
                JFXButton delete = new JFXButton("Delete");
//                delete.setStyle("-fx-background-color: #e74c3c");
                courseTm.add(new CourseTM(courseDto.getId(),
                        courseDto.getName(), courseDto.getType(), courseDto.getDuration(), delete));
            }
            table.setItems(courseTm);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    void Search(ActionEvent event) {

    }

    @FXML
    void add(ActionEvent event) throws Exception {
        boolean c = courseBo.save(new CourseDto("C001", txtName.getText().trim()
                , txtType.getText().trim(), txtDuration.getText().trim()));
        if (c){
            Notification.conformation("Course Added Successful");
            clear();
        }else {
            Notification.erro("Course Added Failed");
        }
    }



    public void home(MouseEvent mouseEvent) throws IOException {
        SetUi.setUi("/view/Dashboard.fxml");
        close();
    }

    @FXML
    void close(MouseEvent event) {
        close();
    }
    void close(){
        Stage stage= (Stage) imgClose.getScene().getWindow();
        stage.close();
    }
    void clear(){
        txtName.clear();
        txtType.clear();
        txtDuration.clear();
    }
}
