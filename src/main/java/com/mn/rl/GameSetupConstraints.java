package com.mn.rl;

import java.util.stream.Stream;

public class GameSetupConstraints {

        private static final int BOARD_DIM_LOWER_BOUND = 3;
        private static final int BOARD_DIM_UPPER_BOUND = 10;

        private static final String BOARD_DIM_ERR_MSG = "Given board dimension size is %s is invalid.";

        private static final String PLAYER_SYMBOLS_INVALID_MSG = "The given player symbols are non-unique.";

        public static void validateBoardDimension(int d) throws InvalidGameSetup {
                if (d < BOARD_DIM_LOWER_BOUND || d > BOARD_DIM_UPPER_BOUND)
                        throw new InvalidGameSetup(String.format(BOARD_DIM_ERR_MSG, d));
        }

        public static void validatePlayerSymbols(Character[] playerSymbols) throws InvalidGameSetup {
                if (Stream.of(playerSymbols).distinct().count() != playerSymbols.length)
                        throw new InvalidGameSetup(PLAYER_SYMBOLS_INVALID_MSG);
        }

}
