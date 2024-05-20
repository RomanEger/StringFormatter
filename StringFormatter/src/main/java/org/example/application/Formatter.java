package org.example.application;

import java.util.*;

public class Formatter {
    public String format(String data) {

        String[] strArray = data.split("(?=[{};])|(?<=[{};])");

        for (int i = 0; i < strArray.length; i++) {
            strArray[i] = strArray[i].trim().replaceAll("\\s+", " ");
        }

        StringBuilder sb = new StringBuilder();
        ArrayList<String> array = new ArrayList<>();

        for (int i = 0; i < strArray.length; i++) {
            sb.append(strArray[i]);
            if (strArray[i].startsWith("for")) {
                while (!strArray[i].equals("{")) {
                    sb.append(strArray[++i]);
                }
                array.add(sb.toString());
                sb.delete(0, sb.length());
            } else if (strArray[i].equals("{") || strArray[i].equals(";") || strArray[i].equals("}")) {
                array.add(sb.toString());
                sb.delete(0, sb.length());
            }
        }

        int countTab = 0;

        sb.append(array.get(0));

        String[] keyWords = new String[]{
                "if", "else", "switch",
                "for", "while", "do",
                "try", "catch",
                "class", "enum",
                "synchronized",
                "public", "private", "protected",
                "this", "base",
                "void",
                "return"
        };

        for (int i = 1; i < array.size(); i++) {
            if (array.get(i - 1).contains("{") ||
                    array.get(i - 1).contains("}") ||
                    (array.get(i - 1).contains(";") )) {

                sb.append("\n");

                if (array.get(i - 1).contains("{") && !array.get(i).contains("}")) {
                    countTab++;
                } else {
                    if (array.get(i).contains("}") && !array.get(i - 1).contains("{")
                    ) {
                        countTab--;
                    }
                }
                for (int j = 0; j < countTab; j++) {
                    sb.append("\t");
                }
            }
            sb.append(array.get(i));
        }

        return sb.toString();
    }

}
