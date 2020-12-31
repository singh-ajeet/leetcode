package org.ajeet.learnings.leetcode.stack;

public final class Stack<T> {
    private final Object[] buffer;
    private int index = -1;

    public Stack(int capacity) {
        if(capacity <= 0){
            throw new IllegalArgumentException("Capacity must be greater than 0.");
        }
        this.buffer = new Object[capacity];
    }

    public void push(T element){
       if(isFull()) {
           throw new RuntimeException("Stack is full.");
       }
       buffer[++index] = element;
    }

    public T pop(){
        if(isEmpty()) {
            throw new RuntimeException("Stack is empty.");
        }

        T element = (T) buffer[index];
        buffer[index] = null;
        index--;

        return element;
    }

    public boolean isFull() {
        return index == buffer.length - 1;
    }

    public boolean isEmpty(){
        return index == -1;
    }
}
