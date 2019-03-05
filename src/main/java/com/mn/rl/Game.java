package com.mn.rl;

import com.mn.rl.board.Board;
import com.mn.rl.player.Player;
import com.mn.rl.player.PlayerTurn;

public abstract class Game {
        protected GameState gameState;
        protected Board board;
        protected PlayerTurn playerTurn;

        public Game(GameState gameState, Board board, PlayerTurn playerTurn) {
                super();
                this.setGameState(gameState);
                this.board = board;
                this.playerTurn = playerTurn;
        }

        public GameState getGameState() {
                return gameState;
        }

        public void setGameState(GameState gameState) {
                this.gameState = gameState;
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

        public abstract void playTurn();
}
