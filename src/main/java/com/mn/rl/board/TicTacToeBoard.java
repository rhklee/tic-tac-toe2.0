package com.mn.rl.board;

import com.mn.rl.player.InvalidMoveException;
import com.mn.rl.player.Player;
import com.mn.rl.player.PlayerMove;

public class TicTacToeBoard implements Board {
        private final BoardPosition[][] boardPositions;
        private final int boardDimension;
        private final BoardFormatter boardFormatter;
        private final BoardStateDecider boardStateDecider;
        private BoardState boardState;

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

        public int getBoardDimension() {
                return boardDimension;
        }

        @Override
        public void updateWithMove(Player currentPlayer, PlayerMove pMove) throws InvalidMoveException {
                BoardPosition boardPosition = boardPositions[pMove.getRow()][pMove.getColumn()];
                if (!boardPosition.isEmpty()) {
                        throw new InvalidMoveException("Position is occupied.");
                }

                boardPosition.setOccupant(currentPlayer);
                boardPositions[pMove.getRow()][pMove.getColumn()] = boardPosition;
                boardState = boardStateDecider.evaluate(boardPositions, boardDimension);
        }

        @Override
        public void display() {
                System.out.println(boardFormatter.format(boardPositions, boardDimension));
        }

        @Override
        public BoardState getBoardState() {
                return boardState;
        }
}
