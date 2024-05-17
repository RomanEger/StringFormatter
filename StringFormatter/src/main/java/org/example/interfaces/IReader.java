package org.example.interfaces;

import java.io.IOException;
import java.io.InputStream;

public interface IReader {
    boolean hasNext() throws IOException;

    int read() throws IOException;

    void setData(String data);
}
