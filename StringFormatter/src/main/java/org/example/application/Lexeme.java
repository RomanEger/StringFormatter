package org.example.application;

import java.util.ArrayList;

public class Lexeme {
    private ArrayList<Token> lexeme;

    public ArrayList<Token> getLexeme() {
        return lexeme;
    }

    public void setLexeme(ArrayList<Token> newLexeme){
        lexeme = newLexeme;
    }

    public void add(Token token){
        lexeme.add(token);
    }

    public Lexeme(){}

    public Lexeme(ArrayList<Token> lexeme){
        setLexeme(lexeme);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Lexeme)){
            return false;
        }
        return this.lexeme.equals(((Lexeme) o).lexeme);
    }
}
