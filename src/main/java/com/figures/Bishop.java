package com.figures;
import com.enums.FigureColor;
import java.util.ArrayList;

public class Bishop extends BasicFigure{
    public Bishop(boolean isWhite) {
        super(isWhite);
    }

    public ArrayList<int[]> getMovementPossibilities(BasicFigure[][] matrixFigure, int i, int j, FigureColor playercolor){
        ArrayList coordinatesList = new ArrayList();
        for (int k=1; k<8; k++){
            int[] coordinates = new int[2];
            if(i+k<8 && j+k<8){
                if(matrixFigure[i+k][j+k].figureColor == FigureColor.NONE){
                    coordinates[0] =i+k;
                    coordinates[1] =j+k;
                    coordinatesList.add(coordinates);
                }
                else if(matrixFigure[i+k][j+k].figureColor == playercolor){
                    break;

                }
                else if(matrixFigure[i+k][j+k].figureColor != playercolor){
                    coordinates[0] =i+k;
                    coordinates[1] =j+k;
                    coordinatesList.add(coordinates);
                    break;
                }
            }
        }

        for (int k=1; k<8; k++){
            int[] coordinates = new int[2];
            if(i-k>-1 && j-k>-1){
                if(matrixFigure[i-k][j-k].figureColor == FigureColor.NONE){
                    coordinates[0] =i-k;
                    coordinates[1] =j-k;
                    coordinatesList.add(coordinates);
                }
                else if(matrixFigure[i-k][j-k].figureColor == playercolor){
                    break;
                }
                else if(matrixFigure[i-k][j-k].figureColor != playercolor){
                    coordinates[0] =i-k;
                    coordinates[1] =j-k;
                    coordinatesList.add(coordinates);
                    break;
                }
            }
        }

        for (int k=1; k<8; k++){
            int[] coordinates = new int[2];
            if(i+k<8 && j-k>-1){
                if(matrixFigure[i+k][j-k].figureColor == FigureColor.NONE){
                    coordinates[0] =i+k;
                    coordinates[1] =j-k;
                    coordinatesList.add(coordinates);
                }
                else if(matrixFigure[i+k][j-k].figureColor == playercolor){
                    break;
                }
                else if(matrixFigure[i+k][j-k].figureColor != playercolor){
                    coordinates[0] =i+k;
                    coordinates[1] =j-k;
                    coordinatesList.add(coordinates);
                    break;
                }
            }
        }

        for (int k=1; k<8; k++){
            int[] coordinates = new int[2];
            if(i-k>-1 && j+k<8){
                if(matrixFigure[i-k][j+k].figureColor == FigureColor.NONE){
                    coordinates[0] =i-k;
                    coordinates[1] =j+k;
                    coordinatesList.add(coordinates);
                }
                else if(matrixFigure[i-k][j+k].figureColor == playercolor){
                    break;
                }
                else if(matrixFigure[i-k][j+k].figureColor != playercolor){
                    coordinates[0] =i-k;
                    coordinates[1] =j+k;
                    coordinatesList.add(coordinates);
                    break;
                }
            }
        }
        return coordinatesList;
    }
}