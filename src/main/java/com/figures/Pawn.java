package com.figures;

import com.enums.FigureColor;

import java.util.ArrayList;

public class Pawn extends BasicFigure {
    public Pawn(boolean isWhite) {
        super(isWhite);
    }

    public ArrayList<int[]> getMovementPossibilities(BasicFigure[][] matrixFigure, int i, int j, FigureColor playerColor) {
        ArrayList coordinatesList = new ArrayList();
        int k = 1;
        int l = 2;

        if (playerColor == FigureColor.WHITE) {
            if (i-k>-1  && j+k<8) {
                int[] coordinates = new int[2];
                if (matrixFigure[i - k][j + k].figureColor == FigureColor.BLACK) {
                    coordinates[0] = i - k;
                    coordinates[1] = j + k;
                    coordinatesList.add(coordinates);
                }
            }
            if (i -k > -1 && j - k > -1) {
                int[] coordinates = new int[2];
                if (matrixFigure[i - k][j - k].figureColor == FigureColor.BLACK) {
                    coordinates[0] = i - k;
                    coordinates[1] = j - k;
                    coordinatesList.add(coordinates);
                }
            }

            if(i-k>-1){
                int[]coordinates = new int[2];
                if (matrixFigure[i - k][j].figureColor == FigureColor.NONE) {
                    coordinates[0] = i - k;
                    coordinates[1] = j;
                    coordinatesList.add(coordinates);
                }
            }

            if(i ==6){
                int[]coordinates = new int[2];
                if (matrixFigure[i - l][j].figureColor == FigureColor.NONE) {
                    coordinates[0] = i - l;
                    coordinates[1] = j;
                    coordinatesList.add(coordinates);
                }
            }
        }

        if (playerColor == FigureColor.BLACK) {
            if (i + k < 8 && j+k<8) {
                int[] coordinates = new int[2];
                if (matrixFigure[i + k][j + k].figureColor == FigureColor.WHITE) {
                    coordinates[0] = i + k;
                    coordinates[1] = j + k;
                    coordinatesList.add(coordinates);
                }
            }
            if (i + k < 8 && j - k > -1) {
                int[] coordinates = new int[2];
                if (matrixFigure[i + k][j - k].figureColor == FigureColor.WHITE) {
                    coordinates[0] = i + k;
                    coordinates[1] = j - k;
                    coordinatesList.add(coordinates);
                }
            }

            if(i+k<8){
                int[]coordinates = new int[2];
                if (matrixFigure[i + k][j].figureColor == FigureColor.NONE) {
                    coordinates[0] = i + k;
                    coordinates[1] = j;
                    coordinatesList.add(coordinates);
                }
            }

            if(i ==1){
                int[]coordinates = new int[2];
                if (matrixFigure[i + l][j].figureColor == FigureColor.NONE) {
                    coordinates[0] = i + l;
                    coordinates[1] = j;
                    coordinatesList.add(coordinates);
                }
            }
        }
        return coordinatesList;
    }

    public boolean ifChangePawnToQueen(int rowIndex, FigureColor playerColor){
        if(playerColor == FigureColor.WHITE){
            return rowIndex == 0;
        } else {
            return rowIndex == 7;
        }
    }
}
