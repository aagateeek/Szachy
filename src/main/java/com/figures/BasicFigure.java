package com.figures;

import com.enums.FigureColor;

import java.util.ArrayList;

public abstract class BasicFigure {
    protected boolean isWhite;
    protected FigureColor figureColor;

    protected BasicFigure(boolean isWhite){
        this.isWhite = isWhite;
        this.figureColor = FigureColor.getFigureColor(false, isWhite);
    }

    protected BasicFigure() {}

    public boolean getIsWhite() {
        return isWhite;
    }

    public FigureColor getFigureColor(){
        return figureColor;
    }

    public abstract ArrayList<int[]> getMovementPossibilities(BasicFigure[][] matrixFigure,int i, int j, FigureColor playerColor);

    public boolean isKing() {
        return false;
    }

    public boolean ifChangePawnToQueen(int rowIndex, FigureColor playerColor){
        return false;
    }
}