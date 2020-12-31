package org.ajeet.learnings.leetcode.queue;

class MyCircularQueue {
    private final int[] buffer;
    private int size = 0;
    private int front = 0;
    private int rear = -1;

    public MyCircularQueue(int capacity) {
        if(capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than 0.");
        }
        this.buffer = new int[capacity];
    }

    public boolean enQueue(int element){
        if(isFull()){
            // throw new RuntimeException("Queue is full.");
            return false;
        }

        rear++;
        rear = rear % (buffer.length);
        buffer[rear] = element;
        size++;
        return true;
    }

    public boolean deQueue(){
        if(isEmpty()){
            //throw new RuntimeException("Queue is empty.");
            return false;
        }
        front = front % (buffer.length);
        buffer[front++] = 0;
        size--;

        return true;
    }

    public boolean isFull() {
        return size == buffer.length;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int Front() {
        if(isEmpty()){
            return -1;
        }
        front = front % (buffer.length);
        return buffer[front];
    }

    public int Rear() {
        if(isEmpty()){
            return -1;
        }

        rear = rear % (buffer.length);
        return buffer[rear];
    }

    public static void main(String[] args) {
        MyCircularQueue queue = new MyCircularQueue(3);
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);

        System.out.println(queue.Rear());
        System.out.println(queue.isFull());

        queue.deQueue();
        queue.enQueue(4);

        System.out.println(queue.Rear());
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */