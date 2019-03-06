package com.mn.rl.player;

import java.util.Scanner;

import com.mn.rl.board.Board;

public abstract class Player {

        protected final String playerName;
        protected final char playerSymbol;
        protected final PlayerType playerType;

        protected final String PLAYER_TURN_TEXT = "It is %s turn. [symbol = %s]";

        public Player(String playerName, char playerSymbol, PlayerType playerType) {
                this.playerName = playerName;
                this.playerSymbol = playerSymbol;
                this.playerType = playerType;
        }

        public String getPlayerName() {
                return playerName;
        }

        public char getPlayerSymbol() {
                return playerSymbol;
        }

        public PlayerType getPlayerType() {
                return playerType;
        }

        @Override
        public boolean equals(Object obj) {
                if (this == obj)
                        return true;
                if (obj == null)
                        return false;
                if (getClass() != obj.getClass())
                        return false;
                Player other = (Player) obj;
                if (playerName == null) {
                        if (other.playerName != null)
                                return false;
                } else if (!playerName.equals(other.playerName))
                        return false;
                if (playerSymbol != other.playerSymbol)
                        return false;
                if (playerType != other.playerType)
                        return false;
                return true;
        }

        public abstract PlayerMove move(Board board, Scanner scanner);

}
