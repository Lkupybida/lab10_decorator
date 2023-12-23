package org.example;

import java.sql.SQLException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code. hi
public class Main {
    public static void main(String[] args) throws SQLException {

        Document sd = new SmartDocument("gs://cv-examples/wiki.png");
        System.out.println(sd.parse());

        TimedDocument timedDocument = new TimedDocument("gs://cv-examples/wiki.png");
        System.out.println(timedDocument.parse());

        String gcsPath = "gs://cv-examples/wiki.png";
        CashedDocument app = new CashedDocument(new SmartDocument(gcsPath));
        app.connect();
        app.createTable();
        if (app.recordExists(gcsPath)) {
            app.injectText("text1", gcsPath);
            System.out.println("Record updated successfully");
        }
        else {
            System.out.println("Record not found");
        }
    }
}