package org.example.stateMachines;

import org.example.application.Lexeme;

public enum FormatterState {
    READ{
        @Override
        public void handle(StringBuilder sb, Lexeme lexeme) {
            String lexemeStr = lexeme.getLexeme().toString();
            //if(lexemeStr.contains())
            for(Character c : arrForNewLine){
                if(lexemeStr.contains(c.toString())){
                    //nextState(ADD_NEWLINE);
                    return;
                }
            }

            //nextState(ADD_LEXEME);
        }
    },
    ADD_LEXEME{
        @Override
        public void handle(StringBuilder sb, Lexeme lexeme) {
            sb.append(lexeme.getLexeme().toString());
            //nextState(READ);//.handle(sb, lexeme);
        }
    },
    ADD_TAB{
        @Override
        public void handle(StringBuilder sb, Lexeme lexeme) {
            countTab++;
            for(int i = 0; i < countTab; i++){
                sb.append("\t");
            }
            //nextState(READ);//.handle(sb, lexeme);
        }
    },
    REMOVE_TAB{
        @Override
        public void handle(StringBuilder sb, Lexeme lexeme) {
            countTab--;
            //nextState(READ);//.handle(sb, lexeme);
        }
    },
    ADD_NEWLINE{
        @Override
        public void handle(StringBuilder sb, Lexeme lexeme) {
            sb.append("\n");
            //nextState(READ);//.handle(sb,lexeme);
        }


    };

    public FormatterState nextState(FormatterState state) {
        return state;
    }
    public abstract void handle(StringBuilder sb, Lexeme lexeme);
    protected int countTab = 0;
    protected final Character[] arrForNewLine = new Character[]{
            '{',
            '}',
            ';'
    };

    protected final char charForAddTab = '{';

    protected final char charForRemoveTab = '}';

//    protected abstract void addLexeme(StringBuilder sb, Lexeme lexeme);
}
