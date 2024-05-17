package org.example;

import org.example.application.*;
import org.example.interfaces.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Formatter formatter = new Formatter();
        //File file = new File("/home/wms/Practice/text.odn");
        //IWriter writer = new FileWriter(file);
        //writer.write("{{{}}}");
        //IReader reader = new FileReader(file);
        String result = formatter.format(new Scanner(System.in).next());

        System.out.println(result);
    }
}