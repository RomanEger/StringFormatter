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
        int minTabs = 0;

        for(int i = 1; i < lexeme.getLexeme().size(); i++){
            if((lexeme.getLexeme().get(i - 1).equals(new Token('{'))) ||
                    (lexeme.getLexeme().get(i - 1).equals(new Token('}'))) ||
                    (lexeme.getLexeme().get(i - 1).equals(new Token(';')))){
                sb.append("\n");
                if(i == lexeme.getLexeme().size() - 1){
                    countTab = minTabs = 0;
                }
                if(lexeme.getLexeme().get(i-1).equals(new Token('{')) &&
                        !lexeme.getLexeme().get(i).equals(new Token('}'))){
                    countTab++;
                } else if(lexeme.getLexeme().get(i-1).equals(new Token('}')) ||
                        (lexeme.getLexeme().get(i-1).equals(new Token(';')) &&
                                lexeme.getLexeme().get(i).equals(new Token('}'))) &&
                                countTab > minTabs){
                    countTab--;
                }

                for(int j = 0; j < countTab; j++){
                    sb.append("\t");
                }
            }

            if(lexeme.getLexeme().get(i-1).equals(new Token(')')) &&
                    lexeme.getLexeme().get(i).equals(new Token('{'))) {
                minTabs++;
                if(countTab < minTabs){
                    countTab = minTabs;
                }
            }
            //String[] str = lexeme.getLexeme().toString().split(",");
            sb.append(lexeme.getLexeme().get(i));

            if(sb.length() < 5){
                continue;
            }

            if(lexeme.getLexeme().get(i).equals(new Token('s'))){
                String cl = sb.toString().substring(sb.length()-5);

                if(cl.equals("class")){
                    minTabs++;
                }
            }
        }

        return sb.toString();
    }
}
