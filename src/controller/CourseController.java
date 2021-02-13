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
import javafx.scene.control.*;
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
    public JFXButton btnNew;
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
        /////////////SET VALUES//////////
        colid.setCellValueFactory(new PropertyValueFactory<>("id"));
        colname.setCellValueFactory(new PropertyValueFactory<>("name"));
        coltype.setCellValueFactory(new PropertyValueFactory<>("type"));
        colduration.setCellValueFactory(new PropertyValueFactory<>("duration"));
        colOperation.setCellValueFactory(new PropertyValueFactory<>("button"));

        /////////// FETCH DATA//////////////

        try {
            genarateId();
            tableLoad();
        } catch (Exception e) {
            e.printStackTrace();
        }

        /////////////TABLE LISTNER////////////////
        table.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                CourseTM selectedItem = table.getSelectionModel().getSelectedItem();
                lblId.setText(selectedItem.getId());
                txtName.setText(selectedItem.getName());
                txtType.setText(selectedItem.getType());
                txtDuration.setText(selectedItem.getDuration());
                btnAdd.setText("Update");
            }
        });
    }
    @FXML
    void Search(ActionEvent event) throws Exception {
        CourseDto search = courseBo.search(txtSearch.getText().trim());
        lblId.setText(search.getId());
        txtName.setText(search.getName());
        txtType.setText(search.getType());
        txtDuration.setText(search.getDuration());
    }

    @FXML
    void add(ActionEvent event) throws Exception {

        ArrayList<CourseDto> all = courseBo.getAll();
        for (CourseDto courseDto : all) {
            if (lblId.getText().equals(courseDto.getId())){
                boolean update = courseBo.update(new CourseDto(lblId.getText(), txtName.getText().trim()
                        , txtType.getText().trim(), txtDuration.getText().trim()));
                if (update){
                    Notification.conformation("Course Updated Success");
                    tableLoad();
                }else {
                    Notification.erro("Course Updated Failed");
                }
                    return;
            }
        }
        boolean c = courseBo.save(new CourseDto(lblId.getText(), txtName.getText().trim()
                , txtType.getText().trim(), txtDuration.getText().trim()));
        if (c){
            Notification.conformation("Course Added Successful");
            clear();
        }else {
            Notification.erro("Course Added Failed");
        }
        tableLoad();
        genarateId();
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
        lblId.setText(" ");
        txtName.clear();
        txtType.clear();
        txtDuration.clear();
    }

    public void newOnAction(ActionEvent actionEvent) throws Exception {
        clear();
        btnAdd.setText("Add");
        genarateId();
    }
    void tableLoad() throws Exception {
        courseTm.clear();
        table.refresh();
        ArrayList<CourseDto> all = courseBo.getAll();
        for (CourseDto courseDto : all) {
            JFXButton delete = new JFXButton("Delete");
            delete.setOnAction((e)->{
                try {
                    courseBo.delete(courseDto.getId());
                    tableLoad();
                    genarateId();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            });
            courseTm.add(new CourseTM(courseDto.getId(),
                    courseDto.getName(), courseDto.getType(), courseDto.getDuration(), delete));
        }
        table.setItems(courseTm);
    }
    void genarateId() throws Exception {
        CourseDto courseDto = courseBo.gernarateId();
        String[] cs = courseDto.getId().split("C");
        int count =Integer.parseInt(cs[1]);
        if (count>=99){
            lblId.setText("C"+(count+1));
        }else if(count>=9){
            lblId.setText("C0"+(count+1));
        }else {
            lblId.setText("C00"+(count+1));
        }
    }
}
