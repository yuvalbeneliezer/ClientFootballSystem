package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;


public class CreateTeamController extends Controller {

    public RequiredField requiredField2;
    public RequiredField requiredField3;
    public RequiredField requiredField4;
    public RequiredField requiredField5;
    public RequiredField requiredField6;

    public TextField teamName;
    public TextField teamBudget;
    public ComboBox cmbLeagueType2;
    public ComboBox cmbFieldType;
    public ComboBox cmbSeasonType21;


    @FXML
    public void clickOnCreateTeam(ActionEvent e) {
        requiredField2.eval();
        requiredField3.eval();
        requiredField4.eval();
        requiredField5.eval();
        requiredField6.eval();
        if ( !requiredField2.getHasErrors() && !requiredField3.getHasErrors() &&
                !requiredField4.getHasErrors() && !requiredField5.getHasErrors() && !requiredField6.getHasErrors()) {
            String ans = client.createTeam(teamName.getText(), cmbLeagueType2.getValue().toString(),
                    cmbSeasonType21.getValue().toString(), cmbFieldType.getValue().toString());
            String [] array;
            if (ans != null) {
                array = ans.split(",");
                if (array[0].equals("Ok")) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Dialog");
                    alert.setContentText("The request has been sent to the \n" +
                            " Representative Football Association!");
                    alert.showAndWait();
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText(ans);
                    alert.showAndWait();
                }
            }
        }
    }

    public void init() {

        String ans = client.getAllLeagues();
        String[] array;
        if (ans != null) {
            array = ans.split(",");
            if (array[0].equals("Ok")) {
                for (int i = 1; i < array.length; i++) {
                    this.cmbLeagueType2.getItems().add(array[i]);
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText(ans);
                alert.showAndWait();
            }
        }

        ans = client.getAllSeasons();
        String[] array1;
        if (ans != null) {
            array1 = ans.split(",");
            if (array1[0].equals("Ok")) {
                for (int i = 1; i < array1.length; i++) {
                    this.cmbSeasonType21.getItems().add(array1[i]);
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText(ans);
                alert.showAndWait();
            }
        }

        ans = client.getAllFields();
        String[] array2;
        if (ans != null) {
            array2 = ans.split(",");
            if (array2[0].equals("Ok")) {
                for (int i = 1; i < array2.length; i++) {
                    this.cmbFieldType.getItems().add(array2[i]);
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText(ans);
                alert.showAndWait();
            }
        }

    }
}