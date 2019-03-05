package com.mn.rl;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class CircularQueueTest {

        @Test
        public void test_get_head_initialized_circular_queue() {
                List<Integer> list = new ArrayList<>();
                list.add(9);
                list.add(10);
                CircularQueue<Integer> cq = new CircularQueue<>(list);
                assertEquals(9, cq.getHead());
        }

        @Test
        public void test_get_next() {
                List<Integer> list = new ArrayList<>();
                list.add(9);
                list.add(10);
                list.add(11);
                CircularQueue<Integer> cq = new CircularQueue<>(list);
                assertAll(() -> assertEquals(9, cq.getNext()),
                          () -> assertEquals(10, cq.getNext()),
                          () -> assertEquals(11, cq.getNext()),
                          () -> assertEquals(9, cq.getNext()),
                          () -> assertEquals(10, cq.getNext()),
                          () -> assertEquals(11, cq.getNext()),
                          () -> assertEquals(9, cq.getNext()));
        }
}
