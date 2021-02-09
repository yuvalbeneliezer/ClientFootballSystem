package Controllers;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextInputControl;

/**
 * Created by pedro_000 on 7/2/2014.
 */
public class RequiredField extends ValidatorBase {

    public RequiredField()
    {
    }

    /***************************************************************************
     *                                                                         *
     * Methods                                                                 *
     *                                                                         *
     **************************************************************************/

    @Override
    public void eval()
    {
        if(srcControl.get() instanceof TextInputControl)
            evalTextInputField();
        else if (srcControl.get() instanceof ComboBox)
            evalComboBox();
        else if (srcControl.get() instanceof ChoiceBox)
            evalChoiceBox();
    }

    private void evalChoiceBox() {

        ChoiceBox choiceBox = (ChoiceBox) srcControl.get();

        if (choiceBox.getValue() == null || choiceBox.getValue().toString().trim().isEmpty())
            hasErrors.set(true);
        else
            hasErrors.set(false);

        onEval();
    }

    protected void evalComboBox() {
        ComboBox comboBox = (ComboBox) srcControl.get();

        if (comboBox.getValue() == null || comboBox.getValue().toString().trim().isEmpty())
            hasErrors.set(true);
        else
            hasErrors.set(false);

        onEval();
    }

    protected void evalTextInputField()
    {
        TextInputControl textField = (TextInputControl) srcControl.get();
        if (textField.getText() == null || textField.getText().equals(""))
            hasErrors.set(true);
        else
            hasErrors.set(false);

        onEval();
    }




    /***************************************************************************
     *                                                                         *
     * Properties                                                              *
     *                                                                         *
     **************************************************************************/

}
