package org.example.application;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class ReadonlyHashMap<T, K> extends HashMap<T, K> {
    @Override
    public K put(T key, K value) {
        throw new NotImplementedException();
    }

    @Override
    public void putAll(Map m) {
        throw new NotImplementedException();
    }

    @Override
    public K putIfAbsent(T key, K value) {
        throw new NotImplementedException();
    }

    @Override
    public void clear() {
        throw new NotImplementedException();
    }

    @Override
    public boolean remove(Object key, Object value) {
        throw new NotImplementedException();
    }

    @Override
    public K remove(Object key) {
        throw new NotImplementedException();
    }

    @Override
    public boolean replace(Object key, Object oldValue, Object newValue) {
        throw new NotImplementedException();
    }

    @Override
    public K replace(T key, K value) {
        throw new NotImplementedException();
    }

    @Override
    public void replaceAll(BiFunction function) {
        throw new NotImplementedException();
    }

    private boolean isInit = true;

    public void init(Map<T, K> map){
        if(!isInit)
            return;
        super.putAll(map);
        isInit = false;
    }
}
