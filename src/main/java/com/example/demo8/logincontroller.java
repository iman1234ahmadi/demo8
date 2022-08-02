package com.example.demo8;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class logincontroller implements Initializable {
@FXML
private Label loginlabel;
@FXML
private Button loginbutton;
@FXML
private TextField welcometextfield;
@FXML
private TextField usernamelogin;
    @FXML
    private TextField passwordlogin;
    @FXML
    private Label backbutton;

    @FXML
    private Button forget_password;

    @FXML
    private Label newacount;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    loginbutton.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
database.changeScene(event,"hello-view.fxml","login.",null,null);
      if(usernamelogin.getText().trim().isEmpty() && passwordlogin.getText().trim().isEmpty()){
          database.loginuser(event,usernamelogin.getText(),passwordlogin.getText());
      }
      else {
          System.out.println("please fill in all information");
          Alert alert=new Alert(Alert.AlertType.ERROR);
          alert.setContentText("please fill in all information to log in");
          alert.show();
      }
            }
    });
    }
    public void setuserinformation(String username,String password){
        usernamelogin.setText(username);
        passwordlogin.setText(password);
    }
}
