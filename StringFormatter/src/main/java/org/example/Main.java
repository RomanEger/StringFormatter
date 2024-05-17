package org.example;

import org.example.interfaces.IReader;
import org.example.interfaces.IWriter;

public class Main {
    public static void main(String[] args) {
        Formatter formatter = new Formatter();

        StringBuilder sb = new StringBuilder();
        IWriter writer = new StringWriter(sb);

        IReader reader = new StringReader(sb.toString());

        String result = formatter.format(writer, reader);
        
        System.out.println(result);
    }
}