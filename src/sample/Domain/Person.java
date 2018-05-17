package sample.Domain;

import sample.ReadAndWriteFile.ReadPersonScoreFile;

/**
 * Created by thabomoopa on 12/05/2018.
 */
public class Person {


    private String name;
    private String score;

    public Person()
    {

    }

    public Person(String name, String score)
    {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public static void main(String[] args)
    {
        ReadPersonScoreFile file = new ReadPersonScoreFile();
        file.openFile();
        file.readRecords();
        file.closeFile();
    }
}
