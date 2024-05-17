package org.example;

import com.sun.xml.internal.fastinfoset.util.CharArray;
import org.example.interfaces.IReader;
import org.example.interfaces.IWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Formatter {
    public String format(IWriter writer, IReader reader){
        List<Character> array = new ArrayList<>();

        if(!reader.hasNext()){
            writer.write(new Scanner(System.in).next());
            reader.setData(writer.toString());
        }

        while(reader.hasNext()){
            try {
                array.add((char)reader.read());
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }


        StringBuilder sb = new StringBuilder();
        sb.append(array.get(0));

        int countTab = 0;
        for(int i = 1; i < array.stream().count(); i++){
            if(array.get(i-1) == '{' || array.get(i-1) == '}' || array.get(i-1) == ';'){
                sb.append("\n");

                if(array.get(i-1) == '{' && array.get(i) != '}'){
                    countTab++;
                } else if(array.get(i-1) == '}' || (array.get(i-1) == ';' && array.get(i) == '}')){
                    countTab--;
                }
                for(int j = 0; j < countTab; j++){
                    sb.append("\t");
                }
            }

            sb.append(array.get(i));
        }

        return sb.toString();
    }


}
