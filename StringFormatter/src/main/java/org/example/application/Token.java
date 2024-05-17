package org.example.application;

public class Token {
    private Character token;

    public Character getToken(){
        return token;
    }

    public void setToken(Character character){
        token = character;
    }

    public Token(){}

    public Token(Character character){
        setToken(character);
    }

    public Token(char character){
        setToken(character);
    }

    @Override
    public String toString() {
        return token.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Token)){
            return false;
        }
        return this.token.equals(((Token) o).token);
    }
}
