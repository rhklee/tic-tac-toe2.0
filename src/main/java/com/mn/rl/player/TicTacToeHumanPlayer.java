package com.mn.rl.player;

import com.mn.rl.board.Board;

public class TicTacToeHumanPlayer extends Player {

        public TicTacToeHumanPlayer(String playerName, char playerSymbol) {
                this.playerName = playerName;
                this.playerSymbol = playerSymbol;
                this.playerType = PlayerType.HUMAN;
        }

        @Override
        public PlayerMove move(Board board) throws InvalidMoveInputException {
                // TODO Auto-generated method stub
                return null;
        }

        
        
//        @Override
//        public PlayerMove move(Board board) throws InvalidMoveInputException {
//                board.display();
//                System.out.print(String.format("%s please make your move [e.g. in the form 'row,column']: ",
//                                playerName));
//                try {
//                        String input = null;
//
//                        System.out.println("DEBUG: [" + input + "]");
//
//                        if (!Pattern.compile("\\d+,\\d+").matcher(input).matches()) {
//                                System.out.println("Throwing InvalidMoveInputException...");
//                                throw new InvalidMoveInputException("Comma separated integers were not entered.");
//                        }
//                        // if (!sc.hasNext(Pattern.compile("\\d+,\\d+"))) {
//                        // sc.next();
//                        // throw new InvalidMoveInputException("Comma separated integers were not
//                        // entered.");
//                        // }
//                        String[] rowColPair = input.split(",");
//                        System.out.println("rowColPair = " + Arrays.deepToString(rowColPair));
//                        // sc.next();
//                        // if(!input.contains(",")) {
//                        // throw new InvalidMoveInputException("Comma separated integers were not
//                        // entered.");
//                        // }
//                        // String[] rowColPair = input.split(",");
//                        // if (rowColPair.length != 2) {
//                        // throw new InvalidMoveInputException("Comma separated integers were not
//                        // entered.");
//                        // }
//
//                        int rowInd = Integer.valueOf(rowColPair[0]);
//                        int colInd = Integer.valueOf(rowColPair[1]);
//                        System.out.println(String.format("r = %s : c = %s", rowInd, colInd));
//                        return new TicTacToePlayerMove(rowInd, colInd);
//                } catch (NumberFormatException e) {
//                        throw new InvalidMoveInputException("Non-integer row,column pair was entered.", e);
//                }
//        }

}
