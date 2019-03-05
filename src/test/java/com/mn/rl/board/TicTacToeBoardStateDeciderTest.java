package com.mn.rl.board;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.mn.rl.player.Player;
import com.mn.rl.player.TicTacToeHumanPlayer;

public class TicTacToeBoardStateDeciderTest {

        private static BoardStateDecider bsd;
        private static Player p1;
        private static Player p2;
        private static Player p3;

        @BeforeAll
        public static void setup() {
                bsd = new TicTacToeBoardStateDecider();
                p1 = new TicTacToeHumanPlayer("Player 1", 'x');
                p2 = new TicTacToeHumanPlayer("Player 2", 'o');
                p3 = new TicTacToeHumanPlayer("Player 3", 'a');
        }

        @Test
        public void empty_board_evaluation() {
                final BoardPosition[][] empty10by10 = {
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
                                                new BoardPosition(), new BoardPosition(), new BoardPosition() } };
                assertEquals(BoardStateType.PLAYING, bsd.evaluate(empty10by10, 10).getBoardStateType());
        }

        @Test
        public void one_spot_empty_no_winner() {
                final BoardPosition[][] board = {
                                {new BoardPosition(false, p1), new BoardPosition(false, p2), new BoardPosition(false, p3)},
                                {new BoardPosition(false, p2), new BoardPosition(false, p3), new BoardPosition(false, p1)},
                                {new BoardPosition(false, p1), new BoardPosition(), new BoardPosition(false, p2)}
                };
                BoardState bs = bsd.evaluate(board, 3);
                assertEquals(BoardStateType.PLAYING, bs.getBoardStateType());
        }
        
        @Test
        public void winning_row_evaluation() {
                final BoardPosition[][] winRow3by3 = {
                                { new BoardPosition(false, p1), new BoardPosition(false, p1),
                                                new BoardPosition(false, p1) },
                                { new BoardPosition(), new BoardPosition(false, p2), new BoardPosition() },
                                { new BoardPosition(false, p3), new BoardPosition(), new BoardPosition(false, p2) } };
                BoardState bs = bsd.evaluate(winRow3by3, 3);
                assertAll(() -> assertEquals(BoardStateType.WINNER, bs.getBoardStateType()),
                                () -> assertEquals(p1, bs.getWinner()));
        }

        @Test
        public void winning_row_evaluation2() {
                final BoardPosition[][] winRow3by3 = {
                                { new BoardPosition(), new BoardPosition(false, p2), new BoardPosition() },
                                { new BoardPosition(false, p1), new BoardPosition(false, p1),
                                                new BoardPosition(false, p1) },
                                { new BoardPosition(false, p3), new BoardPosition(), new BoardPosition(false, p2) } };
                BoardState bs = bsd.evaluate(winRow3by3, 3);
                assertAll(() -> assertEquals(BoardStateType.WINNER, bs.getBoardStateType()),
                                () -> assertEquals(p1, bs.getWinner()));
        }

        @Test
        public void winning_col_evaluation() {
                final BoardPosition[][] winCol5by5 = {
                                {new BoardPosition(), new BoardPosition(false, p2), new BoardPosition(false, p1), new BoardPosition(), new BoardPosition(false, p2)},
                                {new BoardPosition(), new BoardPosition(false, p2), new BoardPosition(false, p1), new BoardPosition(), new BoardPosition(false, p3)},
                                {new BoardPosition(), new BoardPosition(false, p2), new BoardPosition(false, p1), new BoardPosition(), new BoardPosition(false, p3)},
                                {new BoardPosition(), new BoardPosition(false, p2), new BoardPosition(false, p1), new BoardPosition(), new BoardPosition(false, p3)},
                                {new BoardPosition(), new BoardPosition(false, p2), new BoardPosition(false, p3), new BoardPosition(), new BoardPosition(false, p3)}
                };
                BoardState bs = bsd.evaluate(winCol5by5, 5);
                assertAll(() -> assertEquals(BoardStateType.WINNER, bs.getBoardStateType()),
                                () -> assertEquals(p2, bs.getWinner()));
        }

        @Test
        public void winning_col_evaluation2() {
                final BoardPosition[][] winCol5by5 = {
                                {new BoardPosition(), new BoardPosition(false, p3), new BoardPosition(false, p1), new BoardPosition(), new BoardPosition(false, p2)},
                                {new BoardPosition(), new BoardPosition(false, p2), new BoardPosition(false, p1), new BoardPosition(), new BoardPosition(false, p3)},
                                {new BoardPosition(), new BoardPosition(false, p2), new BoardPosition(false, p1), new BoardPosition(), new BoardPosition(false, p3)},
                                {new BoardPosition(), new BoardPosition(false, p2), new BoardPosition(false, p1), new BoardPosition(), new BoardPosition(false, p3)},
                                {new BoardPosition(), new BoardPosition(false, p2), new BoardPosition(false, p1), new BoardPosition(), new BoardPosition(false, p3)}
                };
                BoardState bs = bsd.evaluate(winCol5by5, 5);
                assertAll(() -> assertEquals(BoardStateType.WINNER, bs.getBoardStateType()),
                                () -> assertEquals(p1, bs.getWinner()));
        }

        @Test
        public void winning_left_diag() {
                final BoardPosition[][] winleftDiag5by5 = {
                                {new BoardPosition(false, p2), new BoardPosition(false, p3), new BoardPosition(false, p1), new BoardPosition(), new BoardPosition(false, p2)},
                                {new BoardPosition(), new BoardPosition(false, p2), new BoardPosition(false, p1), new BoardPosition(), new BoardPosition(false, p3)},
                                {new BoardPosition(), new BoardPosition(false, p2), new BoardPosition(false, p2), new BoardPosition(), new BoardPosition(false, p3)},
                                {new BoardPosition(), new BoardPosition(false, p2), new BoardPosition(false, p1), new BoardPosition(false, p2), new BoardPosition(false, p3)},
                                {new BoardPosition(), new BoardPosition(false, p2), new BoardPosition(false, p1), new BoardPosition(), new BoardPosition(false, p2)}
                };
                BoardState bs = bsd.evaluate(winleftDiag5by5, 5);
                assertAll(() -> assertEquals(BoardStateType.WINNER, bs.getBoardStateType()),
                                () -> assertEquals(p2, bs.getWinner()));
        }
        
        @Test
        public void winning_right_diag() {
                final BoardPosition[][] winRightDiag5by5 = {
                                {new BoardPosition(false, p1), new BoardPosition(false, p3), new BoardPosition(false, p1), new BoardPosition(), new BoardPosition(false, p1)},
                                {new BoardPosition(), new BoardPosition(false, p2), new BoardPosition(false, p1), new BoardPosition(false, p1), new BoardPosition(false, p3)},
                                {new BoardPosition(), new BoardPosition(false, p2), new BoardPosition(false, p1), new BoardPosition(), new BoardPosition(false, p3)},
                                {new BoardPosition(), new BoardPosition(false, p1), new BoardPosition(false, p3), new BoardPosition(false, p2), new BoardPosition(false, p3)},
                                {new BoardPosition(false, p1), new BoardPosition(false, p2), new BoardPosition(false, p3), new BoardPosition(), new BoardPosition(false, p2)}
                };
                BoardState bs = bsd.evaluate(winRightDiag5by5, 5);
                assertAll(() -> assertEquals(BoardStateType.WINNER, bs.getBoardStateType()),
                                () -> assertEquals(p1, bs.getWinner()));
        }
        
        @Test
        public void draw_state() {
                final BoardPosition[][] draw = {
                                {new BoardPosition(false, p1), new BoardPosition(false, p2), new BoardPosition(false, p3)},
                                {new BoardPosition(false, p2), new BoardPosition(false, p3), new BoardPosition(false, p1)},
                                {new BoardPosition(false, p1), new BoardPosition(false, p1), new BoardPosition(false, p2)}
                };
                BoardState bs = bsd.evaluate(draw, 3);
                assertEquals(BoardStateType.DRAW, bs.getBoardStateType());
        }
}
