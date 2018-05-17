package sample.Domain;

import sample.ReadAndWriteFile.ReadAnimalFile;

import java.util.ArrayList;

/**
 * Created by thabomoopa on 12/05/2018.
 */
public class Play {

    //private Map<String,String> animals;

    private String id;
    private String name;
    private String image;
    private ArrayList<Play> animals;


    public Play()
    {

    }
    public Play(String id, String name, String image) {
        this.id = id;
        this.name = name;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ArrayList<Play> getAnimals() {
        return animals;

    }

    public void setAnimals(ArrayList<Play> animals) {
        this.animals = animals;

    }

    public static void main(String []args)
    {
        ReadAnimalFile readAnimalFile = new ReadAnimalFile();
        readAnimalFile.openFile();
        readAnimalFile.readRecords();
        readAnimalFile.closeFile();

    }
}
