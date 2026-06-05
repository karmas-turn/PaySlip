module best {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.kordamp.ikonli.javafx;
    requires java.sql;
    requires org.kordamp.ikonli.fontawesome6;
    requires mysql.connector.j;
    



    opens best to javafx.fxml;
    exports best;
}
