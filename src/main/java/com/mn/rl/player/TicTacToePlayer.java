//package com.mn.rl.player;
//
//import java.util.Scanner;
//
//public class TicTacToePlayer implements Player {
//
//        private final String playerName;
//        private final char playerSymbol;
//        private final PlayerType playerType;
//
//        public TicTacToePlayer(String playerName, char playerSymbol, PlayerType playerType) {
//                super();
//                this.playerName = playerName;
//                this.playerSymbol = playerSymbol;
//                this.playerType = playerType;
//        }
//
//        @Override
//        public String getPlayerName() {
//                return playerName;
//        }
//
//        @Override
//        public char getPlayerSymbol() {
//                return playerSymbol;
//        }
//
//        @Override
//        public PlayerMove move() throws InvalidMoveInputException {
//                switch (playerType) {
//                case HUMAN:
//                        System.out.println("Please make your move [e.g. in the form 'row,column']: ");
//                        try(Scanner sc = new Scanner(System.in)) {
//                                String inputLine = sc.nextLine().trim();
//                        }
//                        break;
//                case COMPUTER:
//                        break;
//                default:
//                        break;
//                }
//                
//                return null;
//        }
//
//}
