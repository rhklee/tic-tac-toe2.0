package com.mn.rl.player;

import com.mn.rl.board.Board;

public class TicTacToeComputerPlayer extends Player {

        public TicTacToeComputerPlayer(String playerName, char playerSymbol) {
                this.playerName = playerName;
                this.playerSymbol = playerSymbol;
                this.playerType = PlayerType.COMPUTER;
        }

        @Override
        public PlayerMove move(Board board) throws InvalidMoveInputException {
                // TODO Auto-generated method stub
                return null;
        }

}
