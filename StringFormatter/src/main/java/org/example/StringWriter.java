package org.example;

import org.example.interfaces.IWriter;

import java.io.IOException;

public class StringWriter implements IWriter {

    final StringBuilder sb;

    public StringWriter(StringBuilder sb) {
        this.sb = sb;
    }

    @Override
    public void write(String data) {
        sb.append(data);
    }

    @Override
    public void write(char c) {
        sb.append(c);
    }

    @Override
    public String toString() {
        return sb.toString();
    }
}
