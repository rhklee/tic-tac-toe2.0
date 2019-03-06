package com.mn.rl.player;

import com.mn.rl.board.Board;

public class TicTacToePlayerMove extends PlayerMove {

        public TicTacToePlayerMove(int rowInd, int colInd) {
                super(rowInd, colInd);
        }

        /**
         * Row and column indices inputted by the user are not zero indexed.
         */
        @Override
        public void validate(Board board) throws InvalidMoveException {
                int boardDim = board.getBoardDimension();

                if (rowInd <= 0 || rowInd > boardDim)
                        throw new InvalidMoveException(
                                        String.format("Row index out of bounds [row index=%s].", rowInd));
                if (colInd <= 0 || colInd > boardDim)
                        throw new InvalidMoveException(
                                        String.format("Column index out of bounds [column index=%s].", colInd));

                if (!board.getBoardPosition(rowInd - 1, colInd - 1).isEmpty())
                        throw new InvalidMoveException("Position is occupied.");
        }
}
