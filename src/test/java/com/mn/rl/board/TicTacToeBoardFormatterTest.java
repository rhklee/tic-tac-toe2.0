package com.mn.rl.board;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.mn.rl.player.TicTacToeHumanPlayer;

public class TicTacToeBoardFormatterTest {

        @Test
        public void format_3by3_board() {
                String expected = "___\n" + "x_o\n" + "a__\n";
                BoardFormatter formatter = new TicTacToeBoardFormatter();
                BoardPosition[][] boardPositions = new BoardPosition[][] {
                                { new BoardPosition(), new BoardPosition(), new BoardPosition() },
                                { new BoardPosition(false, new TicTacToeHumanPlayer("Player 1", 'x')),
                                                new BoardPosition(),
                                                new BoardPosition(false, new TicTacToeHumanPlayer("Player 2", 'o')) },
                                { new BoardPosition(false, new TicTacToeHumanPlayer("Player 3", 'a')),
                                                new BoardPosition(), new BoardPosition() } };
                assertEquals(expected, formatter.format(boardPositions, 3));
        }

        @Test
        public void format_10by10_empty_board() {
                String expected = "__________\n" + "__________\n" + "__________\n" + "__________\n" + "__________\n"
                                + "__________\n" + "__________\n" + "__________\n" + "__________\n" + "__________\n";
                BoardFormatter formatter = new TicTacToeBoardFormatter();
                BoardPosition[][] boardPositions = new BoardPosition[][] {
                                { new BoardPosition(), new BoardPosition(), new BoardPosition(), new BoardPosition(),
                                                new BoardPosition(), new BoardPosition(), new BoardPosition(),
                                                new BoardPosition(), new BoardPosition(), new BoardPosition() },
                                { new BoardPosition(), new BoardPosition(), new BoardPosition(), new BoardPosition(),
                                                new BoardPosition(), new BoardPosition(), new BoardPosition(),
                                                new BoardPosition(), new BoardPosition(), new BoardPosition() },
                                { new BoardPosition(), new BoardPosition(), new BoardPosition(), new BoardPosition(),
                                                new BoardPosition(), new BoardPosition(), new BoardPosition(),
                                                new BoardPosition(), new BoardPosition(), new BoardPosition() },
                                { new BoardPosition(), new BoardPosition(), new BoardPosition(), new BoardPosition(),
                                                new BoardPosition(), new BoardPosition(), new BoardPosition(),
                                                new BoardPosition(), new BoardPosition(), new BoardPosition() },
                                { new BoardPosition(), new BoardPosition(), new BoardPosition(), new BoardPosition(),
                                                new BoardPosition(), new BoardPosition(), new BoardPosition(),
                                                new BoardPosition(), new BoardPosition(), new BoardPosition() },
                                { new BoardPosition(), new BoardPosition(), new BoardPosition(), new BoardPosition(),
                                                new BoardPosition(), new BoardPosition(), new BoardPosition(),
                                                new BoardPosition(), new BoardPosition(), new BoardPosition() },
                                { new BoardPosition(), new BoardPosition(), new BoardPosition(), new BoardPosition(),
                                                new BoardPosition(), new BoardPosition(), new BoardPosition(),
                                                new BoardPosition(), new BoardPosition(), new BoardPosition() },
                                { new BoardPosition(), new BoardPosition(), new BoardPosition(), new BoardPosition(),
                                                new BoardPosition(), new BoardPosition(), new BoardPosition(),
                                                new BoardPosition(), new BoardPosition(), new BoardPosition() },
                                { new BoardPosition(), new BoardPosition(), new BoardPosition(), new BoardPosition(),
                                                new BoardPosition(), new BoardPosition(), new BoardPosition(),
                                                new BoardPosition(), new BoardPosition(), new BoardPosition() },
                                { new BoardPosition(), new BoardPosition(), new BoardPosition(), new BoardPosition(),
                                                new BoardPosition(), new BoardPosition(), new BoardPosition(),
                                                new BoardPosition(), new BoardPosition(), new BoardPosition() }
                };
                assertEquals(expected, formatter.format(boardPositions, 10));
        }
}
