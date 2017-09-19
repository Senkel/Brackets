package com.senkel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Application entry point.
 */
public class Main {

    private static final String fileName = "src/main/resources/file.txt";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        String input;
        StringBuilder stringBuilder = new StringBuilder();
        while ((input = bufferedReader.readLine()) != null) {
            stringBuilder.append(input);
        }
        Brackets brackets = new Brackets();
        brackets.balance(stringBuilder.toString());
    }
}
