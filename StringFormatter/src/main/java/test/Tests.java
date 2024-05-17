package test;

import org.example.*;
import org.example.interfaces.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests {

    @Test
    public void Test_WithQuotations(){
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
    public void Test_WithText(){
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
    public void Test_WithQuotationsAndText(){
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
