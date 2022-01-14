package controller;

import Module.Player;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ScenesController {

    private Stage stage;
    private Scene scene;
    private Parent parent;

    //Registration Form Component
    private TextField registerTxt_userName;
    private Label errorlogin_label;
    private PasswordField registertxt_password;
    private PasswordField registerTxt_ComfirmPass;
    private ImageView registerLogo;
    private ImageView Online_RecordIImage;
    private Label OnlinePlayer1Score;

    // with Computer 
    private Hyperlink vsPcGameForm_p00;
    private Hyperlink vsPcGameForm_p01;
    private Hyperlink vsPcGameForm_p02;
    private Hyperlink vsPcGameForm_p10;
    private Hyperlink vsPcGameForm_p11;
    private Hyperlink vsPcGameForm_p12;
    private Hyperlink vsPcGameForm_p20;
    private Hyperlink vsPcGameForm_p21;
    private Hyperlink vsPcGameForm_p22;
    private AnchorPane withComputerWin;
    private AnchorPane withComputerForm;
    private Label pcOWinLable;
    // Play with friend form
    private AnchorPane playWithFriendForm;
    private AnchorPane withFreindWin;
    private Hyperlink withFriendGameForm_p00;
    private Hyperlink withFriendGameForm_p01;
    private Hyperlink withFriendGameForm_p02;
    private Hyperlink withFriendGameForm_p10;
    private Hyperlink withFriendGameForm_p11;
    private Hyperlink withFriendGameForm_p12;
    private Hyperlink withFriendGameForm_p20;
    private Hyperlink withFriendGameForm_p21;
    private Hyperlink withFriendGameForm_p22;
    private MediaView WinMediaPlayer;
    private Label withFriendXWinLable;
    private Label withFriendOWinLable;

    private MediaPlayer mediaPlayer;
    private Media media;

    Hyperlink test;

    @FXML
    private TextField loginTxt_userName;
    @FXML
    private TextField logintxt_password;

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
    HashMap<String, String> pos = new HashMap<String, String>();
    RequestToServer request = RequestToServer.createRequest();

    boolean turnFlag = false;
    Hyperlink game[][] = {{vsPcGameForm_p00, vsPcGameForm_p10, vsPcGameForm_p20},
    {vsPcGameForm_p01, vsPcGameForm_p11, vsPcGameForm_p21}, {vsPcGameForm_p02, vsPcGameForm_p12, vsPcGameForm_p22}};
    ;
    //Random randam = new Random();
        String[][] gameBoard = {{"a", "a", "a"}, {"a", "a", "a"}, {"a", "a", "a"}};
    @FXML
    private Label ChooseX_O_Label;
    @FXML
    private Label ChooseX_O_Lable_Qestion;
    @FXML
    private Button Choose_X_O_btn_x;
    @FXML
    private Button Choose_X_O_btn_O;
    @FXML
    private Button ChooseX_O_btnBack;
    @FXML
    private ImageView ChooseX_O_backButtonImg;

    public void handlecell1(ActionEvent event) {
        //System.out.print(vsPcGameForm_p00.getText().toString());
        if (vsPcGameForm_p00.getText().isEmpty()) {
            vsPcGameForm_p00.setText(initialStart);
            game[0][0].setText(initialStart);
            gameBoard[0][0] = initialStart;
            turnFlag = false;
            initialStart = "O";
            if (withPcCheckForWinner() == false);
            computerTurn(game);
        }
    }

    public void computerTurn(Hyperlink[][] links) {

        Move move = AIGame.easyAI(gameBoard);
        if (move.getCol() != -1) {
            links[move.getCol()][move.getRow()].setText(initialStart);
            gameBoard[move.getCol()][move.getRow()] = initialStart;
            initialStart = "X";
            turnFlag = true;
        }
    }

    @FXML
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

    @FXML
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

    @FXML
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
            //socket = new Socket("127.0.0.1", 63000);
//            TextInputDialog dialog = new TextInputDialog();
//            dialog.setTitle("Text Input Dialog");
//            dialog.setHeaderText("Look, a Text Input Dialog");
//            dialog.setContentText("Please enter IP:");
//
//// Traditional way to get the response value.
//            Optional<String> result = dialog.showAndWait();
//            if (result.isPresent()) {
//                request.getFromServer(result.get());
//            }
            request.getFromServer("127.0.0.1");
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

        System.out.println(" Socket Open ");
        System.out.println("ussername" + loginTxt_userName.getText());
        if (!loginTxt_userName.getText().isEmpty() && !logintxt_password.getText().isEmpty()) {
            Player player = new Player("hhgg", "123654");
            LoginController enter = new LoginController();
            request.sendToServer(enter.sendData(player));
            System.out.println("Login start ");
            playerOnline.setUserName(loginTxt_userName.getText().trim());
        }
    }

    public void goToList(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/FXMLAvailableListForm.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ScenesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void switchToAvailableList(ActionEvent event) {
        if (!registerTxt_userName.getText().isEmpty()
                && !registertxt_password.getText().isEmpty() && !registerTxt_ComfirmPass.getText().isEmpty()) {
            if (registertxt_password.getText().equals(registerTxt_ComfirmPass.getText())) {
                Player player = new Player(loginTxt_userName.getText().trim(), logintxt_password.getText());
                RequestToServer request = RequestToServer.createRequest();
                RegieterController enter = new RegieterController();
                request.sendToServer(enter.sendData(player));
                playerOnline.setUserName(registerTxt_userName.getText().trim());
            }
        }
    }

    public void availableList(ActionEvent event) {
        System.out.println("FXML");
        try {
            Stage stage = new Stage();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/view/FXMLAvailableListForm.fxml")));
            stage.setScene(scene);
            stage.show();
//            Parent root = FXMLLoader.load(getClass().getResource("/view/FXMLAvailableListForm.fxml"));
//            TicTacToe_Games.getStageX().getScene().setRoot(root);
//            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//            scene = new Scene(root);
//            stage.setScene(scene);
//            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void play(ActionEvent event) {
        Hyperlink l = (Hyperlink) event.getSource();
        String id = l.getId();
        l.setText(initialStart);
        l.setOnAction(null);
        //withPcCheckForWinner();
        if (initialStart.equals("X")) {
            l.setTextFill(Color.RED);
            initialStart = "O";
            xoCounter++;
        } else {
            l.setTextFill(Color.BLUE);
            initialStart = "X";
            xoCounter++;
        }
    }

    public void playWithFriend(ActionEvent event) {
        Hyperlink gameSymbol = (Hyperlink) event.getSource();
        String id = gameSymbol.getId();
        gameSymbol.setText(initialStart);
        gameSymbol.setOnAction(null);
        withFriendCheckForWinner();
        if (initialStart.equals("X")) {
            gameSymbol.setTextFill(Color.RED);
            initialStart = "O";
            xoCounter++;
        } else {
            gameSymbol.setTextFill(Color.BLUE);
            initialStart = "X";
            xoCounter++;
        }
    }

    public void withFriendCheckForWinner() {
        String getXorO = null;
        if (xoCounter < 9) { // Game not eneded
            //System.out.print("Game continue");
            if ((withFriendGameForm_p00.getText().equals(withFriendGameForm_p10.getText())) && (withFriendGameForm_p00.getText().equals(withFriendGameForm_p20.getText())) && (!withFriendGameForm_p00.getText().isEmpty())) {
                getXorO = withFriendGameForm_p00.getText();
                System.out.println("Winner");
                isPlayerWin = true;
            } else if ((withFriendGameForm_p01.getText().equals(withFriendGameForm_p11.getText())) && (withFriendGameForm_p01.getText().equals(withFriendGameForm_p21.getText())) && (!withFriendGameForm_p01.getText().isEmpty())) {
                getXorO = withFriendGameForm_p01.getText();
                System.out.println("Winner");
                isPlayerWin = true;
            } else if ((withFriendGameForm_p02.getText().equals(withFriendGameForm_p12.getText())) && (withFriendGameForm_p02.getText().equals(withFriendGameForm_p22.getText())) && (!withFriendGameForm_p02.getText().isEmpty())) {
                getXorO = withFriendGameForm_p02.getText();
                System.out.println("Winner");
                isPlayerWin = true;
            } else if ((withFriendGameForm_p00.getText().equals(withFriendGameForm_p01.getText())) && (withFriendGameForm_p00.getText().equals(withFriendGameForm_p02.getText())) && (!withFriendGameForm_p00.getText().isEmpty())) {
                getXorO = withFriendGameForm_p00.getText();
                System.out.println("Winner");
                isPlayerWin = true;
            } else if ((withFriendGameForm_p10.getText().equals(withFriendGameForm_p11.getText())) && (withFriendGameForm_p10.getText().equals(withFriendGameForm_p12.getText())) && (!withFriendGameForm_p10.getText().isEmpty())) {
                getXorO = withFriendGameForm_p10.getText();
                System.out.println("Winner");
                isPlayerWin = true;
            } else if ((withFriendGameForm_p20.getText().equals(withFriendGameForm_p21.getText())) && (withFriendGameForm_p20.getText().equals(withFriendGameForm_p22.getText())) && (!withFriendGameForm_p20.getText().isEmpty())) {
                getXorO = withFriendGameForm_p20.getText();
                System.out.println("Winner");
                isPlayerWin = true;
            } else if ((withFriendGameForm_p20.getText().equals(withFriendGameForm_p11.getText())) && (withFriendGameForm_p20.getText().equals(withFriendGameForm_p02.getText())) && (!withFriendGameForm_p02.getText().isEmpty())) {
                getXorO = withFriendGameForm_p20.getText();
                System.out.println("Winner");
                isPlayerWin = true;
            } else if ((withFriendGameForm_p00.getText().equals(withFriendGameForm_p11.getText())) && (withFriendGameForm_p00.getText().equals(withFriendGameForm_p22.getText())) && (!withFriendGameForm_p00.getText().isEmpty())) {
                getXorO = withFriendGameForm_p00.getText();
                System.out.println("Winner");
                isPlayerWin = true;
            }
        }
        if (xoCounter == 8 && isPlayerWin == false) {  // game ended without any winner 
            Alert a = new Alert(Alert.AlertType.INFORMATION, "Game ended without any winner......");
            a.show();
            xoCounter = 0;
        } else {
            if (isPlayerWin == true) {
                if (getXorO == "X") {
                    System.out.println("X is  winner");
                    playWithFriendForm.setVisible(false);
                    withFreindWin.setVisible(true);
                    String path = new File("src/Images/win.mp4").getAbsolutePath();
                    media = new Media(new File(path).toURI().toString());
                    mediaPlayer = new MediaPlayer(media);
                    WinMediaPlayer.setMediaPlayer(mediaPlayer);
                    mediaPlayer.setAutoPlay(true);
                } else {
                    System.out.println("O is  winner");
                    playWithFriendForm.setVisible(false);
                    withFreindWin.setVisible(true);
                    withFriendXWinLable.setVisible(false);
                    withFriendOWinLable.setVisible(true);
                    String path = new File("src/Images/win.mp4").getAbsolutePath();
                    media = new Media(new File(path).toURI().toString());
                    mediaPlayer = new MediaPlayer(media);
                    WinMediaPlayer.setMediaPlayer(mediaPlayer);
                    mediaPlayer.setAutoPlay(true);
                }
            }
        }
    }

    public boolean withPcCheckForWinner() {
        String getXorO = null;
        if (xoCounter < 9) { // Game not eneded
            //System.out.print("Game continue");
            if ((vsPcGameForm_p00.getText().equals(vsPcGameForm_p10.getText())) && (vsPcGameForm_p00.getText().equals(vsPcGameForm_p20.getText())) && (!vsPcGameForm_p00.getText().isEmpty())) {
                getXorO = vsPcGameForm_p00.getText();
                System.out.println("Winner");
                isPlayerWin = true;
            } else if ((vsPcGameForm_p01.getText().equals(vsPcGameForm_p11.getText())) && (vsPcGameForm_p01.getText().equals(vsPcGameForm_p21.getText())) && (!vsPcGameForm_p01.getText().isEmpty())) {
                getXorO = vsPcGameForm_p01.getText();
                System.out.println("Winner");
                isPlayerWin = true;
            } else if ((vsPcGameForm_p02.getText().equals(vsPcGameForm_p12.getText())) && (vsPcGameForm_p02.getText().equals(vsPcGameForm_p22.getText())) && (!vsPcGameForm_p02.getText().isEmpty())) {
                getXorO = vsPcGameForm_p02.getText();
                System.out.println("Winner");
                isPlayerWin = true;
            } else if ((vsPcGameForm_p00.getText().equals(vsPcGameForm_p01.getText())) && (vsPcGameForm_p00.getText().equals(vsPcGameForm_p02.getText())) && (!vsPcGameForm_p00.getText().isEmpty())) {
                getXorO = vsPcGameForm_p00.getText();
                System.out.println("Winner");
                isPlayerWin = true;
            } else if ((vsPcGameForm_p10.getText().equals(vsPcGameForm_p11.getText())) && (vsPcGameForm_p10.getText().equals(vsPcGameForm_p12.getText())) && (!vsPcGameForm_p10.getText().isEmpty())) {
                getXorO = vsPcGameForm_p10.getText();
                System.out.println("Winner");
                isPlayerWin = true;
            } else if ((vsPcGameForm_p20.getText().equals(vsPcGameForm_p21.getText())) && (vsPcGameForm_p20.getText().equals(vsPcGameForm_p22.getText())) && (!vsPcGameForm_p20.getText().isEmpty())) {
                getXorO = vsPcGameForm_p20.getText();
                System.out.println("Winner");
                isPlayerWin = true;
            } else if ((vsPcGameForm_p20.getText().equals(vsPcGameForm_p11.getText())) && (vsPcGameForm_p20.getText().equals(vsPcGameForm_p02.getText())) && (!vsPcGameForm_p20.getText().isEmpty())) {
                getXorO = vsPcGameForm_p20.getText();
                System.out.println("Winner");
                isPlayerWin = true;
            } else if ((vsPcGameForm_p00.getText().equals(vsPcGameForm_p11.getText())) && (vsPcGameForm_p00.getText().equals(vsPcGameForm_p22.getText())) && (!vsPcGameForm_p00.getText().isEmpty())) {
                getXorO = vsPcGameForm_p00.getText();
                System.out.println("Winner");
                isPlayerWin = true;
            }
        }
        if (xoCounter == 8 && isPlayerWin == false) {  // game ended without any winner 
            Alert a = new Alert(Alert.AlertType.INFORMATION, "Game ended without any winner......");
            a.show();
            xoCounter = 0;
        } else {
            if (isPlayerWin == true) {
                if (getXorO == "X") {
                    System.out.println("X is  winner");
                    Alert a = new Alert(Alert.AlertType.INFORMATION, "Player X is the Winner....");
                    a.show();
                    xoCounter = 0;

                } else {
                    System.out.println("O is  winner");
                    Alert a = new Alert(Alert.AlertType.INFORMATION, "Player O is the Winner....");
                    a.show();
                    xoCounter = 0;
                }
            }
        }
        return isPlayerWin;
    }

    public void withFriendPlayAgainGameForm(ActionEvent event) {
        withFriendClearToPlayAgain();
        isPlayerWin = false;
        xoCounter = 0;
    }

    public void withFriendPlayAgainWinForm(ActionEvent event) {
        playWithFriendForm.setVisible(true);
        withFreindWin.setVisible(false);
        withFriendClearToPlayAgain();
        isPlayerWin = false;
        xoCounter = 0;
    }

    public void withFriendBackWinForm(ActionEvent event) {
        playWithFriendForm.setVisible(true);
        withFreindWin.setVisible(false);
        withFriendGameForm_p00.setOnAction(null);
        withFriendGameForm_p10.setOnAction(null);
        withFriendGameForm_p20.setOnAction(null);
        withFriendGameForm_p10.setOnAction(null);
        withFriendGameForm_p11.setOnAction(null);
        withFriendGameForm_p12.setOnAction(null);
        withFriendGameForm_p20.setOnAction(null);
        withFriendGameForm_p21.setOnAction(null);
        withFriendGameForm_p22.setOnAction(null);
    }

    public void withFriendClearToPlayAgain() {
        withFriendGameForm_p00.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                playWithFriend(event);
            }
        });
        withFriendGameForm_p01.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                playWithFriend(event);
            }
        });
        withFriendGameForm_p02.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                playWithFriend(event);
            }
        });
        withFriendGameForm_p10.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                playWithFriend(event);
            }
        });
        withFriendGameForm_p11.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                playWithFriend(event);
            }
        });
        withFriendGameForm_p12.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                playWithFriend(event);
            }
        });
        withFriendGameForm_p20.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                playWithFriend(event);
            }
        });
        withFriendGameForm_p21.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                playWithFriend(event);
            }
        });
        withFriendGameForm_p22.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                playWithFriend(event);
            }
        });
        withFriendGameForm_p00.setText("");
        withFriendGameForm_p01.setText("");
        withFriendGameForm_p02.setText("");
        withFriendGameForm_p10.setText("");
        withFriendGameForm_p11.setText("");
        withFriendGameForm_p12.setText("");
        withFriendGameForm_p20.setText("");
        withFriendGameForm_p21.setText("");
        withFriendGameForm_p22.setText("");
    }

    public void clearToPlayAgainWinFormWithPc(ActionEvent event) {
        withComputerWin.setVisible(false);
        withComputerForm.setVisible(true);
    }

    public void withPcPlayAgainGameForm(ActionEvent event) {
        withPcClearToPlayAgain();
        isPlayerWin = false;
        xoCounter = 0;
    }

    public void withPcClearToPlayAgain() {
        vsPcGameForm_p00.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                handlecell1(event);
            }
        });
        vsPcGameForm_p10.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });
        vsPcGameForm_p20.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });
        vsPcGameForm_p10.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });
        vsPcGameForm_p11.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });
        vsPcGameForm_p12.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });
        vsPcGameForm_p20.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });
        vsPcGameForm_p21.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });
        vsPcGameForm_p22.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });
        vsPcGameForm_p00.setText("");
        vsPcGameForm_p10.setText("");
        vsPcGameForm_p20.setText("");
        vsPcGameForm_p10.setText("");
        vsPcGameForm_p11.setText("");
        vsPcGameForm_p12.setText("");
        vsPcGameForm_p20.setText("");
        vsPcGameForm_p21.setText("");
        vsPcGameForm_p22.setText("");
    }

}
