package sample.Controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Domain.Person;


import javax.imageio.IIOParam;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.IOException;

public class PersonController implements ActionListener {


    private Person person;

    private Alert alert;

    @FXML
    private Button btnPlay;

    @FXML
    private TextField txtName;


    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {

    }

    public void callNextView(ActionEvent e)
    {

        person = new Person();
        person.setName(txtName.getText());

       if(txtName.getText().isEmpty())
       {
           alert = new Alert(Alert.AlertType.ERROR, "Please enter your name before you can continue");
           alert.showAndWait();
       }
       else
       {
           String message = "Welcome " + person.getName() + " to Wild Animals. \n\nWild Animals is a game where you need to look at the picture and type in the name of the animal. \n" +
                   " \n\nGame Instructions: \n\nYou need to be able to answer all the questions within the three (3) given chances." +
                   "\nYou have 5 questions that you need to answer.\n" +
                   "Age group: \n\n8 - 13 years old.";

           alert = new Alert(Alert.AlertType.INFORMATION, message);
           alert.showAndWait();

           try{
//
               FXMLLoader loader = new FXMLLoader(getClass().getResource(
                       "../Views/PlayView.fxml"));
               Parent root = (Parent) loader.load();
               PlayController controller = loader.getController();
               controller.playerName(txtName.getText());
               Stage newStage = new Stage();
               newStage.setScene(new Scene(root,735, 680));
               newStage.show();

//               FXMLLoader loader = new FXMLLoader(getClass().getResource(
//                       "../Views/Scoring.fxml"));
//               Parent root = (Parent) loader.load();
//               //ScoreController controller = loader.getController();
//               //controller.populateTable();
//               Stage newStage = new Stage();
//               newStage.setScene(new Scene(root,735, 590));
//               newStage.show();


           }
           catch(IOException ex)
           {

           }
           txtName.setText("");
       }








    }
}
