package ru.basharin;

public class MyArrayList {
    private int defaultCapacity = 16;
    private Object[] data;
    private int size;

    public MyArrayList() {
        this.data = new Object[defaultCapacity];
    }

    public MyArrayList(int capacity) {
        if (capacity > 0) {
            this.data = new Object[capacity];
        } else {
            this.data = new Object[defaultCapacity];
        }
    }

    public boolean add(Object o) {
        if (size == data.length) {
            remove();
            data[data.length - 1] = o;
            return true;
        }
        data[size++] = o;

        return true;
    }

    public Object getIndex(int index) {
        checkSize(index);
        return MyArrayList.this.data[index];
    }

    public Object getValue(Object o) {
        for (int i =0; i<data.length; i++) {
            if (o.equals(data[i])) {
                return data[i];
            }
        }
        return o;
    }

    public boolean delete(Object o) {
        for (int i = 0; i< size; i++) {
            if (o.equals(data[i])) {
                System.arraycopy(data, i+1, data, i, size-i-1);
                data[--size]=null;
            }
        }
        return true;
    }

    public int getSize() {
        return size;
    }

    private void remove() {
        int numMoved = size - 1;
        System.arraycopy(data, 1, data, 0, numMoved);
    }

    private void checkSize(int index) {
        if (index>size || index<0) {
            throw new IndexOutOfBoundsException("Index not found");
        }
    }
}
