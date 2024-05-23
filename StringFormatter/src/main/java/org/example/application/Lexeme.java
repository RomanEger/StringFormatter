package org.example.application;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.Stream;

public class Lexeme {


    private StringBuilder lexeme = new StringBuilder();

    public StringBuilder getLexeme() {
        return lexeme;
    }

//    public boolean isNormal(){
//        if(lexeme.toString().contains()){
//            return false;
//        }
//        return true;
//    }

//    public boolean contains(Character token){
//        for(char c : keySymbols){
//            if(c == token){
//                return true;
//            }
//        }
//        return false;
//    }

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
