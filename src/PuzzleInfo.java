//Andrew Larrazabal

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
/**
 * PuzzleInfo stores information for the senario from the puzzle1.csv
 */
public class PuzzleInfo {
    //ATTRIBUTES
    /**
     * Categories is an array of String that stores the name of each catagory.
     */
    private String[] categories;
    /**
     * Canidates is an 2d array of Strings that stores the name of canidates from each catageory.
     */
    private String[][] candidates;
    /**
     * Clues is a array of Strings that represent the clues.
     */
    private String[] clues;
    /**
     * Story is the string that holds the story.
     */
    private String story;
    /**
     * Answer is the Answer object that represents the correct answer.
     */
    private Answer answer;

    //CONSTRUCTORS
    /**
     * Default Constructor.
     * @throws FileNotFoundException
     */
    public PuzzleInfo() throws FileNotFoundException {
        this(null);
    }
    /**
     * Constructor recieves a File object that represetns the file that is being used.
     * @param puzzleInfoFile
     * @throws FileNotFoundException
     */
    public PuzzleInfo(File puzzleInfoFile) throws FileNotFoundException {
        Scanner fileReader = new Scanner(puzzleInfoFile);

        categories = fileReader.nextLine().split(",");
        candidates = new String[categories.length][];

        for (int i=0; i < categories.length; i++) {
            candidates[i] = fileReader.nextLine().split(",");
        }

        clues = fileReader.nextLine().split(",");
        story = fileReader.nextLine().replaceAll(",", "");
        
        String answerStr = "";
        
        while(fileReader.hasNextLine()) {
        	answerStr += fileReader.nextLine() + "\n";
        }
        
        answer = new Answer(answerStr);
        
        fileReader.close();
    }

    //GETTERS
    /**
     * Get method for the categories
     * @return
     */
    public String[] getCategories() {
        return categories;
    }
    /**
     * Get method for canidates.
     */
    public String[][] getCandidates() {
        return candidates;
    }
    /**
     * Get method for clues.
     * @return
     */
    public String[] getClues() {
        return clues;
    }
    /**
     * Get method for story.
     * @return
     */
    public String getStory() {
        return story;
    }
    /**
     * Get method for Answer.
     * @return
     */
    public Answer getAnswer() {
    	return answer;
    }
    /**
     * Equals method that compares the this PuzzleInfo object to another.
     * @param other
     * @return
     */
    public boolean equals(PuzzleInfo other) {
        String[] otherCategories = other.getCategories();
        String[][] otherCandidates = other.getCandidates();
        String[] otherClues = other.getClues();
        String otherStory = other.getStory();
        Answer otherAnswer = other.getAnswer();

        //Check if all the length of the arrays are the same
        if (categories.length != otherCategories.length ||
            candidates.length != otherCandidates.length || candidates[0].length != otherCandidates[0].length ||
            clues.length != otherClues.length) {
                return false;
        }

        //Check if categories are the same
        for (int i = 0; i < categories.length; i++) {
            if (!categories[i].equals(otherCategories[i])) {
                return false;
            }
        }

        //Check if candidates are the same
        for (int i = 0; i < candidates.length; i++) {
            for (int j = 0; j < candidates[0].length; j++) {
                if (!candidates[i][j].equals(otherCandidates[i][j])) {
                    return false;
                }
            }
        }

        //Check if clues are the same
        for (int i = 0; i < clues.length; i++) {
            if (!clues[i].equals(otherClues[i])) {
                return false;
            }
        }

        //Check if stories are the same
        if (!(story.equals(otherStory))) {
        	return false;
        }
        
        //Check if answers are the same and return
        return answer.equals(otherAnswer);
    } 

    @Override
    public String toString() {
        String s = "";

        s += "Categories: " + Arrays.toString(categories) + 
                         "\nCandidates: " + Arrays.deepToString(candidates) + 
                         "\nClues: " + Arrays.toString(clues) + 
                         "\nStory: " + story +
                        "\nAnswer: " + answer;

        return s;
    }
}
