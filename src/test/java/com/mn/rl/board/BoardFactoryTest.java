package com.mn.rl.board;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class BoardFactoryTest {

        @Test
        public void factory_valid_initialization() {
                Board board = BoardFactory.makeTicTacToeBoard(7);
                assertAll(() -> assertEquals(7, board.getBoardDimension()),
                                () -> assertEquals(BoardStateType.PLAYING, board.getBoardState().getBoardStateType()),
                                () -> assertNull(board.getBoardState().getWinner()));
        }
}
