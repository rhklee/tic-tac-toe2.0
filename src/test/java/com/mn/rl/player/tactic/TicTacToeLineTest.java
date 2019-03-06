package com.mn.rl.player.tactic;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.mn.rl.board.BoardPosition;
import com.mn.rl.player.Player;
import com.mn.rl.player.PlayerFactory;

public class TicTacToeLineTest {

        private static Player p1;
        private static Player p2;
        private static Player p3;

        @BeforeAll
        public static void setup() {
                List<Player> players = PlayerFactory.generatePlayers(new Character[] { 'x', 'y', 'z' });
                p1 = players.get(0);
                p2 = players.get(1);
                p3 = players.get(2);
        }

        @Test
        public void score_line_empty() {
                List<TicTacToeEntry> entries = new ArrayList<>();
                entries.add(new TicTacToeEntry(1, 1, new BoardPosition()));
                entries.add(new TicTacToeEntry(1, 2, new BoardPosition()));
                entries.add(new TicTacToeEntry(1, 3, new BoardPosition()));
                entries.add(new TicTacToeEntry(1, 4, new BoardPosition()));
                entries.add(new TicTacToeEntry(1, 5, new BoardPosition()));
                TicTacToeLine line = new TicTacToeLine(entries, 5);
                assertEquals(0, line.score(p1));
        }

        @Test
        public void score_line_one_entry() {
                List<TicTacToeEntry> entries = new ArrayList<>();
                entries.add(new TicTacToeEntry(1, 1, new BoardPosition(false, p1)));
                entries.add(new TicTacToeEntry(1, 2, new BoardPosition()));
                entries.add(new TicTacToeEntry(1, 3, new BoardPosition()));
                entries.add(new TicTacToeEntry(1, 4, new BoardPosition()));
                entries.add(new TicTacToeEntry(1, 5, new BoardPosition()));
                TicTacToeLine line = new TicTacToeLine(entries, 5);
                assertEquals(1, line.score(p1));
        }

        @Test
        public void score_line_one_opponent_entry() {
                List<TicTacToeEntry> entries = new ArrayList<>();
                entries.add(new TicTacToeEntry(1, 1, new BoardPosition(false, p2)));
                entries.add(new TicTacToeEntry(1, 2, new BoardPosition()));
                entries.add(new TicTacToeEntry(1, 3, new BoardPosition()));
                entries.add(new TicTacToeEntry(1, 4, new BoardPosition()));
                entries.add(new TicTacToeEntry(1, 5, new BoardPosition()));
                TicTacToeLine line = new TicTacToeLine(entries, 5);
                assertEquals(-1, line.score(p1));
        }
        
        @Test
        public void score_line_one_almost_full_line() {
                List<TicTacToeEntry> entries = new ArrayList<>();
                entries.add(new TicTacToeEntry(1, 1, new BoardPosition(false, p1)));
                entries.add(new TicTacToeEntry(1, 2, new BoardPosition(false, p1)));
                entries.add(new TicTacToeEntry(1, 3, new BoardPosition(false, p1)));
                entries.add(new TicTacToeEntry(1, 4, new BoardPosition(false, p1)));
                entries.add(new TicTacToeEntry(1, 5, new BoardPosition()));
                TicTacToeLine line = new TicTacToeLine(entries, 5);
                assertEquals(4, line.score(p1));
        }
}
