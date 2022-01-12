/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Module.Player;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import org.json.JSONException;
import org.json.JSONObject;

;

/**
 *
 * @author AM STORE
 */
public class LoginController {

    private int isCheck;


    public JSONObject sendData(Player player) {
        System.out.println("Login Controller");
        JSONObject file = null;
        try {
            file = new JSONObject();   
            file.put("Key", "Login");
            JSONObject obj = new JSONObject();
            obj.put("user", player.getUserName());
            obj.put("pass", player.getPassword());
            
            file.put("value", obj);
            
            System.out.println("json file "+ file);
            RequestToServer request = RequestToServer.createRequest();
            request.sendToServer(file);
            
        } catch (JSONException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return file;
    }

    public int checkData(String message) {
        try {
            System.out.println("check data in login");
            JSONObject jSONObject = new JSONObject(message);
            if (jSONObject.get("response").equals("1")) { // Exist
                isCheck = 1;
                System.out.println("Exist");
            } else if (jSONObject.get("response").equals("-1")) { // user not  exist
                System.out.println("Not Exist");
                 Platform.runLater(() -> {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText("This Username is not Exist.");
                    alert.showAndWait();
                });
            } else if (jSONObject.get("response").equals("0")) { // password wrong 
                 Platform.runLater(() -> {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText("This Password is wrong.");
                    alert.showAndWait();
                });
            }
            System.out.println("is Chick     " + isCheck);

        } catch (Exception ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isCheck;
    }
}
