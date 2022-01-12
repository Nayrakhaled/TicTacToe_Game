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
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author AM STORE
 */
public class ModeController {

   
    private int isModeChanged;


    
    public void ChangeMode(Player player){
        JSONObject file;
    try {
            file = new JSONObject();   
            file.put("Key", "mode");
            JSONObject obj = new JSONObject();
            obj.put("user", player.getUserName());
            obj.put("mode", player.getPassword());
            
            file.put("value", obj);
            
            System.out.println("json file "+ file);
            RequestToServer request = RequestToServer.createRequest();
            request.sendToServer(file);
            
        } catch (JSONException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
