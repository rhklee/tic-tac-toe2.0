package com.mn.rl.board;

import com.mn.rl.player.InvalidMoveException;
import com.mn.rl.player.Player;
import com.mn.rl.player.PlayerMove;

public interface Board {
        public void updateWithMove(Player currentPlayer, PlayerMove pMove) throws InvalidMoveException;
        public BoardState getBoardState();
        public int getBoardDimension();
        public void display();
}
