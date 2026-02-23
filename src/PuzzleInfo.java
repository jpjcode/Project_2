//Andrew Larrazabal

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class PuzzleInfo {
    private String[] categories;
    private String[][] candidates;
    private String[] clues;
    private String story;
    private Answer correction;

    public PuzzleInfo() throws FileNotFoundException {
        this(null);
    }

    public PuzzleInfo(File puzzleInfoFile) throws FileNotFoundException {
        Scanner fileReader = new Scanner(puzzleInfoFile);

        categories = fileReader.nextLine().split(",");
        candidates = new String[categories.length][];

        for (int i=0; i < categories.length; i++) {
            candidates[i] = fileReader.nextLine().split(",");
        }

        clues = fileReader.nextLine().split(",");
        story = fileReader.nextLine();

        //FIXME: Debugging PuzzleInfo file
        System.out.println("Categories: " + Arrays.toString(categories) + 
                         "\nCandidates: " + Arrays.deepToString(candidates) + 
                         "\nClues: " + Arrays.toString(clues) + 
                         "\nStory: " + story);
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
