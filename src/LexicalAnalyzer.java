import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LexicalAnalyzer {

    private File programFile;
    private Scanner input;

    public LexicalAnalyzer(File programFile) throws FileNotFoundException {
        this.programFile = programFile;
        input = new Scanner(programFile);
    }

    public List<LuaLine> analyze() {

        int lineCount = 0;
        List<LuaLine> luaLines = new ArrayList<>();
        // Iterate through file line by line
        while (input.hasNext()) {
            String sourceLine = input.nextLine();
            String[] parts = sourceLine.split(" ");
            ArrayList<String> partList = new ArrayList<>(Arrays.asList(parts));
            int partIndex = 0;
            List<Lexeme> lexemes = new ArrayList<>();
            for (String part : partList) {
                if (Token.getToken(part) != Token.NOT_DEFINED)
                    lexemes.add(new Lexeme(Token.getToken(part), part));
                else { // look ahead
                    if (partList.indexOf(part) + 1 < partList.size() && Token.getToken(partList.get(partList.indexOf(part) + 1)) == Token.ASSIGNMENT_OPERATOR) {
                        lexemes.add(new Lexeme(Token.ID, part));
                    }
                }
                partIndex++; // Increment part index
            }
            luaLines.add(new LuaLine(lexemes));
            lineCount++;

        }
        return luaLines;
    }

    private void displayArray(String[] parts) {
        for (String part: parts) {
            System.out.println(part);
        }
    }


}
