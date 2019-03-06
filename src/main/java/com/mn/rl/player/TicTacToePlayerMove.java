package com.mn.rl.player;

import com.mn.rl.board.Board;

public class TicTacToePlayerMove extends PlayerMove {

        private final String ROW_OUT_OF_BOUNDS_ERR_MSG = "Row index out of bounds [row index=%s].";
        private final String COLUMN_OUT_OF_BOUNDS_ERR_MSG = "Column index out of bounds [column index=%s].";
        private final String POSITION_OCCUPIED_ERR_MSG = "Position is occupied.";

        public TicTacToePlayerMove(int rowInd, int colInd) {
                super(rowInd, colInd);
        }

        /**
         * Row and column indices inputed by the user are not zero indexed.
         */
        @Override
        public void validate(Board board) throws InvalidMoveException {
                int boardDim = board.getBoardDimension();

                if (rowInd <= 0 || rowInd > boardDim)
                        throw new InvalidMoveException(String.format(ROW_OUT_OF_BOUNDS_ERR_MSG, rowInd));
                if (colInd <= 0 || colInd > boardDim)
                        throw new InvalidMoveException(String.format(COLUMN_OUT_OF_BOUNDS_ERR_MSG, colInd));

                if (!board.getBoardPosition(rowInd - 1, colInd - 1).isEmpty())
                        throw new InvalidMoveException(POSITION_OCCUPIED_ERR_MSG);
        }
}
