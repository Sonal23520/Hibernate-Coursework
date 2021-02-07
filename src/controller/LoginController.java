package controller;

import bo.BoFactory;
import bo.SuperBO;
import bo.custom.LoginBo;
import bo.custom.impl.LoginBoImpl;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import dto.LoginDto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import util.Notification;

import javax.swing.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    public Label lblmessage;
    public TextField show;
    @FXML
    private TextField textusername;

    @FXML
    private PasswordField txtpassword;

    @FXML
    private JFXButton btnlogin;
    LoginBo bo = BoFactory.getInstance().getBo(BoFactory.BoType.LOGIN);

    @FXML
    void login(ActionEvent event) throws Exception {
        ArrayList<LoginDto> all = bo.getAll();
        if (textusername.getText().isEmpty()){
            lblmessage.setText("Please fill username field");
        }else if (txtpassword.getText().isEmpty()){
            lblmessage.setText("Please fill password field");
        }else{

            for (LoginDto loginDto : all) {
                if (loginDto.getUsername().equals(textusername.getText().trim()) &&
                        loginDto.getPassword().equals(txtpassword.getText().trim())){
                    Notification.conformation("Login Successful");
                    return;
                }
            }
            lblmessage.setText("Invalid username or password");
            return;
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        try {
//            boolean save = bo.save(new LoginDto(1, "sonal", "1234", "ADMIN"));
//            if (save){
//                System.out.println("saved!!!!!!!!!!!!!!!!!!!!!!!");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }


    public void eyeON(MouseEvent mouseEvent) {
        show.setVisible(true);
        show.setText(txtpassword.getText());
        txtpassword.setVisible(false);

    }

    public void eyeOff(MouseEvent mouseEvent) {
        show.setVisible(false);
        show.clear();
        txtpassword.setVisible(true);
    }

    public void lblReset(KeyEvent keyEvent) {
        lblmessage.setText("");
    }
}
