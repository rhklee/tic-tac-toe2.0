package com.mn.rl.board;

public interface BoardStateDecider {
        public BoardState evaluate(BoardPosition[][] boardPositions, int boardDimension);
}
