/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.DataInputStream;
import java.io.IOException;
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
public class RequestGameController {
    private boolean isCheck = false;
    PrintStream printStream;
    DataInputStream dataInputStream;
    
    public RequestGameController(Socket socket){
        try {
            printStream = new PrintStream(socket.getOutputStream());
            dataInputStream = new DataInputStream(socket.getInputStream());

           
            
        } catch (Exception ex) {
            Logger.getLogger(RegieterController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
       
    public int AlertRequest(String player, String aganist){
        int result = 0;
        try {
            
             JSONObject file = new JSONObject();
            file.put("Key", "requsetPlay");
            JSONObject obj = new JSONObject();
            obj.put("aganist", aganist);
           
            file.put("value", obj);

            printStream.println(file);
            System.out.println(file);
            
            String resultOfRequest = dataInputStream.readLine();
            System.out.println("result of client" + resultOfRequest);
            if(resultOfRequest.equals("false")){
                System.out.println("OK........");
                result = 1;
            }else{
                System.out.println("User is Busy");
            }
            
           
        } catch (IOException ex) {
            Logger.getLogger(RequestGameController.class.getName()).log(Level.SEVERE, null, ex);
        }
         return result;
    }
    
}
