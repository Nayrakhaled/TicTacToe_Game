/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.DataInputStream;
import java.io.File;
import java.io.PrintStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author elshamey
 */
public class PlayOnlineGameSymbolController {
  
    
    @FXML
    private static Hyperlink playOnline_C00;
    private static Hyperlink playOnline_C10;
    private static Hyperlink playOnline_C20;
    private static Hyperlink playOnline_C01;
    private static Hyperlink playOnline_C11;
    private static Hyperlink playOnline_C21;
    private static Hyperlink playOnline_C02;
    private static Hyperlink playOnline_C12;
    private static Hyperlink playOnline_C22;
    private AnchorPane playOnlineForm;
    private AnchorPane OnlineWinForm;
    private MediaView onlineWinMediaPlayer;
    
    HashMap<String, Hyperlink> cells = new HashMap();
    String resultOfRequest = null; 
     String against , symbol = null;
    String hyperPressedId = null;
  
    private static Hyperlink[][] linkss = {{playOnline_C00, playOnline_C10, playOnline_C20},
    {playOnline_C01, playOnline_C11, playOnline_C21}, {playOnline_C02, playOnline_C12, playOnline_C22}};
    String playerSymbol = "X";
    String againstSymbol = "O";
    private static int xoCounter = 0;
    boolean isPlayerWin = false;
    boolean myTurn = true;
    boolean againstFlag = false;
    String againstName;
    Media media;
    MediaPlayer mediaPlayer;
    Hyperlink hyperPressed;
   String id;
    
    
    public void hyperLinkPressed(ActionEvent event){
        
        if(isPlayerWin == false && myTurn == true){
            hyperPressed = (Hyperlink) event.getSource();
            id = hyperPressed.getId();
            System.out.println("pressed "+ id);
            if(hyperPressed.getText().equals("")){
                hyperPressed.setText(playerSymbol);
                 hyperPressed.setOnAction(null);
                System.out.println("My Turn " + playerSymbol);
                myTurn = false;
                againstFlag = true;
               requestPlayerMoves(againstName,playerSymbol,id);
               aganistTurnFun();
                if(myTurn == true && playerSymbol.equals("X")){
                    hyperPressed.setTextFill(Color.RED);
                }else{
                    hyperPressed.setTextFill(Color.BLUE);
                }
                CheckForOnlineWinner();
            }
        }
    }
    
    public void aganistTurnFun(){
        Hyperlink aglink = cells.get(hyperPressedId);
        aglink.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    Hyperlink link = (Hyperlink) event.getSource();
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            link.setText(againstSymbol);
                            CheckForOnlineWinner();
                        }
                    });
                }
            });
            aglink.fire();
            myTurn= true;
            againstFlag = false;
        
        
        
        
        
        CheckForOnlineWinner();
       
    }
    
     public void CheckForOnlineWinner() {
        String getXorO = null;
        if (xoCounter < 9) {
            if ((playOnline_C00.getText().equals(playOnline_C10.getText())) && (playOnline_C00.getText().equals(playOnline_C20.getText())) && (!playOnline_C00.getText().isEmpty())) {
                getXorO = playOnline_C00.getText();
                isPlayerWin = true;
            } else if ((playOnline_C01.getText().equals(playOnline_C11.getText())) && (playOnline_C01.getText().equals(playOnline_C21.getText())) && (!playOnline_C01.getText().isEmpty())) {
                getXorO = playOnline_C01.getText();
                isPlayerWin = true;
            } else if ((playOnline_C02.getText().equals(playOnline_C12.getText())) && (playOnline_C02.getText().equals(playOnline_C22.getText())) && (!playOnline_C02.getText().isEmpty())) {
                getXorO = playOnline_C02.getText();
                isPlayerWin = true;
            } else if ((playOnline_C00.getText().equals(playOnline_C01.getText())) && (playOnline_C00.getText().equals(playOnline_C02.getText())) && (!playOnline_C00.getText().isEmpty())) {
                getXorO = playOnline_C00.getText();
                isPlayerWin = true;
            } else if ((playOnline_C10.getText().equals(playOnline_C11.getText())) && (playOnline_C10.getText().equals(playOnline_C12.getText())) && (!playOnline_C10.getText().isEmpty())) {
                getXorO = playOnline_C10.getText();
                isPlayerWin = true;
            } else if ((playOnline_C20.getText().equals(playOnline_C21.getText())) && (playOnline_C20.getText().equals(playOnline_C22.getText())) && (!playOnline_C20.getText().isEmpty())) {
                getXorO = playOnline_C20.getText();
                isPlayerWin = true;
            } else if ((playOnline_C00.getText().equals(playOnline_C11.getText())) && (playOnline_C00.getText().equals(playOnline_C22.getText())) && (!playOnline_C00.getText().isEmpty())) {
                getXorO = playOnline_C00.getText();
                isPlayerWin = true;
            } else if ((playOnline_C20.getText().equals(playOnline_C11.getText())) && (playOnline_C20.getText().equals(playOnline_C02.getText())) && (!playOnline_C20.getText().isEmpty())) {
                getXorO = playOnline_C20.getText();
                isPlayerWin = true;
            }
            if (xoCounter == 8 && isPlayerWin == false) {  // game ended without any winner 
                Alert a = new Alert(Alert.AlertType.INFORMATION, "Game ended without any winner.....");
                a.show();
                xoCounter = 0;
            } else {
                if (isPlayerWin == true) {
                    if (getXorO == "X") {
                        xoCounter = 0;
                        System.out.println("X is winner");
                        playOnlineForm.setVisible(false);
                        OnlineWinForm.setVisible(true);
                        String path = new File("src/Images/win.mp4").getAbsolutePath();
                        media = new Media(new File(path).toURI().toString());
                        mediaPlayer = new MediaPlayer(media);
                        onlineWinMediaPlayer.setMediaPlayer(mediaPlayer);
                        mediaPlayer.setAutoPlay(true);
                    } else {
                        System.out.println("O is winner");
                        xoCounter = 0;
                        playOnlineForm.setVisible(false);
                        OnlineWinForm.setVisible(true);
                        String path = new File("src/Images/win.mp4").getAbsolutePath();
                        media = new Media(new File(path).toURI().toString());
                        mediaPlayer = new MediaPlayer(media);
                        onlineWinMediaPlayer.setMediaPlayer(mediaPlayer);
                        mediaPlayer.setAutoPlay(true);
                    }
                }
            }

        }
    }
    
    public JSONObject requestPlayerMoves(String aganist, String symbol, String hyperPressedID) {
        JSONObject file = null;
        try {
            file = new JSONObject();
            file.put("Key", "requestMovement");

            JSONObject obj = new JSONObject();
            obj.put("aganist", aganist);
            obj.put("symbol", symbol);
            obj.put("hyperPressed", hyperPressedID);
            file.put("value", obj);
            System.out.println("Request Movement Json File: " + file);
            RequestToServer request = RequestToServer.createRequest();
            request.sendToServer(file);
        } catch (JSONException ex) {
            Logger.getLogger(PlayOnlineGameSymbolController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return file;
    }

    public String resposdGameSymbol(String message){
        
        try {
            JSONObject jSONObject = new JSONObject(message);
            JSONObject value = (JSONObject) jSONObject.get("value"); 
            against = value.getString("aganist");
            symbol = value.getString("symbol");
           hyperPressedId = value.getString("hyperPressed");
        } catch (JSONException ex) {
            Logger.getLogger(PlayOnlineGameSymbolController.class.getName()).log(Level.SEVERE, null, ex);
        }
       return message;
    }
    
    /*
    public JSONObject requestPlayerMoves(String aganist, String symbol, int col, int row){
         JSONObject file = null;
        try {
           
            file = new JSONObject();
            file.put("Key", "requestMovement");
            
            JSONObject obj = new JSONObject();
            obj.put("aganist", aganist);
            obj.put("symbol", symbol);
            obj.put("col", col);
            obj.put("row", row);
            file.put("value", obj);
            System.out.println("Request Movement Json File: " + file);
            RequestToServer request = RequestToServer.createRequest();
            request.sendToServer(file);
        } catch (JSONException ex) {
            Logger.getLogger(RequestGameSymbolController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return file;
    }
     */
    
    
   
}
