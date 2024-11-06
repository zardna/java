package org.digitalstack.chess;

public class ChessBoard {

    public static int BOARD_WIDTH = 7;
    public static int BOARD_HEIGHT = 7;

    private final Pawn[][] pieces;

    public ChessBoard() {
        pieces = new Pawn[BOARD_WIDTH][BOARD_HEIGHT];
    }

    public void add(Pawn pawn, int xCoordinate, int yCoordinate, PieceColor pieceColor) {

        if (isLegalBoardPosition(xCoordinate, yCoordinate) && pieces[xCoordinate][yCoordinate] == null && countPawns()<pieces.length) {
            pawn.setXCoordinate(xCoordinate);
            pawn.setYCoordinate(yCoordinate);
            pieces[xCoordinate][yCoordinate] = pawn;
        }
        else {
            pawn.setXCoordinate(-1);
            pawn.setYCoordinate(-1);
        }

    }

    public boolean isLegalBoardPosition(int xCoordinate, int yCoordinate) {
        return xCoordinate >= 0 && xCoordinate < 7 && yCoordinate >= 0 && yCoordinate < 7;
    }

    public int countPawns() {
        int pieceCount=0;
        for(int i = 0;i<BOARD_WIDTH;i++){
            for(int j=0;j<BOARD_HEIGHT;j++){
                if(pieces[i][j]!=null){
                    pieceCount++;
                }
            }
        }
        return pieceCount;
    }
}
