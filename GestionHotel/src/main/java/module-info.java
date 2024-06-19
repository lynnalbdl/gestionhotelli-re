module com.example.gestionhotel {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires jdk.javadoc;

    opens com.example.gestionhotel to javafx.fxml;
    opens controllers to javafx.fxml;
    exports com.example.gestionhotel;
}


