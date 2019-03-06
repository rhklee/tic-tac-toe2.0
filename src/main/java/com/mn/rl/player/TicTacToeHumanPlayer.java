package com.mn.rl.player;

import java.util.Scanner;
import java.util.regex.Pattern;

import com.mn.rl.board.Board;

public class TicTacToeHumanPlayer extends Player {

        private final String HUMAN_PLAYER_INSTRUCTIONS = "Please make your move (in the form 'row,column'): ";
        private final String USER_INPUT_REGEX = "\\d+,\\d+";

        public TicTacToeHumanPlayer(String playerName, char playerSymbol) {
                super(playerName, playerSymbol, PlayerType.HUMAN);
        }

        @Override
        public PlayerMove move(Board board, Scanner scanner) {
                PlayerMove playerMove;
                System.out.println(String.format(PLAYER_TURN_TEXT, playerName, playerSymbol));

                String userInput = null;
                while (true) {
                        System.out.print(HUMAN_PLAYER_INSTRUCTIONS);
                        userInput = scanner.next();

                        if (!validHumanPlayerInput(userInput))
                                continue;

                        String[] rowCol = userInput.split(",");
                        playerMove = new TicTacToePlayerMove(Integer.valueOf(rowCol[0]), Integer.valueOf(rowCol[1]));

                        try {
                                playerMove.validate(board);
                                break;
                        } catch (InvalidMoveException e) {
                                System.out.println(e.getMessage());
                                continue;
                        }
                }

                return playerMove;
        }

        private boolean validHumanPlayerInput(String userInput) {
                return Pattern.compile(USER_INPUT_REGEX).matcher(userInput).matches();
        }
}
