package org.example.application;

import org.example.interfaces.*;

import java.io.IOException;
import java.util.*;

public class Formatter {
    public String format(IWriter writer, IReader reader) throws IOException {
        Lexeme lexeme = new Lexeme(new ArrayList<>());

        if(!reader.hasNext()){
            writer.write(new Scanner(System.in).next());
            reader.setData(writer.toString());
        }

        while(reader.hasNext()){
            try {
                lexeme.add(new Token((char)reader.read()));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(lexeme.getLexeme().get(0));

        int countTab = 0;
        for(int i = 1; i < lexeme.getLexeme().stream().count(); i++){
            if((lexeme.getLexeme().get(i - 1).equals(new Token('{'))) ||
                    (lexeme.getLexeme().get(i - 1).equals(new Token('}'))) ||
                    (lexeme.getLexeme().get(i - 1).equals(new Token(';')))){
                sb.append("\n");

                if(lexeme.getLexeme().get(i-1).equals(new Token('{')) &&
                        !lexeme.getLexeme().get(i).equals(new Token('}'))){
                    countTab++;
                } else if(lexeme.getLexeme().get(i-1).equals(new Token('}')) ||
                        (lexeme.getLexeme().get(i-1).equals(new Token(';')) &&
                                lexeme.getLexeme().get(i).equals(new Token('}')))){
                    countTab--;
                }
                for(int j = 0; j < countTab; j++){
                    sb.append("\t");
                }
            }

            sb.append(lexeme.getLexeme().get(i));
        }

        return sb.toString();
    }
}
