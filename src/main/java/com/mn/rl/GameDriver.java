package com.mn.rl;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.mn.rl.board.BoardState;
import com.mn.rl.board.BoardStateType;

public class GameDriver {

        private static final String ENTER_CONFIG_ERR_MSG = "Enter config file.";
        private static final String CONFIG_DNE_ERR_MSG = "Config file doesn't exist.";
        private static final String CONFIG_FILE_READ_ERR_MSG = "Problem reading config file. Error: %s";
        private static final String GAMEPLAY_ERR_MSG = "There was an error during game play: %s";

        private static final String GAMEOVER_MSG = "The game is over.";
        private static final String DRAW_MSG = "The game was a draw.";
        private static final String WIN_MSG = "The game was won by %s.";

        public static void main(String[] args) {
                /*
                 * Read in configurations. 1. Board dimensions: 3 - 10 2. Players a. human / ai
                 * b. symbol
                 * 
                 * Check: 1. Valid dimensions 2. Player symbols are unique 3. Must be 3 players
                 * 4. Only one of the players must be ai
                 */
                if (args.length != 1) {
                        System.out.println(ENTER_CONFIG_ERR_MSG);
                        return;
                }

                if (!Files.exists(Paths.get(args[0]))) {
                        System.out.println(CONFIG_DNE_ERR_MSG);
                        return;
                }

                List<String> lines = null;
                try {
                        lines = Files.readAllLines(Paths.get(args[0]), StandardCharsets.UTF_8);
                } catch (IOException e) {
                        System.out.println(String.format(CONFIG_FILE_READ_ERR_MSG, e.getMessage()));
                }

                /*
                 * Initialize game.
                 */
                Game game = null;
                try {
                        game = GameFactory.makeTicTacToe(lines);
                } catch (InvalidGameSetup e) {
                        System.out.println(e.getMessage());
                        return;
                }

                /*
                 * Play the game.
                 */
                BoardState bs = null;
                try {
                        bs = game.play();
                } catch (Exception e) {
                        System.out.println(String.format(GAMEPLAY_ERR_MSG, e.getMessage()));
                } finally {
                        /*
                         * Conclude a game.
                         */
                        System.out.println(GAMEOVER_MSG);
                        if (bs != null) {
                                if (bs.getBoardStateType() == BoardStateType.WINNER)
                                        System.out.println(String.format(WIN_MSG, bs.getWinner().getPlayerName()));
                                else if (bs.getBoardStateType() == BoardStateType.DRAW)
                                        System.out.println(DRAW_MSG);
                        }
                }
        }
}
