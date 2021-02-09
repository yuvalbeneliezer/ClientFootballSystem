package Controllers;


import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;


public class EditTeamPropertyController extends Controller {

    @FXML
    Button coach;
    @FXML
    Button player;
    @FXML
    Button teamManager;
    @FXML
    Button field;
    @FXML
    Button saveCoach;
    @FXML
    TextField coachFirstName;
    @FXML
    TextField coachLastName;
    @FXML
    ChoiceBox ETrainingCB;
    @FXML
    ChoiceBox ECoachRoleCB;
    @FXML
    ChoiceBox coachUserNameCB;
    @FXML
    Button saveTM;
    @FXML
    ChoiceBox teamManagerUserNameCB;
    @FXML
    TextField teamManagerFirstName;
    @FXML
    TextField teamManagerLastName;
    @FXML
    Button savePlayer;
    @FXML
    ChoiceBox playerUserNameCB;
    @FXML
    TextField playerFirstName;
    @FXML
    TextField playerLastName;
    @FXML
    ChoiceBox EPlayerRoleCB;
    @FXML
    Button saveField;
    @FXML
    ChoiceBox fieldNameCB;
    @FXML
    TextField fieldCity;
    @FXML
    TextField fieldCapacity;

    @FXML
    RequiredField requiredField1;
    @FXML
    RequiredField requiredField2;
    @FXML
    RequiredField requiredField3;
    @FXML
    RequiredField requiredField4;
    @FXML
    ErrorLabel e1;

    @FXML
    public void editCoach() {
        divisibleEditField();
        divisibleEditPlayer();
        divisibleEditTM();
        visibleEditCoach();
        coachUserNameCB.getItems().clear();
        String ans = client.getCoachesForTeamAtSeason(this.teamName, this.seasonYear);
        String[] array;
        if (ans != null) {
            array = ans.split(",");
            if (array[0].equals("Ok")) {
                for (int i = 1; i < array.length; i++) {
                    this.coachUserNameCB.getItems().add(array[i]);
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText(ans);
                alert.showAndWait();
            }
        }
    }

    private void visibleEditCoach() {
        saveCoach.setVisible(true);
        coachUserNameCB.setVisible(true);
        coachFirstName.setVisible(true);
        coachLastName.setVisible(true);
        ETrainingCB.setVisible(true);
        ECoachRoleCB.setVisible(true);
    }

    private void divisibleEditCoach() {
        saveCoach.setVisible(false);
        coachUserNameCB.setVisible(false);
        coachFirstName.setVisible(false);
        coachLastName.setVisible(false);
        ETrainingCB.setVisible(false);
        ECoachRoleCB.setVisible(false);
    }

    @FXML
    public void editTM() {
        divisibleEditField();
        divisibleEditPlayer();
        divisibleEditCoach();
        visibleEditTM();
        this.teamManagerUserNameCB.getItems().clear();
        String ans = client.getTeamManagersForTeamAtSeason(this.teamName, this.seasonYear);
        String[] array;
        if (ans != null) {
            array = ans.split(",");
            if (array[0].equals("Ok")) {
                for (int i = 1; i < array.length; i++) {
                    this.teamManagerUserNameCB.getItems().add(array[i]);
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText(ans);
                alert.showAndWait();
            }
        }
    }

    private void visibleEditTM() {
        saveTM.setVisible(true);
        teamManagerUserNameCB.setVisible(true);
        teamManagerFirstName.setVisible(true);
        teamManagerLastName.setVisible(true);
    }

    private void divisibleEditTM() {
        saveTM.setVisible(false);
        teamManagerUserNameCB.setVisible(false);
        teamManagerFirstName.setVisible(false);
        teamManagerLastName.setVisible(false);
    }

    @FXML
    public void editPlayer() {
        divisibleEditField();
        divisibleEditCoach();
        divisibleEditTM();
        visibleEditPlayer();
        this.playerUserNameCB.getItems().clear();
        String ans = client.getPlayersForTeamAtSeason(this.teamName, this.seasonYear);
        String[] array;
        if (ans != null) {
            array = ans.split(",");
            if (array[0].equals("Ok")) {
                for (int i = 1; i < array.length; i++) {
                    this.playerUserNameCB.getItems().add(array[i]);
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText(ans);
                alert.showAndWait();
            }
        }
    }

    private void visibleEditPlayer() {
        savePlayer.setVisible(true);
        playerUserNameCB.setVisible(true);
        playerFirstName.setVisible(true);
        playerLastName.setVisible(true);
        EPlayerRoleCB.setVisible(true);
    }

    private void divisibleEditPlayer() {
        savePlayer.setVisible(false);
        playerUserNameCB.setVisible(false);
        playerFirstName.setVisible(false);
        playerLastName.setVisible(false);
        EPlayerRoleCB.setVisible(false);
    }

    @FXML
    public void editField() {
        divisibleEditPlayer();
        divisibleEditCoach();
        divisibleEditTM();
        visibleEditField();
        this.fieldNameCB.getItems().clear();
        String ans = client.getFieldsForTeamAtSeason(this.teamName, this.seasonYear);
        String[] array;
        if (ans != null) {
            array = ans.split(",");
            if (array[0].equals("Ok")) {
                for (int i = 1; i < array.length; i++) {
                    this.fieldNameCB.getItems().add(array[i]);
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText(ans);
                alert.showAndWait();
            }
        }
    }

    private void visibleEditField() {
        saveField.setVisible(true);
        fieldNameCB.setVisible(true);
        fieldCity.setVisible(true);
        fieldCapacity.setVisible(true);
    }

    private void divisibleEditField() {
        saveField.setVisible(false);
        fieldNameCB.setVisible(false);
        fieldCity.setVisible(false);
        fieldCapacity.setVisible(false);
    }

    @FXML
    public void saveCoach() {
        requiredField1.eval();
        if (requiredField1.getHasErrors()) {
            return;
        }
        String training = null;
        Object t = this.ETrainingCB.getValue();
        if (t != null) {
            training = t.toString();
        }
        String role = null;
        Object r = this.ECoachRoleCB.getValue();
        if (r != null) {
            role = r.toString();
        }
        String ans = client.editCoachDetails(teamName, seasonYear, coachUserNameCB.getValue().toString(), coachFirstName.getText(),
                coachLastName.getText(), training, role);
        receivedFeedbackFromServer(ans);
        this.coachLastName.clear();
        this.coachFirstName.clear();
    }

    @FXML
    public void saveTM() {
        requiredField2.eval();
        if (requiredField2.getHasErrors()) {
            return;
        }
        String ans = client.editTeamManagerDetails(teamName, seasonYear, teamManagerUserNameCB.getValue().toString(),
                teamManagerFirstName.getText(),
                teamManagerLastName.getText());
        receivedFeedbackFromServer(ans);
        this.teamManagerFirstName.clear();
        this.teamManagerLastName.clear();
    }

    private void receivedFeedbackFromServer(String ans) {
        String[] array;
        if (ans != null) {
            array = ans.split(",");
            if (array[0].equals("Ok")) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("The details has been saved successfully!");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText(ans);
                alert.showAndWait();
            }
        }
    }

    @FXML
    public void savePlayer() {
        requiredField3.eval();
        if (requiredField3.getHasErrors()) {
            return;
        }
        String role = null;
        Object r = this.EPlayerRoleCB.getValue();
        if (r != null) {
            role = r.toString();
        }
        String ans = client.editPlayerDetails(teamName,seasonYear,playerUserNameCB.getValue().toString(),playerFirstName.getText(),
                    playerLastName.getText(),role);
        receivedFeedbackFromServer(ans);
        this.playerFirstName.clear();
        this.playerLastName.clear();
    }

    @FXML
    public void saveField() {
        requiredField4.eval();
        if (requiredField4.getHasErrors()) {
            return;
        }
        String ans = client.editFieldDetails(teamName,seasonYear,fieldNameCB.getValue().toString(),fieldCity.getText(),
                    fieldCapacity.getText());
        receivedFeedbackFromServer(ans);
        this.fieldCity.clear();
        this.fieldCapacity.clear();
    }

    private String teamName;
    private String seasonYear;

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void setSeasonYear(String seasonYear) {
        this.seasonYear = seasonYear;
    }
}
