package com.mn.rl.player;

import java.util.List;

public class TicTacToePlayerTurn implements PlayerTurn {
        private CircularQueue<Player> playerQueue;

        public TicTacToePlayerTurn(List<Player> players) {
                playerQueue = new CircularQueue<>(players);
        }

        public Player currentPlayer() {
                return playerQueue.peekCurrent();
        }

        public void nextPlayer() {
                playerQueue.next();
        }
}
