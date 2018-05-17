package sample.ReadAndWriteFile;

import sample.Domain.Play;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ReadAnimalFile {

        private  Scanner input;
        private  Play player;

    private static ArrayList<Play> animals = new ArrayList<Play>();

        // open file clients.txt
        public void openFile()
        {
            try
            {
                input = new Scanner(Paths.get("src/animals.txt"));
                System.out.println(input);
            }
            catch (IOException ioException)
            {
                System.err.println("Error opening file. Terminating.");
                System.exit(1);
            }
        }

        // read record from file
        public ArrayList<Play> readRecords()
        {
            try
            {
                while ( input.hasNext()) // while there is more to read
                {
                    player = new Play(input.next(),input.next(),input.next());
                    animals.add(player);

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
            return animals;
        } // end method readRecords

        // close file and terminate application
        public void closeFile()
        {
            if (input != null)
                input.close();
        }

    public ArrayList<Play> getAnimals(ArrayList<Play> animals)
    {
        return animals;
    }
    }



