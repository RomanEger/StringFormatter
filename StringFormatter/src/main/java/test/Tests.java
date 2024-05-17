package test;

import org.example.application.Formatter;
import org.example.application.StringReader;
import org.example.application.StringWriter;
import org.example.interfaces.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests {

    @Test
    public void Test_WithSimpleCode() throws IOException {
        StringBuilder sb = new StringBuilder();
        IWriter writer = new StringWriter(sb);
        IReader reader = new StringReader("public class Foo{private int x;}");
        Formatter formatter = new Formatter();
        String result = formatter.format(writer, reader);
        assertEquals(
                "public class Foo{" +
                        "\n\tprivate int x;" +
                        "\n}",
                result);
    }

    @Test
    public void Test_WithIfElse() throws IOException{
        StringBuilder sb = new StringBuilder();
        IWriter writer = new StringWriter(sb);
        IReader reader = new StringReader(
                "package test;" +
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
        Formatter formatter = new Formatter();
        String result = formatter.format(writer, reader);
        String expected = "package test;" +
                "\npublic class Foo{" +
                "\n\tprivate int x;" +
                "\n\tpublic int getX(){" +
                "\n\t\tif(x>0){" +
                "\n\t\t\treturn x;" +
                "\n\t\t}" +
                "\n\t\telse {" +
                "\n\t\t\treturn -1;" +
                "\n\t\t}" +
                "\n\t}" +
                "\n}";

        assertEquals(
                expected,
                result);
    }

    @Test
    public void Test_WithTwoMethods() throws IOException {
        StringBuilder sb = new StringBuilder();
        IWriter writer = new StringWriter(sb);
        IReader reader = new StringReader(
                "package test;" +
                        "public class Foo{" +
                        "private int x;" +
                        "public int getX(){" +
                        "return x;" +
                        "}" +
                        "public void setX(int x){" +
                        "this.x = x;" +
                        "}" +
                        "}");
        Formatter formatter = new Formatter();
        String result = formatter.format(writer, reader);
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
    public void Test_WithQuotations() throws IOException {
        StringBuilder sb = new StringBuilder();
        IWriter writer = new StringWriter(sb);
        IReader reader = new StringReader("{{{}}}");
        Formatter formatter = new Formatter();
        String result = formatter.format(writer, reader);
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
    public void Test_WithText() throws IOException {
        StringBuilder sb = new StringBuilder();
        IWriter writer = new StringWriter(sb);
        IReader reader = new StringReader("{str;stt;stg;}");
        Formatter formatter = new Formatter();
        String result = formatter.format(writer, reader);
        assertEquals(
                "{" +
                        "\n\tstr;" +
                        "\n\tstt;" +
                        "\n\tstg;" +
                        "\n}",
                result);
    }

    @Test
    public void Test_WithQuotationsAndText() throws IOException {
        StringBuilder sb = new StringBuilder();
        IWriter writer = new StringWriter(sb);
        IReader reader = new StringReader("{str;stt;ggt;{sss;}}");
        Formatter formatter = new Formatter();
        String result = formatter.format(writer, reader);
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
}
