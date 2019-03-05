package com.mn.rl;

import com.mn.rl.board.Board;
import com.mn.rl.board.BoardState;
import com.mn.rl.player.PlayerTurn;

public abstract class Game {
        protected Board board;
        protected PlayerTurn playerTurn;

        public Game(Board board, PlayerTurn playerTurn) {
                super();
                this.board = board;
                this.playerTurn = playerTurn;
        }

        public Board getBoard() {
                return board;
        }

        public void setBoard(Board board) {
                this.board = board;
        }

        public PlayerTurn getPlayerTurn() {
                return playerTurn;
        }

        public void setPlayerTurn(PlayerTurn playerTurn) {
                this.playerTurn = playerTurn;
        }

        public abstract BoardState play() throws Exception;
}
