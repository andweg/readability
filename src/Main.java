package readability;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) {
        try {
            new Calculator(new Stats(Files.readString(Path.of(args[0])))).analyze();
        } catch (IOException e) {
            System.out.println("No file specified!");
        }
    }
}