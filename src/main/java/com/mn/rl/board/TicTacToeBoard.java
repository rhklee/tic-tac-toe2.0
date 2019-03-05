package com.mn.rl.board;

import com.mn.rl.player.Player;
import com.mn.rl.player.PlayerMove;

public class TicTacToeBoard extends Board {

        private final BoardFormatter boardFormatter;
        private final BoardStateDecider boardStateDecider;

        public TicTacToeBoard(int boardDimension, BoardFormatter boardFormatter, BoardStateDecider boardStateDecider) {
                this.boardDimension = boardDimension;
                boardPositions = new BoardPosition[boardDimension][boardDimension];
                for (int r = 0; r < boardDimension; r++) {
                        for (int c = 0; c < boardDimension; c++) {
                                boardPositions[r][c] = new BoardPosition();
                        }
                }
                this.boardFormatter = boardFormatter;
                this.boardStateDecider = boardStateDecider;
                boardState = new BoardState();
        }

        /**
         * Update occupant with the player's move.
         * It is expected the player move is valid and the board position is not occupied.
         */
        @Override
        public void updateWithMove(Player currentPlayer, PlayerMove pMove) {
                BoardPosition boardPosition = boardPositions[pMove.getRow() - 1][pMove.getColumn() - 1];

                boardPosition.setOccupant(currentPlayer);
                boardPositions[pMove.getRow() - 1][pMove.getColumn() - 1] = boardPosition;
                boardState = boardStateDecider.evaluate(boardPositions, boardDimension);
        }

        @Override
        public void display() {
                System.out.println(boardFormatter.format(boardPositions, boardDimension));
        }

}
