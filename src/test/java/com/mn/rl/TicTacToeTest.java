package com.mn.rl;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.mn.rl.board.BoardStateType;
import com.mn.rl.player.Player;
import com.mn.rl.player.TicTacToeComputerPlayer;
import com.mn.rl.player.TicTacToeHumanPlayer;

public class TicTacToeTest {

        @Test
        public void check_initialization_is_correct() {
                final int dimension = 10;
                List<Player> players = new ArrayList<>();
                players.add(new TicTacToeHumanPlayer("Player 1", 'x'));
                players.add(new TicTacToeHumanPlayer("Player 2", 'o'));
                players.add(new TicTacToeComputerPlayer("Player 3", 'a'));

                Game game = new TicTacToe(dimension, players);

                assertAll(() -> assertEquals(dimension, game.getBoard().getBoardDimension()),
                                () -> assertEquals(players.get(0), game.getPlayerTurn().currentPlayer()),
                                () -> assertEquals(BoardStateType.PLAYING,
                                                game.getBoard().getBoardState().getBoardStateType()),
                                () -> assertNull(game.getBoard().getBoardState().getWinner()));
        }
}
