package test;

import org.example.application.Formatter;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FormaterTestCase {

    @Test
    public void Test_WithSimpleCode(){
        Formatter formatter = new Formatter();
        String result = formatter.format("public class Foo{private int x;}");
        assertEquals(
                "public class Foo{" +
                        "\n\tprivate int x;" +
                        "\n}",
                result);
    }

    @Test
    public void Test_WithIfElse(){
        Formatter formatter = new Formatter();
        String result = formatter.format("package test;" +
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
                "}");
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
        Formatter formatter = new Formatter();
        String result = formatter.format("package test;" +
                "public class Foo{" +
                "private int x;" +
                "public int getX(){" +
                "return x;" +
                "}" +
                "public void setX(int x){" +
                "this.x = x;" +
                "}" +
                "}");
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
        Formatter formatter = new Formatter();
        String result = formatter.format("package test;" +
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
        Formatter formatter = new Formatter();
        String result = formatter.format("package test;" +
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
                "}");

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
        String result = new Formatter().format("package test;" +
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
                "}");

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
        Formatter formatter = new Formatter();
        String result = formatter.format("{{{}}}");
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
        Formatter formatter = new Formatter();
        String result = formatter.format("{str;stt;stg;}");
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
        Formatter formatter = new Formatter();
        String result = formatter.format("{str;stt;ggt;{sss;}}");
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
        Formatter formatter = new Formatter();
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
}
