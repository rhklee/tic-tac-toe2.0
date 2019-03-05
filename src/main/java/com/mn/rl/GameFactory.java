package com.mn.rl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

import com.mn.rl.player.Player;
import com.mn.rl.player.PlayerFactory;

public class GameFactory {

        private static final String CONFIG_INVALID = "Invalid configuration file.";

        public static Game makeTicTacToe(List<String> configurations) throws InvalidGameSetup {
                if (configurations == null)
                        throw new InvalidGameSetup(CONFIG_INVALID);
                if (!validNumberOfConfigInstructions(configurations.size()))
                        throw new InvalidGameSetup(CONFIG_INVALID);
                if (!isInteger(configurations.get(0)))
                        throw new InvalidGameSetup(CONFIG_INVALID);
                if (!isCharSymbols(configurations.get(1)))
                        throw new InvalidGameSetup(CONFIG_INVALID);

                int boardSize = Integer.valueOf(configurations.get(0));
                Character[] playerSymbols = Arrays.stream(configurations.get(1).split(",")).map(i -> i.charAt(0))
                                .toArray(Character[]::new);

                GameSetupConstraints.validateBoardDimension(boardSize);
                GameSetupConstraints.validatePlayerSymbols(playerSymbols);

                List<Player> players = PlayerFactory.generatePlayers(playerSymbols);
                Collections.shuffle(players);

                return new TicTacToe(boardSize, players);
        }

        private static boolean validNumberOfConfigInstructions(int size) {
                return size == 2;
        }

        private static boolean isInteger(String intStr) {
                return Pattern.compile("\\d+").matcher(intStr).matches();
        }
        
        private static boolean isCharSymbols(String symbols) {
                return Pattern.compile("\\S,\\S,\\S").matcher(symbols).matches();
        }
}
