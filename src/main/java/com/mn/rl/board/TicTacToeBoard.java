package com.mn.rl.board;

import java.util.ArrayList;
import java.util.List;

import com.mn.rl.player.Player;
import com.mn.rl.player.PlayerMove;
import com.mn.rl.player.tactic.TicTacToeEntry;
import com.mn.rl.player.tactic.TicTacToeLine;

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
         * Update occupant with the player's move. It is expected the player move is
         * valid and the board position is not occupied.
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

        @Override
        public List<TicTacToeLine> getLines() {
                List<TicTacToeLine> lines = new ArrayList<TicTacToeLine>();
                // go through rows and lines
                for (int i = 0; i < boardDimension; i++) {
                        List<TicTacToeEntry> entriesRow = new ArrayList<>();
                        List<TicTacToeEntry> entriesCols = new ArrayList<>();
                        for (int j = 0; j < boardDimension; j++) {
                                entriesRow.add(new TicTacToeEntry(i + 1, j + 1, boardPositions[i][j]));
                                entriesCols.add(new TicTacToeEntry(j + 1, i + 1, boardPositions[j][i]));
                        }
                        lines.add(new TicTacToeLine(entriesRow, boardDimension));
                        lines.add(new TicTacToeLine(entriesCols, boardDimension));
                }

                // add two diagonals
                List<TicTacToeEntry> entriesLeftDiag = new ArrayList<>();
                List<TicTacToeEntry> entriesRightDiag = new ArrayList<>();
                for (int i = 0; i < boardDimension; i++) {
                        for (int j = 0; j < boardDimension; j++) {
                                entriesLeftDiag.add(new TicTacToeEntry(i + 1, j + 1, boardPositions[i][j]));
                                entriesRightDiag.add(new TicTacToeEntry(boardDimension - i, j + 1,
                                                boardPositions[boardDimension - 1 - i][j]));
                        }
                }

                lines.add(new TicTacToeLine(entriesLeftDiag, boardDimension));
                lines.add(new TicTacToeLine(entriesRightDiag, boardDimension));

                return lines;
        }

}
