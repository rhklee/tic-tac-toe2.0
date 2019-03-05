package com.mn.rl.player;

public class TicTacToePlayerMove implements PlayerMove {

        private int rowInd;
        private int colInd;

        public TicTacToePlayerMove(int rowInd, int colInd) {
                super();
                this.rowInd = rowInd;
                this.colInd = colInd;
        }

        @Override
        public void validate(int boardDim) throws InvalidMoveException {
                if (rowInd <= 0 || rowInd > boardDim)
                        throw new InvalidMoveException(
                                        String.format("Row index out of bounds [row index=%s].", rowInd));
                if (colInd <= 0 || colInd > boardDim)
                        throw new InvalidMoveException(
                                        String.format("Column index out of bounds [column index=%s].", colInd));
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
