package org.example.interfaces;

import java.io.IOException;

public interface IWriter {
    void write(String data) throws IOException;
    void write(char c) throws IOException;
}
