package sample.Controllers;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sample.Domain.Person;
import sample.Domain.Play;
import sample.ReadAndWriteFile.ReadAnimalFile;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
import javafx.scene.control.*;

/**
 * Created by thabomoopa on 12/05/2018.
 */
public class PlayController implements ActionListener, Initializable {

    private static final Object URL = "";
    private static final Object ResourceBundle = "";

    private Play play;

    private Person person;

    private ReadAnimalFile file = new ReadAnimalFile();

    private String[] answerAndImage;

    int totalCounter;
    int totalPlays = 0;

    ArrayList<Play> animals;

    SecureRandom random = new SecureRandom();

    Alert alert;


    int counter = 0;
    int score = 0;

    String name;
    @FXML
    private ImageView imageView;

    @FXML
    private Text myLabel;

    @FXML
    private TextField txtAnswer;

    @FXML
    private Button btnAnswer;

    @FXML
    private Label lblPlayerName;

    //private String val = "";



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        displayImage();
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void playerName(String name)
    {
        lblPlayerName.setText(name);
    }

    public String generateRandomAnimal(){

        String url = "";

        file.openFile();
        animals = file.readRecords();
        file.closeFile();

        SecureRandom random = new SecureRandom();
        int newIndex = random.nextInt(animals.size());
        int current = -1;

        if(newIndex == current){
            random = new SecureRandom();
            newIndex = random.nextInt(animals.size());
        }
        else{
            url = animals.get(newIndex).getImage(); //get the index of arraylist then get image
            current = newIndex;

        }
        name = animals.get(newIndex).getName();
        myLabel.setText(shuffle(name));

        return url;

    }

    public void displayImage(){

        String url = "src/sample/images/"+generateRandomAnimal();
        File file = new File(url);
        Image image = new Image(file.toURI().toString());
        imageView.setImage(image);
    }

    private static String shuffle(String sentence) {
        String[] words = sentence.split("\\s+");
        StringBuilder builder = new StringBuilder();
        for (String word : words) {
            List<Character> letters = new ArrayList<Character>();
            for (char letter : word.toCharArray()) {
                letters.add(letter);
            }
            if (letters.size() > 2) {
                Collections.shuffle(letters.subList(1, letters.size() - 1));
            }
            for (char letter : letters) {
                builder.append(letter);
            }
            builder.append(" ");
        }
        return builder.toString();
    }


    public void buttonPressed(javafx.event.ActionEvent actionEvent) {

        String name = lblPlayerName.getText();

        if(totalPlays != 6) //number of times you are questionned
        {
            if(counter<2) //Number of tries you get the whole game play
            {
                if(txtAnswer.getText().equalsIgnoreCase(name))
                {
                    score++;
                    displayImage();
                }
                else
                {
                    counter++;
                    score--;
                    totalCounter = 3 - counter;
                    alert = new Alert(Alert.AlertType.WARNING, "Your answer is wrong, you left with " + totalCounter);
                    alert.showAndWait();
                }
            }
            else
            {
                alert = new Alert(Alert.AlertType.ERROR, "You have lost! Goodbye...");
                alert.showAndWait();
                writeToFile(name, getScore(score));
                openScoreController();

            }

            txtAnswer.setText("");
        }
        else
        {


            writeToFile(name, getScore(score));
            openScoreController();
        }

        totalPlays++;

    }

    public void writeToFile(String name, int score)
    {
        try{
            String contentToAppend = "\n" + name + " " + score;
            Files.write(
                    Paths.get("src/scores.txt"),
                    contentToAppend.getBytes(),
                    StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void openScoreController()
    {
        try{

            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    "../Views/Scoring.fxml"));
            Parent root = (Parent) loader.load();
            //ScoreController controller = loader.getController();
            //controller.populateTable();
            Stage newStage = new Stage();
            newStage.setScene(new Scene(root,735, 650));
            newStage.show();

        }
        catch(IOException ex)
        {

        }
    }
    public int getScore(int Score)
    {
        if(score<0)
            score = 0;

        return score;
    }



}
