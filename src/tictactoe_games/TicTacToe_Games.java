
package tictactoe_games;

import controller.RequestToServer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class TicTacToe_Games extends Application {
    
    private static Stage stageX;

    public static Stage getStageX() {
        return stageX;
    }
    
    
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/view/FXMLHome.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("TieTacToe Game");
        stage.initStyle(StageStyle.UTILITY);
        stageX = stage;
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
