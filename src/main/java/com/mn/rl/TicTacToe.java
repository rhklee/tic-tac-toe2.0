package com.mn.rl;

import java.util.List;

import com.mn.rl.board.Board;
import com.mn.rl.board.BoardStateType;
import com.mn.rl.board.TicTacToeBoard;
import com.mn.rl.board.TicTacToeBoardFormatter;
import com.mn.rl.board.TicTacToeBoardStateDecider;
import com.mn.rl.player.InvalidMoveException;
import com.mn.rl.player.InvalidMoveInputException;
import com.mn.rl.player.Player;
import com.mn.rl.player.PlayerMove;
import com.mn.rl.player.PlayerTurn;
import com.mn.rl.player.TicTacToePlayerTurn;

public class TicTacToe extends Game {

        public TicTacToe(GameState gameState, Board board, PlayerTurn playerTurn) {
                super(gameState, board, playerTurn);
        }

        public TicTacToe(int boardSize, List<Player> players) {
                this(GameState.ACTIVE,
                                new TicTacToeBoard(boardSize,
                                                new TicTacToeBoardFormatter(),
                                                new TicTacToeBoardStateDecider()),
                                new TicTacToePlayerTurn(players));
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
                        pMove.validate(board.getBoardDimension());
                        board.updateWithMove(currentPlayer, pMove);
                } catch (InvalidMoveInputException e) {
                        System.out.println(e.getMessage());
                        return;
                } catch (InvalidMoveException e) {
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
