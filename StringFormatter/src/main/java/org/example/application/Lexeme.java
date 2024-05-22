package org.example.application;

import java.util.ArrayList;
import java.util.HashMap;

public class Lexeme {
    private final char[] keySymbols = new char[]{
            '{',
            '}',
            ';',
            '(',
            ')'
    };


    private HashMap<HashMap<String, >, String> map;

    private StringBuilder lexeme = new StringBuilder();

    public StringBuilder getLexeme() {
        return lexeme;
    }

    public void add(Character token) {
        lexeme.append(token);
    }

    public Lexeme() {

    }

    public Lexeme(StringBuilder lexeme) {
        this();
        this.lexeme = lexeme;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Lexeme)) {
            return false;
        }
        return this.lexeme.toString().contentEquals(((Lexeme) o).lexeme);
    }
}
