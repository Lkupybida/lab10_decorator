package org.example;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TimedDocument implements Document {
    public String gcsPath;

    @Override
    public String parse() {
        long startTime = System.nanoTime();

        SmartDocument smartDocument = new SmartDocument(gcsPath);
        smartDocument.parse();

        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;

        return String.format("Parsing took %d nanoseconds", elapsedTime);
    }
}


