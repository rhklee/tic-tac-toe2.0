package com.mn.rl.board;

interface BoardStateDecider {
        public BoardState evaluate(BoardPosition[][] boardPositions, int boardDimension);
}
