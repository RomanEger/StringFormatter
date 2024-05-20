package org.example;
import org.example.application.*;
import org.example.interfaces.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) throws IOException {
        Formatter formatter = new Formatter();

        File file = new File("/home/wms/Practice/text.odn");

        IWriter writer = new FileWriter(file);
        writer.write("package test;" +
                "public class Foo{" +
                "private int x;" +
                "public int getX(){" +
                "if(x>0){" +
                "x++;" +
                "}" +
                "return x;" +
                "}" +
                "public void setX(int x){" +
                "this.x = x;" +
                "}" +
                "}");

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