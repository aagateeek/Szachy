package com.figures;

import com.enums.FigureColor;

import java.util.ArrayList;

public class EmptyFigure extends BasicFigure{
    public EmptyFigure(){
        this.figureColor = FigureColor.getFigureColor(true, false);
    }

    public ArrayList<int[]> getMovementPossibilities(BasicFigure[][] matrixFigure, int i, int j, FigureColor playerColor) {
        return null;
    }
}
