package org.example.application;

public enum FormatterState {
    WAIT{
        @Override
        public void handle(StringBuilder sb, Lexeme lexeme) {
            nextState(ADD_LEXEME);
        }
    },
    ADD_LEXEME{
        @Override
        public void handle(StringBuilder sb, Lexeme lexeme) {
            sb.append(lexeme.getLexeme().toString());
            nextState(ADD_NEWLINE);//.handle(sb, lexeme);
        }
    },
    ADD_TAB{
        @Override
        public void handle(StringBuilder sb, Lexeme lexeme) {
            countTab++;
            for(int i = 0; i < countTab; i++){
                sb.append("\t");
            }
            nextState(ADD_LEXEME);//.handle(sb, lexeme);
        }
    },
    REMOVE_TAB{
        @Override
        public void handle(StringBuilder sb, Lexeme lexeme) {
            countTab--;
            nextState(ADD_LEXEME);//.handle(sb, lexeme);
        }
    },
    ADD_NEWLINE{
        @Override
        public void handle(StringBuilder sb, Lexeme lexeme) {
            sb.append("\n");
            nextState(ADD_LEXEME);//.handle(sb,lexeme);
        }
    };

    public FormatterState nextState(FormatterState state) {
        return state;
    }
    public abstract void handle(StringBuilder sb, Lexeme lexeme);
    protected int countTab = 0;
}
