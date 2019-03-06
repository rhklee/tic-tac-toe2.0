package com.mn.rl.board;

public class BoardFactory {
        public static TicTacToeBoard makeTicTacToeBoard(int boardSize) {
                return new TicTacToeBoard(boardSize, new TicTacToeBoardFormatter(), new TicTacToeBoardStateDecider());
        }
}
