package com.mn.rl.player;

import com.mn.rl.board.Board;

public interface PlayerMove {
        public void validate(Board board) throws InvalidMoveException;
        public int getRow();
        public int getColumn();
}
