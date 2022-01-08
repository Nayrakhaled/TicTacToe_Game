/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Module.Player;
import java.io.DataInputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import org.json.simple.JSONObject;

/**
 *
 * @author AM STORE
 */
public class LoginController {
    private int isCheck;
    PrintStream printStream;
    DataInputStream dataInputStream;

    public int checkData(Player player, Socket socket) {
        try {
            printStream = new PrintStream(socket.getOutputStream());
            dataInputStream = new DataInputStream(socket.getInputStream());

            JSONObject file = new JSONObject();
            file.put("Key", "Login");
            JSONObject obj = new JSONObject();
            obj.put("user", player.getUserName());
            obj.put("pass", player.getPassword());            

            file.put("value", obj);

            printStream.println(file);

            System.out.println(file);
            String resultOfLogin = dataInputStream.readLine();
            System.out.println("result of client" + resultOfLogin);
            if (resultOfLogin.equals("1")) { // Exist
                isCheck = 1;
                player.setMode(isCheck);
                ModeController mode = new ModeController();
                int result = mode.changeMode(player, socket);
                System.out.println("result of mode in client login" + result);
               
            } else if (resultOfLogin.equals("-1")) { // user not  exist
                System.out.println("NotExist");
                isCheck = -1;
            }else if(resultOfLogin.equals("0")){ // password wrong 
                isCheck = 0;
            }
        } catch (Exception ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isCheck;
    }
}
