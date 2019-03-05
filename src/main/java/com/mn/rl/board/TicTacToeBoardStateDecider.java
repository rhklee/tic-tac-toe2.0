package com.mn.rl.board;

import java.util.function.Predicate;
import java.util.stream.Stream;

import com.mn.rl.player.Player;

public class TicTacToeBoardStateDecider implements BoardStateDecider {

        @Override
        public BoardState evaluate(BoardPosition[][] boardPositions, int boardDimension) {
                for (int i = 0; i < boardDimension; i++) {
                        // check row
                        Player rowPlayer = boardPositions[i][0].getOccupant();
                        if (arrayOccupiedByOnePlayer(boardPositions[i], rowPlayer)) {
                                return new BoardState(BoardStateType.WINNER, rowPlayer);
                        }

                        // check column
                        Player columnPlayer = boardPositions[0][i].getOccupant();
                        if (arrayOccupiedByOnePlayer(getColumnArray(boardPositions, boardDimension, i), columnPlayer)) {
                                return new BoardState(BoardStateType.WINNER, columnPlayer);
                        }
                }

                // check diagonals
                Player diagonalPlayer = boardPositions[0][0].getOccupant();
                if (arrayOccupiedByOnePlayer(getDiagonalLeftArray(boardPositions, boardDimension), diagonalPlayer)) {
                        return new BoardState(BoardStateType.WINNER, diagonalPlayer);
                }

                diagonalPlayer = boardPositions[0][boardDimension - 1].getOccupant();
                if (arrayOccupiedByOnePlayer(getDiagonalRightArray(boardPositions, boardDimension), diagonalPlayer)) {
                        return new BoardState(BoardStateType.WINNER, diagonalPlayer);
                }

                // check if a draw i.e. no empty positions
                if (isDraw(boardPositions, boardDimension))
                        return new BoardState(BoardStateType.DRAW);

                return new BoardState();
        }

        private boolean isDraw(BoardPosition[][] boardPositions, int boardDimension) {
                if (Stream.of(boardPositions).flatMap(x -> Stream.of(x)).anyMatch(bp -> bp.isEmpty()))
                        return false;
                return true;
        }

        private BoardPosition[] getDiagonalRightArray(BoardPosition[][] boardPositions, int boardDimension) {
                BoardPosition[] diagonal = new BoardPosition[boardDimension];
                for (int i = 0; i < boardDimension; i++) {
                        diagonal[i] = boardPositions[i][boardDimension - 1 - i];
                }
                return diagonal;
        }

        private BoardPosition[] getDiagonalLeftArray(BoardPosition[][] boardPositions, int boardDimension) {
                BoardPosition[] diagonal = new BoardPosition[boardDimension];
                for (int i = 0; i < boardDimension; i++) {
                        diagonal[i] = boardPositions[i][i];
                }
                return diagonal;
        }

        private BoardPosition[] getColumnArray(BoardPosition[][] boardPositions, int boardDimension, int colInd) {
                BoardPosition[] column = new BoardPosition[boardDimension];
                for (int i = 0; i < boardDimension; i++) {
                        column[i] = boardPositions[i][colInd];
                }
                return column;
        }

        private boolean arrayOccupiedByOnePlayer(BoardPosition[] boardPositions, Player player) {
                if (Stream.of(boardPositions).map(bp -> bp.getOccupant()).allMatch(Predicate.isEqual(player)))
                        return true;
                return false;
        }

}
