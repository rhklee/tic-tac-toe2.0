package com.mn.rl.player;

import java.util.Scanner;
import java.util.regex.Pattern;

import com.mn.rl.board.Board;

public class Player {

        private final String playerName;
        private final char playerSymbol;
        private final PlayerType playerType;

        private final String PLAYER_TURN_TEXT = "It is %s turn. [symbol = %s]";
        private final String HUMAN_PLAYER_INSTRUCTIONS = "Please make your move (in the form 'row,column'): ";
        private final String USER_INPUT_REGEX = "\\d+,\\d+";

        private final String UNKNOWN_PLAYER_ERR_MSG = "Current player of unknown player type: %s";

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

        public PlayerMove move(Board board, Scanner scanner) throws InvalidPlayerException {
                PlayerMove playerMove;

                System.out.println(String.format(PLAYER_TURN_TEXT, playerName, playerSymbol));

                if (playerType == PlayerType.HUMAN) {
                        String userInput = null;
                        while (true) {
                                System.out.print(HUMAN_PLAYER_INSTRUCTIONS);
                                userInput = scanner.next();

                                if (!validHumanPlayerInput(userInput))
                                        continue;

                                String[] rowCol = userInput.split(",");
                                playerMove = new TicTacToePlayerMove(Integer.valueOf(rowCol[0]),
                                                Integer.valueOf(rowCol[1]));

                                try {
                                        playerMove.validate(board);
                                        break;
                                } catch (InvalidMoveException e) {
                                        System.out.println(e.getMessage());
                                        continue;
                                }
                        }

                } else if (playerType == PlayerType.COMPUTER) {
                        playerMove = ComputerPlayerStrategy.move(board);
                } else {
                        throw new InvalidPlayerException(String.format(UNKNOWN_PLAYER_ERR_MSG, playerType));
                }
                return playerMove;
        }

        private boolean validHumanPlayerInput(String userInput) {
                return Pattern.compile(USER_INPUT_REGEX).matcher(userInput).matches();
        }
}
