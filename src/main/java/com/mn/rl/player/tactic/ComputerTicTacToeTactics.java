package com.mn.rl.player.tactic;

import com.mn.rl.board.Board;
import com.mn.rl.player.Player;
import com.mn.rl.player.PlayerMove;

public interface ComputerTicTacToeTactics {
        PlayerMove generateMove(Board board, Player player);
}
