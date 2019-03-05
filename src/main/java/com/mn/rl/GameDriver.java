package com.mn.rl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

import com.mn.rl.board.BoardState;
import com.mn.rl.board.BoardStateType;
import com.mn.rl.player.Player;
import com.mn.rl.player.PlayerFactory;

public class GameDriver {
        private static final String INCORRECT_COMMAND_LINE_ARGS_MSG = "Enter two arguements. The first a integer 3-10 and the second 3 distinct comma separated non-whitespace characters.";

        public static void main(String[] args) {
                /*
                 * Read in configurations. 1. Board dimensions: 3 - 10 2. Players a. human / ai
                 * b. symbol
                 * 
                 * Check: 1. Valid dimensions 2. Player symbols are unique 3. Must be 3 players
                 * 4. Only one of the players must be ai
                 */

                if (args.length != 2) {
                        System.out.println(INCORRECT_COMMAND_LINE_ARGS_MSG);
                        return;
                }

                if (!Pattern.compile("\\d+").matcher(args[0]).matches()) {
                        System.out.println(INCORRECT_COMMAND_LINE_ARGS_MSG);
                        return;
                }

                if (!Pattern.compile("\\S,\\S,\\S").matcher(args[1]).matches()) {
                        System.out.println(INCORRECT_COMMAND_LINE_ARGS_MSG);
                        return;
                }

                int dimension = Integer.valueOf(args[0]);
                Character[] playerSymbols = Arrays.stream(args[1].split(",")).map(i -> i.charAt(0))
                                .toArray(Character[]::new);

                try {
                        GameSetupConstraints.validateBoardDimension(dimension);
                        GameSetupConstraints.validatePlayerSymbols(playerSymbols);
                } catch (InvalidGameSetup e) {
                        System.out.println(e.getMessage());
                }

                List<Player> players = PlayerFactory.generatePlayers(playerSymbols);

                // randomly shuffle players.
                Collections.shuffle(players);

                /*
                 * Initialize game.
                 */
                Game game = new TicTacToe(dimension, players);

                /*
                 * Play the game.
                 */
                BoardState bs = null;
                try {
                        bs = game.play();
                } catch (Exception e) {
                        System.out.println(String.format("There was an error during game play: %s", e.getMessage()));
                } finally {
                        /*
                         * Conclude a game.
                         */
                        System.out.println("The game is over.");
                        if (bs != null) {
                                if (bs.getBoardStateType() == BoardStateType.WINNER)
                                        System.out.println(String.format("The game was won by %s.",
                                                        bs.getWinner().getPlayerName()));
                                else if (bs.getBoardStateType() == BoardStateType.DRAW)
                                        System.out.println("The game was a draw.");
                        }
                }
        }
}
