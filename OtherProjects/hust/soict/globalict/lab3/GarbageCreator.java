package OtherProjects.hust.soict.globalict.lab3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GarbageCreator {
    public static void main(String[] args) {
        String filename = "OtherProjects/hust/soict/globalict/lab3/test.txt";
        byte[] inputBytes = { 0 };
        long startTime, endTime;

        try {
            inputBytes = Files.readAllBytes(Paths.get(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }

        startTime = System.currentTimeMillis();
        String outpString = "";
        for (byte b : inputBytes) {
            outpString += (char) b;
        }
        endTime = System.currentTimeMillis();
        System.out.println("Time taken by String concatenation: " + (endTime - startTime) + "ms");
    }
}
