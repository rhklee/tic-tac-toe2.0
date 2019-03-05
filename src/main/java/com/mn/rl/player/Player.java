package com.mn.rl.player;

import com.mn.rl.board.Board;

public abstract class Player {

        protected String playerName;
        protected char playerSymbol;
        protected PlayerType playerType;

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

        public abstract PlayerMove move(Board board) throws InvalidMoveInputException;
}
