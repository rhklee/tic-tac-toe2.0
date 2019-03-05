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
                if (configurations.size() != 2)
                        throw new InvalidGameSetup(CONFIG_INVALID);
                if (!Pattern.compile("\\d+").matcher(configurations.get(0)).matches())
                        throw new InvalidGameSetup(CONFIG_INVALID);
                if (!Pattern.compile("\\S,\\S,\\S").matcher(configurations.get(1)).matches())
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

}
