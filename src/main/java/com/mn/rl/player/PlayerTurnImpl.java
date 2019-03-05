package com.mn.rl.player;

import java.util.List;

import com.mn.rl.CircularQueue;

public class PlayerTurnImpl implements PlayerTurn {
        private CircularQueue<Player> playerQueue;

        public PlayerTurnImpl(List<Player> players) {
                playerQueue = new CircularQueue<>(players);
        }

        public Player currentPlayer() {
                return playerQueue.peekCurrent();
        }
        
        public void nextPlayer() {
                playerQueue.next();
        }
}
