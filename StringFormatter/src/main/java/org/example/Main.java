package org.example;

import org.example.application.*;
import org.example.interfaces.*;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Formatter formatter = new Formatter();

        StringBuilder sb = new StringBuilder();
        IWriter writer = new StringWriter(sb);

        IReader reader = new StringReader(sb.toString());

        String result = null;
        try {
            result = formatter.format(writer, reader);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(result);
    }
}