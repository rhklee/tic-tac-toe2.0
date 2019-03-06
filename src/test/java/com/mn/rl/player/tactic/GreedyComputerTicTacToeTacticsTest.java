package com.mn.rl.player.tactic;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.mn.rl.board.Board;
import com.mn.rl.board.BoardFactory;
import com.mn.rl.player.Player;
import com.mn.rl.player.PlayerFactory;
import com.mn.rl.player.PlayerMove;
import com.mn.rl.player.TicTacToePlayerMove;

public class GreedyComputerTicTacToeTacticsTest {

        @Test
        public void fill_in_remaining_blank_to_win() {
                List<Player> players = PlayerFactory.generatePlayers(new Character[] { 'x', 'y', 'z' });
                Board board = BoardFactory.makeTicTacToeBoard(3);
                board.updateWithMove(players.get(0), new TicTacToePlayerMove(1, 1));
                board.updateWithMove(players.get(1), new TicTacToePlayerMove(2, 2));
                board.updateWithMove(players.get(2), new TicTacToePlayerMove(3, 3));
                board.updateWithMove(players.get(2), new TicTacToePlayerMove(2, 3));

                ComputerTicTacToeTactics tactics = new GreedyComputerTicTacToeTactics();
                PlayerMove pm = tactics.generateMove(board, players.get(2));
                assertEquals(new TicTacToePlayerMove(1, 3), pm);
        }
}
