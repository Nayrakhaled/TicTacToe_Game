
package controller;

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
   
      public void switchToPlayVSComputer(ActionEvent event){
        try{
             Parent root = FXMLLoader.load(getClass().getResource("FXMLPlayWithComputer.fxml")); 
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void switchToPlayVSFriend(ActionEvent event){
        try{
             Parent root = FXMLLoader.load(getClass().getResource("FXMLPlayWithFriend.fxml")); 
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
     
       public void switchToPlayOnline(ActionEvent event){
        try{
             Parent root = FXMLLoader.load(getClass().getResource("FXMLPlayOnline.fxml")); 
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
           public void switchToRecordsList(ActionEvent event){
        try{
             Parent root = FXMLLoader.load(getClass().getResource("FXMLGameForm.fxml")); 
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
          public void switchToRankList(ActionEvent event){
        try{
             Parent root = FXMLLoader.load(getClass().getResource("FXMLGameForm.fxml")); 
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
          public void switchToHome(ActionEvent event){
        try{
             Parent root = FXMLLoader.load(getClass().getResource("FXMLHome.fxml")); 
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
           public void switchToChooseX_O(ActionEvent event){
        try{
             Parent root = FXMLLoader.load(getClass().getResource("FXMLChoose_X_O.fxml")); 
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
