package Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainPageController extends Controller{

    public Button manageTeamBtn;
    public Button managePolicyBtn;
    public Button manageGameBtn;
    public MainPageController() {
    }

    @FXML
    public void manageTeamClick() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/ManageTeamUI.fxml"));
        Stage stage = getStage(loader,manageTeamBtn);
        stage.setTitle("Manage Team");
        ManageTeamController controller = loader.getController();
        controller.init();
        // showAndWait will block execution until the window closes...
        stage.showAndWait();
    }

    @FXML
    public void managePolicyClick() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/ManagePolicyUI.fxml"));
        Stage stage = getStage(loader,managePolicyBtn);
        stage.setTitle("Manage Policy");
        ManagePolicyController controller = loader.getController();
        controller.init();
        // showAndWait will block execution until the window closes...
        stage.showAndWait();
    }

    @FXML
    public void manageGameClick() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/ManageGameUI.fxml"));
        Stage stage = getStage(loader,manageGameBtn);
        stage.setTitle("Manage Game");
        ManageGameController controller = loader.getController();
        controller.init();
        // showAndWait will block execution until the window closes...
        stage.showAndWait();
    }


    public void init(String fanByUserName){
        if (fanByUserName.equals("Coach")) {
            manageGameBtn.setDisable(true);
            managePolicyBtn.setDisable(true);
            manageTeamBtn.setDisable(true);
        } else if (fanByUserName.equals("Player")) {
            manageGameBtn.setDisable(true);
            managePolicyBtn.setDisable(true);
            manageTeamBtn.setDisable(true);
        } else if (fanByUserName.equals("Referee")) {
            managePolicyBtn.setDisable(true);
            manageTeamBtn.setDisable(true);
        } else if (fanByUserName.equals("RepresentativeFootballAssociation")) {
            manageGameBtn.setDisable(true);
            manageTeamBtn.setDisable(true);
        } else if (fanByUserName.equals("SystemManager")) {
            manageGameBtn.setDisable(true);
            managePolicyBtn.setDisable(true);
            manageTeamBtn.setDisable(true);
        } else if (fanByUserName.equals("TeamManager")) {
            manageGameBtn.setDisable(true);
            managePolicyBtn.setDisable(true);
            manageTeamBtn.setDisable(true);
        } else if (fanByUserName.equals("TeamOwner")) {
            manageGameBtn.setDisable(true);
            managePolicyBtn.setDisable(true);
        } else if (fanByUserName.equals("Fan")) {
            manageGameBtn.setDisable(true);
            managePolicyBtn.setDisable(true);
            manageTeamBtn.setDisable(true);
        }
    }

}
