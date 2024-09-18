package com.muchiri;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.sun.net.httpserver.Request;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Reader {

    public static String readRequestFile(Path filepath) throws IOException {
        if (filepath.toString().endsWith(".yml") || filepath.toString().endsWith(".yaml")) {
            Request request = readYml(filepath);
            System.out.println(request);

            return "This is a yaml file";
        } else if (filepath.toString().endsWith(".json")) {
            Book book = new Book("75683645-156f-4357-a968-254821389123", "Winds of winter", 2004);
            String bookObj = readJson(book);
            System.out.println(bookObj);

            return "This is a json file";
        }
        return "Unsupported file type";
    }

    private static Request readYml(Path filepath) throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        return mapper.readValue(Files.readString(filepath), Request.class);
    }

    private static String readJson(Book book) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(book);
    }
}
