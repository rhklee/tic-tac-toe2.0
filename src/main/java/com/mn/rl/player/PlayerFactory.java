package com.mn.rl.player;

import java.util.ArrayList;
import java.util.List;

public class PlayerFactory {
        private static final String PLAYER_NAME_PREFIX = "Player %s";

        public static List<Player> generatePlayers(Character[] playerSymbols) {
                List<Player> players = new ArrayList<>();
                players.add(new TicTacToeHumanPlayer(String.format(PLAYER_NAME_PREFIX, 1), playerSymbols[0]));
                players.add(new TicTacToeHumanPlayer(String.format(PLAYER_NAME_PREFIX, 2), playerSymbols[1]));
                players.add(new TicTacToeComputerPlayer(String.format(PLAYER_NAME_PREFIX, 3), playerSymbols[2]));
                return players;
        }
}
