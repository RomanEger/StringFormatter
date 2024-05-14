package org.example;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Formatter {
    public String stringFormatter(String data){

        char[] array = data.toCharArray();

        StringBuilder sb = new StringBuilder();
        sb.append(array[0]);

        int countTab = 0;
        for(int i = 1; i < array.length; i++){
            if(array[i-1] == '{' || array[i-1] == '}' || array[i-1] == ';'){
                sb.append("\n");

                if(array[i-1] == '{' && array[i] != '}'){
                    countTab++;
                } else if(array[i-1] == '}' || (array[i-1] == ';' && array[i] == '}')){
                    countTab--;
                }
                for(int j = 0; j < countTab; j++){
                    sb.append("\t");
                }
            }

            sb.append(array[i]);
        }

        return sb.toString();
    }

    public String reader(String path) {
        StringBuilder sb = new StringBuilder();
        try(FileInputStream fin=new FileInputStream("notes.txt"))
        {
            int i;
            while((i=fin.read())!=-1){
                sb.append(i);
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        return sb.toString();
    }

    public String reader(){
        Scanner scanner = new Scanner(System.in);
        String result = scanner.next();
        return result;
    }
}
