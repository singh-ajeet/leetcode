package org.ajeet.learnings.leetcode.queue;

public final class Queue<T> {
    private final Object[] buffer;
   // private final int capacity;
    private int size = 0;
    private int front = 0;
    private int rear = -1;

    public Queue(int capacity) {
        if(capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than 0.");
        }
        this.buffer = new Object[capacity];
    }

    public void enQueue(T element){
        if(isFull()){
            throw new RuntimeException("Queue is full.");
        }

        rear = rear % buffer.length;
        buffer[rear++] = element;
        size++;
    }

    public T deQueue(){
        if(isEmpty()){
            throw new RuntimeException("Queue is empty.");
        }

        front = front % buffer.length;
        T element = (T) buffer[front];
        buffer[front++] = null;
        size--;

        return element;
    }

    public boolean isFull() {
        return size == buffer.length;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public T front() {
        if(isEmpty()){
            throw new RuntimeException("Queue is empty.");
        }

        front = front % buffer.length;
        return (T) buffer[front];
    }

    public T rear() {
        if(isEmpty()){
            throw new RuntimeException("Queue is empty.");
        }

        rear = rear % buffer.length;
        return (T) buffer[rear];
    }
}
