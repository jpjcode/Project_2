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
    private Answer answer;

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
        story = fileReader.nextLine().replaceAll(",", "");
        
        String answerStr = "";
        
        while(fileReader.hasNextLine()) {
        	answerStr += fileReader.nextLine() + "\n";
        }
        
        answer = new Answer(answerStr);
        
        fileReader.close();
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
    
    public Answer getAnswer() {
    	return answer;
    }

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
