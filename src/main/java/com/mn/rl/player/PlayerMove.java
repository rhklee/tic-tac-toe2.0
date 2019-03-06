package com.mn.rl.player;

import com.mn.rl.board.Board;

public abstract class PlayerMove {
        protected final int rowInd;
        protected final int colInd;

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

        @Override
        public boolean equals(Object obj) {
                if (this == obj)
                        return true;
                if (obj == null)
                        return false;
                if (getClass() != obj.getClass())
                        return false;
                PlayerMove other = (PlayerMove) obj;
                if (colInd != other.colInd)
                        return false;
                if (rowInd != other.rowInd)
                        return false;
                return true;
        }

        public abstract void validate(Board board) throws InvalidMoveException;
}
