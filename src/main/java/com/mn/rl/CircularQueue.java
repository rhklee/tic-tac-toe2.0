package com.mn.rl;

import java.util.List;

public class CircularQueue<T> {

        private List<T> list;
        private int currentPosition;

        public CircularQueue(List<T> list) {
                this.list = list;
                currentPosition = 0;
        }

        public T getNext() {
                currentPosition = (currentPosition + 1) % list.size();
                return list.get(currentPosition);
        }

        public void next() {
                currentPosition = (currentPosition + 1) % list.size();
        }

        public T getHead() {
                return list.get(0);
        }

        public T peekCurrent() {
                return list.get(currentPosition);
        }
}
