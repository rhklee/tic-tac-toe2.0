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
import com.mn.rl.player.InvalidMoveInputException;
import com.mn.rl.player.Player;
import com.mn.rl.player.PlayerMove;
import com.mn.rl.player.PlayerTurn;
import com.mn.rl.player.PlayerType;
import com.mn.rl.player.TicTacToePlayerMove;
import com.mn.rl.player.TicTacToePlayerTurn;

public class TicTacToe extends Game {

        public TicTacToe(GameState gameState, Board board, PlayerTurn playerTurn) {
                super(gameState, board, playerTurn);
        }

        public TicTacToe(int boardSize, List<Player> players) {
                this(GameState.ACTIVE, new TicTacToeBoard(boardSize, new TicTacToeBoardFormatter(),
                                new TicTacToeBoardStateDecider()), new TicTacToePlayerTurn(players));
        }

        private final String PLAYER_TURN_TEXT = "It is %s turn. ";
        private final String HUMAN_PLAYER_INSTRUCTIONS = "Please make your move (in the form 'row,column'): ";

        @Override
        public BoardState play() throws Exception {
                try (Scanner scanner = new Scanner(System.in)) {

                        do {
                                Player currentPlayer = playerTurn.currentPlayer();

                                System.out.println(String.format(PLAYER_TURN_TEXT, currentPlayer.getPlayerName()));

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
                                        throw new Exception(String.format("Current player of unknown player type: %s",
                                                        currentPlayer.getPlayerType()));
                                }

                                board.updateWithMove(currentPlayer, playerMove);
                                board.display();

                                if (board.getBoardState().getBoardStateType() == BoardStateType.PLAYING) {
                                        playerTurn.nextPlayer();
                                }

                        } while (board.getBoardState().getBoardStateType() == BoardStateType.PLAYING);
                }
                return board.getBoardState();
        }

        private final String USER_INPUT_REGEX = "\\d+,\\d+";

        private boolean validHumanPlayerInput(String userInput) {
                return Pattern.compile(USER_INPUT_REGEX).matcher(userInput).matches();
        }

        @Override
        public void playTurn() {
                // get current player
                Player currentPlayer = playerTurn.currentPlayer();

                try {
                        // validate player move
                        // if the move is invalid, then end turn
                        // else the move is valid, update the board
                        PlayerMove pMove = currentPlayer.move(board);
                        // System.out.println(String.format("rInd = %s, cInd = %s", pMove.getRow(),
                        // pMove.getRow()));
                        System.out.println(String.format("Board dimensions =   %d", board.getBoardDimension()));
                        // pMove.validate(board.getBoardDimension());
                        board.updateWithMove(currentPlayer, pMove);
                } catch (InvalidMoveInputException e) {
                        System.out.println(e.getMessage());
                        return;
                }

                // if the board is a playing state, then go to next player and next turn
                // else deactivate game state
                if (board.getBoardState().getBoardStateType() == BoardStateType.PLAYING) {
                        playerTurn.nextPlayer();
                } else {
                        gameState = GameState.INACTIVE;
                }
        }
}
