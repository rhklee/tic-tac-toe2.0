package com.mn.rl;

import java.util.List;
import java.util.Scanner;

import com.mn.rl.board.Board;
import com.mn.rl.board.BoardFactory;
import com.mn.rl.board.BoardState;
import com.mn.rl.board.BoardStateType;
import com.mn.rl.player.Player;
import com.mn.rl.player.PlayerMove;
import com.mn.rl.player.PlayerTurn;
import com.mn.rl.player.TicTacToePlayerTurn;

class TicTacToe extends Game {

        public TicTacToe(Board board, PlayerTurn playerTurn) {
                super(board, playerTurn);
        }

        public TicTacToe(int boardSize, List<Player> players) {
                this(BoardFactory.makeTicTacToeBoard(boardSize), new TicTacToePlayerTurn(players));
        }

        @Override
        public BoardState play() throws Exception {
                try (Scanner scanner = new Scanner(System.in)) {
                        do {
                                Player currentPlayer = playerTurn.currentPlayer();
                                PlayerMove playerMove = currentPlayer.move(board, scanner);
                                board.updateWithMove(currentPlayer, playerMove);
                                board.display();
                                playerTurn.nextPlayer();
                        } while (board.getBoardState().getBoardStateType() == BoardStateType.PLAYING);
                }
                return board.getBoardState();
        }

}
