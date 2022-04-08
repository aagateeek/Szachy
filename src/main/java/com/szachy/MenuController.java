package com.szachy;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {

    @FXML
    private Button button;

    @FXML
    protected void onPlayChessButtonClick() throws IOException {
        Stage stage = (Stage) button.getScene().getWindow();
        GameView.start(stage);
    }
}