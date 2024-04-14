module com.example.gestionhotel {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.gestionhotel to javafx.fxml;
    exports com.example.gestionhotel;
}