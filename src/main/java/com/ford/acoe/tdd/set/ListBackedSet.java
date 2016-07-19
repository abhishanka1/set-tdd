package com.ford.acoe.tdd.set;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by mikesmithson on 7/18/16.
 */
public class ListBackedSet<T> {
    private List<T> list = new ArrayList<>();

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public boolean add(T element) {
        if (list.contains(element) || element == null) {
            return false;
        }
        return list.add(element);
    }

    public void clear() {
        list.clear();
    }

    public int size() {
        return list.size();
    }

    public boolean contains(T element) {
        return list.contains(element);
    }

    public boolean remove(T element) {
        return list.remove(element);
    }

    public <T> T[] toArray(T[] type) {
        return list.toArray(type);
    }

    public Object[] toArray() {
        return list.toArray();
    }

    public void addAll(Collection<? extends T> listWithDuplicates) {
        for (T element : listWithDuplicates) {
            if (!contains(element)) {
                list.add(element);
            }
        }
    }
}
