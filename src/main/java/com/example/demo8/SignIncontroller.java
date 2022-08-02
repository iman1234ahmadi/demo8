package com.example.demo8;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SignIncontroller implements Initializable{

        @FXML
        private TextField acount_mode;

        @FXML
        private TextField answerfield;

        @FXML
        private Button backbutton;

        @FXML
        private TextField confirmpasswordfield;

        @FXML
        private TextField firstnamefield;

        @FXML
        private TextField lastnamefield;

        @FXML
        private TextField passwordfield;

        @FXML
        private TextField security_question;

        @FXML
        private Button signupbutton;

        @FXML
        private TextField usernamefield;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
signupbutton.setOnAction(new EventHandler<ActionEvent>(){
    @Override
    public void handle(ActionEvent event) {
        database.changeScene(event,"signIn.fxml","sign up.",null,null);
        if(usernamefield.getText().trim().isEmpty() && passwordfield.getText().trim().isEmpty() && confirmpasswordfield.getText().trim().isEmpty()
                && firstnamefield.getText().trim().isEmpty() && lastnamefield.getText().trim().isEmpty() && security_question.getText().trim().isEmpty()
                && answerfield.getText().trim().isEmpty() && acount_mode.getText().trim().isEmpty()){
            database.signupuser(event,usernamefield.getText(),passwordfield.getText(),confirmpasswordfield.getText(),firstnamefield.getText(),lastnamefield.getText(),
                    security_question.getText(),answerfield.getText(),acount_mode.getText());
        }
        else {
            System.out.println("please fill in all information");
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("please fill in all information to sign up");
            alert.show();
        }
    }

    });





}
public void setuserinformationssignup(String username,String password,String confirmpassword,String firstname,String lastname,String security_ques,String answer,String acount){
    usernamefield.setText(username);
    passwordfield.setText(password);
    confirmpasswordfield.setText(confirmpassword);
    firstnamefield.setText(firstname);
    lastnamefield.setText(lastname);
    security_question.setText(security_ques);
    answerfield.setText(answer);
    acount_mode.setText(acount);

}
    @FXML
    public void backButton(ActionEvent event) throws IOException {
        Stage stage=(Stage) backbutton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Startmenu.fxml"));
        stage.getScene().setRoot(root);
        stage.show();

    }
    }
