package com.mn.rl.player.tactic;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

import com.mn.rl.board.Board;
import com.mn.rl.player.Player;
import com.mn.rl.player.PlayerMove;

public class GreedyComputerTicTacToeTactics implements ComputerTicTacToeTactics {

        @Override
        public PlayerMove generateMove(Board board, Player player) {
                Map<Integer, TicTacToeLine> scoreToPath = new TreeMap<>();

                for (TicTacToeLine line : board.getLines()) {
                        scoreToPath.put(line.score(player), line);
                }

                // return a random empty position from the line with highest score
                TicTacToeLine line = scoreToPath.get(Collections.max(scoreToPath.keySet()));
                return line.getRandomEmpty();
        }

}
