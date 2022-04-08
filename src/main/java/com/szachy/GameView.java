package com.szachy;

import com.enums.FigureColor;
import com.figures.BasicFigure;
import java.io.IOException;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class GameView {
    private MatrixFigureController matrixFigureController;
    private BasicFigure clickedFigure;
    private int previousRowIndex;
    private int previousColIndex;
    private FigureColor playerColor;
    private Pane[][] paneMatrix;
    private boolean ifUnlockCells;
    private ImageView whiteQueen;
    private ImageView blackQueen;
    @FXML
    private GridPane chessboard;
    @FXML
    private Label playerLabel;
    @FXML
    private Label winLabel;
    @FXML
    private ImageView whiteQueenImageView;
    @FXML
    private ImageView blackQueenImageView;
    @FXML
    private Pane pane00;
    @FXML
    private Pane pane01;
    @FXML
    private Pane pane02;
    @FXML
    private Pane pane03;
    @FXML
    private Pane pane04;
    @FXML
    private Pane pane05;
    @FXML
    private Pane pane06;
    @FXML
    private Pane pane07;
    @FXML
    private Pane pane10;
    @FXML
    private Pane pane11;
    @FXML
    private Pane pane12;
    @FXML
    private Pane pane13;
    @FXML
    private Pane pane14;
    @FXML
    private Pane pane15;
    @FXML
    private Pane pane16;
    @FXML
    private Pane pane17;
    @FXML
    private Pane pane20;
    @FXML
    private Pane pane21;
    @FXML
    private Pane pane22;
    @FXML
    private Pane pane23;
    @FXML
    private Pane pane24;
    @FXML
    private Pane pane25;
    @FXML
    private Pane pane26;
    @FXML
    private Pane pane27;
    @FXML
    private Pane pane30;
    @FXML
    private Pane pane31;
    @FXML
    private Pane pane32;
    @FXML
    private Pane pane33;
    @FXML
    private Pane pane34;
    @FXML
    private Pane pane35;
    @FXML
    private Pane pane36;
    @FXML
    private Pane pane37;
    @FXML
    private Pane pane40;
    @FXML
    private Pane pane41;
    @FXML
    private Pane pane42;
    @FXML
    private Pane pane43;
    @FXML
    private Pane pane44;
    @FXML
    private Pane pane45;
    @FXML
    private Pane pane46;
    @FXML
    private Pane pane47;
    @FXML
    private Pane pane50;
    @FXML
    private Pane pane51;
    @FXML
    private Pane pane52;
    @FXML
    private Pane pane53;
    @FXML
    private Pane pane54;
    @FXML
    private Pane pane55;
    @FXML
    private Pane pane56;
    @FXML
    private Pane pane57;
    @FXML
    private Pane pane60;
    @FXML
    private Pane pane61;
    @FXML
    private Pane pane62;
    @FXML
    private Pane pane63;
    @FXML
    private Pane pane64;
    @FXML
    private Pane pane65;
    @FXML
    private Pane pane66;
    @FXML
    private Pane pane67;
    @FXML
    private Pane pane70;
    @FXML
    private Pane pane71;
    @FXML
    private Pane pane72;
    @FXML
    private Pane pane73;
    @FXML
    private Pane pane74;
    @FXML
    private Pane pane75;
    @FXML
    private Pane pane76;
    @FXML
    private Pane pane77;

    public static void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("game-view.fxml"));
        Scene scene = new Scene((Parent)fxmlLoader.load(), 675.0, 423.0);
        stage.setTitle("Chess");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void initialize() {
        setPaneMatrix();
        setQueen();
        playerColor = FigureColor.WHITE;
        playerLabel.setText("White");
        clickedFigure = null;
        ifUnlockCells = true;

        chessboard.setOnMouseClicked((actionEvent) -> {
            Node clickedNode = actionEvent.getPickResult().getIntersectedNode();
            if (clickedNode.getCursor() == Cursor.HAND) {
                Integer rowIndex = GridPane.getRowIndex(clickedNode);
                Integer colIndex = GridPane.getColumnIndex(clickedNode);
                if (rowIndex != null && colIndex != null) {
                    clickedFigure = matrixFigureController.getFigure(rowIndex - 1, colIndex - 1);
                    if (clickedFigure.getFigureColor() == playerColor) {
                        unlockCells();
                        ArrayList<int[]> coordinatesList = matrixFigureController.getMovementPossibilitiesFromFigure(playerColor, rowIndex - 1, colIndex - 1);

                        for(int[] coordinate : coordinatesList) {
                            getNode(coordinate[0] + 1, coordinate[1] + 1).setCursor(Cursor.HAND);
                            previousRowIndex = rowIndex;
                            previousColIndex = colIndex;
                        }
                    } else {
                        if (clickedFigure.getFigureColor() == FigureColor.NONE) {
                            paneMatrix[rowIndex - 1][colIndex - 1].getChildren().addAll(paneMatrix[previousRowIndex - 1][previousColIndex - 1].getChildren());
                            matrixFigureController.moveFigure(previousRowIndex - 1, previousColIndex - 1, rowIndex - 1, colIndex - 1);

                        } else {
                            paneMatrix[rowIndex - 1][colIndex - 1].getChildren().clear();
                            paneMatrix[rowIndex - 1][colIndex - 1].getChildren().addAll(paneMatrix[previousRowIndex - 1][previousColIndex - 1].getChildren());
                            if (matrixFigureController.captureFigureAndIsKingCaptured(previousRowIndex - 1, previousColIndex - 1, rowIndex - 1, colIndex - 1)) {
                                for(int i=1; i<9; i++){
                                    for(int j=1; j<9; j++){
                                        getNode(i,j).setCursor(Cursor.DEFAULT);
                                    }
                                }
                                if (playerColor == FigureColor.WHITE) {
                                    winLabel.setText("Player White won the game!");
                                } else {
                                    winLabel.setText("Player Black won the game!");
                                }
                                ifUnlockCells = false;
                            }
                        }

                        if(matrixFigureController.isPawnChanged(rowIndex - 1, colIndex - 1, playerColor)){
                            paneMatrix[rowIndex - 1][colIndex - 1].getChildren().clear();
                            if(playerColor == FigureColor.WHITE)
                                paneMatrix[rowIndex - 1][colIndex - 1].getChildren().add(whiteQueen);
                            else
                                paneMatrix[rowIndex - 1][colIndex - 1].getChildren().add(blackQueen);
                        }

                        if (playerColor == FigureColor.WHITE) {
                            playerColor = FigureColor.BLACK;
                            playerLabel.setText("Black");
                        } else {
                            playerColor = FigureColor.WHITE;
                            playerLabel.setText("White");
                        }

                        if(ifUnlockCells)
                            unlockCells();
                    }
                }
            }

        });
        matrixFigureController = new MatrixFigureController();
    }

    private void setQueen() {
        whiteQueen = new ImageView();
        whiteQueen.setDisable(true);
        whiteQueen.setFitHeight(40);
        whiteQueen.setFitWidth(45);
        whiteQueen.setLayoutX(2);
        whiteQueen.setLayoutY(2);
        whiteQueen.setPickOnBounds(true);
        whiteQueen.setPreserveRatio(true);
        Image whiteQueenImage = new Image(whiteQueenImageView.getImage().getUrl());
        whiteQueen.setImage(whiteQueenImage);

        blackQueen = new ImageView();
        blackQueen.setDisable(true);
        blackQueen.setFitHeight(40);
        blackQueen.setFitWidth(45);
        blackQueen.setLayoutX(2);
        blackQueen.setLayoutY(2);
        blackQueen.setPickOnBounds(true);
        blackQueen.setPreserveRatio(true);
        Image blackQueenImage = new Image(blackQueenImageView.getImage().getUrl());
        blackQueen.setImage(blackQueenImage);
    }

    Node getNode(Integer row, Integer column) {
        if(row != null && row==0)
            row = null;
        if(column != null && column==0)
            column = null;
        for (Node i : chessboard.getChildren()) {
            if(GridPane.getRowIndex(i) == row && GridPane.getColumnIndex(i) == column){
                return i;
            }
        }
        return null;
    }

    private void unlockCells() {
        for(int i = 1; i < 9; ++i) {
            for(int j = 1; j < 9; ++j) {
                if (matrixFigureController.canBeClicked(playerColor, i - 1, j - 1)) {
                    getNode(i, j).setCursor(Cursor.HAND);
                } else {
                    getNode(i, j).setCursor(Cursor.DEFAULT);
                }
            }
        }

    }

    @FXML
    private void onPlayAgainButton() throws IOException {
        Stage stage = (Stage)chessboard.getScene().getWindow();
        start(stage);

    }

    private void setPaneMatrix() {
        paneMatrix = new Pane[8][8];
        paneMatrix[0][0] = pane00;
        paneMatrix[1][0] = pane01;
        paneMatrix[2][0] = pane02;
        paneMatrix[3][0] = pane03;
        paneMatrix[4][0] = pane04;
        paneMatrix[5][0] = pane05;
        paneMatrix[6][0] = pane06;
        paneMatrix[7][0] = pane07;
        paneMatrix[0][1] = pane10;
        paneMatrix[1][1] = pane11;
        paneMatrix[2][1] = pane12;
        paneMatrix[3][1] = pane13;
        paneMatrix[4][1] = pane14;
        paneMatrix[5][1] = pane15;
        paneMatrix[6][1] = pane16;
        paneMatrix[7][1] = pane17;
        paneMatrix[0][2] = pane20;
        paneMatrix[1][2] = pane21;
        paneMatrix[2][2] = pane22;
        paneMatrix[3][2] = pane23;
        paneMatrix[4][2] = pane24;
        paneMatrix[5][2] = pane25;
        paneMatrix[6][2] = pane26;
        paneMatrix[7][2] = pane27;
        paneMatrix[0][3] = pane30;
        paneMatrix[1][3] = pane31;
        paneMatrix[2][3] = pane32;
        paneMatrix[3][3] = pane33;
        paneMatrix[4][3] = pane34;
        paneMatrix[5][3] = pane35;
        paneMatrix[6][3] = pane36;
        paneMatrix[7][3] = pane37;
        paneMatrix[0][4] = pane40;
        paneMatrix[1][4] = pane41;
        paneMatrix[2][4] = pane42;
        paneMatrix[3][4] = pane43;
        paneMatrix[4][4] = pane44;
        paneMatrix[5][4] = pane45;
        paneMatrix[6][4] = pane46;
        paneMatrix[7][4] = pane47;
        paneMatrix[0][5] = pane50;
        paneMatrix[1][5] = pane51;
        paneMatrix[2][5] = pane52;
        paneMatrix[3][5] = pane53;
        paneMatrix[4][5] = pane54;
        paneMatrix[5][5] = pane55;
        paneMatrix[6][5] = pane56;
        paneMatrix[7][5] = pane57;
        paneMatrix[0][6] = pane60;
        paneMatrix[1][6] = pane61;
        paneMatrix[2][6] = pane62;
        paneMatrix[3][6] = pane63;
        paneMatrix[4][6] = pane64;
        paneMatrix[5][6] = pane65;
        paneMatrix[6][6] = pane66;
        paneMatrix[7][6] = pane67;
        paneMatrix[0][7] = pane70;
        paneMatrix[1][7] = pane71;
        paneMatrix[2][7] = pane72;
        paneMatrix[3][7] = pane73;
        paneMatrix[4][7] = pane74;
        paneMatrix[5][7] = pane75;
        paneMatrix[6][7] = pane76;
        paneMatrix[7][7] = pane77;
    }
}
