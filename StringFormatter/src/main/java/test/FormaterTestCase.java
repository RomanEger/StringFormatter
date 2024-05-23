package test;

import org.example.application.Formatter;
import org.example.application.Lexeme;
import org.junit.jupiter.api.Test;

import javax.xml.crypto.Data;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FormaterTestCase {

    @Test
    public void Test_WithSimpleCode(){
        String result = getResultForFsm("public class Foo{private int x;}");
        assertEquals(
                "public class Foo{" +
                        "\n\tprivate int x;" +
                        "\n}",
                result);
    }

    @Test
    public void Test_WithIfElse(){
        String data = "package test;" +
                "public class Foo{" +
                "private int x;" +
                "public int getX(){" +
                "if(x>0){" +
                "return x;" +
                "}" +
                "else {" +
                "return -1;" +
                "}" +
                "}" +
                "}";
        String result = getResultForFsm(data);
        String expected = "package test;" +
                "\npublic class Foo{" +
                "\n\tprivate int x;" +
                "\n\tpublic int getX(){" +
                "\n\t\tif(x>0){" +
                "\n\t\t\treturn x;" +
                "\n\t\t}" +
                "\n\t\telse{" +
                "\n\t\t\treturn -1;" +
                "\n\t\t}" +
                "\n\t}" +
                "\n}";

        assertEquals(
                expected,
                result);
    }

    @Test
    public void Test_WithTwoMethods(){
        String data = "package test;" +
                "public class Foo{" +
                "private int x;" +
                "public int getX(){" +
                "return x;" +
                "}" +
                "public void setX(int x){" +
                "this.x = x;" +
                "}" +
                "}";
        String result = getResultForFsm(data);
        String expected = "package test;" +
                "\npublic class Foo{" +
                "\n\tprivate int x;" +
                "\n\tpublic int getX(){" +
                "\n\t\treturn x;" +
                "\n\t}" +
                "\n\tpublic void setX(int x){" +
                "\n\t\tthis.x = x;" +
                "\n\t}" +
                "\n}";

        assertEquals(
                expected,
                result);
    }

    @Test
    public void Test_WithTwoMethodsAndIfWithReturn(){
        String data = "package test;" +
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
                "}";

        String result = getResultForFsm(data);
        String expected =
                "package test;" +
                "\npublic class Foo{" +
                "\n\tprivate int x;" +
                "\n\tpublic int getX(){" +
                "\n\t\tif(x>0){" +
                "\n\t\t\tx++;" +
                "\n\t\t}" +
                "\n\t\treturn x;" +
                "\n\t}" +
                "\n\tpublic void setX(int x){" +
                "\n\t\tthis.x = x;" +
                "\n\t}" +
                "\n}";
        assertEquals(expected, result);
    }

    @Test
    public void Test_WithTwoMethodsAndIf(){
        
        String data = "package test;" +
                "public class Foo{" +
                "private int x;" +
                "public int getX(){" +
                "return x;" +
                "}" +
                "public void setX(int x){" +
                "if(x>0){" +
                "x++;" +
                "}" +
                "int y = 5;" +
                "this.x = x;" +
                "}" +
                "}";

        String result = getResultForFsm(data);
        
        String expected =
                "package test;" +
                        "\npublic class Foo{" +
                        "\n\tprivate int x;" +
                        "\n\tpublic int getX(){" +
                        "\n\t\treturn x;" +
                        "\n\t}" +
                        "\n\tpublic void setX(int x){" +
                        "\n\t\tif(x>0){" +
                        "\n\t\t\tx++;" +
                        "\n\t\t}" +
                        "\n\t\tint y = 5;" +
                        "\n\t\tthis.x = x;" +
                        "\n\t}" +
                        "\n}";
        assertEquals(expected, result);
    }

    @Test
    public void Test_WithTwoMethodsAndForAndIf(){
        String data = "package test;" +
                "public class Foo{" +
                "private int x;" +
                "public int getX(){" +
                "for(int i = 0; i < 5; i++){" +
                "if(x>0){" +
                "x++;" +
                "}" +
                "}" +
                "return x;" +
                "}" +
                "public void setX(int x){" +
                "this.x = x;" +
                "}" +
                "}";

        String result = getResultForFsm(data);
        String expected =
                "package test;" +
                        "\npublic class Foo{" +
                        "\n\tprivate int x;" +
                        "\n\tpublic int getX(){" +
                        "\n\t\tfor(int i = 0;i < 5;i++){" +
                        "\n\t\t\tif(x>0){" +
                        "\n\t\t\t\tx++;" +
                        "\n\t\t\t}" +
                        "\n\t\t}" +
                        "\n\t\treturn x;" +
                        "\n\t}" +
                        "\n\tpublic void setX(int x){" +
                        "\n\t\tthis.x = x;" +
                        "\n\t}" +
                        "\n}";
        assertEquals(expected, result);
    }

    @Test
    public void Test_WithQuotations(){
        String result = getResultForFsm("{{{}}}");
        assertEquals(
                "{" +
                        "\n\t{" +
                        "\n\t\t{" +
                        "\n\t\t}" +
                        "\n\t}" +
                        "\n}",
                result);
    }

    @Test
    public void Test_WithText(){
        String result = getResultForFsm("{str;stt;stg;}");
        assertEquals(
                "{" +
                        "\n\tstr;" +
                        "\n\tstt;" +
                        "\n\tstg;" +
                        "\n}",
                result);
    }

    @Test
    public void Test_WithQuotationsAndText(){
        String result = getResultForFsm("{str;stt;ggt;{sss;}}");
        assertEquals(
                "{" +
                        "\n\tstr;" +
                        "\n\tstt;" +
                        "\n\tggt;" +
                        "\n\t{" +
                        "\n\t\tsss;" +
                        "\n\t}" +
                        "\n}",
                result);
    }
    
    @Test
    public void Test_WithString(){
        String data = "package test;" +
                "public class Tests{" +
                "private void helloWorld(){" +
                "if(true){" +
                "System.out.println(\"Hello world!\");" +
                "}" +
                "else{" +
                "int x=5;" +
                "}" +
                "}" +
                "}";
        String result = getResultForFsm(data);
        String expected = "package test;" +
                "\npublic class Tests{" +
                "\n\tprivate void helloWorld(){" +
                "\n\t\tif(true){" +
                "\n\t\t\tSystem.out.println(\"Hello world!\");" +
                "\n\t\t}" +
                "\n\t\telse{" +
                "\n\t\t\tint x=5;" +
                "\n\t\t}" +
                "\n\t}" +
                "\n}";
        assertEquals(expected, result);
    }

    @Test
    public void Test_WithSpaces(){
        Formatter formatter = new Formatter();
        String data = "package    test;" +
                "public class Tests{" +
                "  private void helloWorld(){" +
                " if(true){" +
                "System.out.println(\"Hello world!\");" +
                "}" +
                "else{   " +
                "int x=5;" +
                "}" +
                "}" +
                "}";
        String result = formatter.format(data);
        String expected = "package test;" +
                "\npublic class Tests{" +
                "\n\tprivate void helloWorld(){" +
                "\n\t\tif(true){" +
                "\n\t\t\tSystem.out.println(\"Hello world!\");" +
                "\n\t\t}" +
                "\n\t\telse{" +
                "\n\t\t\tint x=5;" +
                "\n\t\t}" +
                "\n\t}" +
                "\n}";
        assertEquals(expected, result);
    }

    @Test
    public void Test_Main(){
        String data = "package org.example;" +
                "import org.example.application.*;" +
                "import org.example.interfaces.*;" +
                "import java.io.File;" +
                "import java.io.IOException;" +
                "import java.util.ArrayList;" +
                "public class Main{" +
                "public static void main(String[] args) throws IOException{" +
                "Formatter formatter = new Formatter();" +
                "File file = new File(\"/home/wms/Practice/text.odn\");" +
                "IWriter writer = new FileWriter(file);" +
                "writer.write(\"some data\");" +
                "IReader reader = new FileReader(file);" +
                "ArrayList<Character> chars = new ArrayList<>();" +
                "while (reader.hasNext()){" +
                "chars.add((char)reader.read());" +
                "}" +
                "StringBuilder sb = new StringBuilder();" +
                "for(Character c : chars){" +
                "sb.append(c);" +
                "}" +
                "String result = formatter.format(sb.toString());" +
                "System.out.println(result);" +
                "}" +
                "}";
        String result = new Formatter().format(data);
        String expected = "package org.example;" +
                "\nimport org.example.application.*;" +
                "\nimport org.example.interfaces.*;" +
                "\nimport java.io.File;" +
                "\nimport java.io.IOException;" +
                "\nimport java.util.ArrayList;" +
                "\npublic class Main{" +
                "\n\tpublic static void main(String[] args) throws IOException{" +
                "\n\t\tFormatter formatter = new Formatter();" +
                "\n\t\tFile file = new File(\"/home/wms/Practice/text.odn\");" +
                "\n\t\tIWriter writer = new FileWriter(file);" +
                "\n\t\twriter.write(\"some data\");" +
                "\n\t\tIReader reader = new FileReader(file);" +
                "\n\t\tArrayList<Character> chars = new ArrayList<>();" +
                "\n\t\twhile (reader.hasNext()){" +
                "\n\t\t\tchars.add((char)reader.read());" +
                "\n\t\t}" +
                "\n\t\tStringBuilder sb = new StringBuilder();" +
                "\n\t\tfor(Character c : chars){" +
                "\n\t\t\tsb.append(c);" +
                "\n\t\t}" +
                "\n\t\tString result = formatter.format(sb.toString());" +
                "\n\t\tSystem.out.println(result);" +
                "\n\t}" +
                "\n}";
        assertEquals(expected, result);
    }
    
    private String getResultForFsm(String data){
        ArrayList<Lexeme> lexemes = new ArrayList<>();
        String[] strArray = data.split("(?=[{};])|(?<=[{};])");
        for(String str: strArray){
            lexemes.add(new Lexeme(new StringBuilder(str)));
        }
        Lexeme[] lexemesArr = new Lexeme[lexemes.size()];
        return new Formatter().format(lexemes.toArray(lexemesArr));
    }
}
