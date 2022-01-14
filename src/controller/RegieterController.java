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
import javafx.scene.control.Alert.AlertType;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author AM STORE
 */
public class RegieterController {

    private int isCheck = 0;

    public JSONObject sendData(Player player) {

        JSONObject file = null;
        try {
            file = new JSONObject();
            file.put("Key", "Register");
            JSONObject obj = new JSONObject();
            obj.put("user", player.getUserName());
            obj.put("pass", player.getPassword());
            obj.put("confirmPass", player.getConfirmPassword());

            file.put("value", obj);

            System.out.println(file);
        } catch (JSONException ex) {
            Logger.getLogger(RegieterController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return file;
    }

    public int checkData(String message) {
        try {

            JSONObject jSONObject = new JSONObject(message);
            if (jSONObject.get("response").equals("0")) { // not insert
                System.out.println("No insert");
            } else if (jSONObject.get("response").equals("1")) { // insert success
                isCheck = 1;
            } else if (jSONObject.get("response").equals("2")) { // user exist
                System.out.println("Exist");
                Platform.runLater(() -> {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setHeaderText("This Username is Exist.");
                    alert.showAndWait();
                });
            }
        } catch (Exception ex) {
            Logger.getLogger(RegieterController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isCheck;
    }
}
