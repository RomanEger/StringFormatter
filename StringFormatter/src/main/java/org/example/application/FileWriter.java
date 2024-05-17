package org.example.application;

import org.example.interfaces.IWriter;

import java.io.File;
import java.io.IOException;

public class FileWriter implements IWriter {
    private final File file;

    private final java.io.FileWriter writer;

    public FileWriter(String filePath) throws IOException {
        file = new File(filePath);
        createIfNotExists();
        writer = new java.io.FileWriter(file);
    }

    public FileWriter(File file) throws IOException {
        this.file = file;
        createIfNotExists();
        writer = new java.io.FileWriter(this.file);
    }

    private boolean createIfNotExists() throws IOException {
        if(!file.exists()){
            return file.createNewFile();
        }
        return false;
    }

    @Override
    public void write(char c) throws IOException {
        if(file.canWrite()){
            writer.write((char)c);
        }
    }

    @Override
    public void write(String data) throws IOException {
        int length = data.length();
        for(int i = 0; i < length; i++){
            write(data.charAt(i));
        }
        writer.flush();
    }
}
