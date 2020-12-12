package org.ajeet.algorithms.concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedBlockingQueue {
    private final int capacity;
    private int size;
    private int add = -1;
    private int remove = 0;
    private Integer[] buffer;

    private final Lock lock = new ReentrantLock();
    private final Condition emptyCondition = lock.newCondition();
    private final Condition fullCondition = lock.newCondition();

    public BoundedBlockingQueue(int capacity) {
        if(capacity < 1){
            throw new IllegalArgumentException("Queue capacity must be greater than 0.");
        }

        this.capacity = capacity;
        this.buffer = new Integer[capacity];
    }

    public void enqueue(int element) throws InterruptedException {
        lock.lock();
        try{
            while(isFull()){
                emptyCondition.await();
            }
            ++add;
            if(add == capacity){
                add = 0;
            }
            buffer[add] = element;
            size++;
            fullCondition.signal();
        } finally {
            lock.unlock();
        }
    }

    public int dequeue() throws InterruptedException {
        lock.lock();
        try{
            while(isEmpty()){
                fullCondition.await();
            }
            int element = this.buffer[remove];
            this.buffer[remove++] = null;
            if(remove == capacity){
                remove = 0;
            }
            size--;
            emptyCondition.signal();
            return element;
        } finally {
            lock.unlock();
        }

    }

    private boolean isFull(){
        return size == capacity;
    }

    private boolean isEmpty(){
        return size == 0;
    }

    public int size() {
        return size;
    }
}