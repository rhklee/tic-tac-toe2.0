package com.mn.rl.player;

public interface PlayerMove {
        public void validate(int boardDim) throws InvalidMoveException;
        public int getRow();
        public int getColumn();
}
