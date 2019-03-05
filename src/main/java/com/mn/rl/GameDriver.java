package com.mn.rl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.mn.rl.player.Player;
import com.mn.rl.player.TicTacToeComputerPlayer;
import com.mn.rl.player.TicTacToeHumanPlayer;

public class GameDriver {

        public static void main(String[] args) {
                /*
                 * Read in configurations.
                 * 1. Board dimensions: 3 - 10
                 * 2. Players
                 *      a. human / ai
                 *      b. symbol
                 *      
                 * Check:
                 * 1. Valid dimensions
                 * 2. Player symbols are unique
                 * 3. Must be 3 players
                 * 4. Only one of the players must be ai
                 */
                final int dimension = 10;
                List<Player> players = new ArrayList<>();
                players.add(new TicTacToeHumanPlayer("Player 1", 'x'));
                players.add(new TicTacToeHumanPlayer("Player 2", 'o'));
                players.add(new TicTacToeComputerPlayer("Player 3", 'a'));
                // randomly shuffle players.
                Collections.shuffle(players);

                /*
                 * Initialize game.
                 */
                Game game = new TicTacToe(dimension, players);

                /*
                 * Play the game.
                 */
                while (game.getGameState() == GameState.ACTIVE) {
                        game.playTurn();
                }

                /*
                 * Conclude an inactive game.
                 */
                System.out.println("The game is over.");
        }
}
