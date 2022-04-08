package com.figures;
import com.enums.FigureColor;
import java.util.ArrayList;

public class Horse extends BasicFigure{
    public Horse(boolean isWhite) {
        super(isWhite);
    }

    public ArrayList<int[]> getMovementPossibilities(BasicFigure[][] matrixFigure, int i, int j, FigureColor playerColor) {
        ArrayList coordinatesList = new ArrayList();

        int k = 1;
        int l = 2;
        if(i+k<8 && j+l<8){
            int[] coordinates = new int[2];
            if(matrixFigure[i+k][j+l].figureColor == FigureColor.NONE){
                coordinates[0] =i+k;
                coordinates[1] =j+l;
                coordinatesList.add(coordinates);
            }
            else if(matrixFigure[i+k][j+l].figureColor != playerColor){
                coordinates[0] =i+k;
                coordinates[1] =j+l;
                coordinatesList.add(coordinates);
            }
        }

        if(i-k>-1 && j-l>-1){
            int[] coordinates = new int[2];
            if(matrixFigure[i-k][j-l].figureColor == FigureColor.NONE){
                coordinates[0] =i-k;
                coordinates[1] =j-l;
                coordinatesList.add(coordinates);
            }
            else if(matrixFigure[i-k][j-l].figureColor != playerColor){
                coordinates[0] =i-k;
                coordinates[1] =j-l;
                coordinatesList.add(coordinates);
            }
        }

        if(i+k<8 && j-l>-1){
            int[] coordinates = new int[2];
            if(matrixFigure[i+k][j-l].figureColor == FigureColor.NONE){
                coordinates[0] =i+k;
                coordinates[1] =j-l;
                coordinatesList.add(coordinates);
            }
            else if(matrixFigure[i+k][j-l].figureColor != playerColor){
                coordinates[0] =i+k;
                coordinates[1] =j-l;
                coordinatesList.add(coordinates);
            }
        }

        if(i-k>-1 && j+l<8){
            int[] coordinates = new int[2];
            if(matrixFigure[i-k][j+l].figureColor == FigureColor.NONE){
                coordinates[0] =i-k;
                coordinates[1] =j+l;
                coordinatesList.add(coordinates);
            }
            else if(matrixFigure[i-k][j+l].figureColor != playerColor){
                coordinates[0] =i-k;
                coordinates[1] =j+l;
                coordinatesList.add(coordinates);
            }
        }

        if(i+l<8 && j+k<8){
            int[] coordinates = new int[2];
            if(matrixFigure[i+l][j+k].figureColor == FigureColor.NONE){
                coordinates[0] =i+l;
                coordinates[1] =j+k;
                coordinatesList.add(coordinates);
            }
            else if(matrixFigure[i+l][j+k].figureColor != playerColor){
                coordinates[0] =i+l;
                coordinates[1] =j+k;
                coordinatesList.add(coordinates);
            }
        }

        if(i-l>-1 && j-k>-1){
            int[] coordinates = new int[2];
            if(matrixFigure[i-l][j-k].figureColor == FigureColor.NONE){
                coordinates[0] =i-l;
                coordinates[1] =j-k;
                coordinatesList.add(coordinates);
            }
            else if(matrixFigure[i-l][j-k].figureColor != playerColor){
                coordinates[0] =i-l;
                coordinates[1] =j-k;
                coordinatesList.add(coordinates);
            }
        }

        if(i+l<8 && j-k>-1){
            int[] coordinates = new int[2];
            if(matrixFigure[i+l][j-k].figureColor == FigureColor.NONE){
                coordinates[0] =i+l;
                coordinates[1] =j-k;
                coordinatesList.add(coordinates);
            }
            else if(matrixFigure[i+l][j-k].figureColor != playerColor){
                coordinates[0] =i+l;
                coordinates[1] =j-k;
                coordinatesList.add(coordinates);
            }
        }

        if(i-l>-1 && j+k<8){
            int[] coordinates = new int[2];
            if(matrixFigure[i-l][j+k].figureColor == FigureColor.NONE){
                coordinates[0] =i-l;
                coordinates[1] =j+k;
                coordinatesList.add(coordinates);
            }
            else if(matrixFigure[i-l][j+k].figureColor != playerColor){
                coordinates[0] =i-l;
                coordinates[1] =j+k;
                coordinatesList.add(coordinates);
            }
        }
        return coordinatesList;
    }
}