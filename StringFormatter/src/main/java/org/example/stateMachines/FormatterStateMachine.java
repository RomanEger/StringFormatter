package org.example.stateMachines;

import org.example.application.Lexeme;

public class FormatterStateMachine {
    private enum state {addLexeme, addLineBreak, addCountTab, removeCountTab, addLoop};
    private state status = state.addLexeme;
    private int countTab;
    
    public void hande(Lexeme[] lexemes, StringBuilder sb){
        int i = 0;
        int countBraceInLoop = 0;
        while(i < lexemes.length){
            String lexeme = lexemes[i].getLexeme().toString();
            String prevLexeme = i > 0 ? lexemes[i - 1].getLexeme().toString() : "";
            switch (status){
                case addLexeme:{
                    if((prevLexeme.contains("for (") || prevLexeme.contains("for(")) && lexeme.contains(";")) {
                        countBraceInLoop++;
                        status = state.addLoop;
                    }
                    else if(lexeme.contains("{") || lexeme.contains("}") || lexeme.contains(";"))
                        status = state.addLineBreak;
                    
                    if(lexeme.contains("}")) {
                        for (int j = 0; j < countTab-1; j++) {
                            sb.append("\t");
                        }
                    }
                    else if(prevLexeme.contains(";") || prevLexeme.contains("{") || prevLexeme.contains("}")) {
                        for (int j = 0; j < countTab; j++) {
                            sb.append("\t");
                        }
                    }
                    sb.append(lexeme);
                    i++;
                    break;
                }
                case addLineBreak:{
                    sb.append("\n");
                    
                    if(prevLexeme.contains("{"))
                        status = state.addCountTab;
                    else if(prevLexeme.contains("}"))
                        status = state.removeCountTab;
                    else
                        status = state.addLexeme;
                    
                    break;
                }
                case addCountTab:{
                    countTab++;
                    status = state.addLexeme;
                    break;
                }
                case removeCountTab:{
                    countTab--;
                    status = state.addLexeme;
                    break;
                }
                case addLoop: {
                    char[] chars = lexeme.toCharArray();
                    for (char aChar : chars) {
                        if (aChar == '(')
                            countBraceInLoop++;
                        else if (aChar == ')')
                            countBraceInLoop--;
                    }
                    if(countBraceInLoop == 0)
                        status = state.addLexeme;
                    sb.append(lexeme);
                    i++;
                    break;
                }
                default:
                    break;
            }
        }
    }
}
