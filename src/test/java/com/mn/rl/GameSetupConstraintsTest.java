package com.mn.rl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class GameSetupConstraintsTest {

        @Test
        public void throw_dim_constraint_exception() {
                String expectedExceptionMsg = "Given board dimension size is 11 is invalid.";
                Throwable t = assertThrows(InvalidGameSetup.class,
                                () -> GameSetupConstraints.validateBoardDimension(11));
                assertEquals(expectedExceptionMsg, t.getMessage());
        }

        @Test
        public void throw_dim_constraint_exception2() {
                String expectedExceptionMsg = "Given board dimension size is 2 is invalid.";
                Throwable t = assertThrows(InvalidGameSetup.class,
                                () -> GameSetupConstraints.validateBoardDimension(2));
                assertEquals(expectedExceptionMsg, t.getMessage());
        }

        @Test
        public void throw_unique_constraint() {
                String expectedExceptionMsg = "The given player symbols are non-unique.";
                Throwable t = assertThrows(InvalidGameSetup.class,
                                () -> GameSetupConstraints.validatePlayerSymbols(new Character[] { 'x', 'o', 'x' }));
                assertEquals(expectedExceptionMsg, t.getMessage());
        }

        @Test
        public void throw_unique_constraint_non_unique() {
                String expectedExceptionMsg = "The given player symbols are non-unique.";
                Throwable t = assertThrows(InvalidGameSetup.class,
                                () -> GameSetupConstraints.validatePlayerSymbols(new Character[] { 'o', 'o', 'o' }));
                assertEquals(expectedExceptionMsg, t.getMessage());
        }
}
