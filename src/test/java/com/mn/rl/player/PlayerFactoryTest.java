package com.mn.rl.player;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class PlayerFactoryTest {

        @Test
        public void generate_factory_defaults_check_player_types() {
                List<Player> players = PlayerFactory.generatePlayers(new Character[] { 'x', 'o', 'u' });
                assertAll(() -> assertEquals(PlayerType.HUMAN, players.get(0).getPlayerType()),
                                () -> assertEquals(PlayerType.HUMAN, players.get(1).getPlayerType()),
                                () -> assertEquals(PlayerType.COMPUTER, players.get(2).getPlayerType()));
        }

        @Test
        public void generate_factory_defaults_check_player_symbols() {
                List<Player> players = PlayerFactory.generatePlayers(new Character[] { 'x', 'o', 'u' });
                assertAll(() -> assertEquals('x', players.get(0).getPlayerSymbol()),
                                () -> assertEquals('o', players.get(1).getPlayerSymbol()),
                                () -> assertEquals('u', players.get(2).getPlayerSymbol()));
        }
}
