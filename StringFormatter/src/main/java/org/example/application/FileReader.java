package org.example.application;

import com.ibm.jvm.dtfjview.tools.utils.FileUtils;
import org.example.interfaces.IReader;

import java.io.BufferedReader;
import java.io.IOException;

public class FileReader implements IReader {

    private final java.io.FileReader reader;

    public FileReader(java.io.FileReader reader){
        this.reader = reader;
    }

    @Override
    public int read() throws IOException {
        return reader.read();
    }

    @Override
    public boolean hasNext() throws IOException {
        return reader.read() >= 0;
    }

    @Override
    public void setData(String data) {
        //not implemented
    }
}
