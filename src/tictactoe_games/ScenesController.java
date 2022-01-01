/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe_games;

import java.awt.event.MouseEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


public class ScenesController {
    
    private Stage stage;
    private Scene scene;
    private Parent parent;
    
    //Registration Form Component
    @FXML
    private TextField registerTxt_userName;
    @FXML
    private TextField registertxt_password;
    @FXML
    private TextField registerTxt_ComfirmPass;
    private ImageView registerLogo;
    
    
    
    
    
    
    
    
    public ScenesController(){
       
    }
   
    
    public void switchToSignup(ActionEvent event){
        try{
             Parent root = FXMLLoader.load(getClass().getResource("FXMLSignup.fxml")); 
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void switchToLoginForm(ActionEvent event){
        try{
             Parent root = FXMLLoader.load(getClass().getResource("FXMLLogin.fxml")); 
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void switchToAvailableList(ActionEvent event){
        registerTxt_userName.clear();
        registertxt_password.clear();
        registerTxt_ComfirmPass.clear();
    }
    
    
    
    
    
    
    
    
}
