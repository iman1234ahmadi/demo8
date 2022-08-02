package com.example.demo8;

        import javafx.event.ActionEvent;
        import javafx.event.EventHandler;
        import javafx.fxml.FXML;
        import javafx.fxml.FXMLLoader;
        import javafx.fxml.Initializable;
        import javafx.scene.Parent;
        import javafx.scene.Scene;
        import javafx.scene.control.Button;
        import javafx.scene.control.RadioButton;
        import javafx.scene.paint.Color;
        import javafx.scene.paint.CycleMethod;
        import javafx.scene.paint.LinearGradient;
        import javafx.scene.paint.Stop;
        import javafx.stage.Stage;

        import java.io.IOException;
        import java.net.URL;
        import java.util.ResourceBundle;

public class StartmenuController implements Initializable {

    @FXML
    private Button aboutusbutton;

    @FXML
    private Button exitbutton;

    @FXML
    private Button helpbutton;

@FXML
private Button loginbutton;
@FXML
private Button signupbutton;


    @FXML
  public   void exitbuttonOnaction(ActionEvent event) {
        Stage stage=(Stage) exitbutton.getScene().getWindow();
        stage.close();
    }

    @FXML
   public void helpbuttonOnaction(ActionEvent event) {
        Stage stage=(Stage) exitbutton.getScene().getWindow();
        stage.close();
        Stage stage3=new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("help.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage3.setScene(new Scene(root,778,656));
        stage3.show();
    }

    @FXML
   public void loginbuttonOnaction(ActionEvent event) {
        Stage stage=(Stage) exitbutton.getScene().getWindow();
        stage.close();
        Stage stage2=new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage2.setScene(new Scene(root, 750, 666));
        stage2.show();
    }

    @FXML
  public   void signupbuttonOnaction(ActionEvent event) {
        Stage stage=(Stage) exitbutton.getScene().getWindow();
        stage.close();
        Stage stage1=new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("signIn.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage1.setScene(new Scene(root, 885, 695));
        stage1.show();
    }
  public   void aboutusbuttonOnaction(ActionEvent event){
      Stage stage=(Stage) exitbutton.getScene().getWindow();
        stage.close();
        Stage stage4=new Stage();
        Parent root=null;
        try {
            root= FXMLLoader.load(getClass().getResource("aboutus.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loginbutton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                database.changeScene(event,"hello-view.fxml","log in",null,null);
            }
        });


    }




}



