package com.mn.rl.board;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TicTacToeBoardPositionTest {

        @Test
        public void test_basic_variable_initialization() {
                BoardPosition bp = new BoardPosition();
                assertAll(() -> assertTrue(bp.isEmpty()),
                          () -> assertNull(bp.getOccupant()));
        }
}
