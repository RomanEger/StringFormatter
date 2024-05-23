package org.example.stateMachines;

import org.example.application.Lexeme;

public class FormatterStateMachine {
    private enum state {read, addLexeme, addLineBreak, addTab, removeTab};
    private state status = state.read;
    private int countTab;

    public void hande(Lexeme[] lexemes, StringBuilder sb){
        int i = 0;
        while(i < lexemes.length){
            String lexeme = lexemes[i].getLexeme().toString();
            switch (status){
                case read:{
                    if(lexeme.contains("{") || lexeme.contains("}") || lexeme.contains(";")){
                        status = state.addLineBreak;
                    }
                    else
                        status = state.addLexeme;
                    if(lexeme.contains("{"))
                        status = state.addTab;
                    else if(lexeme.contains("}"))
                        status = state.removeTab;
                    break;
                }
                case addLexeme:{
                    for(int j = 0; j < countTab; j++){
                        sb.append("\t");
                    }
                    sb.append(lexeme);
                    i++;
                    status = state.read;
                    break;
                }
                case addLineBreak:{
                    sb.append("\n");
                    status = state.read;
                    break;
                }
                case addTab:{
                    countTab++;
                    status = state.read;
                    break;
                }
                case removeTab:{
                    countTab--;
                    status = state.read;
                    break;
                }
                default:
                    break;
            }
        }
    }
}
