package com.mn.rl.player;

import java.util.concurrent.ThreadLocalRandom;

import com.mn.rl.board.Board;

public class ComputerPlayerStrategy {

        public static PlayerMove move(Board board) {
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
