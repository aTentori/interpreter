import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        LexicalAnalyzer lex = new LexicalAnalyzer(new File("test1.lua"));
        PrintWriter output = new PrintWriter("output.txt");

        List<LuaLine> results = lex.analyze();

        for (LuaLine luaLine: results) {
            List<Lexeme> lexemes = luaLine.getLexemeList();

            output.println("{");
            for (Lexeme lexeme : lexemes) {
                output.println(lexeme.getLexeme() + ":" + lexeme.getToken());
            }
            output.println("}");
        }

        output.close();
    }


}
