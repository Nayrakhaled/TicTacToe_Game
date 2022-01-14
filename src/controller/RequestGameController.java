/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.AnchorPane;
import org.json.JSONException;
import org.json.JSONObject;
import tictactoe_games.TicTacToe_Games;

/**
 *
 * @author AM STORE
 */
public class RequestGameController {

    private int isBusy = 0;
    private RequestToServer request = RequestToServer.createRequest();
    
    @FXML
    private AnchorPane playRequestForm;
    
    @FXML
    private ProgressIndicator progressLoading;

    public RequestGameController() {

    }

    public void requestToGame(String player, String aganist) {
        try {
            JSONObject file = new JSONObject();
            file.put("Key", "requsetPlay");
            JSONObject obj = new JSONObject();
            obj.put("aganist", aganist);
            obj.put("player", player);
            file.put("value", obj);
            request.sendToServer(file);
            System.out.println("json of request " + file);

        } catch (JSONException ex) {
            Logger.getLogger(RequestGameController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void sendRequest(String message) {
        try {
            JSONObject jSONObject = new JSONObject(message);
            System.out.println("json in class request 1 " + message);
            if (Integer.parseInt(jSONObject.get("response").toString()) == 0) {
                System.out.println("json in class request 2 " + message);
                String vs = jSONObject.get("aganist").toString();
                System.out.println("online in class request 2 " + jSONObject.get("player"));
                System.out.println("vs in class request 2 " + vs);
                System.out.println("playerOnline in class request 2 " + ScenesController.playerOnline.getUserName());
                if (!ScenesController.playerOnline.getUserName().equals(vs)) {
                    System.out.println("Have a request ");
                    Platform.runLater(() -> {
                        try {
                            showConfirmation("You Have request from " + vs, vs);
                        } catch (JSONException ex) {
                            Logger.getLogger(RequestGameController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    });
                } else {
                    System.out.println("wait for response ");
                    Platform.runLater(() -> {
                        //playRequestForm.setVisible(true);
//                        try {
//                            Parent root = FXMLLoader.load(getClass().getResource("/view/LoadingRequest.fxml"));
//                            Scene scene = new Scene(root);
//                            TicTacToe_Games.getStageX().setScene(scene);
//                            TicTacToe_Games.getStageX().show();
//                        } catch (IOException ex) {
//                            Logger.getLogger(RequestGameController.class.getName()).log(Level.SEVERE, null, ex);
//                        }
                    });
                }
            }
        } catch (JSONException ex) {
            Logger.getLogger(RequestGameController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void showConfirmation(String text, String vs) throws JSONException {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Select");
        alert.setHeaderText(text);

        ButtonType accept = new ButtonType("Accept");
        ButtonType reject = new ButtonType("Reject");

        // Remove default ButtonTypes
        alert.getButtonTypes().clear();

        alert.getButtonTypes().addAll(accept, reject);

        // option != null.
        Optional<ButtonType> option = alert.showAndWait();

        if (option.get() == accept) {
            System.out.println("Acceptttttttttttt");
            JSONObject file = new JSONObject();
            file.put("Key", "responsePlay");
            file.put("response", "accept");
            file.put("vs", vs);
            request.sendToServer(file);

        } else if (option.get() == reject) {
            System.out.println("rejectttttttttttt");
            JSONObject file = new JSONObject();
            file.put("Key", "responsePlay");
            file.put("response", "reject");
            file.put("vs", ScenesController.playerOnline.getUserName());
            request.sendToServer(file);
            
        }

    }

}
