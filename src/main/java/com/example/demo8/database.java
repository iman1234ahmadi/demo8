package com.example.demo8;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javafx.scene.control.Alert;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class database {
    public static void changeScene(ActionEvent event, String fxmlfile, String title, String username, String password) {
        Parent root = null;

        if (username != null && password != null) {
            try {
                FXMLLoader loader = new FXMLLoader(database.class.getResource(fxmlfile));
                root = loader.load();
                logincontroller logincontroller=loader.getController();
                logincontroller.setuserinformation(username,password);
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
        else{
            try {
                root=FXMLLoader.load(database.class.getResource(fxmlfile));
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
        Stage stage=(Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle(title);
        stage.setScene(new Scene(root,600,400));
        stage.show();

    }
    public static void changeScenes(ActionEvent event, String fxmlfile, String signupquestion, String loginquestion, String forgetpasswordquestion) throws IOException {
        Parent root;
                FXMLLoader loader = new FXMLLoader(database.class.getResource(fxmlfile));
                root = loader.load();
                helpController helpController=loader.getController();
            Stage stage3=(Stage) ((Node) event.getSource()).getScene().getWindow();
        stage3.setScene(new Scene(root,600,400));
        stage3.show();
        }




    public static void signupuser(ActionEvent event,String username,String password,String security_question,String security_answer, String firstname,String lastname,String age,String acount_mode){
      Connection connection=null;
      PreparedStatement preparedStatement=null;
      PreparedStatement preparedcheckuserexist=null;
      ResultSet resultSet=null;

      try{
          connection=DriverManager.getConnection("jdbc.mysql://localhost:3306/twitternew","root","iman1234a@");
          preparedcheckuserexist=connection.prepareStatement("select * from userss where username= ?");
          preparedcheckuserexist.setString(1,username);
          resultSet=preparedcheckuserexist.executeQuery();

          if(resultSet.isBeforeFirst()){
              System.out.println("username already exist!");
              Alert alert=new Alert(Alert.AlertType.ERROR);
              alert.setContentText("you cannot use this username.");
              alert.show();
          }
          else {
              preparedStatement=connection.prepareStatement("insert into userss(username,password,security_question,security_answer,firstname,lastname,age,user_mode values (?,?,?,?,?,?,?,?))");
              preparedStatement.setString(1,username);
              preparedStatement.setString(2,password);
              preparedStatement.setString(3,security_question);
              preparedStatement.setString(4,security_answer);
              preparedStatement.setString(5,firstname);
              preparedStatement.setString(6,lastname);
              preparedStatement.setString(7,age);
              preparedStatement.setString(8,acount_mode);
              preparedStatement.executeUpdate();

              changeScene(event,"Startmenu.fxml","welcome to the twitter",username,password);
          }
      }
      catch (SQLException e){
          e.printStackTrace();
      }
      finally {
          if(resultSet!=null){
              try {
                  resultSet.close();
              }
              catch (SQLException e){
                  e.printStackTrace();
              }
          }
          if(preparedcheckuserexist !=null){
              try {
                  preparedcheckuserexist.close();
              }
              catch (SQLException e){
                  e.printStackTrace();

              }
          }
          if(preparedStatement!=null){
              try {
                  preparedStatement.close();
              }
              catch (SQLException e){
                  e.printStackTrace();
              }
          }
          if(connection!=null){
              try {
                  connection.close();
              }
              catch (SQLException e){
                  e.printStackTrace();
              }
          }
      }


    }
    public static void loginuser(ActionEvent event,String username,String password){
        Connection connection=null;
        PreparedStatement preparedStatement1=null;
        ResultSet resultSet=null;
        try {
            connection=DriverManager.getConnection("jdbc.mysql://localhost:3306/twitternew","root","iman1234a@");
            preparedStatement1=connection.prepareStatement("select password from userss where username =?");
            preparedStatement1.setString(1,username);
            resultSet=preparedStatement1.executeQuery();

            if(!resultSet.isBeforeFirst()){
                System.out.println("user not found in the database.");
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setContentText("information are in correct.");
                alert.show();
            }
            else{
                while (resultSet.next()){
                    String retrievedusername=resultSet.getString("username");
                    String retrievedpassword=resultSet.getString("password");
                    if(retrievedpassword.equals(password)){
                        changeScene(event,"Startmenu.fxml","welcome to the twitter.",username,password);
                    }
                    else {
                        System.out.println("password did not match.");
                        Alert alert=new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("the provided credentials are incorrect");
                        alert.show();
                    }

                }

            }
        }
        catch (SQLException e){
            e.printStackTrace();

        }
        finally {
            if(resultSet!=null){
                try {
                    resultSet.close();
                }
                catch (SQLException e){
                    e.printStackTrace();
                }
            }
            if(preparedStatement1 !=null){
                try {
                    preparedStatement1.close();
                }
                catch (SQLException e){
                    e.printStackTrace();

                }
            }
            if(connection!=null){
                try {
                    connection.close();
                }
                catch (SQLException e){
                    e.printStackTrace();
                }
            }
            if(connection!=null){
                try {
                    connection.close();
                }
                catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }

        }
    }

