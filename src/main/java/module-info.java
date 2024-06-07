module com.example.deal2 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.deal2 to javafx.fxml;
    exports com.example.deal2;
    exports com.example.deal2.repository;
    opens com.example.deal2.repository to javafx.fxml;
}