module com.example.demo8 {
    requires javafx.controls;
    requires javafx.fxml;
    requires AnimateFX;
    requires javafx.graphics;
    requires java.sql;
    requires org.jetbrains.annotations;


    opens com.example.demo8 to javafx.fxml;
    exports com.example.demo8;
}