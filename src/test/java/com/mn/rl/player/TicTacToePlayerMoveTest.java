package com.mn.rl.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.mn.rl.board.Board;
import com.mn.rl.board.BoardFactory;

public class TicTacToePlayerMoveTest {

        @Test
        public void invalid_player_move_rows() {
                Board board = BoardFactory.makeTicTacToeBoard(10);
                PlayerMove pm = new TicTacToePlayerMove(11, 1);
                Throwable t = assertThrows(InvalidMoveException.class, () -> {
                        pm.validate(board);
                });
                assertEquals("Row index out of bounds [row index=11].", t.getMessage());
        }

        @Test
        public void invalid_player_move_columns() {
                Board board = BoardFactory.makeTicTacToeBoard(10);
                PlayerMove pm = new TicTacToePlayerMove(10, 12);
                Throwable t = assertThrows(InvalidMoveException.class, () -> {
                        pm.validate(board);
                });
                assertEquals("Column index out of bounds [column index=12].", t.getMessage());
        }

        @Test
        public void occupied_board_position() {
                Board board = BoardFactory.makeTicTacToeBoard(10);
                Player player = PlayerFactory.generatePlayers(new Character[] { 'x', 'y', 'z' }).get(0);
                PlayerMove pm = new TicTacToePlayerMove(5, 6);
                board.updateWithMove(player, pm);

                Throwable t = assertThrows(InvalidMoveException.class, () -> {
                        pm.validate(board);
                });
                assertEquals("Position is occupied.", t.getMessage());
        }
}
