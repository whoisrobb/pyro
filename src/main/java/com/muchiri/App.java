package com.muchiri;

import java.io.IOException;
import java.net.URISyntaxException;

public class App {
    public static void main( String[] args ) throws IOException, URISyntaxException {
        if (args.length < 1) {
            System.err.println("Please provide the request file path.");
            System.exit(1);
        }

        String filepath = args[0];
        boolean colorize = args.length > 1 && args[1].equals("--colorize");

        RequestHandler handler = new RequestHandler(colorize);
        handler.handleRequest(filepath);
    }
}
