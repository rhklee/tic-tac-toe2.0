package com.mn.rl.board;

import com.mn.rl.player.Player;
import com.mn.rl.player.PlayerMove;

public abstract class Board {
        protected BoardState boardState;
        protected BoardPosition[][] boardPositions;
        protected int boardDimension;

        public BoardState getBoardState() {
                return boardState;
        }

        public int getBoardDimension() {
                return boardDimension;
        }

        public BoardPosition getBoardPosition(int r, int c) {
                return boardPositions[r][c];
        }

        public abstract void display();

        public abstract void updateWithMove(Player currentPlayer, PlayerMove pMove);
}
