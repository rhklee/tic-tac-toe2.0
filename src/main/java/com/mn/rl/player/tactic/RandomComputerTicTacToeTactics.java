package com.mn.rl.player.tactic;

import java.util.concurrent.ThreadLocalRandom;

import com.mn.rl.board.Board;
import com.mn.rl.player.Player;
import com.mn.rl.player.PlayerMove;
import com.mn.rl.player.TicTacToePlayerMove;

public class RandomComputerTicTacToeTactics implements ComputerTicTacToeTactics {

        @Override
        public PlayerMove generateMove(Board board, Player player) {
                final int boardDim = board.getBoardDimension();
                int randRow;
                int randCol;

                do {
                        randRow = ThreadLocalRandom.current().nextInt(0, boardDim);
                        randCol = ThreadLocalRandom.current().nextInt(0, boardDim);
                } while (!board.getBoardPosition(randRow, randCol).isEmpty());

                return new TicTacToePlayerMove(randRow + 1, randCol + 1);
        }
}
