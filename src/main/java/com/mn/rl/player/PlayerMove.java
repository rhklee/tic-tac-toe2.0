package com.mn.rl.player;

import com.mn.rl.board.Board;

public abstract class PlayerMove {
        protected int rowInd;
        protected int colInd;

        public PlayerMove(int rowInd, int colInd) {
                this.rowInd = rowInd;
                this.colInd = colInd;
        }

        public int getRow() {
                return rowInd;
        }

        public int getColumn() {
                return colInd;
        }

        public abstract void validate(Board board) throws InvalidMoveException;
}
