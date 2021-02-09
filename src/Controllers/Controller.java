package Controllers;
import Client.Client;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import java.io.IOException;

public class Controller {


    public static Client client;
    static final String STYLE_SHEET = "../View/common-styles.css";


    public void stillWorkingOnIt() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setContentText("Ops.. Our system is still working on it \n" +
                " please try soon!");
        alert.showAndWait();
    }

    public void raiseAlert(RecordException e1){
        Alert alert;
        alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(e1.getErrorMessage());
        alert.showAndWait();
    }

    public Stage getStage(FXMLLoader loader, Button button) {
        Stage stage = new Stage();
        stage.initOwner(button.getScene().getWindow());
        try {
            Scene scene = new Scene(loader.load());
            scene.getStylesheets().add(getClass().getResource(STYLE_SHEET).toExternalForm());
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stage;
    }

    public void initGameIdCB(ComboBox comboBox){
        String ans = client.getGameIds();
        String[] array;
        if (ans != null) {
            array = ans.split(",");
            if (array[0].equals("Ok")) {
                for (int i = 1; i < array.length; i++) {
                    comboBox.getItems().add(array[i]);                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText(ans);
                alert.showAndWait();
            }
        }
    }

    public void setClient(Client connectToServer) {
        this.client = connectToServer;
    }
}
