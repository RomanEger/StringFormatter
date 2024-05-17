package org.example;

import org.example.application.*;
import org.example.interfaces.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Formatter formatter = new Formatter();
        
        File file = new File("/home/wms/Practice/text.odn");
        
        IWriter writer = new FileWriter(file);
        writer.write("{{{}}}");
        
        IReader reader = new FileReader(file);
        ArrayList<Character> chars = new ArrayList<>();
        while (reader.hasNext()) {
            chars.add((char)reader.read());
        }
        
        StringBuilder sb = new StringBuilder();
        for(Character c : chars) {
            sb.append(c);
        }
        
        String result = formatter.format(sb.toString());

        System.out.println(result);
    }
}