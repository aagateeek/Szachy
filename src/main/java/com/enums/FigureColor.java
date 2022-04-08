package com.enums;

public enum FigureColor {
    NONE, WHITE, BLACK;

    public static FigureColor getFigureColor(boolean isEmpty, boolean isWhite){
        if(isEmpty){
            return FigureColor.NONE;
        } else {
            if(isWhite){
                return FigureColor.WHITE;
            } else {
                return FigureColor.BLACK;
            }
        }
    }
}
