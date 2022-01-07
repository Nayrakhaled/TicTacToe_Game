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
import org.json.simple.JSONObject;

/**
 *
 * @author AM STORE
 */
public class ModeController {

    PrintStream printStream;
    DataInputStream dataInputStream;
    private int isModeChanged;


    public int changeMode(Player player, Socket socket) {
        try {
            printStream = new PrintStream(socket.getOutputStream());
            dataInputStream = new DataInputStream(socket.getInputStream());

            JSONObject file = new JSONObject();
            file.put("Key", "Mode");
            JSONObject obj = new JSONObject();
            obj.put("user", player.getUserName());
            System.out.println("file in mode" + file);
            //System.out.println("mode in json client" + player.getMode());
            //obj.put("mode", player.getMode());

            file.put("value", obj);

            printStream.println(file);

            String resultOfMode = dataInputStream.readLine();
            System.out.println("result of client" + resultOfMode);
            
            if (resultOfMode.equals("1")) {
                System.out.println("mode success");
                isModeChanged = 1;
            } else {
                System.out.println("mode fail");
                isModeChanged = 0;
            }
        } catch (IOException ex) {
            Logger.getLogger(ModeController.class.getName()).log(Level.SEVERE, null, ex);
        }
            return isModeChanged;
    }
}
