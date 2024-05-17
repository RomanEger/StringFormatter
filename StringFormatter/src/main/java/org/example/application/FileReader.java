package org.example.application;

import com.ibm.jvm.dtfjview.tools.utils.FileUtils;
import org.example.interfaces.IReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileReader implements IReader {

    private final java.io.FileReader reader;
    private final File file;
    private int current = 0;
    public FileReader(File file){
        try {
            this.reader = new java.io.FileReader(file);
            this.file = file;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int read() throws IOException {
        current++;
        return reader.read();
    }

    @Override
    public boolean hasNext() throws IOException {
        return file.length() > current;
    }

    @Override
    public void setData(String data) {
        //not implemented
    }
}
