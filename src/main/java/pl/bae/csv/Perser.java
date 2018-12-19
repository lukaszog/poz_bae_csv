package pl.bae.csv;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Perser {

    public static Path
            file = Paths.get("file.csv");

    public static void readFile() {
        try {

            byte[] lines = Files.readAllBytes(file);
            System.out.println(lines);
            String l = new String(lines);
            System.out.println(l);

            String[] allLines = l.split("\\r");
            Line[] linesObj = new Line[allLines.length - 1];

            for(int i=1; i<linesObj.length; i++){
                String[] result =  allLines[i].split(",");
                System.out.println(result[0]);

                linesObj[i] = new Line(
                        result[0],
                        result[1],
                        result[2],
                        result[3],
                        Integer.parseInt(result[4]),
                        Integer.parseInt(result[5]),
                        Integer.parseInt(result[6]),
                        result[7],
                        result[8],
                        Integer.parseInt(result[9]),
                        Double.parseDouble(result[10]),
                        Double.parseDouble(result[11]));
            }

            System.out.println(linesObj[10]);

        } catch (IOException error) {
            error.printStackTrace();
        }


    }


}
