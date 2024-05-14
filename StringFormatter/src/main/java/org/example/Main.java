package org.example;

import java.util.ArrayList;
import java.util.StringJoiner;

public class Main {
    public static void main(String[] args) {
        Formatter formatter = new Formatter();

        String result = formatter.stringFormatter(formatter.reader());
        
        System.out.println(result);
    }
}