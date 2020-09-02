import java.util.List;

public class LuaLine {

    private List<Lexeme> lexemeList;

    public LuaLine(List<Lexeme> lexemeList) {
        this.lexemeList = lexemeList;
    }

    public void addLexeme(Lexeme lex) {
        lexemeList.add(lex);
    }

    public List<Lexeme> getLexemeList() {
        return lexemeList;
    }
}
