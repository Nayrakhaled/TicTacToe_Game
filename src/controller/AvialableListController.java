/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import static java.lang.Math.E;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import static javafx.scene.input.KeyCode.E;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author AM STORE
 */
public class AvialableListController {

    PrintStream printStream;
    DataInputStream dataInputStream;
    ArrayList<String> playerOnline;

    public AvialableListController(Socket socket) {

        try {
            printStream = new PrintStream(socket.getOutputStream());
            dataInputStream = new DataInputStream(socket.getInputStream());

        } catch (IOException ex) {
            Logger.getLogger(AvialableListController.class.getName()).log(Level.SEVERE, null, ex);
        }

        JSONObject file = new JSONObject();
        file.put("Key", "AvialableList");
        printStream.println(file);

    }

    public ArrayList<String> getPlayerOnline() {

        try {
            playerOnline = new ArrayList<>();

            String str = dataInputStream.readLine();
            System.out.println("player onlin11111111111111111e");

            if (!str.equals("1")) {
                System.out.println("player onlin11111111111111111e");

                JSONParser jsonParser = new JSONParser();
                System.out.println("xxxxxxxxxx" + str);
               
                    JSONObject jsonObject = (JSONObject) jsonParser.parse(str);
                    JSONArray jsonArray = (JSONArray) jsonObject.get("AvaliableList");

                    //Iterating the contents of the array
                    Iterator<String> iterator = jsonArray.iterator();
                    while (iterator.hasNext()) {
                        //  System.out.println(iterator.next());
                        playerOnline.add(iterator.next());
                    }
                

            }
        } catch (IOException ex) {
            // Logger.getLogger(AvialableListController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("io: No available list!");

        } catch (ParseException ex) {
            // Logger.getLogger(AvialableListController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("parse: No available list!");
        }

        return playerOnline;
    }
}
