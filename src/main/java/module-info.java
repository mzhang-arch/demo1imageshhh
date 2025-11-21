module com.example.demo1cookieclickerv2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.demo1cookieclickerv2 to javafx.fxml;
    exports com.example.demo1cookieclickerv2;
}