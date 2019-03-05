package com.mn.rl.player;

import com.mn.rl.board.Board;

public class TicTacToePlayerMove implements PlayerMove {

        private int rowInd;
        private int colInd;

        public TicTacToePlayerMove(int rowInd, int colInd) {
                super();
//                System.out.println(String.format("Initializing TicTacToePlayerMove: (%s,%s)", rowInd, colInd));
                this.rowInd = rowInd;
                this.colInd = colInd;
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

        @Override
        public int getRow() {
                return rowInd;
        }

        @Override
        public int getColumn() {
                return colInd;
        }
}
