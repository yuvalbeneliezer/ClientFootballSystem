package Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;


public class ManageTeamController extends Controller {

    @FXML
    public Button createNewTeamBtn;
    public Button addTP;
    public Button removeTP;
    public Button editTP;
    public ComboBox cmbTeamNameType;
    public Button nominateTO;
    public Button nominateTM;
    public Button removeTO;
    public Button removeTM;
    public Button closeTeam;
    public RequiredField requiredField1;
    public RequiredField requiredField2;
    public ComboBox cmbSeasonType;

    @FXML
    public void teamNameCBChoose() {
        //init season DB
        cmbSeasonType.getItems().clear();
        cmbSeasonType.setVisible(true);
        String ans = client.availableSeasonsForTeam(cmbTeamNameType.getValue().toString());
        String[] array;
        if (ans != null) {
            array = ans.split(",");
            if (array[0].equals("Ok")) {
                for (int i = 1; i < array.length ; i++) {
                    this.cmbSeasonType.getItems().add(array[i]);
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText(ans);
                alert.showAndWait();
            }
        }
    }

    @FXML
    public void createNewTeam() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/CreateNewTeamUI.fxml"));
        Stage stage = getStage(loader, createNewTeamBtn);
        stage.setTitle("Create New Team");
        CreateTeamController createTeamController = loader.getController();
        createTeamController.init();
        // showAndWait will block execution until the window closes...
        stage.showAndWait();
    }

    @FXML
    public void addTeamProp() {
        stillWorkingOnIt();
    }

    @FXML
    public void removeTeamProp() {
        stillWorkingOnIt();
    }

    @FXML
    public void editTeamProp() {
        requiredField1.eval();
        requiredField2.eval();
        if (requiredField1.getHasErrors() || requiredField2.getHasErrors()) {
            return;
        }
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/EditTeamProperty.fxml"));
        Stage stage = getStage(loader, editTP);
        stage.setTitle("Edit Team Property");
        EditTeamPropertyController controller = loader.getController();
        controller.setSeasonYear(cmbSeasonType.getValue().toString());
        controller.setTeamName(cmbTeamNameType.getValue().toString());
        // showAndWait will block execution until the window closes...
        stage.showAndWait();
    }

    @FXML
    public void nominateTeamOwner() {
        stillWorkingOnIt();
    }

    @FXML
    public void nominateTeamManager() {
        stillWorkingOnIt();
    }

    @FXML
    public void removeTeamOwner() {
        stillWorkingOnIt();
    }

    @FXML
    public void removeTeamManager() {
        stillWorkingOnIt();
    }

    @FXML
    public void closeTeam() {
        stillWorkingOnIt();
    }

    public void init() {
        //init team DB
        String ans = client.getAllTeams();
        String[] array;
        if (ans != null) {
            array = ans.split(",");
            if (array[0].equals("Ok")) {
                for (int i = 1; i < array.length ; i++) {
                    this.cmbTeamNameType.getItems().add(array[i]);
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText(ans);
                alert.showAndWait();
            }
        }
    }

    public void seasonCBChoose() {

    }
}
