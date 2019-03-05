package com.mn.rl.board;

import com.mn.rl.player.Player;

public class BoardPosition {

        private boolean empty;
        private Player occupant;

        public BoardPosition(boolean empty, Player occupant) {
                this.empty = empty;
                this.occupant = occupant;
        }

        public BoardPosition(boolean empty) {
                this(empty, null);
        }

        public BoardPosition() {
                this(true, null);
        }

        public boolean isEmpty() {
                return empty;
        }

        public void setOccupant(Player occupant) {
                empty = false;
                this.occupant = occupant;
        }

        public Player getOccupant() {
                return occupant;
        }

}
