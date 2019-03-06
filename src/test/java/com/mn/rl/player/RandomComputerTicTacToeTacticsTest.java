package com.mn.rl.player;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.mn.rl.board.Board;
import com.mn.rl.board.BoardFactory;
import com.mn.rl.player.tactic.ComputerTicTacToeTactics;
import com.mn.rl.player.tactic.RandomComputerTicTacToeTactics;

public class RandomComputerTicTacToeTacticsTest {

        @Test
        public void check_valid_player_move_generated() {
                List<Player> players = PlayerFactory.generatePlayers(new Character[] { 'x', 'y', 'z' });
                Board board = BoardFactory.makeTicTacToeBoard(3);
                board.updateWithMove(players.get(0), new TicTacToePlayerMove(1, 1));
                board.updateWithMove(players.get(1), new TicTacToePlayerMove(2, 2));

                ComputerTicTacToeTactics tactics = new RandomComputerTicTacToeTactics();
                PlayerMove pm = tactics.generateMove(board);

                assertTrue(board.getBoardPosition(pm.getRow() - 1, pm.getColumn() - 1).isEmpty());
        }
}
