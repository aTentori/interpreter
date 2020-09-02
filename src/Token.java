public enum Token {

    NOT_DEFINED("", 0),
    ID("[a-zA-Z]", 1),
    LITERAL_INTEGER("[0-9]+", 2),
    ASSIGNMENT_OPERATOR("=", 3),
    LE_OPERATOR("<=", 4),
    LT_OPERATOR("<", 5),
    GE_OPERATOR(">=", 6),
    GT_OPERATOR(">", 7),
    EQ_OPERATOR("==", 8),
    NE_OPERATOR("~=", 9),
    ADD_OPERATOR("\\+", 10),
    SUB_OPERATOR("-", 11),
    MUL_OPERATOR("\\*", 12),
    DIV_OPERATOR("/", 13),
    MOD_OPERATOR("%", 14),
    EXP_OPERATOR("^", 15),

    FUNCTION("function", 27),
    END("end", 28);


    private String regex;
    private int id;
    Token(String regex, int id) {
        this.regex = regex;
        this.id = id;
    }

    public String getValue() {
        return regex;
    }

    public static Token getToken(String target) {
        for (Token token : Token.values()) {
            if (target.matches(token.getValue())) {
                return token;
            }
        }
        return Token.NOT_DEFINED;
    }

}
