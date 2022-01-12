/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static controller.RequestToServer.messageFromTheServer;
import static controller.ScenesController.playerOnline;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tictactoe_games.TicTacToe_Games;

/**
 *
 * @author AM STORE
 */
public class ListController implements Initializable {

    @FXML
    private ListView listView;

    private int result;
    private String aganist;
    private AnchorPane availableForm;
    private AnchorPane playRequestForm;
    private Button btnAccept;
    private Button btnReject;
    private ArrayList<String> playerOnline;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("player onlin11111111111111111e");
       // listView.getItems().add("Hello !!!!");
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        if (messageFromTheServer != null) {

                            JSONObject jSONObject = new JSONObject(messageFromTheServer);
                            JSONArray array = (JSONArray) jSONObject.get("AvaliableList");
                            System.out.println("Message in list " + messageFromTheServer);
                            System.out.println("Message in list length" + array.length());
                            System.out.println("Message in list length" + array);
                            playerOnline = new ArrayList<>();

//                            // listView.getItems().clear();
                            Platform.runLater(() -> {
                                for (int i = 0; i < array.length(); i++) {
                                    try {
                                        // get field value from JSON Array
                                        System.out.println(array.get(i));
                                        playerOnline.add((String) array.get(i));

                                        System.out.println(playerOnline.size());
                                    } catch (JSONException ex) {
                                        Logger.getLogger(ListController.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                                for (String o : playerOnline) {
//                            if (ScenesController.playerOnline.getUserName().equals(o)) {
                                    System.out.println(o);
                                    listView.getItems().add(o);
                                }
                            });
//                            }

                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(ListController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            messageFromTheServer = null ;

                        }

                    } catch (JSONException ex) {
                        Logger.getLogger(ListController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }).start();
    }

//    public void showList(String message) {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (true) {
//                    try {
//                        JSONObject jSONObject = new JSONObject(message);
//                        JSONArray array = (JSONArray) jSONObject.get("AvaliableList");
//                        System.out.println("Message in list " + message);
//                        System.out.println("Message in list length" + array.length());
//                        System.out.println("Message in list length" + array);
//                        playerOnline = new ArrayList<>();
//
////                            // listView.getItems().clear();
//                        Platform.runLater(() -> {
//                            for (int i = 0; i < array.length(); i++) {
//                                try {
//                                    // get field value from JSON Array
//                                    System.out.println(array.get(i));
//                                    playerOnline.add((String) array.get(i));
//
//                                    System.out.println(playerOnline.size());
//                                } catch (JSONException ex) {
//                                    Logger.getLogger(ListController.class.getName()).log(Level.SEVERE, null, ex);
//                                }
//                            }
//                            for (String o : playerOnline) {
////                            if (ScenesController.playerOnline.getUserName().equals(o)) {
//                                System.out.println(o);
//                                listView.getItems().add(o);
//                            }
//                        });
////                            }
//
//                        try {
//                            Thread.sleep(2000);
//                        } catch (InterruptedException ex) {
//                            Logger.getLogger(ListController.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//
//                    } catch (JSONException ex) {
//                        Logger.getLogger(ListController.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                }
//            }
//        }).start();
//        listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
//        listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
//            @Override
//            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
//                RequestGameController requestPlay = new RequestGameController();
//                aganist = observable.getValue().toString();
//                System.out.println("Aganist" + aganist);
//                result = requestPlay.AlertRequest(ScenesController.playerOnline.getUserName(), aganist);
//                if (result == 1) {
//                    if (ScenesController.playerOnline.getUserName().equals(aganist)) {
//                        showConfirmation();
//                    } else {
//                        // Alert to wait response
//                    }
//
//                }
//
//            }
//        });
    private void showConfirmation() {

        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Select");
        alert.setHeaderText("Choose the sport you like:");

        ButtonType accept = new ButtonType("Accept");
        ButtonType reject = new ButtonType("Reject");

        // Remove default ButtonTypes
        alert.getButtonTypes().clear();

        alert.getButtonTypes().addAll(accept, reject);

        // option != null.
        Optional<ButtonType> option = alert.showAndWait();

        if (option.get() == accept) {
            System.out.println("Acceptttttttttttt");

        } else if (option.get() == reject) {
            System.out.println("rejectttttttttttt");

        }

    }

}
/*
try {
                Parent root = FXMLLoader.load(getClass().getResource("/view/FXMLChoose_X_O.fxml"));
                Scene scene = new Scene(root);
                TicTacToe_Games.getStageX().setScene(scene);
                TicTacToe_Games.getStageX().show();
            } catch (Exception e) {
                e.printStackTrace();
            }
 */
