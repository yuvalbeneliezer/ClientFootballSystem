package Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

public class CreateNewEventController extends Controller {


    public ComboBox cmbGameIDType;
    public ComboBox cmbEventType1;
    public TextArea txtDescription;
    public Button addEvent;
    public RequiredField requiredField1;
    public RequiredField requiredField2;
    public RequiredField requiredField3;

    @FXML
    public void addEvent() {
        requiredField1.eval();
        requiredField2.eval();
        requiredField3.eval();
        if (!requiredField1.getHasErrors() && !requiredField2.getHasErrors() && !requiredField3.getHasErrors()) {
            int gameID = Integer.parseInt(this.cmbGameIDType.getValue().toString());
            String ans = client.addEvent(gameID, cmbEventType1.getValue().toString(), txtDescription.getText());
            String[] array;
            if (ans != null) {
                array = ans.split(",");
                if (array[0].equals("Ok")) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setContentText("The event was adding successfully!");
                    alert.showAndWait();
                }
                else{
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText(ans);
                    alert.showAndWait();
                }
            }
        }
    }

    public void init() {
        initGameIdCB(this.cmbGameIDType);
    }
}
