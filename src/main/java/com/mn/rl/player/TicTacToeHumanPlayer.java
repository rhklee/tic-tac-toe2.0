package com.mn.rl.player;

import java.util.Scanner;

import com.mn.rl.board.Board;

public class TicTacToeHumanPlayer extends Player {

        public TicTacToeHumanPlayer(String playerName, char playerSymbol) {
                this.playerName = playerName;
                this.playerSymbol = playerSymbol;
                this.playerType = PlayerType.HUMAN;
        }

        @Override
        public PlayerMove move(Board board) throws InvalidMoveInputException {
                board.display();
                System.out.println("Please make your move [e.g. in the form 'row,column']: ");
                try (Scanner sc = new Scanner(System.in)) {
                        String[] rowColPair = sc.nextLine().split(",");

                        if (rowColPair.length != 2) {
                                throw new InvalidMoveInputException("Comma separated integers were not entered.");
                        }

                        try {
                                int rowInd = Integer.valueOf(rowColPair[0].trim());
                                int colInd = Integer.valueOf(rowColPair[1].trim());
                                return new TicTacToePlayerMove(rowInd, colInd);
                        } catch (NumberFormatException e) {
                                throw new InvalidMoveInputException("Non-integer row,column pair was entered.", e);
                        }
                }
        }

}
