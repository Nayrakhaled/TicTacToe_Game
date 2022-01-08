/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static controller.ScenesController.playerOnline;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;

/**
 *
 * @author AM STORE
 */
public class ListController implements Initializable {

    @FXML
    private ListView listView;
    private int result;
    private String aganist;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("player onlin11111111111111111e");
        AvialableListController list = new AvialableListController(ScenesController.socket);
        ArrayList<String> onlineList = new ArrayList<>();
        onlineList = list.getPlayerOnline();
        System.out.println(onlineList.size());
        for (String o : onlineList) {
            if (!ScenesController.playerOnline.getUserName().equals(o)) {
                System.out.println(o);
                listView.getItems().add(o);
            }
        }

        listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                RequestGameController requestPlay = new RequestGameController(ScenesController.socket);
                aganist = observable.getValue().toString();
                System.out.println("Aganist" + aganist);
                result = requestPlay.AlertRequest(ScenesController.playerOnline.getUserName(), aganist);
            }
        });
        if (result == 1) {
            if (!ScenesController.playerOnline.getUserName().equals(aganist)) {
                //Alert
                showConfirmation();
            } else {
                // Alert to wait response
                showConfirmation();
            }
        }
    }

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
