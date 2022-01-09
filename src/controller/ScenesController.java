package controller;

import Module.Player;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.DoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;
import jdk.nashorn.internal.runtime.arrays.ArrayLikeIterator;

public class ScenesController {

    private Stage stage;
    private Scene scene;
    private Parent parent;

    //Registration Form Component
    @FXML
    private TextField registerTxt_userName;
    private Label errorlogin_label;
    @FXML
    private PasswordField registertxt_password;
    @FXML
    private PasswordField registerTxt_ComfirmPass;
    private ImageView registerLogo;
    @FXML
    private Circle Online_CirclePlayer1;
    @FXML
    private Circle Online_CirclePlayer2;
    // @FXML
    //private  Label VSComputer;
    @FXML
    private Button Online_btnRecordung;
    private ImageView Online_RecordIImage;
    @FXML
    private ImageView OnlinePlayer1Image;
    @FXML
    private Label OnlinePlayer1UserName;
    private Label OnlinePlayer1Score;
    // Game Fom
    @FXML
    private Label gameForm1_p00;
    @FXML
    private Label gameForm1_p10;

    @FXML
    private Label label00;
    private Label label01;
    private Label label02;
    private Label label10;
    private Label label11;
    private Label label12;
    private Label label20;
    private Label label21;
    private Label label22;
    // with Computer 
    @FXML
    private Hyperlink vsPcGameForm_p00;
    @FXML
    private Hyperlink vsPcGameForm_p01;
    @FXML
    private Hyperlink vsPcGameForm_p02;
    @FXML
    private Hyperlink vsPcGameForm_p10;
    @FXML
    private Hyperlink vsPcGameForm_p11;
    @FXML
    private Hyperlink vsPcGameForm_p12;
    @FXML
    private Hyperlink vsPcGameForm_p20;
    @FXML
    private Hyperlink vsPcGameForm_p21;
    @FXML
    private Hyperlink vsPcGameForm_p22;

    @FXML
    Hyperlink test;

    @FXML
    private TextField loginTxt_userName;
    @FXML
    private TextField logintxt_password;

    @FXML
    private Label registerlabel_NotMatch;

    // other component
    private Hyperlink gameForm_p00;
    private Hyperlink gameForm_p01;
    private Hyperlink gameForm_p02;
    private Hyperlink gameForm_p10;
    private Hyperlink gameForm_p11;
    private Hyperlink gameForm_p12;
    private Hyperlink gameForm_p20;
    private Hyperlink gameForm_p21;
    private Hyperlink gameForm_p22;

    Hyperlink[][] hyperList = {{gameForm_p00, gameForm_p10, gameForm_p20},
    {gameForm_p01, gameForm_p11, gameForm_p21},
    {gameForm_p02, gameForm_p12, gameForm_p22}

    };
    private GridPane gridGame;
    private Label VSComputerPlayer2UserName;
    private Label VSComputer;
    private Label VSComputerPlayerPlayer2Score;
    private Label VSComputer_pcScore;
    String Winner = null;
    public static Player playerOnline = new Player(); // to know current user online 
    boolean isPlayerWin = false;
    int xoCounter = 0;
    String initialStart = "X";
    public static Socket socket;
    HashMap<String, String> pos = new HashMap<String, String>();

    public ScenesController() {
        // labelAViewAvailable = new Label();
        //listviewAvailable = new ListView();

    }

    public void switchToPlayVSComputer(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/FXMLPlayWithComputer.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void switchToPlayVSFriend(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/FXMLPlayWithFriend.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void switchToPlayOnline(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/FXMLPlayOnline.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void switchToRecordsList(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/RecordList.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void switchToRankList(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/Rank.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void switchToHome(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/FXMLHome.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
/*
    
    public void switchToHomeOnline(ActionEvent event) {// back to change mode(avaliable list to home to change mode 0)

        System.out.println("current online player" + playerOnline.getUserName());
        ModeController change = new ModeController();
        int result = change.changeMode(playerOnline, socket);
        System.out.println("result of mode client" + result);
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/FXMLHome.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
*/
    public void switchToChooseX_O(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/FXMLChoose_X_O.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void switchToSignup(ActionEvent event) {
        try {
            socket = new Socket("127.0.0.1", 63000);
            Parent root = FXMLLoader.load(getClass().getResource("/view/FXMLSignup.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void switchToLoginForm(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/FXMLLogin.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void goToAvailableList(ActionEvent event) {
        if (!loginTxt_userName.getText().isEmpty() && !logintxt_password.getText().isEmpty()) {
            Player player = new Player(loginTxt_userName.getText().trim(), logintxt_password.getText());
            LoginController enter = new LoginController();
            int check = enter.checkData(player, socket);
            System.out.println("Check" + check);
            if (check == 1) {
                playerOnline.setUserName(player.getUserName());
                System.out.println("player online" + playerOnline.getUserName());
                availableList(event);
                System.out.println("player online" );

            } else if (check == -1) {
                //errorlogin_label.setText("");
                errorlogin_label.setVisible(true);
                errorlogin_label.setText("Username Not Exist");
            } else if (check == 0) {
                //errorlogin_label.setText("");
                errorlogin_label.setVisible(true);
                errorlogin_label.setText("Password Not Exist");
            }
        }
    }

    public void switchToAvailableList(ActionEvent event) {
        if (!registerTxt_userName.getText().isEmpty()
                && !registertxt_password.getText().isEmpty() && !registerTxt_ComfirmPass.getText().isEmpty()) {
            if (registertxt_password.getText().equals(registerTxt_ComfirmPass.getText())) {
                Player player = new Player(registerTxt_userName.getText(), registertxt_password.getText(), registerTxt_ComfirmPass.getText());
                RegieterController enter = new RegieterController();
                boolean check = enter.checkData(player, socket);
                if (check == true) {
                    playerOnline.setUserName(player.getUserName());
                    System.out.println("player online" + player.getUserName());

                    availableList(event);

                }
            } else {
                registerlabel_NotMatch.setText("");
                registerlabel_NotMatch.setVisible(true);
                registerlabel_NotMatch.setText("Not Match");
            }
        } else {
            registerlabel_NotMatch.setText("");
            registerlabel_NotMatch.setVisible(true);
            registerlabel_NotMatch.setText("Field is emplty");
        }
    }

    public void availableList(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/FXMLAvailableListForm.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void Play1(MouseEvent event) {

        Label l1 = (Label) event.getSource();
        String id = l1.getId();
        System.out.println(l1);
        System.out.println(id);

        l1.setText(initialStart);
        l1.setOnMouseClicked(null);
        if (initialStart.equals("X")) {

            initialStart = "O";
        } else {

            initialStart = "X";

        }
    }

   

    public void play(ActionEvent event) {
        Hyperlink l = (Hyperlink) event.getSource();
        String id = l.getId();

        l.setText(initialStart);
        /*
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println(hyperList[i][j].toString());
                if (hyperList[i][j].toString() == l.getId()) {
                    hyperList[i][j].setText(initialStart);
                    System.out.println(hyperList[i][j].getText());
                    System.out.println(i + j);
                }else{
                    System.out.println("NOooooooooooooooooooooo");
                }
            }
        }*/

        if (initialStart.equals("X")) {
            l.setTextFill(Color.RED);
            initialStart = "O";
            boolean y = checkForWinner();
            clearToPlayAgain(y, event);
            xoCounter++;
        } else {
            l.setTextFill(Color.BLUE);
            initialStart = "X";
            boolean y = checkForWinner();
            clearToPlayAgain(y, event);
            xoCounter++;
        }
    }

    public boolean checkForWinner() {

        String gameGrid00 = pos.get("vsPcGameForm_p00");
        //System.out.print(gameGrid00);
        String gameGrid01 = pos.get("vsPcGameForm_p01");
        String gameGrid02 = pos.get("vsPcGameForm_p02");
        String gameGrid10 = pos.get("vsPcGameForm_p10");
        String gameGrid11 = pos.get("vsPcGameForm_p11");
        String gameGrid12 = pos.get("vsPcGameForm_p12");
        String gameGrid21 = pos.get("vsPcGameForm_p21");
        String gameGrid22 = pos.get("vsPcGameForm_p22");
        String gameGrid20 = pos.get("vsPcGameForm_p20");

        String getXorO = null;

        if (isPlayerWin == false && xoCounter < 9) {
            //System.out.print("Game continue");
/*
            // Win Column 
            for (int i = 0; i < 3; i++) {
                if (hyperList[0][i].getText().equals(hyperList[1][i].getText()) && hyperList[0][i].getText().equals(hyperList[2][i].getText()) && (!hyperList[0][i].getText().isEmpty())) {

                    getXorO = gameGrid00;
                    System.out.println("Winner");
                    isPlayerWin = true;
                }
            }
             */
            if ((vsPcGameForm_p00.getText().equals(vsPcGameForm_p10.getText())) && (vsPcGameForm_p00.getText().equals(vsPcGameForm_p20.getText())) && (!vsPcGameForm_p00.getText().isEmpty())) {

                getXorO = gameGrid00;
                System.out.println("Winner");
                isPlayerWin = true;
            } else if ((vsPcGameForm_p01.getText().equals(vsPcGameForm_p11.getText())) && (vsPcGameForm_p01.getText().equals(vsPcGameForm_p21.getText())) && (!vsPcGameForm_p01.getText().isEmpty())) {

                getXorO = gameGrid00;
                System.out.println("Winner");
                isPlayerWin = true;
            } else if ((vsPcGameForm_p02.getText().equals(vsPcGameForm_p12.getText())) && (vsPcGameForm_p02.getText().equals(vsPcGameForm_p22.getText())) && (!vsPcGameForm_p02.getText().isEmpty())) {

                getXorO = gameGrid00;
                System.out.println("Winner");
                isPlayerWin = true;
            } else if ((vsPcGameForm_p00.getText().equals(vsPcGameForm_p01.getText())) && (vsPcGameForm_p00.getText().equals(vsPcGameForm_p02.getText())) && (!vsPcGameForm_p00.getText().isEmpty())) {

                getXorO = gameGrid00;
                System.out.println("Winner");
                isPlayerWin = true;
            } else if ((vsPcGameForm_p10.getText().equals(vsPcGameForm_p11.getText())) && (vsPcGameForm_p10.getText().equals(vsPcGameForm_p12.getText())) && (!vsPcGameForm_p10.getText().isEmpty())) {

                getXorO = gameGrid00;
                System.out.println("Winner");
                isPlayerWin = true;
            } else if ((vsPcGameForm_p20.getText().equals(vsPcGameForm_p21.getText())) && (vsPcGameForm_p20.getText().equals(vsPcGameForm_p22.getText())) && (!vsPcGameForm_p20.getText().isEmpty())) {

                getXorO = gameGrid00;
                System.out.println("Winner");
                isPlayerWin = true;
            } else if ((vsPcGameForm_p20.getText().equals(vsPcGameForm_p11.getText())) && (vsPcGameForm_p20.getText().equals(vsPcGameForm_p02.getText())) && (!vsPcGameForm_p20.getText().isEmpty())) {

                getXorO = gameGrid00;
                System.out.println("Winner");
                isPlayerWin = true;
            } else if ((vsPcGameForm_p00.getText().equals(vsPcGameForm_p11.getText())) && (vsPcGameForm_p00.getText().equals(vsPcGameForm_p22.getText())) && (!vsPcGameForm_p00.getText().isEmpty())) {

                getXorO = gameGrid00;
                System.out.println("Winner");
                isPlayerWin = true;
            }
            //boolean x = true;
        }
        return isPlayerWin;
    }

    private void clearToPlayAgain(boolean x, ActionEvent event) {

        if (x == true) {
            System.out.println("Win");
            try {
                Thread.sleep(2000);
                Parent root = FXMLLoader.load(getClass().getResource("/view/FXMLWin.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
    /*
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listviewAvailable.getItems().addAll("11111111111111111", "22222222222222", "333333333333");

    }*/
}
