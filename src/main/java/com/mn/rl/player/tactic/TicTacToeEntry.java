package com.mn.rl.player.tactic;

import com.mn.rl.board.BoardPosition;

public class TicTacToeEntry {
        private final int rowInd;
        private final int colInd;
        private final BoardPosition boardPosition;

        public TicTacToeEntry(int rowInd, int colInd, BoardPosition boardPosition) {
                super();
                this.rowInd = rowInd;
                this.colInd = colInd;
                this.boardPosition = boardPosition;
        }

        public int getRowInd() {
                return rowInd;
        }

        public int getColInd() {
                return colInd;
        }

        public BoardPosition getBoardPosition() {
                return boardPosition;
        }

}
