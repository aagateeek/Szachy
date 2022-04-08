module com.example.szachy {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.szachy to javafx.fxml;
    exports com.szachy;
}