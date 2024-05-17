package org.example;

import org.example.application.*;
import org.example.interfaces.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Formatter formatter = new Formatter();

        StringBuilder sb = new StringBuilder();
        File file = new File("/home/wms/Practice/text.odn");
        IWriter writer = new FileWriter(file);
        writer.write("{{{}}}");
        //IWriter writer = new StringWriter(sb);

        IReader reader = new FileReader(file);
        //IReader reader = new StringReader("{{{}}}");
        String result = null;
        try {
            result = formatter.format(writer, reader);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(result);
    }
}