package com.mn.rl;

class InvalidGameSetup extends Exception {
        private static final long serialVersionUID = -7506104518415348329L;

        public InvalidGameSetup(String msg) {
                super(msg);
        }
}
