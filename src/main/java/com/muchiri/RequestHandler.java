package com.muchiri;

import java.io.IOException;
import java.nio.file.Path;

public class RequestHandler {
    private static boolean colorize;

    public RequestHandler(boolean colorize) {
        RequestHandler.colorize = colorize;
    }

    public void handleRequest(String filepath) throws IOException {
        String file = Reader.readRequestFile(Path.of(filepath));
        System.out.println(file);
        System.out.println(colorize);
    }
}
