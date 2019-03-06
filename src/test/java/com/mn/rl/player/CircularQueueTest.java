package com.mn.rl.player;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mn.rl.player.CircularQueue;

public class CircularQueueTest {

        private static CircularQueue<Integer> cq;

        @BeforeEach
        public void setup() {
                List<Integer> list = new ArrayList<>();
                list.add(9);
                list.add(10);
                list.add(11);
                cq = new CircularQueue<>(list);
        }

        @Test
        public void test_get_head_initialized_circular_queue() {
                assertEquals(9, cq.getHead());
        }

        @Test
        public void peek_current_init_is_head_value() {
                assertEquals(9, cq.peekCurrent());
        }

        @Test
        public void test_next() {
                cq.next();
                assertEquals(10, cq.peekCurrent());
        }

        // @Test
        // public void test_get_next() {
        //
        // assertAll(() -> assertEquals(9, cq.getNext()),
        // () -> assertEquals(10, cq.getNext()),
        // () -> assertEquals(11, cq.getNext()),
        // () -> assertEquals(9, cq.getNext()),
        // () -> assertEquals(10, cq.getNext()),
        // () -> assertEquals(11, cq.getNext()),
        // () -> assertEquals(9, cq.getNext()));
        // }
}
