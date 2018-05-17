package sample.ReadAndWriteFile;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.Domain.Person;
import sample.Domain.Play;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Observable;
import java.util.Scanner;

public class ReadPersonScoreFile {

    private Scanner input;
    private Person person;

    private static ObservableList<Person> peopleScore = FXCollections.observableArrayList();

    // open file clients.txt
    public void openFile()
    {
        try
        {
            input = new Scanner(Paths.get("src/scores.txt"));
        }
        catch (IOException ioException)
        {
            System.err.println("Error opening file. Terminating.");
            System.exit(1);
        }
    }

    // read record from file
    public ObservableList<Person> readRecords()
    {
        try
        {
            while ( input.hasNext()) // while there is more to read
            {
                person = new Person(input.next(),input.next());
                peopleScore.add(person);

                //System.out.println(person.getName());

            }
        }
        catch (NoSuchElementException elementException)
        {
            System.err.println("File improperly formed. Terminating.");
        }
        catch (IllegalStateException stateException)
        {
            System.err.println("Error reading from file. Terminating.");
        }
        return peopleScore;
    } // end method readRecords

    // close file and terminate application
    public void closeFile()
    {
        if (input != null)
            input.close();
    }

    public ObservableList<Person> getScore(ObservableList<Person> peopleScore)
    {
        return peopleScore;
    }
}
