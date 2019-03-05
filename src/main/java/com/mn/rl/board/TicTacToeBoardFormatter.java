package com.mn.rl.board;

public class TicTacToeBoardFormatter implements BoardFormatter {

        private final static char EMPTY_SPOT = '_';

        public TicTacToeBoardFormatter() {
                super();
        }

        @Override
        public String format(BoardPosition[][] boardPositions, int boardDimension) {
                String output = "";

                for (int rInd = 0; rInd < boardDimension; rInd++) {
                        for (int cInd = 0; cInd < boardDimension; cInd++) {
                                BoardPosition boardPosition = boardPositions[rInd][cInd];
                                if (boardPosition.isEmpty())
                                        output += EMPTY_SPOT;
                                else
                                        output += boardPosition.getOccupant().getPlayerSymbol();
                        }
                        output += '\n';
                }

                return output;
        }

}
