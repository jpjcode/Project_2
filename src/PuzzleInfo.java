//Andrew Larrazabal

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PuzzleInfo {
    private String[] categories;
    private String[][] candidates;
    private String[] clues;
    private String story;
    private File puzzleInfoFile;
    private Answer correction;

    public PuzzleInfo() throws FileNotFoundException {
        //FIXME: adding null as a placeholder for our puzzle
        this(null);
    }

    public PuzzleInfo(File puzzleInfoFile) throws FileNotFoundException {
        Scanner fileReader = new Scanner(puzzleInfoFile);

        while (fileReader.hasNext()) {
            
        }
    }

    public String[] getCategories() {
        return categories;
    }

    public String[][] getCandidates() {
        return candidates;
    }

    public String[] getClues() {
        return clues;
    }

    public String getStory() {
        return story;
    }

    
}
