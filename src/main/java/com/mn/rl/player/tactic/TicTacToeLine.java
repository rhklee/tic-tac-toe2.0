package com.mn.rl.player.tactic;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import com.mn.rl.player.Player;
import com.mn.rl.player.PlayerMove;
import com.mn.rl.player.TicTacToePlayerMove;

public class TicTacToeLine {

        private final List<TicTacToeEntry> entries;
        private final int lineLength;

        public TicTacToeLine(List<TicTacToeEntry> entries, int lineLength) {
                this.entries = entries;
                this.lineLength = lineLength;
        }

        public List<TicTacToeEntry> getEntries() {
                return entries;
        }

        public int getLineLength() {
                return lineLength;
        }

        public Integer score(Player player) {
                int score = lineLength;

                for (TicTacToeEntry entry : entries) {
                        // if line is unwinnable return -1
                        if (!entry.getBoardPosition().isEmpty() &&
                             entry.getBoardPosition().getOccupant() != player)
                                return -1;
                        
                        // else subtract from max score
                        if(entry.getBoardPosition().isEmpty()) {
                                score--;
                        }
                }

                return score;
        }

        public PlayerMove getRandomEmpty() {
                List<TicTacToeEntry> validEntries = entries.stream().filter(i -> i.getBoardPosition().isEmpty())
                                .collect(Collectors.toList());
                int randomEntryPosition = ThreadLocalRandom.current().nextInt(0, validEntries.size());
                TicTacToeEntry entry = validEntries.get(randomEntryPosition);
                return new TicTacToePlayerMove(entry.getRowInd(), entry.getColInd());
        }
}
