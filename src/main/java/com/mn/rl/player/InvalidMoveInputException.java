package com.mn.rl.player;

public class InvalidMoveInputException extends Exception {

        /**
         * 
         */
        private static final long serialVersionUID = -3393755406092172147L;

        public InvalidMoveInputException(String msg) {
                super(msg);
        }

        public InvalidMoveInputException(String msg, Throwable throwable) {
                super(msg, throwable);
        }
}
