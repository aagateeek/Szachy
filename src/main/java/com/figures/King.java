package com.figures;

import com.enums.FigureColor;

import java.util.ArrayList;
import java.util.List;

public class King extends BasicFigure{
    public King(boolean isWhite){
        super(isWhite);
    }

    public ArrayList<int[]> getMovementPossibilities(BasicFigure[][] matrixFigure,int i, int j,FigureColor playerColor){
        ArrayList coordinatesList = new ArrayList();

        int k = 1;
        if(i+k<8 && j+k<8){
            int[] coordinates = new int[2];
            if(matrixFigure[i+k][j+k].figureColor == FigureColor.NONE){
                coordinates[0] =i+k;
                coordinates[1] =j+k;
                coordinatesList.add(coordinates);
            }
            else if(matrixFigure[i+k][j+k].figureColor != playerColor){
                coordinates[0] =i+k;
                coordinates[1] =j+k;
                coordinatesList.add(coordinates);
            }
        }

        if(i-k>-1 && j-k>-1){
            int[] coordinates = new int[2];
            if(matrixFigure[i-k][j-k].figureColor == FigureColor.NONE){
                coordinates[0] =i-k;
                coordinates[1] =j-k;
                coordinatesList.add(coordinates);
            }
            else if(matrixFigure[i-k][j-k].figureColor != playerColor){
                coordinates[0] =i-k;
                coordinates[1] =j-k;
                coordinatesList.add(coordinates);
            }
        }

        if(i+k<8 && j-k>-1){
            int[] coordinates = new int[2];
            if(matrixFigure[i+k][j-k].figureColor == FigureColor.NONE){
                coordinates[0] =i+k;
                coordinates[1] =j-k;
                coordinatesList.add(coordinates);
            }
            else if(matrixFigure[i+k][j-k].figureColor != playerColor){
                coordinates[0] =i+k;
                coordinates[1] =j-k;
                coordinatesList.add(coordinates);
            }
        }

        if(i-k>-1 && j+k<8){
            int[] coordinates = new int[2];
            if(matrixFigure[i-k][j+k].figureColor == FigureColor.NONE){
                coordinates[0] =i-k;
                coordinates[1] =j+k;
                coordinatesList.add(coordinates);
            }
            else if(matrixFigure[i-k][j+k].figureColor != playerColor){
                coordinates[0] =i-k;
                coordinates[1] =j+k;
                coordinatesList.add(coordinates);
            }
        }

        if(i+k<8){
            int[] coordinates = new int[2];
            if(matrixFigure[i+k][j].figureColor == FigureColor.NONE){
                coordinates[0] =i+k;
                coordinates[1] =j;
                coordinatesList.add(coordinates);
            }
            else if(matrixFigure[i+k][j].figureColor != playerColor){
                coordinates[0] =i+k;
                coordinates[1] =j;
                coordinatesList.add(coordinates);
            }
        }


        if (j + k < 8) {
            int[] coordinates = new int[2];
            if (matrixFigure[i][j + k].figureColor == FigureColor.NONE){
                coordinates[0] = i;
                coordinates[1] = j + k;
                coordinatesList.add(coordinates);
            }
            else if (matrixFigure[i][j + k].figureColor !=playerColor) {
                coordinates[0] = i;
                coordinates[1] = j + k;
                coordinatesList.add(coordinates);
            }
        }

        if (j-k>-1) {
            int[] coordinates = new int[2];
            if (matrixFigure[i][j-k].figureColor == FigureColor.NONE){
                coordinates[0] = i;
                coordinates[1] = j - k;
                coordinatesList.add(coordinates);
            }
            else if (matrixFigure[i][j - k].figureColor !=playerColor) {
                coordinates[0] = i;
                coordinates[1] = j - k;
                coordinatesList.add(coordinates);
            }
        }

        if (i-k>-1) {
            int[] coordinates = new int[2];
            if (matrixFigure[i-k][j].figureColor == FigureColor.NONE){
                coordinates[0] = i-k;
                coordinates[1] = j;
                coordinatesList.add(coordinates);
            }
            else if (matrixFigure[i-k][j].figureColor !=playerColor) {
                coordinates[0] = i-k;
                coordinates[1] = j;
                coordinatesList.add(coordinates);
            }
        }

    return coordinatesList;
    }

    public boolean isKing() {
        return true;
    }
}
