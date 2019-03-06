package com.mn.rl.player;

import java.util.Scanner;

import com.mn.rl.board.Board;
import com.mn.rl.player.tactic.ComputerTicTacToeTactics;

public class TicTacToeComputerPlayer extends Player {

        private final ComputerTicTacToeTactics computerTicTacToeTactics;
        
        public TicTacToeComputerPlayer(String playerName, char playerSymbol, ComputerTicTacToeTactics computerTicTacToeTactics) {
                super(playerName, playerSymbol, PlayerType.COMPUTER);
                this.computerTicTacToeTactics = computerTicTacToeTactics;
        }

        @Override
        public PlayerMove move(Board board, Scanner scanner) {
                System.out.println(String.format(PLAYER_TURN_TEXT, playerName, playerSymbol));
                return computerTicTacToeTactics.generateMove(board);
        }
}
