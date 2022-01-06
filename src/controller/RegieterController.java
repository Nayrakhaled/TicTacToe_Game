/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Module.Player;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import org.json.simple.JSONObject;

/**
 *
 * @author AM STORE
 */
public class RegieterController {

    private boolean isCheck = false;
    PrintStream printStream;
    DataInputStream dataInputStream;

    public boolean checkData(Player player, Socket socket) {
        try {
            printStream = new PrintStream(socket.getOutputStream());
            dataInputStream = new DataInputStream(socket.getInputStream());

            JSONObject file = new JSONObject();
            file.put("Key", "Register");
            JSONObject obj = new JSONObject();
            obj.put("user", player.getUserName());
            obj.put("pass", player.getPassword());
            obj.put("confirmPass", player.getConfirmPassword());
            

            file.put("value", obj);

            printStream.println(file);

            System.out.println(file);
            String resultOfRegister = dataInputStream.readLine();
            System.out.println("result of client" + resultOfRegister);
            if (resultOfRegister.equals("0")) { // not insert
                System.out.println("No insert");
            } else if (resultOfRegister.equals("1")) { // insert success
                isCheck = true;
                Alert a = new Alert(AlertType.NONE);
                // action event
                EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent e) {
                        // set alert type
                        a.setAlertType(AlertType.CONFIRMATION);
                        // show the dialog
                        a.show();
                    }
                };
            } else if (resultOfRegister.equals("2")) { // user exist
                System.out.println("Exist");
            }
        } catch (Exception ex) {
            Logger.getLogger(RegieterController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isCheck;
    }

}
