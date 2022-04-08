package com.szachy;

import com.enums.FigureColor;
import com.figures.*;

import java.util.ArrayList;
import java.util.Optional;

public class MatrixFigureController {
    private BasicFigure[][] matrixFigure;

    public MatrixFigureController(){
        matrixFigure = new BasicFigure[8][8];
        matrixFigure[0][0] = new Rook(false);
        matrixFigure[0][1] = new Horse(false);
        matrixFigure[0][2] = new Bishop(false);
        matrixFigure[0][3] = new Queen(false);
        matrixFigure[0][4] = new King(false);
        matrixFigure[0][5] = new Bishop(false);
        matrixFigure[0][6] = new Horse(false);
        matrixFigure[0][7] = new Rook(false);
        matrixFigure[1][0] = new Pawn(false);
        matrixFigure[1][1] = new Pawn(false);
        matrixFigure[1][2] = new Pawn(false);
        matrixFigure[1][3] = new Pawn(false);
        matrixFigure[1][4] = new Pawn(false);
        matrixFigure[1][5] = new Pawn(false);
        matrixFigure[1][6] = new Pawn(false);
        matrixFigure[1][7] = new Pawn(false);

        for(int i=2; i<7; i++){
            for(int j=0; j<8; j++){
                matrixFigure[i][j] = new EmptyFigure();
            }
        }

        matrixFigure[7][0] = new Rook(true);
        matrixFigure[7][1] = new Horse(true);
        matrixFigure[7][2] = new Bishop(true);
        matrixFigure[7][3] = new Queen(true);
        matrixFigure[7][4] = new King(true);
        matrixFigure[7][5] = new Bishop(true);
        matrixFigure[7][6] = new Horse(true);
        matrixFigure[7][7] = new Rook(true);
        matrixFigure[6][0] = new Pawn(true);
        matrixFigure[6][1] = new Pawn(true);
        matrixFigure[6][2] = new Pawn(true);
        matrixFigure[6][3] = new Pawn(true);
        matrixFigure[6][4] = new Pawn(true);
        matrixFigure[6][5] = new Pawn(true);
        matrixFigure[6][6] = new Pawn(true);
        matrixFigure[6][7] = new Pawn(true);
    }

    public ArrayList<int[]> getMovementPossibilitiesFromFigure(FigureColor playerColor, int i, int j){
        return matrixFigure[i][j].getMovementPossibilities(matrixFigure,i,j, playerColor);
    }

    public BasicFigure getFigure(int i, int j){
        return matrixFigure[i][j];
    }

    public boolean canBeClicked(FigureColor playerColor, int i, int j) {
        return matrixFigure[i][j].getFigureColor() == playerColor;
    }

    public void moveFigure(int previousRowIndex, int previousColIndex, int rowIndex, int colIndex) {
        matrixFigure[rowIndex][colIndex] = matrixFigure[previousRowIndex][previousColIndex];
        matrixFigure[previousRowIndex][previousColIndex] = new EmptyFigure();
    }

    public boolean captureFigureAndIsKingCaptured(int previousRowIndex, int previousColIndex, int rowIndex, int colIndex) {
        boolean isKing = matrixFigure[rowIndex][colIndex].isKing();
        matrixFigure[rowIndex][colIndex] = matrixFigure[previousRowIndex][previousColIndex];
        matrixFigure[previousRowIndex][previousColIndex] = new EmptyFigure();
        return isKing;
    }

    public boolean isPawnChanged(int rowIndex, int colIndex, FigureColor playerColor) {
        if(matrixFigure[rowIndex][colIndex].ifChangePawnToQueen(rowIndex, playerColor)) {
            matrixFigure[rowIndex][colIndex] = new Queen(matrixFigure[rowIndex][colIndex].getIsWhite());
            return true;
        } else
            return false;
    }
}
