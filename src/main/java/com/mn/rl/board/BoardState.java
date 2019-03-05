package com.mn.rl.board;

import com.mn.rl.player.Player;

public class BoardState {
        private BoardStateType boardStateType;
        private Player winner;

        public BoardState(BoardStateType boardStateType, Player winner) {
                super();
                this.boardStateType = boardStateType;
                this.winner = winner;
        }

        public BoardState(BoardStateType boardStateType) {
                this(boardStateType, null);
        }
        
        public BoardState() {
                this(BoardStateType.PLAYING);
        }

        public BoardStateType getBoardStateType() {
                return boardStateType;
        }

        public void setBoardStateType(BoardStateType boardStateType) {
                this.boardStateType = boardStateType;
        }

        public Player getWinner() {
                return winner;
        }

        public void setWinner(Player winner) {
                this.winner = winner;
        }

}
