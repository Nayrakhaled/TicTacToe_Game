
package controller;

import java.awt.event.MouseEvent;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;
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
    @FXML
    private Circle Online_CirclePlayer1;
    @FXML
    private Circle Online_CirclePlayer2;
    @FXML
    private  Label VSComputer;
    @FXML 
    private Button Online_btnRecordung;
    private ImageView Online_RecordIImage;
    @FXML 
    private ImageView OnlinePlayer1Image;
    @FXML
    private  Label OnlinePlayer1UserName;
   private  Label OnlinePlayer1Score;
    
    
    
    
    
    
    
    
    public ScenesController(){
       
    }
   
      public void switchToPlayVSComputer(ActionEvent event){
        try{
             Parent root = FXMLLoader.load(getClass().getResource("/view/FXMLPlayWithComputer.fxml")); 
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            /*OnlinePlayer1Image.setVisible(false);
            OnlinePlayer1UserName.setVisible(false);
            OnlinePlayer1Score.setVisible(false);
            VSComputer.getText();
            VSComputer.setVisible(true);*/
            stage.show();
           
        }catch(Exception e){
            e.printStackTrace();
        }
    }
      public void switchToPlayVSFriend(ActionEvent event){
        try{
             Parent root = FXMLLoader.load(getClass().getResource("/view/FXMLPlayWithFriend.fxml")); 
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
             Parent root = FXMLLoader.load(getClass().getResource("/view/FXMLPlayOnline.fxml")); 
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
           /* Online_CirclePlayer1.setVisible(true);
            Online_CirclePlayer2.setVisible(true);
            Online_btnRecordung.setVisible(true);
            Online_RecordIImage.setVisible(true);*/
            stage.show();
         
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
           public void switchToRecordsList(ActionEvent event){
        try{
             Parent root = FXMLLoader.load(getClass().getResource("/view/RecordList.fxml")); 
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
             Parent root = FXMLLoader.load(getClass().getResource("/view/Rank.fxml")); 
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
             Parent root = FXMLLoader.load(getClass().getResource("/view/FXMLHome.fxml")); 
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
             Parent root = FXMLLoader.load(getClass().getResource("/view/FXMLChoose_X_O.fxml")); 
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
           public void switchToSignup(ActionEvent event){
        try{
             Parent root = FXMLLoader.load(getClass().getResource("/view/FXMLSignup.fxml")); 
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
             Parent root = FXMLLoader.load(getClass().getResource("/view/FXMLLogin.fxml")); 
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void switchToAvailableList(ActionEvent event){
       try{
             Parent root = FXMLLoader.load(getClass().getResource("/view/FXMLAvailableListForm.fxml")); 
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
     
    
    
    
    
    
    
    
    
}
