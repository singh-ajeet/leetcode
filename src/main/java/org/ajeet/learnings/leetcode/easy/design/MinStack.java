package org.ajeet.learnings.leetcode.easy.design;

import java.util.LinkedList;

public final class MinStack {
    private final LinkedList<Entry> buffer;

    /** initialize your data structure here. */
    public MinStack() {
        buffer = new LinkedList<>();
    }

    public void push(int x) {
        Entry entry;
        if(buffer.isEmpty()){
            entry = new Entry(x, x);
        } else {
            int min = x > buffer.getFirst().min ? buffer.getFirst().min : x;
            entry = new Entry(x, min);
        }
        buffer.addFirst(entry);
    }

    public void pop() {
        if(buffer.isEmpty())
            throw new RuntimeException("Stack is empty.");
        buffer.removeFirst();
    }

    public int top() {
        return buffer.getFirst().element;
    }

    public int getMin() {
        return buffer.getFirst().min;
    }

    private static class Entry {
        private final int element;
        private final int min;

        public Entry(int element, int min) {
            this.element = element;
            this.min = min;
        }
    }

}
