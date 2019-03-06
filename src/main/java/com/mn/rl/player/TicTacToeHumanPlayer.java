package com.mn.rl.player;

public class TicTacToeHumanPlayer extends Player {

        public TicTacToeHumanPlayer(String playerName, char playerSymbol) {
                this.playerName = playerName;
                this.playerSymbol = playerSymbol;
                this.playerType = PlayerType.HUMAN;
        }
}
