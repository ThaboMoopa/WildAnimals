package sample.Controllers;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.Domain.Person;
import sample.ReadAndWriteFile.ReadPersonScoreFile;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ResourceBundle;

public class ScoreController  implements ActionListener, Initializable {


    private ReadPersonScoreFile file;
    private ObservableList<Person> people;
    @FXML
    private TableView<Person> tblScores;

    @FXML
    private TableColumn<Person,String> col_name;

    @FXML
    private TableColumn<Person,String> col_score;


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        populateTable();

    }

    public void populateTable()
    {
        file = new ReadPersonScoreFile();
        file.openFile();
        people = file.readRecords();

        for(int i=0; i<people.size(); i++)
        {
            col_name.setCellValueFactory(new PropertyValueFactory<Person, String>("name"));
            col_score.setCellValueFactory(new PropertyValueFactory<Person, String>("score"));

            tblScores.setItems(people);
        }

        file.closeFile();
    }



}
