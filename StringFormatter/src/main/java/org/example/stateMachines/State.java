package org.example.stateMachines;

public class State {

    private final String[] states = new String[]{
            "WAIT",
            "NORMAL_SYMBOL",
            "KEY_SYMBOL"
    };

    public String[] getStates(){
        return states;
    }
}
