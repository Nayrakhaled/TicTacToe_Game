
package controller;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;
import jdk.nashorn.internal.runtime.arrays.ArrayLikeIterator;


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
   // @FXML
    //private  Label VSComputer;
    @FXML 
    private Button Online_btnRecordung;
    private ImageView Online_RecordIImage;
    @FXML 
    private ImageView OnlinePlayer1Image;
    @FXML
    private  Label OnlinePlayer1UserName;
   private  Label OnlinePlayer1Score;
   // Game Fom
   @FXML
   private Label gameForm1_p00;
   @FXML
   private Label gameForm1_p10;
   
   @FXML
   private Label label00;
   private Label label01;
   private Label label02;
   private Label label10;
   private Label label11;
   private Label label12;
   private Label label20;
   private Label label21;
   private Label label22;
   // with Computer 
   private Hyperlink gameForm_p00;
   private Hyperlink gameForm_p01;
   private Hyperlink gameForm_p02;
   private Hyperlink gameForm_p10;
   private Hyperlink gameForm_p11;
   private Hyperlink gameForm_p12;
   private Hyperlink gameForm_p20;
   private Hyperlink gameForm_p21;
   private Hyperlink gameForm_p22;
   private GridPane gridGame;
   private Label VSComputerPlayer2UserName;
   private Label VSComputer;
   private Label VSComputerPlayerPlayer2Score;
   private Label VSComputer_pcScore;
  
   
   String Winner = null;
   String player;
   boolean isPlayerWin = false;
   int xoCounter = -1;
   String initialStart ="X";
    
  
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
    
    @FXML
     public void Play1(MouseEvent event){
     
      Label l1 = (Label) event.getSource();
      String id = l1.getId();
      System.out.println(l1);
      System.out.println(id);
      
      l1.setText(initialStart);
      l1.setOnMouseClicked(null);
      if(initialStart.equals("X")){
          
          initialStart = "O";
      }else{
          
          initialStart = "X";
          
      }
    }
    public void Play(ActionEvent event){
     
      Hyperlink l = (Hyperlink) event.getSource();
      String id = l.getId();
      //System.out.println(l);
     // System.out.println(id);
      
     for(int i=0;i<9;i++){
      l.setText(initialStart);
      System.out.println(id);
     }
      l.setOnAction(null);
      if(initialStart.equals("X")){
          l.setTextFill(Color.RED);
          initialStart = "O";
         // xoCounter++;
                  
          try {
              checkForWinner();
          } catch (IOException ex) {
              Logger.getLogger(ScenesController.class.getName()).log(Level.SEVERE, null, ex);
          }
      }else{
          l.setTextFill(Color.BLUE);
          initialStart = "X";
          //xoCounter++;
          try {
              checkForWinner();
          } catch (IOException ex) {
              Logger.getLogger(ScenesController.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
    }
    
    
    public void checkForWinner() throws IOException{
        
        String gameGrid00 = gameForm_p00.textProperty().getValue();
        System.out.print(gameGrid00);
        String gameGrid01 = gameForm_p01.textProperty().getValue();
        String gameGrid02 = gameForm_p02.textProperty().getValue();
        String gameGrid10 = gameForm_p10.getText();
        String gameGrid11 = gameForm_p11.getText();
        String gameGrid12 = gameForm_p12.getText();
        String gameGrid20 = gameForm_p20.getText();
        String gameGrid21 = gameForm_p21.getText();
        String gameGrid22 = gameForm_p22.getText();
        
        String getXorO = null;
        
        if ((!gameGrid00.isEmpty()) && (gameGrid00.equals(gameGrid10)) && (gameGrid00.equals(gameGrid20))) {
            isPlayerWin = true;
            getXorO = gameGrid00; 
            System.out.print("Win");
        }
        else if ((!gameGrid01.isEmpty()) &&(gameGrid01.equals(gameGrid11)) && (gameGrid01.equals(gameGrid21))) {
            isPlayerWin = true;
            getXorO = gameGrid01;
        }
        else if ((!gameGrid02.isEmpty()) &&(gameGrid02.equals(gameGrid12)) && (gameGrid02.equals(gameGrid22)) ) {
            isPlayerWin = true;
            getXorO = gameGrid02;
        }
        else if ((!gameGrid00.isEmpty()) && (gameGrid00.equals(gameGrid01)) && (gameGrid00.equals(gameGrid02)) ) {
            isPlayerWin = true;
            getXorO = gameGrid00;
        }
        else if ((!gameGrid10.isEmpty()) && (gameGrid10.equals(gameGrid11)) && (gameGrid10.equals(gameGrid12)) ) {
            isPlayerWin = true;
            getXorO = gameGrid10;
        }
        else if ( (!gameGrid20.isEmpty()) &&(gameGrid20.equals(gameGrid21)) && (gameGrid20.equals(gameGrid22)) ) {
            isPlayerWin = true;
            getXorO = gameGrid20;
        }
        else if ( (!gameGrid00.isEmpty()) &&(gameGrid00.equals(gameGrid11)) && (gameGrid00.equals(gameGrid22)) ) {
            isPlayerWin = true;
            getXorO = gameGrid00;
        }
        else if ( (!gameGrid20.isEmpty()) &&(gameGrid20.equals(gameGrid11)) && (gameGrid20.equals(gameGrid02)) ) {
            isPlayerWin = true;
            getXorO = gameGrid20;
        }
        
        if(isPlayerWin == true)
        {
            if(getXorO.equals("X")){
                System.out.println("X Win");
                Alert alert = new Alert(Alert.AlertType.ERROR,"X Win");
                alert.show();
                int pcScore = Integer.valueOf(VSComputer_pcScore.getText()) +10;
                VSComputer_pcScore.setText(String.valueOf(pcScore));
            }
            else{
                Alert alert = new Alert(Alert.AlertType.ERROR,"O Win");
                alert.show();
                int playerScore = Integer.valueOf(VSComputerPlayerPlayer2Score.getText()) +10;
                VSComputerPlayerPlayer2Score.setText(String.valueOf(playerScore));
            }
            xoCounter = 0;
            
        }else{
            System.out.println("O Win");
            if(xoCounter>=8){
                //gridGame.setVisible(false);
                //gridGame.visibleProperty().setValue(Boolean.TRUE);
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.show();
                
            }
        }
        
    }
    
    private void clearToPlayAgain() {

        isPlayerWin = false;
        //setCurrentPlayerSymbol();
        /*
        for (Button boardButton : boardButtons) {
            boardButton.setText("");
            boardButton.setStyle("-fx-background-color: none; -fx-cursor: hand;");
        }
*/

    }
    
    
    
    
    
}
