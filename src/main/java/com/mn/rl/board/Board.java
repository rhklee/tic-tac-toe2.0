package com.mn.rl.board;

import java.util.List;

import com.mn.rl.player.Player;
import com.mn.rl.player.PlayerMove;
import com.mn.rl.player.tactic.TicTacToeLine;

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

        public BoardPosition[][] getBoardPositions() {
                return boardPositions;
        }

        public abstract void display();

        public abstract void updateWithMove(Player currentPlayer, PlayerMove pMove);

        public abstract List<TicTacToeLine> getLines();
}
