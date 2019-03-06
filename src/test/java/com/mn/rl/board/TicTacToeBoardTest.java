package com.mn.rl.board;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.mn.rl.player.tactic.TicTacToeEntry;
import com.mn.rl.player.tactic.TicTacToeLine;

public class TicTacToeBoardTest {

        @Test
        public void check_correct_board_lines_are_generated() {
                Board board = BoardFactory.makeTicTacToeBoard(3);
                List<TicTacToeLine> lines = board.getLines();

                List<TicTacToeEntry> firstRowEntries = lines.get(0).getEntries();

                assertAll(() -> assertEquals(3, lines.get(0).getLineLength()),
                                () -> assertArrayEquals(new int[] { 1, 1 },
                                new int[] { firstRowEntries.get(0).getRowInd(), firstRowEntries.get(0).getColInd() }),
                                () -> assertArrayEquals(new int[] { 1, 2 },
                                                new int[] { firstRowEntries.get(1).getRowInd(),
                                                                firstRowEntries.get(1).getColInd() }),
                                () -> assertArrayEquals(new int[] { 1, 3 },
                                                new int[] { firstRowEntries.get(2).getRowInd(),
                                                                firstRowEntries.get(2).getColInd() }));
        }
}
