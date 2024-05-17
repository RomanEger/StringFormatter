package org.example;

import org.example.interfaces.IReader;

public class StringReader implements IReader {

    int length;
    int current = 0;
    String data;

    public StringReader(String data){
        setData(data);
    }

    public void setData(String data){
        this.data = data;
        length = data.length();
    }

    @Override
    public int read() {
        if(!hasNext()){
            return -1;
        }
        return data.charAt(current++);
    }

    @Override
    public boolean hasNext() {
        return current < length;
    }
}
