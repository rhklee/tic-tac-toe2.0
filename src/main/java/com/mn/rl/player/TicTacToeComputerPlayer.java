package com.mn.rl.player;

public class TicTacToeComputerPlayer extends Player {

        public TicTacToeComputerPlayer(String playerName, char playerSymbol) {
                this.playerName = playerName;
                this.playerSymbol = playerSymbol;
                this.playerType = PlayerType.COMPUTER;
        }
}
