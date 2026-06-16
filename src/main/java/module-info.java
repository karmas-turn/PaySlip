module best {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.kordamp.ikonli.javafx;
    requires java.sql;
    requires org.kordamp.ikonli.fontawesome6;
    // MySQL connector is provided on the classpath; remove automatic module require
    



    opens best to javafx.fxml;
    exports best;
}
