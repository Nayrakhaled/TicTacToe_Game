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
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import org.json.JSONException;
import org.json.JSONObject;
import tictactoe_games.TicTacToe_Games;

/**
 *
 * @author AM STORE
 */
public class RequestToServer {

    public Socket socket;
    private DataInputStream dataInputStream;
    private PrintStream printStream;
    public static RequestToServer requestToServer = null;
    public static String messageFromTheServer = null;
    

    public static RequestToServer createRequest() {
        if (requestToServer == null) {
            requestToServer = new RequestToServer();
        }
        return requestToServer;

    }
    
   

    public void sendToServer(JSONObject message) {

        if (socket != null) {
            System.out.println("Request " + message);
            printStream.println(message);
        } else {
            System.out.println("Socket is null");
        }

    }

    public void getFromServer() {
        try {
            socket = new Socket("127.0.0.1", 63000);
            if (socket != null) {
                printStream = new PrintStream(socket.getOutputStream());
                dataInputStream = new DataInputStream(socket.getInputStream());
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (true) {
                            try {
                                String message = dataInputStream.readLine();
                                System.out.println("Message from server " + message);
                                if (message != null) {
                                    requestToServer.getMessageJson(message);
                                }

                            } catch (IOException ex) {
                                Logger.getLogger(RequestToServer.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }).start();
            }
        } catch (IOException ex) {
            Logger.getLogger(RequestToServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getMessageJson(String message) {

        try {
            System.out.println("getMessage " + message);
            JSONObject jSONObject = new JSONObject(message);
            System.out.println("json" + jSONObject.get("Key").toString());
            int go = 0;
            switch (jSONObject.get("Key").toString()) {
                case "login":
                    go = new LoginController().checkData(message);
                    if (go == 1) {
                        Platform.runLater(() -> {
                             avaliableList();
                        System.out.println("Login client request");
                        });
                    }
                    break;
                case "Register":
                    go = new RegieterController().checkData(message);
                    if (go == 1) {
                       Platform.runLater(() -> {
                             avaliableList();
                        System.out.println("Login client request");
                        });
                    }
                    break;
                case "List":
                    Platform.runLater(() -> {
                        System.out.println("List Request");
                        messageFromTheServer =message;
                    });
                    break;
            }
        } catch (JSONException ex) {
            Logger.getLogger(RequestToServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void avaliableList() {
        try {
            System.out.println("start loading");
            Parent root = FXMLLoader.load(getClass().getResource("/view/FXMLAvailableListForm.fxml"));
            System.out.println("Finished");
            Scene scene = new Scene(root);
            TicTacToe_Games.getStageX().setScene(scene);
            TicTacToe_Games.getStageX().show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
