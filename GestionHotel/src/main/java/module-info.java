module com.example.gestionhotel {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires jdk.javadoc;

    opens com.example.gestionhotel to javafx.fxml;
    opens controllers to javafx.fxml;  // Ajoutez cette ligne pour permettre l'accès par reflection
    exports com.example.gestionhotel;
}


