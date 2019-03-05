package com.mn.rl;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.mn.rl.board.Board;
import com.mn.rl.board.BoardState;
import com.mn.rl.board.BoardStateType;
import com.mn.rl.board.TicTacToeBoard;
import com.mn.rl.board.TicTacToeBoardFormatter;
import com.mn.rl.board.TicTacToeBoardStateDecider;
import com.mn.rl.player.InvalidMoveException;
import com.mn.rl.player.Player;
import com.mn.rl.player.PlayerMove;
import com.mn.rl.player.PlayerTurn;
import com.mn.rl.player.PlayerType;
import com.mn.rl.player.TicTacToePlayerMove;
import com.mn.rl.player.TicTacToePlayerTurn;

public class TicTacToe extends Game {

        private final String PLAYER_TURN_TEXT = "It is %s turn. [symbol = %s]";
        private final String HUMAN_PLAYER_INSTRUCTIONS = "Please make your move (in the form 'row,column'): ";
        private final String USER_INPUT_REGEX = "\\d+,\\d+";

        private final String UNKNOWN_PLAYER_ERR_MSG = "Current player of unknown player type: %s";

        public TicTacToe(Board board, PlayerTurn playerTurn) {
                super(board, playerTurn);
        }

        public TicTacToe(int boardSize, List<Player> players) {
                this(new TicTacToeBoard(boardSize, new TicTacToeBoardFormatter(), new TicTacToeBoardStateDecider()),
                                new TicTacToePlayerTurn(players));
        }

        @Override
        public BoardState play() throws Exception {
                try (Scanner scanner = new Scanner(System.in)) {
                        do {
                                Player currentPlayer = playerTurn.currentPlayer();

                                System.out.println(String.format(PLAYER_TURN_TEXT, currentPlayer.getPlayerName(),
                                                currentPlayer.getPlayerSymbol()));

                                PlayerMove playerMove = null;

                                if (currentPlayer.getPlayerType() == PlayerType.HUMAN) {
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

                                } else if (currentPlayer.getPlayerType() == PlayerType.COMPUTER) {
                                        playerMove = ComputerPlayerStrategy.move(board);
                                } else {
                                        throw new Exception(String.format(UNKNOWN_PLAYER_ERR_MSG,
                                                        currentPlayer.getPlayerType()));
                                }

                                board.updateWithMove(currentPlayer, playerMove);
                                board.display();
                                playerTurn.nextPlayer();
                        } while (board.getBoardState().getBoardStateType() == BoardStateType.PLAYING);
                }
                return board.getBoardState();
        }

        private boolean validHumanPlayerInput(String userInput) {
                return Pattern.compile(USER_INPUT_REGEX).matcher(userInput).matches();
        }

}
